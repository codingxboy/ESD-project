package com.yunhe.company.erp.controller;

import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.service.impl.DepartmentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/11 17:00
 * @Version 1.0
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentServiceImpl departmentServiceImpl;

    @ApiOperation("获取全部部门信息")
    @GetMapping("/all")
    public Result getAllDepart(){
        return Result.success(departmentServiceImpl.getAllDepart());
    }

    @ApiOperation("获取全部部门以及员工信息")
    @GetMapping("/all/user")
    public Result getAllUserDepart(){
        return Result.success(departmentServiceImpl.getAllUserDepart());
    }
    @ApiOperation("根据部门名称获取部门人员信息")
    @GetMapping("/name")
    public Result getAllUserByDepartName(@RequestParam String departName){
        return Result.success(departmentServiceImpl.getUserByDepartName(departName));
    }

    @ApiOperation("新方法获取部门以及员工信息")
    @GetMapping("/all/user/list")
    public Result getAllUserDepartByStream(){
//        return Result.success(departmentServiceImpl.getAllUserDepartByStream());
        return null;
    }

    @ApiOperation("根据用户名获取用户部门信息")
    @GetMapping("/all/user/depart")
    public Result getDepartByUser(@RequestParam String userName){
        return Result.success(departmentServiceImpl.getDepartByUser(userName));
    }

    @ApiOperation("获取部门树状信息")
    @GetMapping("/tree")
    public Result getDepartMenu(){
        return Result.success(departmentServiceImpl.getDepartMenu());
    }
}
