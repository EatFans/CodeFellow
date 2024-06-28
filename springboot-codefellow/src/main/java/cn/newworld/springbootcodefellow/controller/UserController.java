package cn.newworld.springbootcodefellow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器类
 * author: EatFan
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(){

    }

    public ResponseEntity<?> getUserProfile(){
        return null;
    }
}
