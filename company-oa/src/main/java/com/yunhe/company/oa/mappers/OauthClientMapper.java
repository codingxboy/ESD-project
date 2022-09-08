package com.yunhe.company.oa.mappers;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.entity.domain.oa.OauthClient;
import com.yunhe.entity.domain.oa.OauthClientExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthClientMapper extends BaseMapper<OauthClient> {
    long countByExample(OauthClientExample example);

    int deleteByExample(OauthClientExample example);

    int insert(OauthClient record);

    int insertSelective(OauthClient record);

    List<OauthClient> selectByExample(OauthClientExample example);

    int updateByExampleSelective(@Param("record") OauthClient record, @Param("example") OauthClientExample example);

    int updateByExample(@Param("record") OauthClient record, @Param("example") OauthClientExample example);
}
