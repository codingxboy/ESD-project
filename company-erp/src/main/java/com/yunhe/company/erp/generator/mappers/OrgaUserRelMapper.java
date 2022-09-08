package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import com.yunhe.entity.domain.erp.OrgaUserRel;
import com.yunhe.entity.domain.erp.OrgaUserRelExample;
import org.apache.ibatis.annotations.Param;

public interface OrgaUserRelMapper extends BaseMapper<OrgaUserRel> {
    long countByExample(OrgaUserRelExample example);

    int deleteByExample(OrgaUserRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgaUserRel record);

    int insertSelective(OrgaUserRel record);

    List<OrgaUserRel> selectByExample(OrgaUserRelExample example);

    OrgaUserRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRelExample example);

    int updateByExample(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRelExample example);

    int updateByPrimaryKeySelective(OrgaUserRel record);

    int updateByPrimaryKey(OrgaUserRel record);
}
