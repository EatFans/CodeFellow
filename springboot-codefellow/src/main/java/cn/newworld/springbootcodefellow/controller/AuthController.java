package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.model.dto.*;
import cn.newworld.springbootcodefellow.service.intf.AuthService;
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

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 注册新用户接口
     * @param registerRequest 请求中部分user json数据信息
     * @return 返回Api请求对象
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterRequest registerRequest){
        return authService.registerNewUser(registerRequest);
    }

    /**
     * 用户账号验证接口
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果账号验证成功就返回
     */
    @GetMapping("/verify")
    public String activateAccount(@RequestParam("uuid") String uuid, @RequestParam("account") String account, @RequestParam("username") String username){
        return authService.activateAccount(uuid,account,username);

    }

    /**
     * 用户登录接口
     * @param loginRequest 登录请求传输的数据对象
     * @return 登录成功就返回token令牌，否则返回登录错误信息
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest){
        return authService.userLoginIn(loginRequest);
    }

    /**
     * 忘记密码接口
     * @return 返回
     */
    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequest request){
        return authService.forgetPassword(request);
    }

    /**
     * 重置密码接口
     * @return 返回
     */
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request){
        return authService.resetPassword(request);
    }

    /**
     * TODO: 验证登录令牌接口
     * @return
     */
    @PostMapping("/verify-login-token")
    public ResponseEntity<?> verifyLoginToken(){
        return null;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam("key") String key){
        return authService.test(key);
    }


}

