package cn.newworld.springbootcodefellow.mapper;

import cn.newworld.springbootcodefellow.model.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子数据对象映射接口类
 * author: EatFan
 */
@Mapper
public interface PostMapper {
    /**
     * 插入一条帖子数据到数据库中
     * @param post 被插入的帖子数据实体对象
     * @return 如果插入成功就返回1,否则返回0或-1
     */
    int insertPost(Post post);

}
