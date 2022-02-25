package com.indata.service.core.service.dyna;

import com.indata.service.common.model.bo.UserBO;
import com.indata.service.core.vo.request.OrderSubmitRequest;
import com.indata.service.dal.dao.OrderInfoPOMapper;
import com.indata.service.dal.entity.OrderInfoPO;
import com.indata.service.web.BootStrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author byai
 * @create 2021/4/22 17:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BootStrap.class)
public class DynaTest {

    @Resource
    private OrderInfoPOMapper orderInfoPOMapper;

    @Resource
    private ExpressDynaService expressDynaService;

    @Test
    public void testCreate(){
        OrderSubmitRequest orderSubmitRequest=new OrderSubmitRequest();
        orderSubmitRequest.setOrderUserMobile("15179038625");
        orderSubmitRequest.setOrderUserNumber("1223");
        orderSubmitRequest.setOrderWeight(1);
        orderSubmitRequest.setOrderAddress(123);
        orderSubmitRequest.setOrderGetAddress("江西省");
        orderSubmitRequest.setOrderComment("尽快送到");
        orderSubmitRequest.setOrderDescrebe("现在后了吗");
        UserBO userBO=new UserBO();
        userBO.setUserId(123L);
        userBO.setUserSchoolId(12);
        expressDynaService.expressDynaSubmit(orderSubmitRequest,userBO);
    }


    @Test
    public void testSelect(){
        OrderInfoPO orderInfoPO=orderInfoPOMapper.selectByOrderId(2L);
        System.out.println("数据"+orderInfoPO);
    }

    @Test
    public void testDelete(){
        orderInfoPOMapper.deleteByOrderId(2L);
    }

    @Test
    public void testUpdate(){
        OrderInfoPO orderInfoPO=new OrderInfoPO();
        orderInfoPO.setOrderId(3L);
        orderInfoPO.setOrderUser(1234L);
        orderInfoPO.setOrderGetAddress("浙江省");
        orderInfoPOMapper.updateByOrderId(orderInfoPO);
    }
}
