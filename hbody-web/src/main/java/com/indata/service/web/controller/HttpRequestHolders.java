/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.web.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangqi
 * @date 2021-04-18
 */
public class HttpRequestHolders {

    private static final ThreadLocal<HttpServletRequest> localRequest = new ThreadLocal<>();

    public static void setHttpServletRequest(HttpServletRequest request) {
        localRequest.set(request);
    }

    public static HttpServletRequest getHttpServletRequest() {
        return localRequest.get();
    }

    public static void removeHttpServletRequest() {
        localRequest.remove();
    }
}
