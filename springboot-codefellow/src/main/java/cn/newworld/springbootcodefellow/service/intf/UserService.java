package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.User;

/**
 * 用户业务接口
 * author: EatFan
 */
public interface UserService {
    Boolean isAccountExists(String account);

}
