package com.yunhe.company.oa.mappers;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.entity.domain.oa.User;
import com.yunhe.entity.domain.oa.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}
