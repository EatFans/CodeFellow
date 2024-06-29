package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

/**
 * 用户资料数据对象类
 * author: EatFan
 */
@Data
public class UserProfile {
    private int profileId;  // 资料id
    private String UserUuid; // 用户uuid
    private String username; // 用户名
    private String avatarUrl;   // 用户头像url
    private String gender; // 性别
    private long experience;  // 账号经验
    private int level;  // 账号等级
    private String officialCertification; // 官方认证信息
    private String identity; // 用户身份
    // TODO:
}
