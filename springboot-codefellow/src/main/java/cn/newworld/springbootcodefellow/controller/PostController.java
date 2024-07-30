package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.model.dto.post.CreatePostData;
import cn.newworld.springbootcodefellow.service.intf.PostControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子路由控制器类
 * author: EatFan
 */
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostControllerService postControllerService;

    @Autowired
    public PostController(PostControllerService postControllerService){
        this.postControllerService = postControllerService;
    }


    /**
     * 创建帖子
     * @param createPostData 请求发送过来的数据
     * @return 响应反馈的数据
     */
    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody CreatePostData createPostData){
        return postControllerService.createPost(createPostData);
    }

}
