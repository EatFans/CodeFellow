package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.enums.UserAction;
import cn.newworld.springbootcodefellow.mapper.UserActionLogMapper;
import cn.newworld.springbootcodefellow.model.entity.UserActionLog;
import cn.newworld.springbootcodefellow.service.intf.UserActionLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户操作日志业务实现类
 * author: EatFan
 */
@Service
public class UserActionLogServiceImpl implements UserActionLogService {
    private final UserActionLogMapper userActionLogMapper;

    @Autowired
    public UserActionLogServiceImpl(UserActionLogMapper userActionLogMapper){
        this.userActionLogMapper = userActionLogMapper;
    }

    /**
     * 保存用户操作日志
     * @param uuid 用户uuid
     * @param username 用户名
     * @param userAction 用户操作行为
     * @param details 行为具体描述
     * @param status 行为状态
     * @param httpServletRequest http请求数据
     */
    @Override
    public void saveUserActionLog(String uuid, String username, UserAction userAction, String details, String status, HttpServletRequest httpServletRequest) {
        UserActionLog userActionLog = new UserActionLog();
        userActionLog.setUserUuid(uuid);
        userActionLog.setUsername(username);
        userActionLog.setAction(userAction.toString());
        userActionLog.setIp(httpServletRequest.getRemoteAddr());
        userActionLog.setUserAgent(httpServletRequest.getHeader("User-Agent"));
        userActionLog.setDetails(details);
        userActionLog.setStatus(status);

        userActionLogMapper.insertUserActionLog(userActionLog);
    }
}
