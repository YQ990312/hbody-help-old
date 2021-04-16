package com.indata.service.core.service.user.impl;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.dal.dao.UserInfoPOMapper;
import com.indata.service.dal.entity.UserInfoPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangqi
 * @create 2021/4/16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoPOMapper userInfoPOMapper;
    
    @Override
    public int insert(UserInfoPO userInfoPO) {
        return userInfoPOMapper.insert(userInfoPO);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userInfoPOMapper.deleteByUserId(userId);
    }

    @Override
    public int updateByUserId(UserInfoPO userInfoPO) {
        return userInfoPOMapper.updateByUserId(userInfoPO);
    }

    @Override
    public UserInfoPO selectByUserId(Long userId) {
        return userInfoPOMapper.selectByUserId(userId);
    }
}
