package com.indata.service.common.holder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: YangQi
 * @Date: 2022/2/25 14:33
 */
public class ContextHolder {

    private ContextHolder() {

    }

    /**
     * 线程池
     */
    private static final Set<ThreadLocal<Map<String, Object>>> POOL = new HashSet<>();

    /**
     * 注册
     */
    public static void register(ThreadLocal<Map<String, Object>> tl) {
        POOL.add(tl);
    }

    /**
     * 清除所有注册的线程变量
     */
    public static void clean() {
        POOL.forEach(ThreadLocal::remove);
    }
}
