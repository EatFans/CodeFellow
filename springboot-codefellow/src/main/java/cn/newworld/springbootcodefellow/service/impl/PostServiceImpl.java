package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.mapper.PostMapper;
import cn.newworld.springbootcodefellow.model.entity.Post;
import cn.newworld.springbootcodefellow.service.intf.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 帖子业务实现类
 * author: EatFan
 */
@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    /**
     * 创建帖子
     * @param post 帖子数据对象实体
     * @return 如果创建成功就返回true，否则就返回false
     */
    @Override
    public boolean create(Post post) {
        try {
            int rowsAffected = postMapper.insertPost(post);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 生成一个唯一的Uuid
     * @return 返回已经生成好的uuid
     */
    @Override
    public String generateUniqueUuid() {
        String uuid;
        do {
            uuid = UUID.randomUUID().toString();
        } while (doesUuidExist(uuid));
        return uuid;
    }

    /**
     * 在数据库中查询uuid是否已经存在
     * @param uuid 帖子的uuid
     * @return 如果存在就返回true，否则就返回false
     */
    @Override
    public boolean doesUuidExist(String uuid) {
        return postMapper.countByPostUuid(uuid) > 0;
    }
}
