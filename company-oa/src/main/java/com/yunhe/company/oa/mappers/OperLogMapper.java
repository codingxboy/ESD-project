package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.OperLog;
import com.yunhe.entity.domain.oa.OperLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperLogMapper {
    long countByExample(OperLogExample example);

    int deleteByExample(OperLogExample example);

    int insert(OperLog record);

    int insertSelective(OperLog record);

    List<OperLog> selectByExample(OperLogExample example);

    int updateByExampleSelective(@Param("record") OperLog record, @Param("example") OperLogExample example);

    int updateByExample(@Param("record") OperLog record, @Param("example") OperLogExample example);
}
