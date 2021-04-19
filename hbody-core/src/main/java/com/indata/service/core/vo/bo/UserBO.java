package com.indata.service.core.vo.bo;

import lombok.Data;

/**
 * @author yangqi
 * @create 2021/4/18 23:51
 */
@Data
public class UserBO {
    /**
     * 用户id（自增）
     */
    private Long userId;
    /**
     * 学校id
     */
    private Integer userSchoolId;
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
     * 手机号码
     */
    private String userMobile;
    /**
     * 用户权限 0-超级管理员 1-地区管理员 2-普通用户
     */
    private Integer userJurisdiction;
}
