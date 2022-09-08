package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import com.yunhe.entity.domain.erp.Log;
import com.yunhe.entity.domain.erp.LogExample;
import org.apache.ibatis.annotations.Param;

public interface LogMapper extends BaseMapper<Log> {
    long countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}
