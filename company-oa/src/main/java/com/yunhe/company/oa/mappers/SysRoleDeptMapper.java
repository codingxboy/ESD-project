package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysRoleDept;
import com.yunhe.entity.domain.oa.SysRoleDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleDeptMapper {
    long countByExample(SysRoleDeptExample example);

    int deleteByExample(SysRoleDeptExample example);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);
}
