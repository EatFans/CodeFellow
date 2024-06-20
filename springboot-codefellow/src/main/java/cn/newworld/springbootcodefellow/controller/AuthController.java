package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.LoginRequest;
import cn.newworld.springbootcodefellow.model.dto.RegisterRequest;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
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

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
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
        String userUUID = UUIDGenerator.generateUUID(registerRequest.getAccount());
        User user = new User();
        user.setUuid(userUUID);  // 给该用户创建一个uuid
        user.setAccount(registerRequest.getAccount());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setRegistrationTime(new Date());  // 设置注册时间（以服务器时间为标准）
        // TODO: 注册成功保存用户数据到数据库中然后再响应

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！我们将发送一封邮件到您的邮箱进行账号验证！验证完毕即可登录！",user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        //TODO: 通过登录请求中的数据，获取到该用户数据，核对账号和密码是否匹配

        //TODO: 检查用户账号状态是否允许登录

        //TODO: 登录成功后颁发cookie 保持登录
        Cookie test = new Cookie("test", "123456");
        response.addCookie(test);

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录成功！"));
    }
}
