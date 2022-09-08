package com.yunhe.company.erp.service;
import com.yunhe.entity.domain.erp.Role;
public interface RoleService{
    Role getRoleWithoutTenant(Long roleId);
}
