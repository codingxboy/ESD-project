package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysJob;
import com.yunhe.entity.domain.oa.SysJobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysJobMapper {
    long countByExample(SysJobExample example);

    int deleteByExample(SysJobExample example);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    List<SysJob> selectByExample(SysJobExample example);

    int updateByExampleSelective(@Param("record") SysJob record, @Param("example") SysJobExample example);

    int updateByExample(@Param("record") SysJob record, @Param("example") SysJobExample example);
}
