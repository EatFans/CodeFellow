package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.service.intf.TestService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        return name;
    }

    @GetMapping("/hello")
    public String getHello(){
        return testService.hello();
    }
}
