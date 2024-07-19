package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.constant.enums.UserAction;
import cn.newworld.springbootcodefellow.model.dto.*;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.model.entity.UserProfile;
import cn.newworld.springbootcodefellow.service.intf.*;
import cn.newworld.springbootcodefellow.util.PasswordEncryptor;
import cn.newworld.springbootcodefellow.util.TokenEncryptor;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Auth 控制器主要逻辑业务实现类
 * author: EatFan
 */
@Service
public class AuthControllerServiceImpl implements AuthControllerService {
    private final UserService userService;

    private final PasswordEncryptor passwordEncryptor;

    private final EmailService emailService;

    private final RedisService redisService;

    private final UserProfileService userProfileService;
    private final UserActionLogService userActionLogService;

    @Autowired
    public AuthControllerServiceImpl(UserService userService,
                                     PasswordEncryptor passwordEncryptor,
                                     EmailService emailService,
                                     RedisService redisService,
                                     UserProfileService userProfileService,
                                     UserActionLogService userActionLogService) {
        this.userService = userService;
        this.passwordEncryptor = passwordEncryptor;
        this.emailService = emailService;
        this.redisService = redisService;
        this.userProfileService = userProfileService;
        this.userActionLogService = userActionLogService;
    }

    /**
     * 注册一个新用户
     * @param registerRequest 注册请求数据
     * @return 响应最终结果
     */
    @Override
    public ResponseEntity<?> registerNewUser(RegisterRequest registerRequest, HttpServletRequest httpServletRequest) {
        RegisterErrorData registerErrorData = new RegisterErrorData();

        if (userService.isAccountExists(registerRequest.getAccount())){
            registerErrorData.setAccount("该用户账号已经存在！无法注册！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户账号已经存在！无法注册！",registerErrorData));
        }
        if (userService.isUsernameExists(registerRequest.getUsername())){
            registerErrorData.setUsername("该用户名已经被使用！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户名已经被使用！",registerErrorData));
        }
        if (userService.isEmailExists(registerRequest.getEmail())){
            registerErrorData.setEmail("该邮箱已经被使用！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该邮箱已经被使用！",registerErrorData));
        }
        if (userService.isPhoneNumberExists(registerRequest.getPhoneNumber())){
            registerErrorData.setPhoneNumber("该手机号已经被使用！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该手机号已经被使用！",registerErrorData));
        }

        User user = createNewUser(registerRequest);
        if (!userService.create(user)){
            registerErrorData.setRegister("注册失败！原因：无法创建用户！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"注册失败! 原因：无法创建用户！",registerErrorData));
        }


        emailService.sendVerifyEmail(user);
        userActionLogService.saveUserActionLog(user.getUuid(),user.getUsername(), UserAction.REGISTER,"用户注册完成，等待邮箱验证激活账号","Success",httpServletRequest);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！我们将发送一封邮件到您的邮箱进行账号验证！验证完毕即可登录！",registerErrorData));
    }

    /**
     * 创建一个新的用户资料对象
     * @param user 需要创建用户资料的用户
     * @return 返回一个创建初始化完成的UserProfile对象
     */
    private UserProfile createNewUserProfile(User user){
        UserProfile userProfile = new UserProfile();
        userProfile.setUserUuid(user.getUuid());
        userProfile.setUsername(user.getUsername());
        // 设置默认头像
        userProfile.setAvatarUrl("https://github.com/EatFans/EatFans/assets/122099628/6cb303da-9e72-4f57-a242-736c51926b13");
        userProfile.setGender("未知");
        return userProfile;
    }

    /**
     * 创建一个新用户对象
     * @param registerRequest 请求体内容
     * @return 返回一个创建初始化完成user对象
     */
    private User createNewUser(RegisterRequest registerRequest){
        User user = new User();
        String userUUID = UUIDGenerator.generate36CharUUID(registerRequest.getAccount());
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
    public String activateAccount(String uuid, String account, String username, HttpServletRequest httpServletRequest) {
        boolean isVerified = userService.verifyUserAccount(uuid, account, username);

        if (isVerified){
            userActionLogService.saveUserActionLog(uuid,username,UserAction.ACTIVATE_ACCOUNT,"用户已经成功在邮箱中验证激活了账号！","Success",httpServletRequest);
            User user = userService.getUserByUUIDAndAccountAndUsername(uuid, account, username);
            // 创建一个新的用户资料保存到数据中
            UserProfile userProfile = createNewUserProfile(user);
            if (!userProfileService.create(userProfile)){
                return "账号验证激活失败！原因：无法创建用户资料！";
            }
            return "账号验证激活成功！";
        } else {
            userActionLogService.saveUserActionLog(uuid,username,UserAction.ACTIVATE_ACCOUNT,"用户在验证激活账号时候失败！","Error",httpServletRequest);
            return "账号验证激活失败！";
        }
    }

    /**
     * 用户登录
     * @param loginRequest 登录请求数据
     * @return 返回处理完成响应体
     */
    @Override
    public ResponseEntity<?> userLoginIn(LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        LoginErrorData loginErrorData = new LoginErrorData();

        if (!userService.isAccountExists(loginRequest.getAccount())){
            loginErrorData.setAccount("该账号未注册！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该账号未注册！",loginErrorData));
        }
        User user = userService.getUserByAccount(loginRequest.getAccount());
        if (!passwordEncryptor.matches(loginRequest.getPassword(),user.getPassword())){
            loginErrorData.setPassword("密码错误！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"密码错误！",loginErrorData));
        }
        if (!user.getIsVerification()){
            loginErrorData.setLogin("无法登录！账号还未验证激活！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "无法登录！账号还未验证激活！",loginErrorData));
        }
        switch (user.getStatus()){
            case AccountStatus.DISABLED:
                loginErrorData.setLogin("无法登录！账号处于禁用状态！");
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于禁用状态！",loginErrorData));
            case AccountStatus.PENDING:
                loginErrorData.setLogin("无法登录！账号还未激活验证！");
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR, "无法登录！账号还未激活验证！",loginErrorData));
            case AccountStatus.LOCKED:
                loginErrorData.setLogin("无法登录！账号处于锁定状态");
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于锁定状态！",loginErrorData));
            case AccountStatus.SUSPENDED:
                loginErrorData.setLogin("无法登录！账号处于暂停使用状态！");
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于暂停使用状态！",loginErrorData));
            case AccountStatus.BANNED:
                loginErrorData.setLogin("无法登录！账号处于封禁状态！");
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"无法登录！账号处于封禁状态！",loginErrorData));
            default:
                break;
        }
        if (!userService.updateUserLoginTime(user)){
            loginErrorData.setLogin("登录时间更新错误！");
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"登录时间更新错误！",loginErrorData));
        }

        // 生成会话令牌（token）
        String token = TokenEncryptor.generateToken(user.getUuid());

        // 根据 rememberMe 决定令牌有效时间
        if (loginRequest.getRememberMe()){
            redisService.setToken(user.getUuid(),token,14,TimeUnit.DAYS);
            userActionLogService.saveUserActionLog(user.getUuid(),user.getUsername(),UserAction.LOGIN,"用户正在登录，登录令牌有效时间14天"+TokenEncryptor.decryptToken(token),"Success",httpServletRequest);
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录成功！",new TokenResponse(token,14,TimeUnit.DAYS)));
        } else {
            redisService.setToken(user.getUuid(),token,12,TimeUnit.HOURS);
            userActionLogService.saveUserActionLog(user.getUuid(),user.getUsername(),UserAction.LOGIN,"用户正在登录，登录令牌有效时间12小时","Success",httpServletRequest);
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录成功！",new TokenResponse(token,12,TimeUnit.HOURS)));
        }
    }

    /**
     * 用户忘记密码逻辑
     * @param request 忘记密码请求数据
     * @return 返回最终响应实体
     */
    @Override
    public ResponseEntity<?> forgetPassword(ForgetPasswordRequest request, HttpServletRequest httpServletRequest) {
        String account = request.getAccount();
        String email = request.getEmail();
        String phoneNumber = request.getPhoneNumber();

        String redisKey = "forget-password:" + account;
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
    public ResponseEntity<?> resetPassword(ResetPasswordRequest request,HttpServletRequest httpServletRequest) {
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
        userActionLogService.saveUserActionLog(user.getUuid(),user.getUsername(),UserAction.RESET_PASSWORD,"用户重置了密码！","Success",httpServletRequest);
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

    /**
     * 验证登录令牌
     * @param request 请求传输数据体
     * @return 返回请求完毕的响应数据体
     */
    @Override
    public ResponseEntity<?> verifyLoginToken(LoginTokenRequest request,HttpServletRequest httpServletRequest) {
        String token = request.getToken();

        // 验证token是否已经过期
        if (!redisService.tokenExists(token)){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"登录令牌已经失效"));
        }
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录令牌验证成功！"));
    }

}
