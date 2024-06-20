package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
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
     * @param user 请求中部分user json数据信息
     * @return 返回Api请求对象
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody User user){
        if (userService.isAccountExists(user.getAccount())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户账号已经存在！无法注册！"));
        }
        if (userService.isUsernameExists(user.getUsername())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户名已经被使用！"));
        }
        if (userService.isEmailExists(user.getEmail())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该邮箱已经被使用！"));
        }
        String userUUID = UUIDGenerator.generateUUID(user.getAccount());
        user.setUuid(userUUID);

        //TODO: 给用户设置账号状态
        user.setIsVerification(false);
        user.setRegistrationTime(new Date());

        // TODO: 注册成功保存用户数据到数据库中然后再响应

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！我们将发送一封邮件到您的邮箱进行账号验证！验证完毕即可登录！",user));
    }
}
