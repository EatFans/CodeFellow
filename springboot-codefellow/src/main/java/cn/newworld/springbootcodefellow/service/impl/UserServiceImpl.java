package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Boolean isAccountExists(String account) {
        // Test 测试
        return account.equalsIgnoreCase("eatfan0921");
    }
}
