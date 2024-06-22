package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.User;

/**
 * 邮箱业务接口
 * author: EatFan
 */
public interface EmailService {

    /**
     * 发送验证邮件给用户
     * @param user 被发送的用户
     */
    void sendVerifyEmail(User user);
}

