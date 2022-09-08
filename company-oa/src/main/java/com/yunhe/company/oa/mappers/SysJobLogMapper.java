package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysJobLog;
import com.yunhe.entity.domain.oa.SysJobLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysJobLogMapper {
    long countByExample(SysJobLogExample example);

    int deleteByExample(SysJobLogExample example);

    int insert(SysJobLog record);

    int insertSelective(SysJobLog record);

    List<SysJobLog> selectByExample(SysJobLogExample example);

    int updateByExampleSelective(@Param("record") SysJobLog record, @Param("example") SysJobLogExample example);

    int updateByExample(@Param("record") SysJobLog record, @Param("example") SysJobLogExample example);
}
