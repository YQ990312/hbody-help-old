package com.indata.service.core.service.user.impl;

import com.indata.service.common.constant.LoginConstants;
import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.exception.CommonException;
import com.indata.service.common.util.CookieUtil;
import com.indata.service.common.util.UUIDUtils;
import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.core.vo.request.UserLoginRequest;
import com.indata.service.dal.dao.UserInfoPOMapper;
import com.indata.service.dal.entity.UserInfoPO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author yangqi
 * @create 2021/4/16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

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

    @Override
    public UserInfoPO selectByMobile(UserLoginRequest userLoginRequest) {
        String mobile = userLoginRequest.getMobile();
        String password = userLoginRequest.getPassword();
        if (StringUtils.isEmpty(mobile)) {
            throw new CommonException(CommonErrorCodeEnum.VALIDATE_ERROR, "密码不能为空", "用户登录，密码不能空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new CommonException(CommonErrorCodeEnum.VALIDATE_ERROR, "手机号码不能为空", "用户登录，手机号码不能为空");
        }
        UserInfoPO userInfoPO = userInfoPOMapper.selectByMobile(mobile, password);
        if (Objects.isNull(userInfoPO)) {
            logger.error("mobile:{} 账号密码错误", mobile);
            throw new CommonException(CommonErrorCodeEnum.VALIDATE_ERROR, "账号或密码错误", "用户登录，账号或密码错误");
        }

        //加密判断密码是否正确
        /**
         * if (StringUtils.isNotEmpty(password)) {
         *             Pair<String, String> comparePasswords = getComparePasswords(userLoginVO, byrobotAccountDO);
         *             if (!StringUtils.equals(comparePasswords.getLeft(), comparePasswords.getRight())) {
         *                 Long errorTimes = checkErrorLoginTimes(mobile);
         *                 Map<String, Long> errorData = new HashMap<>();
         *                 errorData.put("errorTimes", errorTimes);
         *                 throw new CommonException(CommonErrorCode.VALIDATE_ERROR, "账号或密码错误", "用户登录，账号或密码错误").setData(errorData);
         *             }else{
         *                 redisService.delete(RedisKeyCenter.getLoginErrorTimesKey(mobile));
         *             }
         *         }
         */

        //记录登入记录，后续补充
        /**
         *         AccountOperationWriter.createAccountOperationAsync(mobile, accountType.getCode(), AccountOperationEnum.LOGIN, "手机号密码登录 loginByPhoneAndPasswordAndType");
         */

        return userInfoPO;
    }

    @Override
    public int onlineRegister(String mobile, String password, HttpServletResponse response) {
        UserInfoPO userInfoPO = null;
        try {
            userInfoPO = addNewAccount(mobile, password);
            getLoginToken(response);
        } catch (Exception e) {
            if (Objects.nonNull(userInfoPO)) {
                userInfoPOMapper.deleteByUserId(userInfoPO.getUserId());
            } else {
                userInfoPOMapper.deleteByMobile(mobile);
            }
            logger.error("mobile:{} 注册失败", mobile, e);
        }
        return 0;
    }

    private UserInfoPO addNewAccount(String mobile, String password) {
        /**
         * 1.生成用户
         */
        UserInfoPO userInfoPO = addUser(mobile, password);

        /**
         * 2.创建用户
         */
        userInfoPOMapper.insert(userInfoPO);

        return userInfoPO;
    }

    private UserInfoPO addUser(String mobile, String password) {
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserNickName("宅帮-老板" + UUIDUtils.generateFourUUID());
        userInfoPO.setUserPassword(password);
        userInfoPO.setUserGender(0);
        userInfoPO.setUserMobile(mobile);
        userInfoPO.setUserJurisdiction(2);
        return userInfoPO;
    }

    private void getLoginToken(HttpServletResponse response) {
        if (response == null) {
            return;
        }
        try {
            String token = UUIDUtils.generateUUID();
            CookieUtil.setCookie(response, LoginConstants.COOKIE_TOKEN_NAME, token, LoginConstants.UUID_EXPIRE_TIME);
            CookieUtil.setCookie(response, LoginConstants.CLIENT_TOKEN_NAME, "pc-client", LoginConstants.UUID_EXPIRE_TIME);
        } catch (Exception e) {
            logger.error("设置cookie失败", e);
        }
    }
}
