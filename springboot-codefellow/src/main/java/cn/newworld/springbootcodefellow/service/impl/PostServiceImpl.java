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

    @Override
    public String generateUniqueUuid() {
        String uuid;
        do {
            uuid = UUID.randomUUID().toString();
        } while (doesUuidExist(uuid));
        return uuid;
    }

    // 模拟数据库检查UUID是否存在的方法
    private boolean doesUuidExist(String uuid) {
        // TODO: 实现检查UUID在数据库中是否存在的逻辑
        // 例如，使用查询语句检查 posts 表中的 postUuid 字段是否已存在此 UUID
        return false; // 假设返回false表示UUID不存在
    }
}
