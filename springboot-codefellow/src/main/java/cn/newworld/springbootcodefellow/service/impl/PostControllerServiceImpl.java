package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.AccountStatus;
import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.post.CreatePostData;
import cn.newworld.springbootcodefellow.model.entity.Post;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.model.entity.UserProfile;
import cn.newworld.springbootcodefellow.service.intf.PostControllerService;
import cn.newworld.springbootcodefellow.service.intf.PostService;
import cn.newworld.springbootcodefellow.service.intf.UserProfileService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Post 控制器业务主要逻辑实现类
 * author: EatFan
 */
@Service
public class PostControllerServiceImpl implements PostControllerService {
    private final PostService postService;
    private final UserService userService;

    private final UserProfileService userProfileService;

    @Autowired
    public PostControllerServiceImpl(PostService postService,UserService userService,UserProfileService userProfileService){
        this.postService = postService;
        this.userService = userService;
        this.userProfileService = userProfileService;
    }

    @Override
    public ResponseEntity<?> createPost(CreatePostData data){
        // 先通过用户uuid和用户名，从数据库中确定用户
        User user = userService.getUserByUUIDAndUsername(data.getAuthorUuid(), data.getAuthorName());

        if (user == null)
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"不存在该用户！"));

        String status = user.getStatus();
        // 检查用户账号状态能否发帖
        switch (status) {
            case AccountStatus.DISABLED:
                // 处理禁用账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号已经被禁用，无法发帖！"));
            case AccountStatus.PENDING:
                // 处理待审核账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号未激活，无法发帖！"));
            case AccountStatus.LOCKED:
                // 处理锁定账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号被锁定，无法发帖！"));
            case AccountStatus.SUSPENDED:
                // 处理暂停账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号被停用，无法发帖！"));
            case AccountStatus.BANNED:
                // 处理封禁账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号被封禁，无法发贴！"));
            case AccountStatus.INACTIVE:
                // 处理不活跃账号的逻辑
                return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"你的账号为不活跃账号，无法发帖！"));
            default:
                break;
        }

        // 检查用户等级是否为五级以上
        UserProfile userProfile = userProfileService.getUserProfileByUuid(data.getAuthorUuid());
        if (userProfile == null){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"创建帖子出现问题！"));
        }
        if (userProfile.getLevel() <= 5){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"抱歉！你的等级暂无法发帖！"));
        }

        // 创建帖子存入到数据库中
        Post post = createNewPost(data);
        postService.create(post);
        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"创建帖子成功！请等待帖子审核！",post));
    }

    /**
     * 创建一个新的帖子
     * @param data 请求的数据
     * @return Post对象
     */
    private Post createNewPost(CreatePostData data){
        Post post = new Post();
        post.setPostUuid(postService.generateUniqueUuid());
        post.setTitle(data.getTitle());
        post.setReadme(data.getReadme());
        post.setContent(data.getContent());
        post.setCoverUrl(data.getCoverUrl());
        post.setAuthorUuid(data.getAuthorUuid());
        post.setAuthorName(data.getAuthorName());
        post.setLabel1(data.getLabel1());
        post.setLabel2(data.getLabel2());
        post.setLabel3(data.getLabel3());
        post.setSectionType(data.getSectionType());
        return post;
    }
}
