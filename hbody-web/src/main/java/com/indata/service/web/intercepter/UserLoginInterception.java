package com.indata.service.web.intercepter;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import com.indata.service.common.util.JsonUtils;
import com.indata.service.common.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

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
        Long accountId= SessionUtil.getAccountId(request);
        logger.info("登入拦截器 login:accountId:{}",accountId);
        if (accountId < 0) {
            String token = SessionUtil.getUUid(request);
            logger.info("用户未登录,或者已过期,url:{}, param:{}, token:{}",
                    request.getRequestURL(), getParamString(request), token);
            writeOutJson(response, UN_LOGIN_MSG);
            return false;
        }
        //没有单点登入服务，这里塞一个session
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void writeOutJson(HttpServletResponse response, String jsonMsg) throws IOException {
        response.setStatus(200);
        response.setContentType(APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().append(jsonMsg);
    }


    private String getParamString(HttpServletRequest request) {
        String paramString;
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (null != parameterMap && !parameterMap.isEmpty()) {
            paramString = JsonUtils.object2String(parameterMap);
        } else {
            paramString = getParamStringFromBody(request);
        }
        return paramString;
    }
    private String getParamStringFromBody(HttpServletRequest request){
        BufferedReader bufferedReader = null;
        try {
            String line;
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            logger.warn("user login interceptor get param string from request body throw ex:", e);
        }finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.warn("user login interceptor close reader throw ex:", e);
                }
            }
        }
        return "";
    }
}
