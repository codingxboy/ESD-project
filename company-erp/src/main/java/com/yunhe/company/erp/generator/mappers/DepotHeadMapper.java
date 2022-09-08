package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import java.math.BigDecimal;
import java.util.List;

import com.yunhe.entity.domain.erp.DepotHead;
import com.yunhe.entity.domain.erp.DepotHeadExample;
import org.apache.ibatis.annotations.Param;

public interface DepotHeadMapper extends BaseMapper<DepotHead> {
    long countByExample(DepotHeadExample example);

    int deleteByExample(DepotHeadExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepotHead record);

    int insertSelective(DepotHead record);

    List<DepotHead> selectByExample(DepotHeadExample example);

    DepotHead selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepotHead record, @Param("example") DepotHeadExample example);

    int updateByExample(@Param("record") DepotHead record, @Param("example") DepotHeadExample example);

    int updateByPrimaryKeySelective(DepotHead record);

    int updateByPrimaryKey(DepotHead record);

    BigDecimal getFinishDepositByNumberExceptCurrent(@Param("linkNumber") String linkNumber,
                                                     @Param("number") String number);
}
