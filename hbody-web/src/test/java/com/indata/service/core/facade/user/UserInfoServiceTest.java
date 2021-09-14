package com.indata.service.core.facade.user;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.dal.entity.UserInfoPO;
import com.indata.service.web.HbodyHelpBoot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author byai
 * @create 2021/4/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= HbodyHelpBoot.class)
public class UserInfoServiceTest {
    @Resource
    private UserInfoService userInfoService;

    @Test
    public void insert(){
        UserInfoPO userInfoPO=new UserInfoPO();
        userInfoPO.setUserSchoolId(12123);
        userInfoPO.setUserRealName("杨家齐");
        userInfoPO.setUserNickName("空城");
        userInfoPO.setUserPassword("123123");
        userInfoPO.setUserGender(1);
        userInfoPO.setUserDeliveryAddress("江西省上饶市铅山县石塘镇十一都村");
        userInfoPO.setUserAvatarUrl("http//baidu.com");
        userInfoPO.setUserMobile("15179038625");
        userInfoPO.setUserBacklist(false);
        userInfoPO.setUserRole(0);
        userInfoPO.setUserJurisdiction(2);
        userInfoPO.setUserRegulateSchool(112);
        int row=userInfoService.insert(userInfoPO);
        Assert.assertTrue(row==1);
    }

    @Test
    public void deleteByUserId(){
        userInfoService.deleteByUserId(Long.valueOf(2));
    }

    @Test
    public void updateByUserId(){
        UserInfoPO userInfoPO=new UserInfoPO();
        userInfoPO.setUserId(1L);
        userInfoPO.setUserSchoolId(123413);
        userInfoPO.setUserRealName("钉子强");
        userInfoPO.setUserNickName("空城哦那个我");
        userInfoPO.setUserPassword("大法");
        userInfoPO.setUserGender(2);
        userInfoPO.setUserDeliveryAddress("江西省上饶市广恩行");
        userInfoPO.setUserAvatarUrl("http//sohu.com");
        userInfoPO.setUserMobile("15179038628");
        userInfoPO.setUserBacklist(true);
        userInfoPO.setUserRole(1);
        userInfoPO.setUserJurisdiction(2);
        userInfoPO.setUserRegulateSchool(112);
        int row=userInfoService.updateByUserId(userInfoPO);
        Assert.assertTrue(row==1);
    }

    @Test
    public void selectByUserId(){
        UserInfoPO userInfoPO=userInfoService.selectByUserId(1L);
        System.out.println(userInfoPO);
    }
}
