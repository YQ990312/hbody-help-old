/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.core.service.gray;

import com.google.common.base.Joiner;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.indata.service.common.model.RedisKeyCenter;
import com.indata.service.core.tool.redis.CacheTemplateService;
import com.indata.service.dal.entity.EnumConfigOptionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yangi
 * @date 2021/0/11 上午9:40
 */
@Component
public class GrayFunctionService {

    private static final Logger logger = LoggerFactory.getLogger(GrayFunctionService.class);


    @Resource
    private EnumConfigService enumConfigService;

    @Resource
    private CacheTemplateService cacheTemplateService;

    private final LoadingCache<String, Boolean> FUNCTION_COMPANY_CACHE = CacheBuilder.newBuilder()
            .maximumSize(500)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Boolean>() {
                @Override
                public Boolean load(String fnCmpId) throws Exception {
                    String[] vs = fnCmpId.split(":");
                    String func = vs[0];
                    String companyId = vs[1];
                    EnumConfigOptionPO enumPO = enumConfigService.getByTypeAndKey(func, companyId);
                    return enumPO != null;
                }
            });

    /**
     * 指定功能是否启用
     * 本地缓存
     *
     * @param function
     * @return
     */
    public boolean functionEnabledCache(String function, Integer companyId) {
        if (null == companyId) {
            return false;
        }
        String key = joiner.join(function, companyId.toString());
        try {
            return FUNCTION_COMPANY_CACHE.get(key);
        } catch (ExecutionException e) {
            logger.error("functionEnabled key:{} error:{}", key, e);
            return false;
        }
    }

    public boolean functionEnabledRedis(String configType, Integer companyId) {
        if (null == companyId) {
            return false;
        }
        String configValue;
        String key = RedisKeyCenter.getEnumGralKey(configType, companyId.toString());
        try {
            configValue = cacheTemplateService.findCache(key, String.class, () -> {
                EnumConfigOptionPO enumConfigOptionPO = enumConfigService.getByTypeAndKey(configType, companyId.toString());
                if (Objects.isNull(enumConfigOptionPO)) {
                    return null;
                }
                return enumConfigOptionPO.getConfigValue();
            });
            return configValue != null;
        } catch (Exception e) {
            logger.error("GrayFunctionService:查询redis缓存失败", e);
        }
        return false;
    }

    final static Joiner joiner = Joiner.on(":").skipNulls();
}
