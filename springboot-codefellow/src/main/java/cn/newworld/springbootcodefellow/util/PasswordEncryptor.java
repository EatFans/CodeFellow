package cn.newworld.springbootcodefellow.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * PasswordEncryptor类负责提供密码加密和匹配功能。
 * 使用BCrypt算法进行密码加密，保证密码存储的安全性。
 */
@Component
public class PasswordEncryptor {

    private final PasswordEncoder passwordEncoder;

    /**
     * 构造方法，初始化BCryptPasswordEncoder实例。
     * BCryptPasswordEncoder是Spring Security提供的用于加密密码的实现类，
     * 它使用了强哈希函数BCrypt来保证密码的安全性。
     */
    public PasswordEncryptor() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * 将原始密码进行加密。
     *
     * @param rawPassword 原始密码，即用户输入的未加密的密码。
     * @return 加密后的密码字符串。
     */
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * 验证原始密码和加密后的密码是否匹配。
     *
     * @param rawPassword 原始密码，即用户输入的未加密的密码。
     * @param encodedPassword 已加密的密码字符串，即存储在数据库中的加密密码。
     * @return 如果匹配返回true，否则返回false。
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
