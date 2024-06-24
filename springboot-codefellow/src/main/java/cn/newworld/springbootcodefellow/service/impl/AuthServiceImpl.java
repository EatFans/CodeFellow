package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.*;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.AuthService;
import cn.newworld.springbootcodefellow.service.intf.EmailService;
import cn.newworld.springbootcodefellow.service.intf.RedisService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.PasswordEncryptor;
import cn.newworld.springbootcodefellow.util.TokenEncryptor;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Auth 验证业务实现类
 * author: EatFan
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    private final PasswordEncryptor passwordEncryptor;

    private final EmailService emailService;

    private final RedisService redisService;

    private final TokenEncryptor tokenEncryptor;

    @Autowired
    public AuthServiceImpl(UserService userService,
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
     * 注册一个新用户
     * @param registerRequest 注册请求数据
     * @return 响应最终结果
     */
    @Override
    public ResponseEntity<?> registerNewUser(RegisterRequest registerRequest) {
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
     * 激活验证用户账号
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 返回
     */
    @Override
    public String activateAccount(String uuid, String account, String username) {
        boolean isVerified = userService.verifyUserAccount(uuid, account, username);
        if (isVerified){
            return "账号验证激活成功！";
        } else {
            return "账号验证激活失败！";
        }
    }

    /**
     * 用户登录
     * @param loginRequest 登录请求数据
     * @return 返回处理完成响应体
     */
    @Override
    public ResponseEntity<?> userLoginIn(LoginRequest loginRequest) {
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
            redisService.set(user.getUuid(),token,14, TimeUnit.DAYS);
            return ResponseEntity.ok(new TokenResponse(token,14,TimeUnit.DAYS));
        } else {
            redisService.set(user.getUuid(),token,12,TimeUnit.HOURS);
            return ResponseEntity.ok(new TokenResponse(token,12,TimeUnit.HOURS));
        }
    }

    /**
     * 用户忘记密码逻辑
     * @param request 忘记密码请求数据
     * @return 返回最终响应实体
     */
    @Override
    public ResponseEntity<?> forgetPassword(ForgetPasswordRequest request) {
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
     * 重置密码业务逻辑
     * @param request 重置密码请求数据
     * @return 返回响应实体
     */
    @Override
    public ResponseEntity<?> resetPassword(ResetPasswordRequest request) {
        // 从请求中获取验证码
        String code = request.getCode();
        // 通过验证码，在Redis中获取忘记密码操作令牌
        String token = redisService.getKey(code);
        if (token == null)
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"验证码错误"));
        // 解密操作令牌得到用户账号信息
        String account = decryptForgetPasswordToken(token);
        // 通过用户账号信息去在数据库中修改该用户密码
        User user = userService.getUserByAccount(account);
        // 更新用户密码
        if (!userService.updateUserPassword(user,request.getPassword()))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"更新用户密码错误"));
        // 完成重置密码请求后直接删除存储在Redis中的验证码
        if (!redisService.delete(token))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"删除临时验证码失败"));
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"密码修改成功! 用户账号为："+account));
    }

    /**
     * 解密忘记密码操作令牌获取用户账号信息
     * @param token 忘记密码操作令牌
     * @return 返回用户账号
     */
    private String decryptForgetPasswordToken(String token){
        String[] split = token.split("~");
        return split.length > 1 ? split[1] : null;
    }

    @Override
    public ResponseEntity<?> test(String key) {
        if (!redisService.exists(key))
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"key："+key+" 不存在redis中"));
        Object value = redisService.get(key);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"这个key的value值为："+value));
    }
}
