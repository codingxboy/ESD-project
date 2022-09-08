package com.yunhe.company.oa.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description: OAuth2 认证用户信息
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/25 15:09
 */
@Data
@Builder
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
