/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.indata.service.common.enums;

import lombok.Getter;

/**
 * Created by louie on 16-11-16.
 */
public enum CommonErrorCodeEnum {
    /**
     * 执行成功
     */
    SUCCESS(200, "执行成功"),
    ALIYUN_API_ERROR(300, "调用阿里云API异常"),
    UPLOAD_OSS_ERROR(300, "上传OSS失败"),
    AMAP_API_ERROR(301, "调用高德API异常"),
    BOLAI_API_ERROR(302, "调用伯来API异常"),
    ALIYUN_IOT_API_ERROR(303, "调用阿里云IOT的API异常"),
    ALIYUN_DYVM_API_ERROR(304, "调用阿里云DYVM的API异常"),
    ALIYUN_DYVM_API_INIT_ERROR(305, "DYVM初始化异常"),

    //400 403 前端会强制做跳转，这两个返回码不能修改
    USER_NOT_LOGIN(400, "用户未登录"),
    VALIDATE_ERROR(401, "校验数据错误"),
    NOT_EXSITS(404, "不存在"),
    USER_LOGIN_AUTH_FAILED(401, "账号或密码错误"),
    ACCOUNT_NOT_EXSITS(400, "账号不存在"),
    NO_FREE_VOIP_ACCOUNT(404, "不存在空闲的VoIP账号"),
    VOIP_ACCOUNT_STATUS_ERROR(405, "VoIP账号状态异常"),
    COMPANY_NOT_EXSITS(406, "公司不存在"),
    AUTHENTICATION_FAILED(488, "JWT token认证失败"),

    HAS_EXSITS(405, "已经存在"),
    FORBIDDEN(403, "权限不足"),
    RESOURCE_NOT_FOUND(404, "资源未找到"),
    RESOURCE_CONFLICT(409, "资源冲突"),
    REQUEST_PARAM_ERROR(412, "参数错误"),
    PRECONDITION_FAILED(428, "要求先决条件"),
    PUBLIC_WECHAT_NOT_LOGIN(406, "请在微信公众号中打开链接"),
    DATE_ERROR(407, "日期选择不对"),
    TIME_ERROR(408, "时间选择不对"),
    NOT_SUPPORT(409, "不支持"),
    NO_EMPLOYEE_ROLE(410, "您还没认证成为员工,无权限操作"),
    RE_LOGIN(400, "登录已过期,请重新登录"),
    ACCOUNT_OVERDUE(411, "账号试用期已经结束, 请联系商务"),
    ERROR_NO_FACE(412, "人脸照片不清晰"),
    ERROR_AUTH(413, "没有权限"),
    NO_PERMISSION(414, "没有该权限点，请联系上级管理员添加权限"),

    TOKEN_EXPIRESIN(416, "免登已经过期,请重新获取token"),
    UN_OPEN_STORE(417, "未开通,无法获取免登token"),
    SMS_ERROR(418, "请稍后重试"),
    PARAM_ERROR(419, "参数校验不通过"),
    CS_STAFF_IM_REQUEST_ERROR(420, "人工坐席IM请求失败"),
    CS_STAFF_NOT_EXIST(421, "人工坐席不存在"),
    CHILD_ACCOUNT_NO_PERMISSION(425, "子账号无权限"),

    UNKNOWN_ERROR(500, "出问题了，请记录联系我们哦"),
    SERVER_POWER_LESS(501, "服务器无法完成该请求"),
    SERIALIZATION_ERROR(501, "服务器无法完成该请求"),
    RETRY_ERROR(502, "服务器重试出错"),
    REFRESH_ERROR(504, "请刷新页面"),
    NO_BIND_ERROR(505, "未绑定客户"),

    OPTIMISTIC_LOCK_VERSION_ERROR(600, "更新失败"),
    ALIYUN_NLS_MANAGE_ERROR(601, "阿里云nls管理出错"),

    /**
     * 阿里云特殊处理code
     */
    ALIYUN_HOTWORD_VOCABULARY_TOO_MANY(901, "阿里云热词库超限"),

    /**
     * 微信绑定，登录专用状态码
     */
    WECHAT_QRCODE_DEFAULT(420, "无结果,请重试"),
    WECHAT_QRCODE_OVERTIME(421, "二维码已失效，请刷新二维码"),
    WECHAT_QRCODE_FAIL(422, "失败"),
    WECHAT_QRCODE_BIND(423, "请绑定微信"),

