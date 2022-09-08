package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yunhe.company.erp.generator.mappers.RoleMapper;
import com.yunhe.company.erp.generator.mappers.RoleMapperEx;
import com.yunhe.company.erp.service.RoleService;
import com.yunhe.entity.domain.erp.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/26 15:24
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Resource
    private RoleMapperEx roleMapperEx;
    @Override
    public Role getRoleWithoutTenant(Long roleId) {
        return roleMapperEx.getRoleWithoutTenant(roleId);
    }
}
