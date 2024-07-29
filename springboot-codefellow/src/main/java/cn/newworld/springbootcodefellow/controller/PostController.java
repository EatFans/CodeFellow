package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.mapper.PostMapper;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.post.CreatePostData;
import cn.newworld.springbootcodefellow.model.entity.Post;
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
    private final PostMapper postMapper;

    @Autowired
    public PostController(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    //TODO 测试是否能正常插入一条帖子数据到帖子数据表中
    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody CreatePostData createPostData){
        Post post = new Post();
        post.setPostUuid("123");
        post.setTitle(createPostData.getTitle());
        post.setReadme(createPostData.getReadme());
        post.setContent(createPostData.getContent());
        post.setCoverUrl(createPostData.getCoverUrl());
        post.setAuthorUuid(createPostData.getAuthorUuid());
        post.setAuthorName(createPostData.getAuthorName());
        post.setLabel1(createPostData.getLabel1());
        post.setLabel2(createPostData.getLabel2());
        post.setLabel3(createPostData.getLabel3());
        post.setSectionType(createPostData.getSectionType());

        postMapper.insertPost(post);

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"发布帖子成功"));
    }
}
