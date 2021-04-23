package com.indata.service.web.controller.gral;

import com.indata.service.common.constant.LoginConstants;
import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import com.indata.service.core.service.gray.EnumConfigService;
import com.indata.service.core.vo.bo.UserBO;
import com.indata.service.dal.entity.EnumConfigOptionPO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author yangqi
 * @create 2021/4/23 11:46
 */
@RestController
@RequestMapping("api/gral")
public class CheckIfGralController {

    @Resource
    private EnumConfigService enumConfigService;

    @GetMapping("/isGral")
    public ResultModel isGral(@RequestParam("configType") String configType, HttpSession session){
        UserBO userBO=(UserBO)session.getAttribute(LoginConstants.LOGIN_USER);
        if(userBO==null){
            return ResultModel.fail(CommonErrorCodeEnum.USER_NOT_LOGIN,"用户未登入");
        }
        EnumConfigOptionPO enumConfigOptionPO=enumConfigService.getByTypeAndKey(configType,userBO.getUserSchoolId().toString());
        if(Objects.isNull(enumConfigOptionPO)){
            return ResultModel.fail(CommonErrorCodeEnum.NOT_EXSITS,"不存在");
        }
        return ResultModel.success(true,"查询成功");
    }

    @GetMapping("/gralFunction")
    public ResultModel listGrals(HttpSession session){
        UserBO userBO=(UserBO)session.getAttribute(LoginConstants.LOGIN_USER);
        if(userBO==null){
            return ResultModel.fail(CommonErrorCodeEnum.USER_NOT_LOGIN,"用户未登入");
        }
        List<EnumConfigOptionPO> optionPOList=enumConfigService.getListByKey(userBO.getUserSchoolId().toString());
        if(optionPOList !=null && optionPOList.isEmpty()){
            return ResultModel.fail(CommonErrorCodeEnum.NOT_EXSITS,"不存在");
        }
        return ResultModel.success(optionPOList,"查询成功");
    }
}
