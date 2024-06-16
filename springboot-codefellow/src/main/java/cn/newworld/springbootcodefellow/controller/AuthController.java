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
        return "注册用户接口";
    }
}
