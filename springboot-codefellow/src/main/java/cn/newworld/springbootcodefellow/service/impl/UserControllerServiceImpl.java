package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.user.LoginTokenRequest;
import cn.newworld.springbootcodefellow.model.entity.UserProfile;
import cn.newworld.springbootcodefellow.service.intf.RedisService;
import cn.newworld.springbootcodefellow.service.intf.UserControllerService;
import cn.newworld.springbootcodefellow.service.intf.UserProfileService;
import cn.newworld.springbootcodefellow.util.TokenEncryptor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * User控制器主要逻辑业务实现类
 * author: EatFan
 */
@Service
public class UserControllerServiceImpl implements UserControllerService {
    private final RedisService redisService;
    private final UserProfileService userProfileService;
    public UserControllerServiceImpl(RedisService redisService,
                                     UserProfileService userProfileService){
        this.redisService = redisService;
        this.userProfileService = userProfileService;
    }

    /**
     * 获取用户资料
     * @return 返回响应
     */
    @Override
    public ResponseEntity<?> getUserProfile(LoginTokenRequest loginTokenRequest) {
        String token = loginTokenRequest.getToken();
        // 验证登录令牌token是否有效，确保token
        if (!redisService.tokenExists(token)){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"登录令牌无效"));
        }
        // 解析令牌，获取uuid
        String uuid = TokenEncryptor.decryptToken(token);
        if (uuid == null){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"解析token令牌失败，无法获取用户uuid"));
        }
        // 通过uuid来获取用户资料
        UserProfile userProfile = userProfileService.getUserProfileByUuid(uuid);
        // 检查是否获取成功
        if (userProfile == null){
            return ResponseEntity.ok(new ApiResponse(ResponseStatus.ERROR,"通过用户uuid来获取用户资料出现错误，无法获取用户资料"));
        }

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"成功获取用户资料！", userProfile));


    }


}