    /**
     * 小程序状态码
     */
    WECHAT_MINI_PROGRAM_FAIL(430, "微信接口服务验证失败"),
    WECHAT_MINI_UNION_ACCOUNT_FAIL(431, "unionId未找到对应的绑定账号"),
    WECHAT_MINI_TOKEN_FAIL(432, "token验证失效"),

    /**
     * 需要特殊处理的code
     */
    HAS_AUTH_ERROR(600, "未知错误"),
    MOBILE_SEND_ERR(700, "短信发送失败"),
    TODAY_FREE_TRY_OUT_ALL_USED(701, "今日的免费试用次数已用完"),
    OPEN_DOOR_PERMISSION_DENIED(800, "开门权限不足"),
    PHONE_DEBT(801, "线路欠费"),
    SELF_LINE_PHONE_DEBT(806, "自有线路和渠道线路欠费"),
    UP_AVERAGE(802, "任务高于平均值"),
    SMS_DEBT(803, "短信欠费"),
    BALANCE_DEBT(804, "账号余额不足"),
    CALL_CHARGE_DEBT(805, "话费余额不足"),
    NOT_EMPLOYEE(900, "未认证为员工"),
    AI_SEAT_STOCK_SHORTAGE(777, "AI坐席库存不足"),
    BUSINESS_CARD_STOCK_SHORTAGE(778, "名片库存不足"),
    BUSINESS_CARD_REPORT_ERROR(779, "查询名片报表失败"),
    VOIP_ACCOUNT_CONFLICT(701, "VoIP账号重复"),
    DUBBO_ERROR(602, "百应远程服务异常"),
    SEAT_FULL_ERROR(702, "人工坐席已满"),

    /**
     * ai助理
     */
    DUPLICATION_PRODUCT(920, "产品助理已存在"),
    DUPLICATION_OFFICIAL_WEBSITE(921, "公司助理已存在"),

    /**
     * isv 100xx
     */
    APPKEY_HAS_EXISTS(10001, "AK已存在"),
    APPKEY_NOT_EXISTS(10002, "AK不存在"),
    COMPANY_HAS_BIND_ISV(10003, "已绑定isv"),


    DECISION_TEMPLATE_VARIABLE_NOT_EXIST(1101, "话术模版变量不存在"),
    DECISION_TEMPLATE_VARIABLE_VALUE_NOT_EXIST(1102, "话术模版变量值不存在"),
    SCENE_RECORD_NOT_EXIST(1103, "场景录音不存在"),

    /**
     * 在线注册
     */
    PHONE_EXIST(20000001, "手机号已经存在"),
    PHONE_VERIFY_CODE_ERROR(20000002, "验证码错误"),
    PHONE_VERIFY_ERROR(20000003, "手机号验证失败"),
    PHONE_VERIFY_CODE_NOT_EXIST(20000004, "验证码不存在"),
    PHONE_PASSWORD_NOT_EXIST(20000005, "手机密码不能为空"),
    PHONE_PATTERN_INCORRECT(20000006, "手机号码不正确"),
    CUSTOMER_EXIST(20000009, "客户已经存在"),

    /**
     * 线索2.0
     */
    CLUE_NOT_REGISTERD(20001, "线索未注册"),
    CLUE_EXPIRED(20002, "线索已过期"),

    /**
     * 充值金额异常
     */
    RECHARGE_AMOUNT_OVERFLOW(30001, "单次充值最多不超过9999元"),
    APP_IDENTITY_FAIL(40001, "身份认证失败"),

    EXIST_KNOWLEDGE_REFERENCE(1000, "该流程节点已被知识库关联引用"),
    EXIST_CS_GROUP_REFERENCE(1001, "该坐席组已被话术关联引用"),

    /**
     * 百应宝app登录
     */
    WECHAT_NOT_BIND_PHONE(50001, "该微信未绑定百应账户，请绑定后再使用微信登录"),
    PERSONAL_USER_NOT_PERMISSION(50002, "抱歉，您暂没有权限进入，请前往应用市场下载【百应宝】进行使用"),
    EE_USER_NOT_PERMISSION(50003, "亲~您已是企业版客户，请前往应用市场下载【百应CRM】进行使用"),

    /**
     * APP推送限流错误码
     */
    APP_LIMITS_ERROR(131000004, "APP推送达到限流标准"),

