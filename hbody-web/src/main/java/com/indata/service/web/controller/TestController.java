package com.indata.service.web.controller;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.core.tool.redis.RedisService;
import com.indata.service.core.vo.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yangqi
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RedisService redisService;

    @GetMapping("/get")
    public String test() {
        redisService.set("kongcheng","123");
        return redisService.get("kongcheng");
    }

    @PostMapping("test1")
    public String test_post(@RequestBody UserDTO userDTO){
        System.out.println("睡"+userDTO);
        return "成功";
    }
}
