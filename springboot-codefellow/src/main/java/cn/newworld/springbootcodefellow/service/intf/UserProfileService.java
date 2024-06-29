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

    /**
     * 通过uuid来获取用户资料
     * @param uuid 用户uuid
     * @return 如果存在用户资料就返回，否则就返回null
     */
    UserProfile getUserProfileByUuid(String uuid);
}
