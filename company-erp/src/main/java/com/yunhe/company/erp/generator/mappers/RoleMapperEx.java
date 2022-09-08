package com.yunhe.company.erp.generator.mappers;

import com.yunhe.entity.domain.erp.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RoleMapperEx {

    List<Role> selectByConditionRole(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByRole(
            @Param("name") String name);

    int batchDeleteRoleByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    Role getRoleWithoutTenant(
            @Param("roleId") Long roleId);
}
