package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.util.List;

/**
 * 帖子数据对象类
 * author: EatFan
 */
@Data
public class Post {
    // 帖子的基础数据
    private String postUuid;  // 帖子 uuid  不能为空、可以作为索引
    private String title;  // 帖子标题       不能为空
    private String readme;    // 帖子自述介绍   不能为空
    private String content;  // 帖子内容        不能为空
    private String coverUrl;  // 帖子封面图片url    可以为空
    private String authorUuid;   // 帖子作者uuid   不能为空、可以作为索引
    private String authorName;  // 帖子作者名字     不能为空、可以作为索引
    private Data createAt;  // 帖子创建时候的时间戳   默认自动添加 可以作为索引
    private Data updateAt; // 帖子更新时候的时间戳    不能为空，第一次创建时候，就为创建时间，后续手动修改这个时间戳     可以作为索引

    // 帖子分类和标签
    private String label1;  // 第一个标签 不能为空
    private String label2;  // 第二个标签 可以为空
    private String label3;  // 第三个标签 可以为空
    private String sectionType;  // 帖子版块类型     不能为空、可以作为索引

    // 帖子互动信息
    private long replyCount;  // 帖子的回复量        可以为空、可以作为索引
    private long viewCount;   // 帖子浏览量          可以为空、可以作为索引
    private long likeCount;  // 帖子点赞量           可以为空、可以作为索引
    private long dislikeCount;  // 帖子被踩量        可以为空、可以作为索引
    private long shareCount;  // 帖子分享量          可以为空、可以作为索引


    // 帖子状态
    private String status; // 帖子的状态、可以作为索引
    private boolean isPinned; // 帖子是否为置顶、可以作为索引
    private boolean isFeatured;  // 帖子是否为精华、可以作为索引
    private boolean isLocked;   // 帖子是否为锁定、可以作为索引
    private boolean isReviewed;         // 帖子是否已经通过审核、可以作为索引
    private long reportedCount;            // 帖子被举报的数量
    private String visibility;  // 帖子访问权限，如公开、私密、仅好友可见

    // 帖子评论区
    private List<Comment> comments;

}
