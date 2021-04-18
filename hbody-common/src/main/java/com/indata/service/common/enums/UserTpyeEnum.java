package com.indata.service.common.enums;

/**
 * @author byai
 * @create 2021/4/18 10:39
 */
public enum UserTpyeEnum {
    SUPER_USER(0, "超级管理员"),
    ADMINISTRATORS_USER(1, "学校管理员"),
    MNT_MS_USERS(2, "普通用户");

    private Integer code;
    private String desc;

    UserTpyeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserTpyeEnum fromCode(Integer code) {
        for (UserTpyeEnum iEnum : UserTpyeEnum.values()) {
            if (iEnum.getCode().equals(code)) {
                return iEnum;
            }
        }
        throw new RuntimeException("账号类型错误");
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
