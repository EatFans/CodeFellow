package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.dto.UserInfoData;
import cn.newworld.springbootcodefellow.service.intf.UserControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * User控制器主要逻辑业务实现类
 * author: EatFan
 */
@Service
public class UserControllerServiceImpl implements UserControllerService {
    public UserControllerServiceImpl(){

    }

    /**
     * 获取用户资料
     * @return 返回响应
     */
    @Override
    public ResponseEntity<?> getUserProfile() {

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"测试成功！", new UserInfoData()));
    }
}
