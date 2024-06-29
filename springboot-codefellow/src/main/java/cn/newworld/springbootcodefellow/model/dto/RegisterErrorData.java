package cn.newworld.springbootcodefellow.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 注册失败数据
 * author: EatFan
 */
@Setter
@Getter
public class RegisterErrorData {
    private String account;
    private String password;
    private String passwordSure;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean problemVerification;
    private String register;
}
