package cn.newworld.springbootcodefellow.service.intf;

import org.springframework.http.ResponseEntity;

/**
 * User控制器主要逻辑业务接口类
 * author: EatFan
 */
public interface UserControllerService {
    ResponseEntity<?> getUserProfile();
}
