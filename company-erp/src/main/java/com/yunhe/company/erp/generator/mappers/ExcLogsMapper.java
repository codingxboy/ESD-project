package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;


import com.yunhe.entity.domain.erp.ExcLogs;
import com.yunhe.entity.domain.erp.ExcLogsExample;
import com.yunhe.entity.domain.erp.ExcLogsWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface ExcLogsMapper extends BaseMapper<ExcLogs> {

    long countByExample(ExcLogsExample example);

    int deleteByExample(ExcLogsExample example);

    int insert(ExcLogsWithBLOBs record);

    int insertSelective(ExcLogsWithBLOBs record);

    List<ExcLogsWithBLOBs> selectByExampleWithBLOBs(ExcLogsExample example);

    List<ExcLogs> selectByExample(ExcLogsExample example);

    int updateByExampleSelective(@Param("record") ExcLogsWithBLOBs record, @Param("example") ExcLogsExample example);

    int updateByExampleWithBLOBs(@Param("record") ExcLogsWithBLOBs record, @Param("example") ExcLogsExample example);

    int updateByExample(@Param("record") ExcLogs record, @Param("example") ExcLogsExample example);
}
