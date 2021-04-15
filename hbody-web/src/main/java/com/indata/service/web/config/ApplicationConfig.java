package com.indata.service.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yangqi
 * @create 2021/4/13 22:22
 */
@Configuration
@ComponentScan(basePackages = {
        "com.indata.service.core.service"
})
@PropertySource(value = {

}, ignoreResourceNotFound = true,  encoding = "UTF-8")
public class ApplicationConfig {
    /**
     * 后续添加redis，sms，weChat等配置添加
     */
}
