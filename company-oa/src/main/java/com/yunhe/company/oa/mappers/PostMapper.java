package com.yunhe.company.oa.mappers;


import com.yunhe.entity.domain.oa.Post;
import com.yunhe.entity.domain.oa.PostExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExample(PostExample example);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);
}
