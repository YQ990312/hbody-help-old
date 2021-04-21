package com.indata.service.web.controller;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.core.tool.redis.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
