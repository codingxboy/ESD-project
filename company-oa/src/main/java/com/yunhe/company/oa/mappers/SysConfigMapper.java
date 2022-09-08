package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysConfig;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigMapper {
    long countByExample(com.yunhe.entity.domain.oa.SysConfigExample example);

    int deleteByExample(com.yunhe.entity.domain.oa.SysConfigExample example);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(com.yunhe.entity.domain.oa.SysConfigExample example);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") com.yunhe.entity.domain.oa.SysConfigExample example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") com.yunhe.entity.domain.oa.SysConfigExample example);
}
