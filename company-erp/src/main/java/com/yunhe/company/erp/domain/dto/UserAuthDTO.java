package com.yunhe.company.erp.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: OAuth2 认证用户信息
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/25 10:55
 */
@Data
public class UserAuthDTO {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String passWord;

    /**
     * 用户状态(1:正常;0:禁用)
     */
    private Integer status;

    /**
     * 用户角色编码集合 ["ROOT","ADMIN"]
     */
    private List<String> roles;

    /**
     * 部门ID
     */
    private Long deptId;

}
