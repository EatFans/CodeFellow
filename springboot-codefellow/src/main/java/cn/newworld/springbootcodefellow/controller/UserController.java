package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.service.intf.UserControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器类
 * author: EatFan
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserControllerService userControllerService;
    public UserController(UserControllerService userControllerService){
        this.userControllerService = userControllerService;
    }

    /**
     * 获取用户资料api接口
     * @return 返回响应
     */
    @GetMapping("/getUserProfile")
    public ResponseEntity<?> getUserProfile(){
        return userControllerService.getUserProfile();
    }
}
