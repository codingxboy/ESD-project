package com.yunhe.company.erp.generator.mappers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yunhe.entity.domain.erp.User;
import com.yunhe.entity.domain.erp.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    long countByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    User selectByPrimaryKey(Long userId);

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKey(User user);

    List<User> getUserByUserId(@Param("userIdArray") Long[] userIdArray);

}
