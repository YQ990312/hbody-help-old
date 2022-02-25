package com.indata.service.core.service.dyna;

import com.indata.service.common.model.bo.UserBO;
import com.indata.service.core.vo.request.OrderSubmitRequest;

/**
 * @author yangqi
 * @create 2021/4/20 11:54
 */
public interface ExpressDynaService {
    /**
     * 提交戴拿订单
     * @param orderSubmitRequest
     * @param userBO
     * @return
     */
    int expressDynaSubmit(OrderSubmitRequest orderSubmitRequest, UserBO userBO);
}
