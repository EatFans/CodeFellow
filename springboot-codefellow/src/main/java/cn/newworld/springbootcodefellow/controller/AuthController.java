package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Auth验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    /**
     * 注册新用户
     * @param user 请求中部分user json数据信息
     * @return 返回Api请求对象
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody User user){
        //TODO: 检测用户账号是否存在，存在就不注册
        if (userService.isAccountExists(user.getAccount())){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户账号已经存在！无法注册！"));
        }
        //TODO: 检查用户名是否存在，存在就不注册
        if ( true ){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该用户名已经被使用！"));
        }
        //TODO: 检查用户邮箱是否存在，存在就不注册
        if ( true ){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"该邮箱已经被使用！"));
        }
        //TODO: 给用户生成UUID

        //TODO: 给用户设置账号状态、验证情况（false）、注册时间
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！我们将发送一封邮件到您的邮箱进行账号验证！验证完毕即可登录！",user));
    }
}
