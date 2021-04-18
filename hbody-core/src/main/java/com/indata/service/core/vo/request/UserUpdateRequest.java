package com.indata.service.core.vo.request;

import lombok.Data;

/**
 * @author yangqi
 * @create 2021/4/18 16:28
 */
@Data
public class UserUpdateRequest {
    /**
     * 用户id（自增）
     */
    private String userId;
    /**
     * 学校id
     */
    private Integer userSchoolId;
    /**
     * 真实姓名
     */
    private String userRealName;
    /**
     * 昵称
     */
    private String userNickName;
    /**
     * 用户性别0-未知，1-男，2-女
     */
    private Integer userGender;
    /**
     * 收货地址
     */
    private String userDeliveryAddress;
    /**
     * 头像地址（现默认写死一个）
     */
    private String userAvatarUrl;
    /**
     * 手机号码
     */
    private String userMobile;
    /**
     * 用户权限 0-超级管理员 1-地区管理员 2-普通用户
     */
    private Integer userJurisdiction;
}
