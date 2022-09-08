package com.yunhe.company.erp.generator.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import com.yunhe.entity.domain.erp.UserBusiness;
import com.yunhe.entity.domain.erp.UserBusinessExample;
import org.apache.ibatis.annotations.Param;

public interface UserBusinessMapper extends BaseMapper<UserBusiness> {
    long countByExample(UserBusinessExample example);

    int deleteByExample(UserBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBusiness record);

    int insertSelective(UserBusiness record);

    List<UserBusiness> selectByExample(UserBusinessExample example);

    UserBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBusiness record, @Param("example") UserBusinessExample example);

    int updateByExample(@Param("record") UserBusiness record, @Param("example") UserBusinessExample example);

    int updateByPrimaryKeySelective(UserBusiness record);

    int updateByPrimaryKey(UserBusiness record);
}
