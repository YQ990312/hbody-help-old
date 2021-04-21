package com.indata.service.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @author yangqi
 * @create 2021/4/13 22:22
 */
@Configuration
@ComponentScan(basePackages = {
        "com.indata.service.core"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * 后续添加redis，sms，weChat等配置添加
     *
     */
    /**
     * 增加redis
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }
}
