package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;


/**
 * Auth 控制器主要逻辑业务接口类
 * author: EatFan
 */
public interface AuthControllerService {
    ResponseEntity<?> registerNewUser(RegisterRequest registerRequest, HttpServletRequest httpServletRequest);

    String activateAccount(String uuid, String account, String username, HttpServletRequest httpServletRequest);

    ResponseEntity<?> userLoginIn(LoginRequest loginRequest, HttpServletRequest httpServletRequest);

    ResponseEntity<?> forgetPassword(ForgetPasswordRequest request,  HttpServletRequest httpServletRequest);
    ResponseEntity<?> resetPassword(ResetPasswordRequest request, HttpServletRequest httpServletRequest);

    ResponseEntity<?> verifyLoginToken(LoginTokenRequest request,HttpServletRequest httpServletRequest);

}
