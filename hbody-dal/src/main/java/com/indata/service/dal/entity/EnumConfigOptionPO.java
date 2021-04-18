/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.dal.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 杨齐
 */
@Data
public class EnumConfigOptionPO implements Serializable {
    /**
     * INTEGER(10) 必填
     * 主键
     */
    private Integer id;

    /**
     * VARCHAR(64) 必填
     */
    private String configType;

    /**
     * VARCHAR(64) 默认值[] 必填
     * 标识符
     */
    private String configKey;

    /**
     * VARCHAR(1024) 默认值[] 必填
     * 值
     */
    private String configValue;

    /**
     * VARCHAR(1024) 默认值[]
     * 描述
     */
    private String description;

    /**
     * TIMESTAMP(19) 必填
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * TIMESTAMP(19) 必填
     * 更新时间
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}