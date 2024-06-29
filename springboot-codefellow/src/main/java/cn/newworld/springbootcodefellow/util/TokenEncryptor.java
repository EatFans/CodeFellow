package cn.newworld.springbootcodefellow.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 令牌加密器，用于加密和解密令牌。
 * author: EatFan
 */
@Component
public class TokenEncryptor {
    // 令牌的密钥
    private final static String TOKEN_ENCRYPTION_KEY = "I3anv9B12Y6tGd0T";

    /**
     * 将uuid进行加密，加密成为token。
     *
     * @param uuid 用户uuid。
     * @return 加密后的token。
     */
    public static String generateToken(String uuid) {
        try {
            // 将密钥转换为AES密钥规范
            SecretKeySpec secretKey = new SecretKeySpec(TOKEN_ENCRYPTION_KEY.getBytes(), "AES");

            // 获取AES加密实例，使用ECB模式和PKCS5填充
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // 初始化加密器，指定加密模式和密钥
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // 执行加密操作，并将结果转换为Base64编码的字符串
            return Base64.getEncoder().encodeToString(cipher.doFinal(uuid.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密方法，使用AES算法解密给定的令牌字符串。
     *
     * @param token 要解密的Base64编码的令牌字符串
     * @return 解密后的原始UUID字符串
     */
    public static String decryptToken(String token) {
        try {
            // 将密钥转换为AES密钥规范
            SecretKeySpec secretKey = new SecretKeySpec(TOKEN_ENCRYPTION_KEY.getBytes(), "AES");
            // 获取AES解密实例，使用ECB模式和PKCS5填充
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 初始化解密器，指定解密模式和密钥
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // 执行解密操作，并将结果转换为原始UUID字节数组
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(token));
            // 将解密后的字节数组转换为字符串
            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
