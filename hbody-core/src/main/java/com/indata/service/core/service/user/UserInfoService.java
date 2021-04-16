package com.indata.service.core.service.user;

import com.indata.service.dal.entity.UserInfoPO;

/**
 * @author yangqi
 * @create 2021/4/16
 */

public interface UserInfoService {
    int insert(UserInfoPO userInfoPO);

    void deleteByUserId(Long userId);

    int updateByUserId(UserInfoPO userInfoPO);

    UserInfoPO selectByUserId(Long userId);
}
