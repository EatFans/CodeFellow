package cn.newworld.springbootcodefellow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证相关API接口
 * author: EatFan
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/register")
    public String registerUser(){
        // 检测是否已经注册了该用户

        // 将用户数据添加到数据库中

        // 返回成功注册
        return "注册用户接口";
    }
}
