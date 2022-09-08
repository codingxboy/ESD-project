package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.SysNotice;
import com.yunhe.entity.domain.oa.SysNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysNoticeMapper {
    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExample(SysNoticeExample example);

    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);
}
