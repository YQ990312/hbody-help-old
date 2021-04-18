/*
 *
 *  Copyright 2020 byai.com All right reserved. This software is the
 *  confidential and proprietary information of byai.com ("Confidential
 *  Information"). You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement you entered
 *  into with byai.com.
 * /
 */

package com.indata.service.dal.dao;


import com.indata.service.dal.entity.EnumConfigOptionPO;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * @author yangqi
 */
public interface EnumConfigOptionPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnumConfigOptionPO record);

    int insertSelective(EnumConfigOptionPO record);

    EnumConfigOptionPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnumConfigOptionPO record);

    int updateByPrimaryKey(EnumConfigOptionPO record);

    /**
     * ===========================手动添加方法开始分界线==========================
     */

    List<EnumConfigOptionPO> getListByType(@Param("configType") String type);

    EnumConfigOptionPO getByTypeAndKey(@Param("configType") String configType, @Param("configKey") String configKey);

    List<EnumConfigOptionPO> getListByKey(@Param("configKey") String configKey);


    EnumConfigOptionPO getConfigByCompany(@Param("configType") String configType, @Param("configKey") String configKey);
}