package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.mapper.UserMapper;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final UserMapper userMapper;

    @Autowired
    public TestServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public String test() {
        return "测试";
    }

    @Override
    public String hello() {
        return "Hello World";
    }

    @Override
    public void putUserTest(User user) {
        userMapper.putUserTest(user);
    }
}
