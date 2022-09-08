package com.yunhe.company.oa.controller;
import com.yunhe.common.core.result.Result;
import com.yunhe.company.oa.domain.dto.ClientAuthDTO;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import com.yunhe.company.oa.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private UserServiceImpl userServiceImpl;

    @ApiOperation(value = "根据用户名获取认证信息")
    @GetMapping("/username/{userName}")
    public Result<UserAuthDTO> getUserByUserName(@PathVariable String userName){
        return Result.success(userServiceImpl.getUserByUserName(userName));
    }

}
