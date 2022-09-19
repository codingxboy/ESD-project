package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysDictType;
import com.yunhe.entity.domain.oa.SysDictTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictTypeMapper {
    long countByExample(SysDictTypeExample example);

    int deleteByExample(SysDictTypeExample example);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);
}
