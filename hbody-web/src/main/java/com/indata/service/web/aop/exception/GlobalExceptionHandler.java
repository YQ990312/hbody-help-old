/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.web.aop.exception;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.exception.CommonException;
import com.indata.service.common.model.ResultModel;
import com.indata.service.common.util.JsonUtils;
import com.indata.service.common.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常改善版
 *
 * @author yangqi
 * @date 2021/04/12
 */
@Slf4j
@Order(value = -1)
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class GlobalExceptionHandler {

    private String getRequestId(HttpServletRequest request) {
        String requestId = UUIDUtils.generateUUID(16);
        log.info("====系统异常====requestId:{}", requestId);
        //请求的完整路径
        log.info("requestId:{}, URI:{}", requestId, request.getRequestURI());
        //请求的方式
        log.info("requestId:{}, method:{}", requestId, request.getMethod());
        //请求的参数
        log.info("requestId:{}, Param:{}", requestId, JsonUtils.object2String(request.getParameterMap()));
        return requestId;
    }

    @ExceptionHandler(value = Throwable.class)
    public ResultModel throwable(Throwable e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("====未知系统异常====, requestId:{}", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.UNKNOWN_ERROR, CommonErrorCodeEnum.UNKNOWN_ERROR.getMsg());
    }

    @ExceptionHandler(value = CommonException.class)
    public ResultModel commonException(CommonException ex, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.info("====自定义异常枚举类型==== requestId:{}", requestId, ex);
        return ResultModel.fail(requestId, ex, ex.getData());
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResultModel dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("数据长度超多限制 requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.REQUEST_PARAM_ERROR, "数据长度超出限制", e);
    }

    @ExceptionHandler(value = {DuplicateKeyException.class})
    public ResultModel duplicateKeyException(DuplicateKeyException e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("数据唯一性校验异常 Exception requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.REQUEST_PARAM_ERROR, "数据唯一性校验错误", e);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResultModel illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("内部参数校验错误 Exception requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.REQUEST_PARAM_ERROR, "服务器内部校验参数错误", e);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResultModel noHandlerFoundException(NoHandlerFoundException e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("请求的url不存在 requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.RESOURCE_NOT_FOUND, "请求的url不存在", e);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, MissingServletRequestPartException.class, MethodArgumentTypeMismatchException.class})
    public ResultModel missingServletRequestParameterException(Exception e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("参数类型或数量错误 requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.REQUEST_PARAM_ERROR, "参数类型或数量错误", e);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResultModel httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String requestId = getRequestId(request);
        log.error("请求方式错误 requestId:{} ", requestId, e);
        return ResultModel.fail(requestId, CommonErrorCodeEnum.REQUEST_PARAM_ERROR, "请求方式错误", e);
    }

}
