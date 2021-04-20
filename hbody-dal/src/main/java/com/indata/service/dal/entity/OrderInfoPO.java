package com.indata.service.dal.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yangqi
 * @create 2021/4/19 20:10
 */
@Data
public class OrderInfoPO {
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 下单用户
     */
    private Long orderUser;
    /**
     * 下单时间
     */
    private Date orderSureTime;
    /**
     * 学校
     */
    private Integer orderSchool;
    /**
     * 手机号
     */
    private String orderUserMobile;
    /**
     * 取件码
     */
    private String orderUserNumber;
    /**
     * 类型（重量）0-轻型 1-中型 2-大型
     */
    private Integer orderWeight;
    /**
     * 取件地址
     */
    private Integer orderAddress;
    /**
     * 派送地址
     */
    private String orderGetAddress;
    /**
     * 订单备注
     */
    private String orderComment;
    /**
     * 对东西描述
     */
    private String orderDescrebe;
    /**
     * 订单状体0-待取件 1-正在派送 2-已收货 -1-异常订单
     */
    private Integer orderStatus;
    /**
     * 派送人
     */
    private Long orderPerson;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
}
