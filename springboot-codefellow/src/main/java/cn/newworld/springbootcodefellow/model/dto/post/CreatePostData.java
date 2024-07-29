package cn.newworld.springbootcodefellow.model.dto.post;

import lombok.Getter;

/**
 * 创建帖子发送的数据对象
 * author: EatFan
 */
@Getter
public class CreatePostData {
    private String title;
    private String readme;
    private String content;
    private String coverUrl;
    private String authorUuid;
    private String authorName;
    private String label1;
    private String label2;
    private String label3;
    private String sectionType;
}
