package cn.newworld.springbootcodefellow.model.dto.user;

import lombok.Data;

/**
 * 登录请求数据对象
 * author: EatFan
 */
@Data
public class LoginRequest {
    private String account; // 登录的账号
    private String password; // 登录的密码
    private Boolean rememberMe; // 是否记住登录
}
