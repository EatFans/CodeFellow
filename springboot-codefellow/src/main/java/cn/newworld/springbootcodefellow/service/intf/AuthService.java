package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.dto.ForgetPasswordRequest;
import cn.newworld.springbootcodefellow.model.dto.LoginRequest;
import cn.newworld.springbootcodefellow.model.dto.RegisterRequest;
import cn.newworld.springbootcodefellow.model.dto.ResetPasswordRequest;
import org.springframework.http.ResponseEntity;


/**
 * Auth 验证业务接口类
 * author: EatFan
 */
public interface AuthService {
    ResponseEntity<?> registerNewUser(RegisterRequest registerRequest);

    String activateAccount(String uuid, String account, String username);

    ResponseEntity<?> userLoginIn(LoginRequest loginRequest);

    ResponseEntity<?> forgetPassword(ForgetPasswordRequest request);
    ResponseEntity<?> resetPassword(ResetPasswordRequest request);


    ResponseEntity<?> test(String key);
}
