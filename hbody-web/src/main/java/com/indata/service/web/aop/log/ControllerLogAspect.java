package com.indata.service.web.aop.log;

import com.indata.service.common.constant.CommonConfigConstant;
import com.indata.service.common.context.WebContext;
import com.indata.service.common.holder.ContextHolder;
import com.indata.service.common.model.ResultModel;
import com.indata.service.common.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author yangqi
 * @create 2021/4/13 17:33
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class ControllerLogAspect {


    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controller() {
    }

    @Around("controller()")
    public Object doAroundMethod(ProceedingJoinPoint pig) throws Throwable {
        MethodSignature methodSign = (MethodSignature) pig.getSignature();
        Class targetClass = pig.getTarget().getClass();
        String methodSignName = methodSign.getMethod().getName();
        String targetClassName = targetClass.getSimpleName();
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String requestUrI = request.getRequestURI();
        String method = request.getMethod();
        String requestId = request.getHeader(CommonConfigConstant.REQUEST_ID);
        if (requestId == null) {
            requestId = UUIDUtils.generateUUID(16);
        }
//        WebContext.putAccountId(SessionUtil.getAccountId(request));
        MDC.put(CommonConfigConstant.REQUEST_ID, requestId);
        String[] parameterNames = methodSign.getParameterNames();
        Object[] args = pig.getArgs();
        Object obj = null;
        log.info("【1】====start ====Request URI: {} method: {} accountId:{} ====start ====", requestUrI, method, WebContext.getAccountId());
        long startTime = System.currentTimeMillis();
        try {
            log.info("【2】参数名称{}, 值{}", Arrays.toString(parameterNames), Arrays.toString(args));
            log.info("【3】{}执行{}开始.", targetClassName, methodSignName);
            // 执行controller
            obj = pig.proceed();
        } catch (Throwable e) {
            log.error(" {}执行{}出错, 参数名称{}, 值{}.", targetClassName, methodSignName,
                    Arrays.toString(parameterNames), Arrays.toString(args), e);
            throw e;
        } finally {
            log.info("【4】{}执行{}结束, 总耗时{}ms.====end ====", targetClassName, methodSignName, System.currentTimeMillis() - startTime);
            if (obj instanceof ResultModel) {
                ResultModel resultModel = (ResultModel) obj;
                resultModel.setRequestId(requestId);
            }
            MDC.remove(CommonConfigConstant.REQUEST_ID);
            ContextHolder.clean();
        }
        return obj;
    }
}
