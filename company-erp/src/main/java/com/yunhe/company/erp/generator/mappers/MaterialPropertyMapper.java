package com.yunhe.company.erp.generator.mappers;


import java.util.List;

import com.yunhe.entity.domain.erp.MaterialProperty;
import com.yunhe.entity.domain.erp.MaterialPropertyExample;
import org.apache.ibatis.annotations.Param;

public interface MaterialPropertyMapper {
    long countByExample(MaterialPropertyExample example);

    int deleteByExample(MaterialPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MaterialProperty record);

    int insertSelective(MaterialProperty record);

    List<MaterialProperty> selectByExample(MaterialPropertyExample example);

    MaterialProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MaterialProperty record, @Param("example") MaterialPropertyExample example);

    int updateByExample(@Param("record") MaterialProperty record, @Param("example") MaterialPropertyExample example);

    int updateByPrimaryKeySelective(MaterialProperty record);

    int updateByPrimaryKey(MaterialProperty record);
}
