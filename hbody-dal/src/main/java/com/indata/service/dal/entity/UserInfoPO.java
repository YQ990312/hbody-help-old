package com.indata.service.dal.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yangqi
 * @create 2021/4/14 21:04
 */
@Data
public class UserInfoPO {
    /**
     * 用户id（自增）
     */
    private Long userId;
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
     * 用户密码
     */
    private String userPassword;
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
     * 是否添加黑名单
     */
    private Boolean userBacklist;
    /**
     * 违规条数
     */
    private Integer userRole;
    /**
     * 用户权限 0-超级管理员 1-地区管理员 2-普通用户
     */
    private Integer userJurisdiction;
    /**
     * 管理员管理学校id
     */
    private Integer userRegulateSchool;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

}
