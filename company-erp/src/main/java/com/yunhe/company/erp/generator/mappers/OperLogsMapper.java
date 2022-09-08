package com.yunhe.company.erp.generator.mappers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.entity.domain.erp.OperLogs;
import com.yunhe.entity.domain.erp.OperLogsExample;
import com.yunhe.entity.domain.erp.OperLogsWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperLogsMapper extends BaseMapper<OperLogs> {
    long countByExample(OperLogsExample example);

    int deleteByExample(OperLogsExample example);

    int insert(OperLogsWithBLOBs record);

    int insertSelective(OperLogsWithBLOBs record);

    List<OperLogsWithBLOBs> selectByExampleWithBLOBs(OperLogsExample example);

    List<OperLogs> selectByExample(OperLogsExample example);

    int updateByExampleSelective(@Param("record") OperLogsWithBLOBs record, @Param("example") OperLogsExample example);

    int updateByExampleWithBLOBs(@Param("record") OperLogsWithBLOBs record, @Param("example") OperLogsExample example);

    int updateByExample(@Param("record") OperLogs record, @Param("example") OperLogsExample example);
}
