package com.indata.service.dal.dao;

import com.indata.service.dal.entity.UserInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangqi
 * @create 2021/4/14 21:04
 */
public interface UserInfoPOMapper {

    int insert(UserInfoPO userInfoPO);

    void deleteByUserId(@Param("userId") Long userId);

    int updateByUserId(UserInfoPO userInfoPO);

    UserInfoPO selectByUserId(@Param("userId") Long userId);

    UserInfoPO selectByMobile(@Param("userMobile") String userMobile, @Param("userPassword") String userPassword);

    void deleteByMobile(@Param("mobile") String mobile);
}
