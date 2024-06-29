package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户资料数据映射接口
 * author: EatFan
 */
@Mapper
public interface UserProfileMapper {
    /**
     * 插入一条用户资料数据
     * @param userProfile 用户资料
     * @return 如果插入成功就返回1，否则就小于1
     */
    int insertUserProfile(UserProfile userProfile);

    /**
     * 通过uuid来找用户资料
     * @param uuid 用户uuid
     * @return 如果查询成功就返回该用户资料对象，否则就返回null
     */
    UserProfile findUserProfileByUuid(String uuid);
}
