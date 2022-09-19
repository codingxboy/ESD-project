package com.yunhe.company.oa.mappers;

import com.yunhe.entity.domain.oa.SysDept;
import com.yunhe.entity.domain.oa.SysDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDeptMapper {
    long countByExample(SysDeptExample example);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    List<SysDept> selectByExample(SysDeptExample example);

    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);
}
