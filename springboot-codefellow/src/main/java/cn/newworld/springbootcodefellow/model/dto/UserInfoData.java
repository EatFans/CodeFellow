package cn.newworld.springbootcodefellow.model.dto;

import lombok.Data;

/**
 * 用户信息数据数据传输类
 * author: EatFan
 */
@Data
public class UserInfoData {
    private String uuid;
    private String username;
    private String avatarUrl;
    // TODO: 待设计，数据表也待设计
}
