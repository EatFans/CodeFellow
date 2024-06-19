package cn.newworld.springbootcodefellow.controller;

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
    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        return name;
    }
}
