package com.yunhe.company.erp.generator.mappers;


import java.util.List;

import com.yunhe.entity.domain.erp.Msg;
import com.yunhe.entity.domain.erp.MsgExample;
import org.apache.ibatis.annotations.Param;

public interface MsgMapper {
    long countByExample(MsgExample example);

    int deleteByExample(MsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Msg record);

    int insertSelective(Msg record);

    List<Msg> selectByExample(MsgExample example);

    Msg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByExample(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
}
