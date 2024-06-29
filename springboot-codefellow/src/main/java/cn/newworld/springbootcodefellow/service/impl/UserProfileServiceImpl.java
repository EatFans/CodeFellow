package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.mapper.UserProfileMapper;
import cn.newworld.springbootcodefellow.model.entity.UserProfile;
import cn.newworld.springbootcodefellow.service.intf.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户资料业务类
 * author: EatFan
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileMapper userProfileMapper;

    @Autowired
    public UserProfileServiceImpl(UserProfileMapper userProfileMapper){
        this.userProfileMapper = userProfileMapper;
    }

    /**
     * 创建新的用户资料
     * @param userProfile 需要创建的用户资料数据对象
     * @return 如果创建成功就返回true，否则就返回false
     */
    @Override
    public boolean create(UserProfile userProfile) {
        try {
            int rowsAffected = userProfileMapper.insertUserProfile(userProfile);
            return rowsAffected > 0;
        } catch (Exception e) {
            // 可以在这里处理异常情况，例如日志记录等
            e.printStackTrace();
            return false;
        }
    }
}
