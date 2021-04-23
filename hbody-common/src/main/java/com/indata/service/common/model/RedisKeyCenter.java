package com.indata.service.common.model;

/**
 * @author yangqi
 * @create 2021/4/21 11:22
 */
public class RedisKeyCenter {

    public static String getLoginTokenKey(String token) {
        return String.format("hbody-help:LoginToken:token%S", token);
    }

    public static String getEnumGralKey(String configType, String configKey) {
        return String.format("hbody-help:gral:type:%S-key:%S", configType, configKey);
    }
}
