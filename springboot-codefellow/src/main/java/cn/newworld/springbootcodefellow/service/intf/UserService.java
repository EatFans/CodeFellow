package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.User;

/**
 * 用户业务接口
 * author: EatFan
 */
public interface UserService {
    /**
     * 检查用户账号是否已经存在
     * @param account 用户账号
     * @return 如果用户账号存在就返回true，否则返回false
     */
    Boolean isAccountExists(String account);

}
