package cn.newworld.springbootcodefellow.service.intf;

/**
 * 邮箱业务接口
 * author: EatFan
 */
public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
}