    /**
     * 名片错误码
     */
    BUSINESS_CARD_UNOPEN(30000001, "用户所属公司没有名片"),
    BUSINESS_CARD_COUNT_ERROR(30000002, "名片剩余数量不足，请升级"),
    BUSINESS_CARD_EXPIRE(30000003, "名片已过期，请续费"),

    /**
     * aicrm
     */
    AUTH_ACCOUNT_NOT_ENOUGH(40000001, "剩余可授权用户数不足"),
    QUERY_PERMISSION_GARY_FAIL(40000002, "权限灰度查询失败"),
    OVER_MAX_ROLE_LIST(40000003, "用户最多绑定5个角色"),
    NOT_SUPPORT_DEGRADE(40000004, "暂不支持产品降级"),

    //用户邀请-绑定角色
    INVITEE_UPDATE_RELATION_FAILED(50000001, "邀请用户绑定角色失败，请前往用户编辑页进行操作"),
    INVITEE_UPDATE_RELATION_EX(50000002, "邀请用户绑定角色异常，请前往用户编辑页进行操作"),
    INVITEE_RECORD_PAGE_QUERY_FAILED(50000003, "用户邀请记录分页查询失败"),
    INVITEE_RECORD_PAGE_QUERY_EX(50000004, "用户邀请记录分页查询异常"),
    INVITEE_RECORD_BATCH_AUDIT_FAILED(50000005, "用户邀请批量审核失败"),
    INVITEE_RECORD_BATCH_AUDIT_EX(50000006, "用户邀请批量审核异常"),
    INVITEE_RECORD_AUDIT_FAILED(50000005, "用户邀请审核失败"),
    INVITEE_RECORD_AUDIT_EX(50000006, "用户邀请审核异常"),

    //用户角色操作
    INSERT_BATCH_USER_ROLE_RELATION_EMPTY(50001001, "批量新增用户角色操作结果为空"),
    INSERT_BATCH_USER_ROLE_RELATION_FAILED(50001002, "批量新增用户角色操作失败"),
    INSERT_BATCH_USER_ROLE_RELATION_EX(50001003, "批量新增用户角色操作异常"),
    DELETE_BATCH_USER_ROLE_RELATION_EMPTY(50001004, "批量删除用户角色操作结果为空"),
    DELETE_BATCH_USER_ROLE_RELATION_FAILED(50001005, "批量删除用户角色操作失败"),
    DELETE_BATCH_USER_ROLE_RELATION_EX(50001006, "批量删除用户角色操作异常"),
    UPDATE_BATCH_USER_ROLE_RELATION_EMPTY(50001007, "批量更新用户角色操作结果为空"),
    UPDATE_BATCH_USER_ROLE_RELATION_FAILED(50001008, "批量更新用户角色操作失败"),
    UPDATE_BATCH_USER_ROLE_RELATION_EX(50001009, "批量更新用户角色操作异常"),

    //公司灰度
    COMPANY_GARY_OPEN_COMPANY_MATCH_FAIL(60001000, "只有部分灰度需要指定公司"),
    COMPANY_GARY_INSERT_DESC_BLANK(60001001, "新增灰度请添加描述"),
    COMPANY_GARY_UPDATE_ID_MISS(60001002, "公司灰度更新需要指定ID"),
    COMPANY_GARY_UPDATE_CONFIG_MISS(60001002, "更新灰度不存在"),
    COMPANY_GARY_KEY_EXIST(60001003, "灰度key已经存在"),
    COMPANY_GARY_COMPANY_MISS(60001004, "公司ID缺失"),
    COMPANY_GARY_UPDATE_CONFIG_KEY(60001005, "灰度key不允许修改"),


    /**
     * courier-回单
     */
    COMPANY_NOT_VERIFIED(70001000, "企业未实名认证"),
    VISITOR_NOT_VERIFIED(70001001, "访客未实名认证"),

    ;

    @Getter
    private Integer code;
    @Getter
    private String msg;

    CommonErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonErrorCodeEnum fromCode(Integer code) {
        CommonErrorCodeEnum[] enums = CommonErrorCodeEnum.values();
        for (CommonErrorCodeEnum errorCode : enums) {
            if (errorCode.code.equals(code)) {
                return errorCode;
            }
        }

        return UNKNOWN_ERROR;
    }
}
