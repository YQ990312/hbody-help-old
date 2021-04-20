package com.indata.service.dal.dao;

import com.indata.service.dal.entity.OrderInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangqi
 * @create 2021/4/19 21:34
 */
public interface OrderInfoPOMapper {
    OrderInfoPO selectByOrderId(@Param("orderId") Long orderId);

    void deleteByOrderId(@Param("orderId") Long orderId);

    int createNewOrder(OrderInfoPO orderInfoPO);

    int updateByOrderId(OrderInfoPO orderInfoPO);
}
