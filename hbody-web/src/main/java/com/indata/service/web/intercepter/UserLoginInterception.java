package com.indata.service.web.intercepter;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import com.indata.service.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangqi
 * @create 2021/4/13 14:10
 */
public class UserLoginInterception implements HandlerInterceptor {

    private final static Logger logger= LoggerFactory.getLogger(UserLoginInterception.class);
    /**
     * 未登入
     */
    private static String UN_LOGIN_MSG = JsonUtils.object2String(ResultModel.fail(CommonErrorCodeEnum.USER_NOT_LOGIN));
    /**
     * 登入过期
     */
    private static String NOT_EXIT_MSG = JsonUtils.object2String(ResultModel.fail(CommonErrorCodeEnum.ACCOUNT_NOT_EXSITS));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
