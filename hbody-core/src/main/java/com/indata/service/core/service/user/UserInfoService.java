package com.indata.service.core.service.user;

import com.indata.service.core.vo.request.UserLoginRequest;
import com.indata.service.dal.entity.UserInfoPO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yangqi
 * @create 2021/4/16
 */

public interface UserInfoService {
    /**
     * 增加用户
     *
     * @param userInfoPO
     * @return
     */
    int insert(UserInfoPO userInfoPO);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteByUserId(Long userId);

    /**
     * 更新用户信息
     *
     * @param userInfoPO
     * @return
     */
    int updateByUserId(UserInfoPO userInfoPO);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    UserInfoPO selectByUserId(Long userId);

    /**
     * 根据手机号码查询用户
     *
     * @param userLoginRequest
     * @return
     */
    UserInfoPO selectByMobile(UserLoginRequest userLoginRequest);

    /**
     * 用户在线注册
     *
     * @param mobile
     * @param password
     * @param response
     * @return
     */
    int onlineRegister(String mobile, String password, HttpServletResponse response);
}
