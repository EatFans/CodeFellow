package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * 验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping    ("/register")
    public ResponseEntity<?> registerUser(@RequestBody User requestBodyUser){
        // 检测该用户是否已经注册

        // 将该用户的信息创建保存到数据库

        User user = new User();
        return ResponseEntity.ok(new ApiResponse("success","用户注册成功！",requestBodyUser));
    }
}
