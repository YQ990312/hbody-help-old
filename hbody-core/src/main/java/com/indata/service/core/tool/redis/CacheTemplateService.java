/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.core.tool.redis;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.indata.service.common.exception.CommonException;
import com.indata.service.common.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/03/19
 *
 * @author annpeter.it@gmail.com
 */
@Service
public class CacheTemplateService {
    private static final Logger logger = LoggerFactory.getLogger(CacheTemplateService.class);

    @Resource
    private RedisService redisService;

    private static Interner<String> pool = Interners.newWeakInterner();

    /**
     * 避免缓存穿透的模板
     *
     * @param key      缓存的key
     * @param loadBack 如果缓存失效, 怎么获取
     */
    public <T> T findCache(String key, Class<T> clazz, Callable<T> loadBack) {
        long timeout = 3600 * 24 * 5;
        TimeUnit unit = TimeUnit.SECONDS;
        if (true) {
            String json = redisService.get(key);
            if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
                logger.info("load cache = {}.", key);
                return JsonUtils.string2Object(json, clazz);
            } else {
                synchronized (pool.intern(key)) {
                    json = redisService.get(key);
                    if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
                        logger.info("load cache = {}.", key);
                        return JsonUtils.string2Object(json, clazz);
                    }

                    T result = doLoadBack(loadBack);

                    if (result != null) {
                        redisService.set(key, result.toString(), timeout, unit);
                    }
                    return result;
                }
            }
        } else {
            return doLoadBack(loadBack);
        }
    }

    /**
     * 避免缓存穿透的模板
     *
     * @param key      缓存的key
     * @param timeout  缓存的失效时间
     * @param unit     失效时间单位
     * @param clazz    缓存的类型
     * @param loadBack 如果缓存失效, 怎么获取
     */
    public <T> T findCache(String key, long timeout, TimeUnit unit, Class<T> clazz, Callable<T> loadBack) {
        if (true) {
            String json = redisService.get(key);
            if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
                logger.info("load cache = {}.", key);
                return JsonUtils.string2Object(json, clazz);
            } else {
                synchronized (pool.intern(key)) {
                    json = redisService.get(key);
                    if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
                        logger.info("load cache = {}.", key);
                        return JsonUtils.string2Object(json, clazz);
                    }

                    T result = doLoadBack(loadBack);

                    if (result != null) {
                        redisService.set(key, result, timeout, unit);
                    }
                    return result;
                }
            }
        } else {
            return doLoadBack(loadBack);
        }
    }

    public <T> T findCache(String key, long timeout, Class<T> clazz, Callable<T> loadBack) {
        return findCache(key, timeout, TimeUnit.SECONDS, clazz, loadBack);
    }

    private <T> T doLoadBack(Callable<T> loadBack) {
        try {
            return loadBack.call();
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw (CommonException) e;
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * 异步清理cache
     *
     * @param key
     */
    public void evictKeyCache(String key) {
        redisService.delete(key);
    }
}
