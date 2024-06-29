package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.UserProfile;

/**
 * 用户资料业务接口类
 * author: EatFan
 */
public interface UserProfileService {
    /**
     * 创建新的用户资料
     * @param userProfile 需要创建的用户资料数据对象
     * @return 如果创建成功就返回true，否则就返回false
     */
    boolean create(UserProfile userProfile);
}
