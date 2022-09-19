package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysLoginInfor;
import com.yunhe.entity.domain.oa.SysLoginInforExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLoginInforMapper {
    long countByExample(SysLoginInforExample example);

    int deleteByExample(SysLoginInforExample example);

    int insert(SysLoginInfor record);

    int insertSelective(SysLoginInfor record);

    List<SysLoginInfor> selectByExample(SysLoginInforExample example);

    int updateByExampleSelective(@Param("record") SysLoginInfor record, @Param("example") SysLoginInforExample example);

    int updateByExample(@Param("record") SysLoginInfor record, @Param("example") SysLoginInforExample example);
}
