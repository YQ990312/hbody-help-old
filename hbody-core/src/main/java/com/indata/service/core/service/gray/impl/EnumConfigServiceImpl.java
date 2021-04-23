package com.indata.service.core.service.gray.impl;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.exception.CommonException;
import com.indata.service.core.service.gray.EnumConfigService;
import com.indata.service.dal.dao.EnumConfigOptionPOMapper;
import com.indata.service.dal.entity.EnumConfigOptionPO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yangqi
 * @date 2018/8/22 下午2:37
 */
@Service
@Slf4j
public class EnumConfigServiceImpl implements EnumConfigService {

    private static final Logger logger = LoggerFactory.getLogger(EnumConfigService.class);


    @Resource
    private EnumConfigOptionPOMapper enumConfigOptionPOMapper;

    @Override
    public int insertSelective(EnumConfigOptionPO record) {
        return enumConfigOptionPOMapper.insertSelective(record);
    }

    @Override
    public List<EnumConfigOptionPO> getListByType(String type) {
        return enumConfigOptionPOMapper.getListByType(type);
    }

    @Override
    public EnumConfigOptionPO getByTypeAndKey(String type, String key) {
        return enumConfigOptionPOMapper.getByTypeAndKey(type, key);
    }

    @Override
    public List<EnumConfigOptionPO> getListByKey(String key) {
        return enumConfigOptionPOMapper.getListByKey(key);
    }


    @Override
    public String getCardServer(String type) {
        List<EnumConfigOptionPO> list = enumConfigOptionPOMapper.getListByType(type);
        if (CollectionUtils.isEmpty(list)) {
            throw new CommonException(CommonErrorCodeEnum.VALIDATE_ERROR, "未配置该功能必要的card server url，请联系管理员");
        }
        return list.get(0).getConfigValue();
    }

    @Override
    public void updateSelective(String type, String key, String val) {
        EnumConfigOptionPO byTypeAndKey = getByTypeAndKey(type, key);
        EnumConfigOptionPO enumConfigOptionPO = new EnumConfigOptionPO();
        enumConfigOptionPO.setId(byTypeAndKey.getId());
        enumConfigOptionPO.setConfigValue(val);
        enumConfigOptionPO.setGmtModified(new Date());
        enumConfigOptionPOMapper.updateByPrimaryKeySelective(enumConfigOptionPO);
    }
}
