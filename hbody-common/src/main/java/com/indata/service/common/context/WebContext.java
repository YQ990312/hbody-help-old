package com.indata.service.common.context;

import com.indata.service.common.holder.ContextHolder;
import com.indata.service.common.model.bo.UserBO;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YangQi
 * @Date: 2022/2/25 14:31
 */
public class WebContext {

    private static ThreadLocal<Map<String, Object>> webContextTL = ThreadLocal.withInitial(HashMap::new);

    static {
        ContextHolder.register(webContextTL);
    }

    /**
     * 帐号ID
     */
    private static final String ACCOUNT_ID = "account_id";

    /**
     * 公司id
     */
    private static final String COMPANY_ID = "company_id";

    /**
     * 用户信息
     */
    private static final String USER_INFO = "user_info";

    /**
     * 权限信息
     */
    private static final String PERMISSION_INFO = "permission_info";

    public static void putAccountId(Long accountId) {
        if (accountId == null) {
            throw new NullPointerException();
        }
        webContextTL.get().put(ACCOUNT_ID, accountId);
    }

    public static void putCompanyId(Integer schoolId) {
        if (schoolId == null) {
            throw new NullPointerException();
        }
        webContextTL.get().put(COMPANY_ID, schoolId);
    }

    public static void putUserInfoBo(UserBO userBO) {
        if (userBO == null)
            throw new NullPointerException();
        webContextTL.get().put(USER_INFO, userBO);
    }


    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getAccountId() {
        return (Long) webContextTL.get().getOrDefault(ACCOUNT_ID, -1L);
    }

    /**
     * 获得公司id
     *
     * @return
     */
    public static Long getCompanyId() {
        return (Long) webContextTL.get().getOrDefault(COMPANY_ID, -1L);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static UserBO getUserInfoBO() {
        return (UserBO) webContextTL.get().get(USER_INFO);
    }
}
