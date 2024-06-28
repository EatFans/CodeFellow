package cn.newworld.springbootcodefellow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于用户个人资料或配置的修改的接口控制器
 * author: EatFan
 */
@RestController
@RequestMapping("/profile")
public class UserProfileController {

    public UserProfileController(){

    }

    public ResponseEntity<?> getUserProfile(){
        return null;
    }
}
