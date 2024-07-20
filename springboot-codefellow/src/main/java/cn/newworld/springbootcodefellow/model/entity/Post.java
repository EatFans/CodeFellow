package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 帖子数据对象类
 * author: EatFan
 */
@Data
public class Post {
    // 帖子的基础数据
    private String postUUID;  // 帖子 uuid
    private String title;  // 帖子标题
    private String readme;    // 帖子自述介绍
    private String content;  // 帖子内容
    private String coverUrl;  // 帖子封面图片url
    private String authorUUID;   // 帖子作者uuid
    private String authorName;  // 帖子作者名字
    private Date createAt;  // 帖子创建时候的时间戳
    private Data updateAt; // 帖子更新时候的时间戳

    // 帖子分类和标签
    private List<String> labels;  // 帖子标签
    private String sectionType;  // 帖子版块类型

    // 帖子互动信息
    private long replyCount;  // 帖子的回复量
    private long viewCount;   // 帖子浏览量
    private long likeCount;  // 帖子点赞量
    private long dislikeCount;  // 帖子被踩量
    private long shareCount;  // 帖子分享量

    // 帖子状态
    private String status; // 帖子的状态
    private boolean isPinned; // 帖子是否为置顶
    private boolean isFeatured;  // 帖子是否为精华
    private boolean isLocked;   // 帖子是否为锁定

    // 帖子评论区
    private List<Comment> comments;

}
