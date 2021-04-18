package com.indata.service.core.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author byai
 * @create 2021/4/18 10:31
 */
@Data
public class UserLoginRequest {
    /**
     * 手机号码
     */
    @NotEmpty(message = "手机号码不能为空")
    private String mobile;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 30, message = "密码长度在6到30之间")
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 是否加密
     */
    private Integer useEncrypt;

    /**
     * 用户权限
     */
    private Integer platformType;
}
