package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.LoginRequest;
import cn.newworld.springbootcodefellow.model.dto.RegisterRequest;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.PasswordEncryptor;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;



/**
 * Auth验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncryptor passwordEncryptor;

    @Autowired
    public AuthController(UserService userService,PasswordEncryptor passwordEncryptor){
        this.userService = userService;
        this.passwordEncryptor = passwordEncryptor;
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

        //TODO: 邮箱发送激活验证账号超链接


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

    @GetMapping("/activate")
    public String activateAccount(@RequestParam("uuid") String uuid,@RequestParam("username") String username){
        //TODO: 激活验证账号处理

        return uuid + "  " + username;
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        // 检查该账号是否存在
        if (!userService.isAccountExists(loginRequest.getAccount())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该账号未注册！"));
        }

        // 检查账号密码是否匹配
        User user = userService.getUerByAccount(loginRequest.getAccount());
        if (!passwordEncryptor.matches(loginRequest.getPassword(),user.getPassword())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"账号或密码错误！"));
        }

        // 检查账号状态是否允许登录
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


        //TODO: 更新用户登录时间

        //TODO: 登录成功后颁发cookie 保持登录
        Cookie test = new Cookie("test", "123456");
        response.addCookie(test);

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录成功！", user));
    }
}
