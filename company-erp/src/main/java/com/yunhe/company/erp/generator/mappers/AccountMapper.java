package com.yunhe.company.erp.generator.mappers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


import com.yunhe.entity.domain.erp.Account;
import com.yunhe.entity.domain.erp.AccountExample;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<Account> {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
