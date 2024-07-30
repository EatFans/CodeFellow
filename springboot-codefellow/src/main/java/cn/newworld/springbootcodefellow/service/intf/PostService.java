package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.entity.Post;

/**
 * 帖子业务接口类
 * author: EatFan
 */
public interface PostService {
    /**
     * 创建帖子
     * @param post 帖子数据对象实体
     * @return 如果创建成功就返回true，否则就返回false
     */
    boolean create(Post post);

    /**
     * 生成一个唯一的Uuid
     * @return 返回已经生成好的uuid
     */
    String generateUniqueUuid();

    /**
     * 检查是否存在这个uuid
     * @param uuid 帖子uuid
     * @return 如果存在就返回true，否则就返回false
     */
    boolean doesUuidExist(String uuid);
}
