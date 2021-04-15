package com.indata.service.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqi
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/get")
    public String test(){
        Integer a = null;
        a.intValue();
        return "springboot";
    }
}
