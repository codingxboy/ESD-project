package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysDictData;
import com.yunhe.entity.domain.oa.SysDictDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictDataMapper {
    long countByExample(SysDictDataExample example);

    int deleteByExample(SysDictDataExample example);

    int insert(SysDictData record);

    int insertSelective(SysDictData record);

    List<SysDictData> selectByExample(SysDictDataExample example);

    int updateByExampleSelective(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);

    int updateByExample(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);
}
