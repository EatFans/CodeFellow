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
    private String avatarUrl; // 头像url
    private String bio;   // 用户个性签名
    private String company; // 公司

    // TODO:
}
