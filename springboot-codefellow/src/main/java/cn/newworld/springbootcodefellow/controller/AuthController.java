package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.model.dto.*;
import cn.newworld.springbootcodefellow.service.intf.AuthControllerService;
import jakarta.servlet.http.HttpServletRequest;
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

    private final AuthControllerService authControllerService;

    @Autowired
    public AuthController(AuthControllerService authControllerService) {
        this.authControllerService = authControllerService;
    }

    /**
     * 注册新用户接口
     * @param registerRequest 请求中部分user json数据信息
     * @param httpServletRequest Http请求中的数据
     * @return 返回Api请求对象
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterRequest registerRequest, HttpServletRequest httpServletRequest){
        return authControllerService.registerNewUser(registerRequest,httpServletRequest);
    }

    /**
     * 用户账号验证接口
     * @param uuid 用户uuid
     * @param account 用户账号
     * @param username 用户名
     * @return 如果账号验证成功就返回
     */
    @GetMapping("/verify")
    public String activateAccount(@RequestParam("uuid") String uuid, @RequestParam("account") String account, @RequestParam("username") String username, HttpServletRequest httpServletRequest){
        return authControllerService.activateAccount(uuid,account,username,httpServletRequest);

    }

    /**
     * 用户登录接口
     * @param loginRequest 登录请求传输的数据对象
     * @return 登录成功就返回token令牌，否则返回登录错误信息
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLoginIn(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest){
        return authControllerService.userLoginIn(loginRequest,httpServletRequest);
    }

    /**
     * 忘记密码接口
     * @return 返回
     */
    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequest request,HttpServletRequest httpServletRequest){
        return authControllerService.forgetPassword(request,httpServletRequest);
    }

    /**
     * 重置密码接口
     * @return 返回
     */
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request,HttpServletRequest httpServletRequest){
        return authControllerService.resetPassword(request,httpServletRequest);
    }

    /**
     * 验证登录令牌接口
     * @param request 请求传输数据体
     * @return 返回请求完毕的响应数据体
     */
    @PostMapping("/verify-login-token")
    public ResponseEntity<?> verifyLoginToken(@RequestBody LoginTokenRequest request,HttpServletRequest httpServletRequest){
        return authControllerService.verifyLoginToken(request,httpServletRequest);
    }
}

