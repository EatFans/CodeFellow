package cn.newworld.springbootcodefellow.model.dto;

import lombok.Data;

/**
 * 忘记密码请求数据传输类
 * author: EatFan
 */
@Data
public class ResetPasswordRequest {
    private String code;
    private String password;
}
