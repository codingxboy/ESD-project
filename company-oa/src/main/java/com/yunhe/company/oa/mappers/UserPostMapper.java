package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.UserPost;
import com.yunhe.entity.domain.oa.UserPostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPostMapper {
    long countByExample(UserPostExample example);

    int deleteByExample(UserPostExample example);

    int insert(UserPost record);

    int insertSelective(UserPost record);

    List<UserPost> selectByExample(UserPostExample example);

    int updateByExampleSelective(@Param("record") UserPost record, @Param("example") UserPostExample example);

    int updateByExample(@Param("record") UserPost record, @Param("example") UserPostExample example);
}
