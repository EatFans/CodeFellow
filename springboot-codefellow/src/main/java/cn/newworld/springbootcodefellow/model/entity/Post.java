package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 帖子数据对象类
 * author: EatFan
 */
@Data
public class Post {
    private String postUUID;  // 帖子 uuid
    private String section;  // 帖子版块
    private String authorUUID;   // 帖子作者uuid
    private String authorName;  // 帖子作者名字
    private String title;  // 帖子标题
    private String[] labels;  // 帖子标签
    private String readme;    // 帖子自述介绍
    private String content;  // 帖子内容
    private String coverUrl;  // 帖子封面图片url
    private long likeAmount;  // 帖子被点赞数量
    private long dislikeAmount; // 帖子被踩数量
    private Date updateDate;   // 帖子更新时间
}
