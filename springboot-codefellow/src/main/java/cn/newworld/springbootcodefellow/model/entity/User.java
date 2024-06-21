package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String uuid;    // 用户的UUID
    private String account;  // 用户的账号
    private String password;    // 用户的密码
    private String username;    // 用户的名称
    private String email;       // 用户的邮箱
    private String phoneNumber; // 用户的手机号
    private String recommender; // 推荐人
    private String status;  // 用户账号的状态
    private Boolean isVerification; // 账号是否已经通过验证
    private Date registrationTime;  // 注册的时间
    private Date lastLoginTime; // 最后登录的时间
}
