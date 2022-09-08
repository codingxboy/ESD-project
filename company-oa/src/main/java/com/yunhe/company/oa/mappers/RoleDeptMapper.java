package com.yunhe.company.oa.mappers;

import com.yunhe.entity.domain.oa.RoleDept;
import com.yunhe.entity.domain.oa.RoleDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDeptMapper {
    long countByExample(RoleDeptExample example);

    int deleteByExample(RoleDeptExample example);

    int insert(RoleDept record);

    int insertSelective(RoleDept record);

    List<RoleDept> selectByExample(RoleDeptExample example);

    int updateByExampleSelective(@Param("record") RoleDept record, @Param("example") RoleDeptExample example);

    int updateByExample(@Param("record") RoleDept record, @Param("example") RoleDeptExample example);
}
