package com.yunhe.company.erp.controller;

import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.common.bo.DepotHeadBO;
import com.yunhe.company.erp.common.bo.SupplierBO;
import com.yunhe.company.erp.service.impl.SupplierServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SupplierController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/19 15:55
 * @Version 1.0
 */
@Api(tags = "供应商管理")
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImpl supplierServiceImpl;
    /**
     * @description: 新增零售单据
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 16:57
     */
    @PostMapping("/add")
    @ApiOperation("新增供应商")
    public Result addDepotHead(@RequestBody SupplierBO supplierBO){
        supplierServiceImpl.addSupplier(supplierBO);
        return Result.success();
    }
}
