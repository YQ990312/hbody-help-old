/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.indata.service.common.constant;

/**
 * @author yangqi
 */
public class LoginConstants {

    public static final String COOKIE_TOKEN_NAME = "__byuuid";

    public static String ACCOUNT_ATTRIBUTE = "session.accountId";

    public static final String LOGIN_USER = "admin_login_user";


    public static final String CLIENT_TOKEN_NAME = "client-name";

    public static final int UUID_EXPIRE_TIME = 3600 * 24 * 3;

    public static final String PUSH_KEY = "!@#$%^&*&^%$#@!";

    public static final String AUTH_ACCOUNT_ID = "oauth-accountId";

    /**
     * 免登token-header
     */
    public static final String X_BIND_TOKEN_HEADER = "x-bind-token";

    public LoginConstants() {
    }
}
