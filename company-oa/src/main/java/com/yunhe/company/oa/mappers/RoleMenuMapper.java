package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.RoleMenu;
import com.yunhe.entity.domain.oa.RoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {
    long countByExample(RoleMenuExample example);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);
}
