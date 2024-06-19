package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String hello(){
        return "Hello World";
    }

    @Override
    public String test(){
        return "test";
    }
}
