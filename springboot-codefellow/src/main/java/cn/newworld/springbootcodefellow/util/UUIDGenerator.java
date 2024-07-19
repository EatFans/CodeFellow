package cn.newworld.springbootcodefellow.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * UUID生成器 静态类
 * author: EatFan
 */
public class UUIDGenerator {

    /**
     * 生成一个长度为36位的uuid字符串
     * @param string 需要加密生成的字符串
     * @return 返回已经生成好的uuid字符串
     */
    public static String generate36CharUUID(String string){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(string.getBytes(StandardCharsets.UTF_8));

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            String fullUUID = stringBuilder.toString();
            // Ensure the UUID has 32 hex characters, split into UUID format
            return String.format("%s-%s-%s-%s-%s",
                    fullUUID.substring(0, 8),
                    fullUUID.substring(8, 12),
                    fullUUID.substring(12, 16),
                    fullUUID.substring(16, 20),
                    fullUUID.substring(20, 32));
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
}
