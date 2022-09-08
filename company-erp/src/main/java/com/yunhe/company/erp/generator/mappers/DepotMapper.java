package com.yunhe.company.erp.generator.mappers;


import java.util.List;

import com.yunhe.entity.domain.erp.Depot;
import com.yunhe.entity.domain.erp.DepotExample;
import org.apache.ibatis.annotations.Param;

public interface DepotMapper {
    long countByExample(DepotExample example);

    int deleteByExample(DepotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Depot record);

    int insertSelective(Depot record);

    List<Depot> selectByExample(DepotExample example);

    Depot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Depot record, @Param("example") DepotExample example);

    int updateByExample(@Param("record") Depot record, @Param("example") DepotExample example);

    int updateByPrimaryKeySelective(Depot record);

    int updateByPrimaryKey(Depot record);
}
