package com.indata.service.dal.dao;

import com.indata.service.dal.entity.UserInfoPO;

/**
 * @author yangqi
 * @create 2021/4/14 21:04
 */
public interface UserInfoPOMapper {

    int insert(UserInfoPO userInfoPO);

    void deleteByUserId(Long userId);

    int updateByUserId(UserInfoPO userInfoPO);

    UserInfoPO selectByUserId(Long userId);
}
