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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangqi
 */
public class CookieUtil {


    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return null;
    }


    public static void setCookie(HttpServletResponse response, String key, String value, int maxAge) {
        Cookie newCookie = new Cookie(key, value);
        newCookie.setPath("/");
        newCookie.setMaxAge(maxAge);
        response.addCookie(newCookie);
    }

    public static void setCookie(HttpServletResponse response, String key, String crmDomain, String value, int maxAge) {

        Cookie cookie = new Cookie(key, value);
        //通过二级域名共享cookie
        cookie.setDomain(crmDomain);
        cookie.setPath("/");
        //关闭浏览器就没有cookie
        cookie.setMaxAge(maxAge);
        cookie.setSecure(false);
        cookie.setHttpOnly(false);
        response.addCookie(cookie);
    }

}
