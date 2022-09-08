package com.yunhe.company.erp.generator.mappers;


import java.util.List;

import com.yunhe.entity.domain.erp.MaterialAttribute;
import com.yunhe.entity.domain.erp.MaterialAttributeExample;
import org.apache.ibatis.annotations.Param;

public interface MaterialAttributeMapper {
    long countByExample(MaterialAttributeExample example);

    int deleteByExample(MaterialAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MaterialAttribute record);

    int insertSelective(MaterialAttribute record);

    List<MaterialAttribute> selectByExample(MaterialAttributeExample example);

    MaterialAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MaterialAttribute record, @Param("example") MaterialAttributeExample example);

    int updateByExample(@Param("record") MaterialAttribute record, @Param("example") MaterialAttributeExample example);

    int updateByPrimaryKeySelective(MaterialAttribute record);

    int updateByPrimaryKey(MaterialAttribute record);
}
