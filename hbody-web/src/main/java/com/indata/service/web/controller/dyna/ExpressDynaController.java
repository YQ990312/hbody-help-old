package com.indata.service.web.controller.dyna;

import com.indata.service.common.constant.LoginConstants;
import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.exception.CommonException;
import com.indata.service.common.model.ResultModel;
import com.indata.service.core.service.dyna.ExpressDynaService;
import com.indata.service.core.vo.bo.UserBO;
import com.indata.service.core.vo.request.OrderSubmitRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author yangqi
 * REQUEST_PARAM_ERROR
 * @create 2021/4/20 11:58
 */
@RestController
@RequestMapping("api/dyna")
public class ExpressDynaController {

    @Resource
    private ExpressDynaService expressDynaService;

    @PostMapping("submit")
    public ResultModel submitOrder(HttpSession session, @RequestBody OrderSubmitRequest orderSubmitRequest){
        UserBO userBO=(UserBO)session.getAttribute(LoginConstants.LOGIN_USER);
        if(Objects.isNull(userBO)){
            return ResultModel.fail(CommonErrorCodeEnum.USER_NOT_LOGIN,"用户未登入");
        }
        checkParam(orderSubmitRequest);
        if(Objects.isNull(orderSubmitRequest.getOrderWeight())){
            orderSubmitRequest.setOrderWeight(-1);
        }
        expressDynaService.expressDynaSubmit(orderSubmitRequest,userBO);
        return ResultModel.success("下单成功");
    }
    private void checkParam(OrderSubmitRequest orderSubmitRequest){
        if(Objects.isNull(orderSubmitRequest)){
            throw new CommonException(CommonErrorCodeEnum.PARAM_ERROR,"参数校验错误");
        }
        if (StringUtils.isEmpty(orderSubmitRequest.getOrderUserMobile())) {
            throw new CommonException(CommonErrorCodeEnum.REQUEST_PARAM_ERROR,"手机号码不能为空");
        }
        if(StringUtils.isEmpty(orderSubmitRequest.getOrderUserNumber())){
            throw new CommonException(CommonErrorCodeEnum.REQUEST_PARAM_ERROR,"取件码不能为空");
        }
        if(StringUtils.isEmpty(orderSubmitRequest.getOrderGetAddress())){
            throw new CommonException(CommonErrorCodeEnum.REQUEST_PARAM_ERROR,"派送地址不能为空");
        }
    }
}
