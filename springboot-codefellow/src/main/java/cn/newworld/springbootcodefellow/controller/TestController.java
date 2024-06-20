package cn.newworld.springbootcodefellow.controller;

import cn.newworld.springbootcodefellow.constant.consist.ResponseStatus;
import cn.newworld.springbootcodefellow.model.dto.ApiResponse;
import cn.newworld.springbootcodefellow.model.entity.User;
import cn.newworld.springbootcodefellow.service.intf.TestService;
import cn.newworld.springbootcodefellow.service.intf.UserService;
import cn.newworld.springbootcodefellow.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public  TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        String uuid = UUIDGenerator.generateUUID(name);
        return "通过 name 生成的 uuid 为 ： " +uuid;
    }

    @GetMapping("/hello")
    public String getHello(){
        return testService.hello();
    }


    // 向数据库user数据表插入一条用户
    @PostMapping("/putUser")
    public ResponseEntity<?> putUserTest(@RequestBody User user){
        testService.putUserTest(user);

        return ResponseEntity.ok(new ApiResponse(ResponseStatus.SUCCESS,"成功向user数据表插入一条用户信息"));
    }
}
