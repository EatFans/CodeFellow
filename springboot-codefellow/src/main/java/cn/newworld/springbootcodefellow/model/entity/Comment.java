package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.util.List;

/**
 * 论坛评论数据对象
 * author: EatFan
 */
@Data
public class Comment {
    private String commentUuid;  // 评论uuid
    private String postUuid;     // 帖子uuid
    private String authorUuid;   // 作者uuid
    private String authorName;   // 作者名
    private String content;      // 评论内容
    private Data createAt;       // 创建评论时间

    private long likeCount; // 评论点赞量
    private long dislikeCount; // 评论被踩量

    // 子评论
    private List<Comment> replies;  // 子评论列表

    // 父评论
    private String parentCommentUuid;  // 父评论 UUID 可以为空，如果为空表示这是顶级评论
}
