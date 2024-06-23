package cn.newworld.springbootcodefellow.model.dto;

import lombok.Data;

/**
 * 忘记密码数据传输 类
 * author: EatFan
 */
@Data
public class ForgetPasswordRequest {
    private String account;
    private String email;
    private String phoneNumber;
}
