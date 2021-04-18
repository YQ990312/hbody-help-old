/*
 *
 *  * Copyright 2020 byai.com All right reserved. This software is the
 *  * confidential and proprietary information of byai.com ("Confidential
 *  * Information"). You shall not disclose such Confidential Information and shall
 *  * use it only in accordance with the terms of the license agreement you entered
 *  * into with byai.com.
 *
 */

package com.indata.service.common.exception;


import com.indata.service.common.enums.CommonErrorCodeEnum;
import org.springframework.util.StringUtils;

/**
 * Created on 2017/03/10
 *
 * @author yangqi
 */
public class CommonException extends RuntimeException {

    protected String errMsg;
    protected String detailMsg;
    protected CommonErrorCodeEnum error;
    protected Object data;

    public CommonException(CommonErrorCodeEnum error) {
        super(error.getMsg());
        this.error = error;
        this.errMsg = error.getMsg();
    }

    public CommonException(CommonErrorCodeEnum error, String errMsg) {
        super(errMsg);
        this.error = error;
        this.errMsg = errMsg;
    }

    public CommonException(CommonErrorCodeEnum error, String errMsg, String detailMsg) {
        super(StringUtils.isEmpty(detailMsg) ? errMsg : detailMsg);
        this.error = error;
        this.errMsg = errMsg;
        this.detailMsg = detailMsg;
    }

    public CommonException(CommonErrorCodeEnum error, String errMsg, Throwable cause) {
        super(errMsg, cause);
        this.error = error;
        this.errMsg = errMsg;
    }

    public CommonException(CommonErrorCodeEnum error, String errMsg, String detailMsg, Throwable cause) {
        super(StringUtils.isEmpty(detailMsg) ? errMsg : detailMsg, cause);
        this.error = error;
        this.errMsg = errMsg;
        this.detailMsg = detailMsg;
    }

    public CommonException(CommonErrorCodeEnum error, Throwable cause) {
        super(error.getMsg(), cause);
        this.error = error;
        this.errMsg = error.getMsg();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public CommonErrorCodeEnum getError() {
        return error;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public Object getData() {
        return data;
    }

    public CommonException setData(Object data) {
        this.data = data;
        return this;
    }
}
