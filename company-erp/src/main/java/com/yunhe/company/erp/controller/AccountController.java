package com.yunhe.company.erp.controller;
import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.common.annotation.OperLog;

import com.yunhe.company.erp.generator.mappers.AccountMapper;
import com.yunhe.company.erp.service.impl.AccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AouccntController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/20 19:02
 * @Version 1.0
 */
@Api(tags = "账户管理")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountServiceImpl accountServiceImpl;

    @ApiOperation(value = "查询所有账户")
    @GetMapping("/all")
    public Result getAllAccount(){
        return Result.success(accountServiceImpl.getAllAccount());
    }

}
