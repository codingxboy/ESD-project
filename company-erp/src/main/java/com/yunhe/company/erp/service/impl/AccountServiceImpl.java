package com.yunhe.company.erp.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.company.erp.generator.mappers.AccountMapper;
import com.yunhe.company.erp.service.AccountService;
import com.yunhe.entity.domain.erp.Account;
import com.yunhe.entity.domain.erp.AccountExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/19 17:32
 * @Version 1.0
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    /**
     * @description: 获取所有账户
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 17:35
     */
    @Override
    public List<Account> getAllAccount() {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        return accountMapper.selectByExample(accountExample);
    }
}
