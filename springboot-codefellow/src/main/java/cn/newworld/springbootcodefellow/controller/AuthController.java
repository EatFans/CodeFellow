package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Auth验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/auth")
public class AuthController {


    /**
     * 注册新用户
     * @param requestBodyUser 请求中部分user json数据信息
     * @return 返回Api请求对象
     */
    @PostMapping    ("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody User requestBodyUser){
        // 检测该用户是否已经注册

        // 将该用户的信息创建保存到数据库

        User user = new User();
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"用户注册成功！",requestBodyUser));
    }
}
