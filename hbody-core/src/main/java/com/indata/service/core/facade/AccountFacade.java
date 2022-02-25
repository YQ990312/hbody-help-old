package com.indata.service.core.facade;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.common.model.bo.UserBO;
import com.indata.service.dal.entity.UserInfoPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangqi
 * @create 2021/4/18 23:04
 */
@Service
public class AccountFacade {

    private final static Logger logger= LoggerFactory.getLogger(AccountFacade.class);

    @Resource
    private UserInfoService userInfoService;

    public UserInfoPO getUserByAccountId(Long userId) {
        if (null == userId) {
            return null;
        }

        try {
            UserInfoPO accountUser = userInfoService.selectByUserId(userId);
            if (null == accountUser) {
                return null;
            }
            return accountUser;
        } catch (Exception e) {
            logger.error("accountService.getUserByAccountId:{} throw error", userId, e);
        }
        return null;
    }

    public UserBO toUserBO(UserInfoPO userInfoPO) {
        UserBO userBO = new UserBO();
        try {
            userBO.setUserId(userInfoPO.getUserId());
            userBO.setUserSchoolId(userInfoPO.getUserSchoolId());
            userBO.setUserNickName(userInfoPO.getUserNickName());
            userBO.setUserRealName(userInfoPO.getUserRealName());
            userBO.setUserGender(userInfoPO.getUserGender());
            userBO.setUserDeliveryAddress(userInfoPO.getUserDeliveryAddress());
            userBO.setUserAvatarUrl(userInfoPO.getUserAvatarUrl());
            userBO.setUserMobile(userInfoPO.getUserMobile());
            userBO.setUserJurisdiction(userInfoPO.getUserJurisdiction());
            userBO.setUserRegulateSchool(userInfoPO.getUserRegulateSchool());
        } catch (Exception e) {
            logger.info("accountService.toUserBO:{}, e:", userInfoPO, e);
        }
        return userBO;
    }
}
