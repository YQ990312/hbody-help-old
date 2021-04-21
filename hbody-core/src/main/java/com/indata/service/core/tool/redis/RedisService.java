package com.indata.service.core.tool.redis;

import com.indata.service.common.util.JsonUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yangqi
 * @create 2021/4/20 21:02
 */
@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplate getStringRedisTemplate(){
        return stringRedisTemplate;
    }

    /**
     * redis的添加String类型
     * @param key
     * @param value
     * @param timeOutSeconds
     * @param timeUnit
     */
    public void set(final String key, final String value, final long timeOutSeconds, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().set(key,value,timeOutSeconds,timeUnit);
    }

    /**
     * 对象转json添加到redis中
     * @param key
     * @param value
     * @param timeOutSeconds
     * @param timeUnit
     */
    public void set(final String key, final Object value, final long timeOutSeconds, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, JsonUtils.object2String(value), timeOutSeconds, timeUnit);
    }

    /**
     * 按照秒级别设置时长添加到redis中
     * @param key
     * @param value
     * @param timeOutSeconds
     */
    public void set(final String key, final String value, final long timeOutSeconds) {
        stringRedisTemplate.opsForValue().set(key, value, timeOutSeconds, TimeUnit.SECONDS);
    }

    /**
     * 使用默认时长添加key和value
     * @param key
     * @param value
     */
    public void set(final String key, final String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 判断key和value是否存在，不存在则添加，存在则不改变
     * @param key
     * @param value
     * @return
     */
    public Boolean setIfAbsent(final String key, final String value) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 按照秒级别设置时长
     * @param key
     * @param timeOutSeconds
     */
    public void set(final String key, final long timeOutSeconds) {
        set(key, key, timeOutSeconds);
    }

    /**
     * 按照迷人时间设置对象（转json）
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, JsonUtils.object2String(value));
    }

    /**
     * 判断这个是否存在，存在就不改变，不存在就添加
     * @param key
     * @param value
     */
    public void setIfAbsent(String key, Object value) {
        stringRedisTemplate.opsForValue().setIfAbsent(key, JsonUtils.object2String(value));
    }

    /**
     * 获取一个String的值
     * @param key
     * @return
     */
    public String get(final String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
