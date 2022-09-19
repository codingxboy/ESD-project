package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysPost;
import com.yunhe.entity.domain.oa.SysPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPostMapper {
    long countByExample(SysPostExample example);

    int deleteByExample(SysPostExample example);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    List<SysPost> selectByExample(SysPostExample example);

    int updateByExampleSelective(@Param("record") SysPost record, @Param("example") SysPostExample example);

    int updateByExample(@Param("record") SysPost record, @Param("example") SysPostExample example);
}
