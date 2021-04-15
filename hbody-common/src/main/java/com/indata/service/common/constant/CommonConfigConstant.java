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
 * @author wuque
 * @date 22/05/2017
 */
public class CommonConfigConstant {
    private CommonConfigConstant() {}

    public static final String REQUEST_ID ="REQUEST_ID";
    public static final String PHONE_CAPTCHA = "PHONE_CAPTCHA";
    public static final String INVITEE_PHONE_CAPTCHA = "INVITEE_PHONE_CAPTCHA";
    /**
     * 验证码调用间隔时间
     */
    public static final long CAPTCHA_LATENCY_TIME = 60000;
    /**
     * 验证码失效时间
     */
    public static final long CAPTCHA_INVALID_TIME = 900000;

    public static final long CAPTCHA_INVALID_REDIS_TIME = 5 * 60L;

    /**
     * 公司、部门、渠道信息缓存时间
     */
    public static final long COMPANY_INFO_CACHE_TIME = 120;

    /**
     * 用户角色-权限信息缓存时间
     */
    public static final long ACCOUNT_AUTH_INFO_KEY_CACHE_TIME = 60;

    /**
     * company缓存key
     */
    public static final String ACCOUNT_COMPANY_INFO_KEY = "account_company_info_key";

    /**
     * agency缓存key
     */
    public static final String ACCOUNT_AGENCY_INFO_KEY = "account_agency_info_key";

    /**
     * department缓存key
     */
    public static final String ACCOUNT_DEPARTMENT_INFO_KEY = "account_department_info_key";


    /**
     * 用户角色-权限信息缓存key
     */
    public static final String ACCOUNT_AUTH_INFO_KEY = "account_auth_info_key_";

    /**
     * 用户信息缓存key
     */
    public static final String ACCOUNT_INFO_KEY = "account_info_key_";

    /**
     * 角色-用户信息缓存key
     */
    public static final String PRODUCT_ROLE_USER_INFO_KEY = "product_role_user_info_key_";

    /**
     * 一键跳转登录BOSS
     */
    public static final String ACCOUNT_QUICK_LOGIN_BOSS_KEY = "account_quick_login_key:";

    /**
     * pc地理位置上报
     */
    public static final String ACCOUNT_PC_LOCATION_REPORT_KEY = "account_pc_location_report_key_";

    /**
     * 用户信息收集
     */
    public static final String ACCOUNT_INFORMATION_COLLECTION_KEY = "account_information_collection_key_";

    /**
     * 用户密码登录错误次数记数key
     */
    public static final String LOGIN_ERROR_TIMES_key = "account_login_error_times_key_";
}
