/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.indata.service.common.util;

import com.indata.service.common.constant.LoginConstants;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    /**
     * 从request中获取accountId
     * 注意返回 > 0 才是已登录
     *
     * @param request
     * @return
     */
    public static long getAccountId(HttpServletRequest request) {
        if (null == request) {
            return -1L;
        }
        Object accountId = request.getAttribute(LoginConstants.ACCOUNT_ATTRIBUTE);
        return null != accountId ? (Long) accountId : -1L;
    }


    /**
     * 从request中获取token(uuid)
     *
     * @param request
     * @return
     */
    public static String getUUid(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        Object uuid = request.getAttribute(LoginConstants.COOKIE_TOKEN_NAME);
        return null != uuid ? (String) uuid : null;
    }

}
