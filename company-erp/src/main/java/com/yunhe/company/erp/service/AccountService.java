package com.yunhe.company.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.entity.domain.erp.Account;


import java.util.List;

public interface AccountService extends IService<Account> {
    List<Account> getAllAccount();
}
