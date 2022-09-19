package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysOperLog;
import com.yunhe.entity.domain.oa.SysOperLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOperLogMapper {
    long countByExample(SysOperLogExample example);

    int deleteByExample(SysOperLogExample example);

    int insert(SysOperLog record);

    int insertSelective(SysOperLog record);

    List<SysOperLog> selectByExample(SysOperLogExample example);

    int updateByExampleSelective(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    int updateByExample(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);
}
