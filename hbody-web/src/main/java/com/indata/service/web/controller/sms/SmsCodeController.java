package com.indata.service.web.controller.sms;

import com.indata.service.common.enums.CommonErrorCodeEnum;
import com.indata.service.common.model.ResultModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqi
 * @create 2021/4/18 17:11
 * 验证码放在redis中.
 */
@RestController
@RequestMapping("api/sms/code")
public class SmsCodeController {

    private static String FIANL_CODE = "123456";

    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    @GetMapping("/send")
    public ResultModel sendCode(@RequestParam("mobile") String mobile) {
        /**
         * 验证码放在redis中
         */
        return ResultModel.success();
    }

    /**
     * 验证-验证码
     *
     * @param mobile
     * @param code
     * @return
     */
    @GetMapping("/check")
    public ResultModel checkoutCode(@RequestParam("mobiel") String mobile,
                                    @RequestParam("code") String code) {
        if (!FIANL_CODE.equals(code)) {
            return ResultModel.fail(CommonErrorCodeEnum.PHONE_VERIFY_CODE_ERROR);
        }
        return ResultModel.success();
    }

}
