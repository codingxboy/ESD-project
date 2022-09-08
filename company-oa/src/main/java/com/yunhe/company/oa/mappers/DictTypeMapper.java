package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.DictType;
import com.yunhe.entity.domain.oa.DictTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictTypeMapper {
    long countByExample(DictTypeExample example);

    int deleteByExample(DictTypeExample example);

    int insert(DictType record);

    int insertSelective(DictType record);

    List<DictType> selectByExample(DictTypeExample example);

    int updateByExampleSelective(@Param("record") DictType record, @Param("example") DictTypeExample example);

    int updateByExample(@Param("record") DictType record, @Param("example") DictTypeExample example);
}
