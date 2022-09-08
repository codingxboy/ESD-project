package com.yunhe.company.erp.controller;

import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.common.bo.DepotHeadBO;
import com.yunhe.company.erp.service.impl.DepotHeadServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DepotHeadController
 * @Description TODO 单据管理
 * @Author xiaozuqin
 * @Date 2022/8/18 17:42
 * @Version 1.0
 */
@Api(tags = "单据管理")
@RestController
@RequestMapping("/depotHead")
public class DepotHeadController {
    @Autowired
    private DepotHeadServiceImpl depotHeadServiceImpl;
    /**
     * @description: 新增零售单据
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 16:57
     */
    @PostMapping("/add")
    @ApiOperation("新增零售单")
    public Result addDepotHead(@RequestBody DepotHeadBO depotHeadBO){
        depotHeadServiceImpl.addDepotHead(depotHeadBO);
        return Result.success();
    }
}
