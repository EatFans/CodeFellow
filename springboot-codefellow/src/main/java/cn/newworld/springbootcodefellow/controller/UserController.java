package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.model.dto.user.LoginTokenRequest;
import cn.newworld.springbootcodefellow.service.intf.UserControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/getUserProfile")
    public ResponseEntity<?> getUserProfile(@RequestBody LoginTokenRequest loginTokenRequest){
        return userControllerService.getUserProfile(loginTokenRequest);
    }
}
