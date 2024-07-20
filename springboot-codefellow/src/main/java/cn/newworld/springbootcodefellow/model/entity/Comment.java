package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

/**
 * 论坛评论数据对象
 * author: EatFan
 */
@Data
public class Comment {
    private String commentUUID;
    private String postUUID;

}
