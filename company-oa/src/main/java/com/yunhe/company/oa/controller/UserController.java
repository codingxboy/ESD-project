package com.yunhe.company.oa.controller;
import com.yunhe.common.core.result.Result;
import com.yunhe.common.web.annotation.WebLog;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
//import com.yunhe.company.oa.service.impl.SysUserServiceImpl;
import com.yunhe.company.oa.service.impl.SysUserServiceImpl;
import com.yunhe.entity.domain.oa.SysDept;
import com.yunhe.entity.domain.oa.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/22 11:59
 * @Version 1.0
 */
@Api(tags = "OA系统用户服务管理")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Resource
    private SysUserServiceImpl userServiceImpl;

    @ApiOperation(value = "根据用户名获取认证信息")
    @GetMapping("/username/{userName}")
    public Result<UserAuthDTO> getUserByUserName(@PathVariable String userName){
        return Result.success(userServiceImpl.getUserByUserName(userName));
    }

    @ApiOperation(value = "获取全部用户信息")
    @GetMapping("/all")
    @WebLog
    public Result<List<SysUser>> getAllUserList(){
        return Result.success(userServiceImpl.getAllUsers());
    }

    @ApiOperation(value = "获取部门信息")
    @GetMapping("/all/depart")
    public Result<List<SysDept>> getAllDepartList(){
        return Result.success(userServiceImpl.getDepartList());
    }



}
