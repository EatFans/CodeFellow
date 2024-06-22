package cn.newworld.springbootcodefellow.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 令牌加密器，用于加密和解密令牌。
 * author: EatFan
 */
@Component
public class TokenEncryptor {

    private final PasswordEncoder passwordEncoder;

    /**
     * 构造方法，初始化BCryptPasswordEncoder实例。
     * BCryptPasswordEncoder是Spring Security提供的用于加密密码的实现类，
     * 它使用了强哈希函数BCrypt来保证令牌的安全性。
     */
    public TokenEncryptor() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * 将uuid进行加密，加密成为token。
     *
     * @param uuid 原始密码，即用户输入的未加密的密码。
     * @return 加密后的token。
     */
    public String generateToken(String uuid) {
        return passwordEncoder.encode(uuid);
    }

    /**
     * 验证uuid和加密后的token是否匹配。
     *
     * @param uuid 用户uuid
     * @param token token令牌。
     * @return 如果匹配返回true，否则返回false。
     */
    public boolean matches(String uuid, String token) {
        return passwordEncoder.matches(uuid, token);
    }
}
