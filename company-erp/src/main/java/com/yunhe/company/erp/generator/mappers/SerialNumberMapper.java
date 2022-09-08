package com.yunhe.company.erp.generator.mappers;


import java.util.List;

import com.yunhe.entity.domain.erp.SerialNumber;
import com.yunhe.entity.domain.erp.SerialNumberExample;
import org.apache.ibatis.annotations.Param;

public interface SerialNumberMapper {
    long countByExample(SerialNumberExample example);

    int deleteByExample(SerialNumberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SerialNumber record);

    int insertSelective(SerialNumber record);

    List<SerialNumber> selectByExample(SerialNumberExample example);

    SerialNumber selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    int updateByExample(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    int updateByPrimaryKeySelective(SerialNumber record);

    int updateByPrimaryKey(SerialNumber record);
}
