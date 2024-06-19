package cn.newworld.springbootcodefellow.service.impl;

import cn.newworld.springbootcodefellow.service.intf.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "测试";
    }

    @Override
    public String hello() {
        return "Hello World";
    }
}
