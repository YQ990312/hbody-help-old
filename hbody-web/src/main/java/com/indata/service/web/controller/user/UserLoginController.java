package com.indata.service.web.controller.user;

import com.indata.service.common.constant.LoginConstants;
import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import com.indata.service.common.util.CookieUtil;
import com.indata.service.common.util.UUIDUtils;
import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.core.tool.redis.RedisService;
import com.indata.service.common.model.bo.UserBO;
import com.indata.service.core.vo.request.UserLoginRequest;
import com.indata.service.dal.entity.UserInfoPO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author byai
 * @create 2021/4/18 10:15
 */
@RestController
@RequestMapping("api/user/common/login")
public class UserLoginController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RedisService redisService;

    /**
     * 用户账号密码登入
     *
     * @return
     */
    @PostMapping("/mobileAndPassword")
    public ResultModel loginAndPassword(@RequestBody UserLoginRequest userLoginRequest, HttpServletResponse response) {
        UserInfoPO userInfoPO = userInfoService.selectByMobile(userLoginRequest);
        if (Objects.isNull(userInfoPO)) {
            return ResultModel.fail(CommonErrorCodeEnum.VALIDATE_ERROR, "用户不存在");
        }
        //生成token，以后放redis中，以token为键，accountId为值放入redis中
        String token = UUIDUtils.generateUUID();
        redisService.set(token,String.valueOf(userInfoPO.getUserId()),LoginConstants.UUID_EXPIRE_TIME);
        CookieUtil.setCookie(response, LoginConstants.COOKIE_TOKEN_NAME, token, LoginConstants.UUID_EXPIRE_TIME);
        CookieUtil.setCookie(response, LoginConstants.CLIENT_TOKEN_NAME, "pc-client", LoginConstants.UUID_EXPIRE_TIME);
        UserBO userBO;
        return ResultModel.success(userInfoPO, "登录成功");
    }
}
