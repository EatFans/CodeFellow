package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.LoginRequest;
import cn.newworld.springbootcodefellow.model.dto.RegisterRequest;
import cn.newworld.springbootcodefellow.model.dto.TokenResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.EmailService;
import cn.newworld.springbootcodefellow.service.intf.RedisService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.TokenEncryptor;
import cn.newworld.springbootcodefellow.util.PasswordEncryptor;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import jakarta.servlet.http.HttpServletResponse;
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

    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        if (!userService.isAccountExists(loginRequest.getAccount()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该账号未注册！"));
        User user = userService.getUerByAccount(loginRequest.getAccount());
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



    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam("key") String key){
        if (!redisService.exists(key))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"key："+key+" 不存在redis中"));
        Object value = redisService.get(key);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"这个key的value值为："+value));
    }

    @GetMapping("/test1")
    public ResponseEntity<?> test2(@RequestParam("token") String token,@RequestParam("uuid") String uuid){
        boolean flag = tokenEncryptor.matches(uuid, token);
        if (flag)
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"token与uuid匹配成功,这个token的uuid值为："+uuid));
        else
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"token与uuid匹配失败"));
    }
}

