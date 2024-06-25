package cn.newworld.springbootcodefellow.model.dto;

import lombok.Data;

/**
 * 用户验证登录令牌请求传输数据体
 * author: EatFan
 */
@Data
public class LoginTokenRequest {
    private String token;
}
