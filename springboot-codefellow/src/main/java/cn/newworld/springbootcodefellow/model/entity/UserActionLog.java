package cn.newworld.springbootcodefellow.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户操作日志数据实体类
 * author: EatFan
 */
@Data
public class UserActionLog {
    private long logId;
    private String userUuid;
    private String username;
    private String action;
    private LocalDateTime timestamp;
    private String ip;
    private String userAgent;
    private String details;
    private String status;
}
