package com.yunhe.company.oa.mappers;

import com.yunhe.entity.domain.oa.SysUserPost;
import com.yunhe.entity.domain.oa.SysUserPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserPostMapper {
    long countByExample(SysUserPostExample example);

    int deleteByExample(SysUserPostExample example);

    int insert(SysUserPost record);

    int insertSelective(SysUserPost record);

    List<SysUserPost> selectByExample(SysUserPostExample example);

    int updateByExampleSelective(@Param("record") SysUserPost record, @Param("example") SysUserPostExample example);

    int updateByExample(@Param("record") SysUserPost record, @Param("example") SysUserPostExample example);
}
