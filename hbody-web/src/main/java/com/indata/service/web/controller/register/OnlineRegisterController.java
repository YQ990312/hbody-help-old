package com.indata.service.web.controller.register;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import com.indata.service.core.service.user.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangqi
 * @create 2021/4/18 16:55
 */
@RestController
@RequestMapping("api/user/register")
public class OnlineRegisterController {

    @Resource
    private UserInfoService userInfoService;


    @PostMapping("/mobile")
    public ResultModel onelineRegister(@RequestParam(name = "mobile") String mobile,
                                       @RequestParam(name = "password") String password,
                                       @RequestParam(name = "fansId", required = false) Integer fansId,
                                       HttpServletResponse response) {
        if (StringUtils.isEmpty(password)) {
            return ResultModel.fail(CommonErrorCodeEnum.VALIDATE_ERROR, "密码格式错误");
        }
        userInfoService.onlineRegister(mobile, password, response);
        return ResultModel.success("注册成功");
    }
}
