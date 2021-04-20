package com.indata.service.core.vo.request;

import lombok.Data;

/**
 * @author yangqi
 * @create 2021/4/20 13:52
 */
@Data
public class OrderSubmitRequest {
    /**
     * 手机号
     */
    private String orderUserMobile;
    /**
     * 取件码
     */
    private String orderUserNumber;
    /**
     * 类型（重量）0-轻型 1-中型 2-大型 -1-没有填
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
}
