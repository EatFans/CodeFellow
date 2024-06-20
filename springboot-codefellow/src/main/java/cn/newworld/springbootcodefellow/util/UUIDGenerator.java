package cn.newworld.springbootcodefellow.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * UUID生成器 静态类
 * author: EatFan
 */
public class UUIDGenerator {

    public static String generateUUID(String account){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(account.getBytes(StandardCharsets.UTF_8));

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes){
                stringBuilder.append(String.format("%02x", b));
            }

            String fullUUID = stringBuilder.toString();
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
