package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.DictData;
import com.yunhe.entity.domain.oa.DictDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictDataMapper {
    long countByExample(DictDataExample example);

    int deleteByExample(DictDataExample example);

    int insert(DictData record);

    int insertSelective(DictData record);

    List<DictData> selectByExample(DictDataExample example);

    int updateByExampleSelective(@Param("record") DictData record, @Param("example") DictDataExample example);

    int updateByExample(@Param("record") DictData record, @Param("example") DictDataExample example);
}
