package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.User;

/**
 * 测试业务接口
 * author: EatFan
 */
public interface TestService {
    String hello();
    String test();

    void putUserTest(User user);
}
