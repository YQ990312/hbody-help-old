package com.indata.service.web.filter;

import com.indata.service.common.constant.LoginConstants;
import com.indata.service.common.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author yangqi
 * @create 2021/4/16
 */
@Configuration
public class UserSessionFilter extends OncePerRequestFilter {

    private static final Logger logger= LoggerFactory.getLogger(UserSessionFilter.class);


    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("过滤器启动");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /**
         * 在cookie中获取clientName
         */
        String clientName = CookieUtil.getCookie(request, LoginConstants.CLIENT_TOKEN_NAME);

        if(StringUtils.isEmpty(clientName)){
            /**
             * 执行过滤拦截
             */
            this.doFilter(request);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        logger.info("过滤器销毁");
    }

    /**
     * 拦截请求，判断token是否失效，是否需要重新登入
     * @param request
     */
    private void doFilter(HttpServletRequest request){
        String token=null;
        Long accountId=null;
        try{
            token=CookieUtil.getCookie(request,LoginConstants.COOKIE_TOKEN_NAME);
            if(StringUtils.isNotEmpty(token)){
                accountId=Math.round(Math.random()*1000);
            }
            if(accountId!=null&& accountId>0){
                request.setAttribute(LoginConstants.ACCOUNT_ATTRIBUTE, accountId);
                request.setAttribute(LoginConstants.COOKIE_TOKEN_NAME, token);
            }
        }catch(Exception e){
            logger.error("AccountSessionFilter.doFilter failed", e);
            Boolean requestIsNull = Objects.isNull(request);
            logger.error("AccountSessionFilter.doFilter failed request is null:{}", requestIsNull);
            if (!requestIsNull) {
                logger.error("AccountSessionFilter.doFilter failed path is :{}", request.getRequestURI());
            }
            logger.error("AccountSessionFilter.doFilter failed token:{}, accountId:{}",
                    token, accountId);

            throw e;
        }
    }
}
