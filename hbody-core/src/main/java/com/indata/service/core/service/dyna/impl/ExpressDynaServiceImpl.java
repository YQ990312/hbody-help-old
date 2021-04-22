package com.indata.service.core.service.dyna.impl;

import com.indata.service.core.service.dyna.ExpressDynaService;
import com.indata.service.core.vo.bo.UserBO;
import com.indata.service.core.vo.request.OrderSubmitRequest;
import com.indata.service.dal.dao.OrderInfoPOMapper;
import com.indata.service.dal.entity.OrderInfoPO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yangqi
 * @create 2021/4/20 11:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpressDynaServiceImpl implements ExpressDynaService {

    @Resource
    private OrderInfoPOMapper orderInfoPOMapper;

    @Override
    public int expressDynaSubmit(OrderSubmitRequest orderSubmitRequest, UserBO userBO) {
        OrderInfoPO orderInfoPO=conversionToPo(orderSubmitRequest,userBO);
        System.out.println("数据"+orderInfoPO.getOrderId());
        return orderInfoPOMapper.createNewOrder(orderInfoPO);
    }
    private OrderInfoPO conversionToPo(OrderSubmitRequest orderSubmitRequest,UserBO userBO){
        OrderInfoPO orderInfoPO=new OrderInfoPO();
        orderInfoPO.setOrderUser(userBO.getUserId());
        orderInfoPO.setOrderSchool(userBO.getUserSchoolId());
        orderInfoPO.setOrderUserMobile(orderSubmitRequest.getOrderUserMobile());
        orderInfoPO.setOrderUserNumber(orderSubmitRequest.getOrderUserNumber());
        orderInfoPO.setOrderWeight(orderSubmitRequest.getOrderWeight());
        orderInfoPO.setOrderAddress(orderSubmitRequest.getOrderAddress());
        orderInfoPO.setOrderGetAddress(orderSubmitRequest.getOrderGetAddress());
        orderInfoPO.setOrderComment(orderSubmitRequest.getOrderComment());
        orderInfoPO.setOrderDescrebe(orderSubmitRequest.getOrderDescrebe());
        orderInfoPO.setOrderStatus(0);
        /**
         * 派送人，后期在处理一个学校管理时，管理下面的账号轮训分配
         */
        orderInfoPO.setOrderPerson(0L);
        return orderInfoPO;
    }
}
