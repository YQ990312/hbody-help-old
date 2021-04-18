package com.indata.service.core.facade.user;

import com.indata.service.dal.entity.UserInfoPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangqi
 * @create 2021/4/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class UserInfoServiceTest {


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
    }

    public void deleteByUserId(Long userId){

    }

    public int updateByUserId(UserInfoPO userInfoPO){
        return 0;
    }

    public UserInfoPO selectByUserId(Long userId){
        return null;
    }
}
