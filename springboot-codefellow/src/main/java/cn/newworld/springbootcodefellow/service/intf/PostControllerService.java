package cn.newworld.springbootcodefellow.service.intf;

import cn.newworld.springbootcodefellow.model.dto.post.CreatePostData;
import org.springframework.http.ResponseEntity;

/**
 * Post 控制器主要业务逻辑接口类
 * author: EatFan
 */
public interface PostControllerService {
    ResponseEntity<?> createPost(CreatePostData data);
}
