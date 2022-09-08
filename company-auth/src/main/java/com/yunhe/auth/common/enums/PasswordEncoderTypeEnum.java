package com.yunhe.auth.common.enums;

import lombok.Getter;

/**
 * @ClassName PasswordEncoderTypeEnum
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/23 16:56
 * @Version 1.0
 */
public enum PasswordEncoderTypeEnum {
    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private String prefix;

    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }
}
