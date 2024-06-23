package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.*;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.EmailService;
import cn.newworld.springbootcodefellow.service.intf.RedisService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.TokenEncryptor;
import cn.newworld.springbootcodefellow.util.PasswordEncryptor;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Auth验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final PasswordEncryptor passwordEncryptor;

    private final EmailService emailService;

    private final RedisService redisService;

    private final TokenEncryptor tokenEncryptor;

    @Autowired
    public AuthController(UserService userService,
                          PasswordEncryptor passwordEncryptor,
                          EmailService emailService,
                          RedisService redisService,
                          TokenEncryptor tokenEncryptor) {
        this.userService = userService;
        this.passwordEncryptor = passwordEncryptor;
        this.emailService = emailService;
        this.redisService = redisService;
        this.tokenEncryptor = tokenEncryptor;
    }


    /**
     * 注册新用户
     * @param registerRequest 请求中部分user json数据信息
     * @return 返回Api请求对象
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterRequest registerRequest){
        if (userService.isAccountExists(registerRequest.getAccount()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户账号已经存在！无法注册！"));
        if (userService.isUsernameExists(registerRequest.getUsername()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户名已经被使用！"));
        if (userService.isEmailExists(registerRequest.getEmail()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该邮箱已经被使用！"));

        User user = createNewUser(registerRequest);
        if (!userService.create(user))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"注册失败! 原因：无法将数据保存进数据库中..."));

        emailService.sendVerifyEmail(user);

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！我们将发送一封邮件到您的邮箱进行账号验证！验证完毕即可登录！",user));
    }

    /**
     * 创建一个新用户对象
     * @param registerRequest 请求体内容
     * @return 返回一个创建初始化完成user对象
     */
    private User createNewUser(RegisterRequest registerRequest){
        User user = new User();
        String userUUID = UUIDGenerator.generateUUID(registerRequest.getAccount());
        user.setUuid(userUUID);  // 给该用户创建一个uuid
        user.setAccount(registerRequest.getAccount());
        user.setPassword(passwordEncryptor.encodePassword(registerRequest.getPassword()));
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        String recommender = registerRequest.getRecommender();
        if (recommender != null)
            user.setRecommender(recommender);
        user.setRegistrationTime(new Date());  // 设置注册时间（以服务器时间为标准）
        return user;
    }

    /**
     * 用户账号验证接口
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果账号验证成功就返回
     */
    @GetMapping("/verify")
    public String activateAccount(@RequestParam("uuid") String uuid, @RequestParam("account") String account, @RequestParam("username") String username){
        Boolean isVerified = userService.verifyUserAccount(uuid, account, username);
        if (isVerified){
            return "账号验证激活成功！";
        } else {
            return "账号验证激活失败！";
        }

    }

    /**
     * 用户登录接口
     * @param loginRequest 登录请求传输的数据对象
     * @return 登录成功就返回token令牌，否则返回登录错误信息
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest){
        if (!userService.isAccountExists(loginRequest.getAccount()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该账号未注册！"));
        User user = userService.getUserByAccount(loginRequest.getAccount());
        if (!passwordEncryptor.matches(loginRequest.getPassword(),user.getPassword()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"账号或密码错误！"));
        if (!user.getIsVerification())
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "无法登录！账号还未激活验证！"));
        switch (user.getStatus()){
            case AccountStatus.DISABLED:
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于禁用状态！"));
            case AccountStatus.PENDING:
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "无法登录！账号还未激活验证！"));
            case AccountStatus.LOCKED:
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于锁定状态！"));
            case AccountStatus.SUSPENDED:
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于暂停使用状态！"));
            case AccountStatus.BANNED:
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于封禁状态！"));
            default:
                break;
        }
        if (!userService.updateUserLoginTime(user))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"登录时间更新错误！"));

        // 生成会话令牌（token）
        String token = tokenEncryptor.generateToken(user.getUuid());
        // 根据 rememberMe 决定令牌有效时间
        if (loginRequest.getRememberMe()){
            redisService.set(user.getUuid(),token,14,TimeUnit.DAYS);
            return ResponseEntity.ok(new TokenResponse(token,14,TimeUnit.DAYS));
        } else {
            redisService.set(user.getUuid(),token,12,TimeUnit.HOURS);
            return ResponseEntity.ok(new TokenResponse(token,12,TimeUnit.HOURS));
        }

    }

    /**
     * 忘记密码接口
     * @return 返回
     */
    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequest request){
        String account = request.getAccount();
        String email = request.getEmail();
        String phoneNumber = request.getPhoneNumber();

        String redisKey = "forget-password~" + account;
        // 检查用户是否在验证码未失效前请求过忘记密码接口，避免重复发送验证码
        if (redisService.exists(redisKey))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "验证码已发送，请稍后再试！"));

        // 检查用户账号是否存在
        if (!userService.isAccountExists(account))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"此账号不存在平台中！"));

        User user = userService.getUserByAccount(account);
        if (user == null )
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "The user is null"));

        // 核对用户账号、邮箱、手机号是否在同一个用户上
        if (!user.getEmail().equalsIgnoreCase(email))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "邮箱与账号不匹配"));
        if (!user.getPhoneNumber().equalsIgnoreCase(phoneNumber))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "手机号与账号不匹配"));

        // 随机生成一个忘记密码的6位数验证码
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
        // 临时存储到Redis中，失效时长半小时
        redisService.set(redisKey,code,30,TimeUnit.MINUTES);
        // 发送验证码到用户邮箱中
        emailService.sendCodeEmail(user,code);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS, "验证码已经发送至邮箱"));
    }

    /**
     * TODO: 重置密码接口
     * @return 返回
     */
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request){
        // 从请求中获取验证码
        String code = request.getCode();

        // 通过验证码，在Redis中获取忘记密码操作令牌
        String token = redisService.getKey(code);

        if (token == null){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"验证码错误"));
        }

        // 解密操作令牌得到用户账号信息


        // 通过用户账号信息去在数据库中修改该用户密码

        // 完成重置密码请求后直接删除存储在Redis中的验证码

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"密码修改成功"));
    }






    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam("key") String key){
        if (!redisService.exists(key))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"key："+key+" 不存在redis中"));
        Object value = redisService.get(key);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"这个key的value值为："+value));
    }

    @GetMapping("/test1")
    public ResponseEntity<?> test2(@RequestParam("value") String value){
        String key = redisService.getKey(value);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"Redis中value="+value+" 对应的key键为："+key));
    }
}

