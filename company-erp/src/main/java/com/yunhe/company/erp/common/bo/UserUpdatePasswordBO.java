package com.yunhe.company.erp.common.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName UserUpdatePasswordBO
 * @Description TODO 登录表单
 * @Author xiaozuqin
 * @Date 2022/7/25 9:32
 * @Version 1.0
 */
@Data
@ApiModel(value = "用户信息更新对象",description = "用户信息更新对象")
public class UserUpdatePasswordBO {
    private String loginName;
    private String oldPassWord;
    private String newPassWord;
    private String confirmPassword;
}
