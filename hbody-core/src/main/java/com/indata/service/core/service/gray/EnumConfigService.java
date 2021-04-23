/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.core.service.gray;

import com.indata.service.dal.entity.EnumConfigOptionPO;

import java.time.LocalDate;
import java.util.List;

/**
 * 配置枚举
 *
 * @auther hufen
 * @date 2018/8/22 下午2:36
 */
public interface EnumConfigService {

    int insertSelective(EnumConfigOptionPO record);

    List<EnumConfigOptionPO> getListByType(String type);

    EnumConfigOptionPO getByTypeAndKey(String type, String key);

    List<EnumConfigOptionPO> getListByKey(String key);


    String getCardServer(String type);

    void updateSelective(String type, String key, String val);

}
