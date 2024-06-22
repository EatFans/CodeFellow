package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 邮箱业务实现类
 * author: EatFan
 */
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 发送html邮件
     *
     * @param to          收件人
     * @param htmlContent html邮件内容
     */
    private void sendHtmlEmail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送验证邮件给用户
     * @param user 被发送的用户
     */
    @Override
    public void sendVerifyEmail(User user) {
        try {
            // 使用Spring的ClassPathResource读取文件
            ClassPathResource resource = new ClassPathResource("email/verify.html");
            Path path = Paths.get(resource.getURI());
            String htmlContent = Files.readString(path);

            // 用户uuid
            String uuid = user.getUuid();
            // 用户名
            String username = user.getUsername();
            // 账户
            String account = user.getAccount();
            // 邮箱
            String email = user.getEmail();
            // 账号验证激活超链接
            String verifyLink = "http://localhost:8080/auth/verify?uuid="+uuid+"&account="+account+"&username="+username;

            htmlContent = String.format(htmlContent,username,account,email,verifyLink);

            sendHtmlEmail(user.getEmail(),"验证您的 CodeFellow 账号电子邮箱，以激活您的账号", htmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
