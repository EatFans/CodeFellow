package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.constant.enums.UserAction;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户操作日志业务接口类
 * author: EatFan
 */
public interface UserActionLogService {
    void saveUserActionLog(String uuid, String username, UserAction userAction, String details, String status, HttpServletRequest httpServletRequest);
}
