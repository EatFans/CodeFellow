package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.UserActionLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户操作日志数据映射接口
 * author: EatFan
 */
@Mapper
public interface UserActionLogMapper {
    /**
     * 向用户行为日志表插入一条用户行为日志
     * @param userActionLog 用户行为日志数据实体对象
     * @return 如果插入成功就返回数值大于0，小于等于0就是未插入成功
     */
    int insertUserActionLog(UserActionLog userActionLog);
}
