package cn.newworld.springbootcodefellow.model.dto.user;

import lombok.Data;

/**
 * 注册请求数据对象
 * author: EatFan
 */
@Data
public class RegisterRequest {
    private String account;  // 账号
    private String password; // 密码
    private String username; // 用户名
    private String email; // 邮箱
    private String phoneNumber; // 手机号
    private String recommender; // 推荐人
}
