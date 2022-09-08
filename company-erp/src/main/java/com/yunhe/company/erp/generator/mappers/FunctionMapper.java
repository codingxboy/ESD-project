package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import com.yunhe.entity.domain.erp.Function;
import com.yunhe.entity.domain.erp.FunctionExample;
import org.apache.ibatis.annotations.Param;

public interface FunctionMapper extends BaseMapper<Function> {
    long countByExample(FunctionExample example);

    int deleteByExample(FunctionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Function record);

    int insertSelective(Function record);

    List<Function> selectByExample(FunctionExample example);

    Function selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}
