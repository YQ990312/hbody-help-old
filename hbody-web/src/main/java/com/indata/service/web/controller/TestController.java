package com.indata.service.web.controller;

import com.indata.service.core.service.user.UserInfoService;
import com.indata.service.dal.entity.UserInfoPO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangqi
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserInfoService userInfoService;
    @GetMapping("/get")
    public String test(){
        Integer a = null;
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
        userInfoService.insert(userInfoPO);
        return "springboot";
    }
}
