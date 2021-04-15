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

/**
 * Created by louie on 16-11-16.
 */
public enum CommonErrorCodeEnum {


    /**
     * 错误码范围	3400 0000 ~ 3400 9999
     * (前两位标识业务模块，自增，后两位模块内自定义)
     *
     * 1000-1099 线索 3400 1000
     * 2000-2099 客户 3400 2000
     * ...
     * 1100-1199 跟进记录 3400 1100
     *
     */


    SUCCESS(200, "执行成功"),
    DUBBO_ERROE(306, "调用dubbo接口失败"),

    USER_NOT_LOGIN(400, "用户未登录"),
    VALIDATE_ERROR(401, "校验数据错误"),
    NOT_EXSITS(404, "不存在"),
    NOT_REGISTER(408, "未注册"),

    FORBIDDEN(403, "权限不足"),
    RESOURCE_NOT_FOUND(404, "资源未找到"),
    RESOURCE_CONFLICT(409, "资源冲突"),
    REQUEST_PARAM_ERROR(412, "参数错误"),
    DATE_ERROR(407, "日期选择不对"),
    NOT_SUPPORT(409, "不支持"),
    RE_LOGIN(400, "登录已过期,请重新登录"),
    ACCOUNT_OVERDUE(411, "账号试用期已经结束, 请联系商务"),
    NO_PERMISSION(414, "没有该权限点，请联系上级管理员添加权限"),
    TOKEN_ERROR(415, "获取token失败"),

    UNKNOWN_ERROR(500, "未知错误"),
    SERIALIZATION_ERROR(501, "服务器无法完成该请求"),

    PHONE_EXIST(20000001, "手机号已经存在"),
    PHONE_VERIFY_CODE_ERROR(20000002, "验证码错误"),
    PHONE_VERIFY_CODE_NOT_EXIST(20000004, "验证码不存在"),
    PHONE_PATTERN_INCORRECT(20000006, "手机号不正确"),

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
    WECHAT_MINI_GET_TOKEN_FAIL(433, "获取accessToken失败"),


    HTTP_SERVICE_EXCEPTION(900, "http请求异常"),

    APP_PUSH_CLIENT_EXCEPTION(1001, "app推送消息client异常"),

    MOBILE_HAS_EXISE(10001400, "此电话号码已经绑定其他账号"),

    WECHAT_CODE_LOGIN_FAIL(10000440, "code登录失败"),

    SEND_CAPTCHA_FAIL(10000450, "网络异常，发送验证失败，请重试"),

    CAPTCHA_ALERADY_SEND(10000451, "验证码已经发送"),

    SEND_CAPTCHA_EX(10000452, "短信发送异常，请重试"),


    /**
     * 内部网关调用错误码
     */
    PARAM_ERROR(10001000, "参数错误"),
    EMPTY_PARAM(10001001, "参数不能为空"),
    DUPLICATE_KEY(10001002,"重复插入"),
    TOP_DEPARTMENT_NOT_EXIST(10001203, "顶级部门不存在"),
    COMPANY_DEPARTMENT_ERROR(10001204, "公司部门信息错误"),

    /**
     * 二维码生成错误码
     */
    QRCODE_IMAGE_CREATE_FAILED(20001000, "二维码生成失败"),
    QRCODE_IMAGE_UPLOAD_FAILED(20001001, "二维码上传失败"),
    QRCODE_IMAGE_FAILED_UNKNOWN(20001002, "二维码获取失败"),

    /**
     * 用户邀请
     */
    MOBILE_BELONGS_ACCOUNT(20002000, "您已通过审核，不需要重复提交"),
    RECORD_EXIST(20002001, " 您已提交审核，请耐心等待处理，无需重复提交"),
    INVITEE_AUDIT_BATCH_RECORD_LIST_EMPTY(20002002, "邀请审核,用户记录不能为空"),
    IS_NOT_PERMISSION_GARY_COMPANY(20002003, "非灰度公司,功能暂未开放"),
    INVITEE_GET_QRCODE_EX(20002004, "用户邀请,获取二维码异常"),


    DELETE_BATCH_USER_ROLE_RELAION_PARAM_EMPTY(20003001, "用户和角色不能全部为空"),
    DELETE_BATCH_USER_ROLE_RELAION_NOT_FIND(20003002, "未找到用户和角色的绑定关系"),
    DELETE_BATCH_USER_ROLE_RELAION_IS_EMPTY(20003003, "部分用户没有角色绑定关系"),
    DELETE_BATCH_USER_ROLE_RELAION_AFTER_EMPTY(20003004, "删除后,部分用户没有角色"),
    ADD_BATCH_USER_ROLE_RELAION_OVER_MAX_SIZE(20003005, "部分用户角色达到上限,每人最多支持绑定5个角色"),
    DELETE_BATCH_USER_ROLE_RELAION_CONSTANCT_MAIN(20003005, "删除用户中包含主体账号,主体账号角色不允许操作"),

    DELETE_BATCH_CUSTOMER_DATA_PERMISSIN_PARAM_EMPTY(20004004, "删除自定义数据权限参数为空"),


    /**
     * OpenAPI错误码
     */
    OPENAPI_DATA_NOT_EXIST(50010404, "数据不存在"),
    OPENAPI_ILLEGAL_REQUEST(50010501, "非法请求"),
    OPENAPI_API_UNKNOWN_ERROR(50010500, "未知错误"),


    ACCOUNT_INFO_EMPTY(50010600, "未找到用户信息"),
    MINI_SEND_LOGIN_ERROR(50010700, "请求微信认证失败"),


    /**
     * 部门
     */
    DEPART_NOT_EXIST(34001000, "部门不存在"),
    GET_DEPART_LIST_PARAM_ERROR(34001001, "公司ID和部门ID集合不可全部为空"),
    GET_DEPART_PARAM_ERROR(34001001, "公司ID和部门ID不可全部为空"),

    /**
     * 公司
     */
    COMPANY_IDS_IS_NULL(34002000, "公司集合为空"),


    /**
     * 用户
     */
    GET_ACCOUNT_LIST_PARAM_ERROR(34004000, "公司ID和用户ID集合不可全部为空"),
    //后续可以整合成一个错误码(ByrobotAccountServiceImpl.queryAccount参数校验)
    QUERY_ACCOUNT_ACCOUNT_ID_MISS(34004001, "用户ID不能为空"),


    /**
     * 数据权限
     */
    QUERY_VISIBLE_ACCOUNT_BY_PERMISSION_PARAM_ERROR(34005000, "参数缺失"),


    /**
     * 密码错误达到最大次数
     */
    LOGIN_ERROR_TIMES_MAX_LOCK(34006000, "账户密码输入错误已达到5次，请十分钟后重试，或直接联系客服进行解除"),

    /**
     * openApi
     */
    DEPART_COMPANY_ID_EMPTY(34007000, "部门查询公司不能为空"),
    USER_COMPANY_ID_EMPTY(34007001, "员工查询公司不能为空"),
    USER_FETCH_CHILD_NEED_DEPARTMENT(34007002, "递归查询子部门员工部门不能为空"),
    USER_QUERY_OVER_MAX_PAGE_SIZE(34007003, "每页的记录数超过最大值"),

    /**
     * aicrm
     */
    AUTH_ACCOUNT_NOT_ENOUGH(40000001,"剩余可授权用户数不足"),
    ;



    private Integer code;
    private String msg;

    CommonErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
