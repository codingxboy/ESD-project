package com.yunhe.company.erp.controller;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.result.Result;
import com.yunhe.common.core.result.ResultCode;
import com.yunhe.company.erp.common.annotation.OperLog;
import com.yunhe.company.erp.common.bo.UserBO;
import com.yunhe.company.erp.common.redis.RedisService;

import com.yunhe.company.erp.service.impl.UserServiceImpl;
import com.yunhe.entity.domain.erp.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserController
 * @Description TODO 用户登录
 * @Author xiaozuqin
 * @Date 2022/7/25 11:48
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
@Api(tags = {"用户管理"})
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;
    @Resource
    private RedisService redisService;
    @Value("${manage.roleId}")
    private Integer manageRoleId;

    /**
     * @description: 用户登录
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/5 14:35
     */
    @ApiOperation("登录接口")
    @PostMapping("/login")
    @OperLog(operModul = "用户管理-用户登录",operType = BusinessConstants.LOG_OPERATION_TYPE_LOGIN,operDesc ="用户登录操作" )
    public Result logins(@RequestBody User userParam, HttpServletRequest httpServletRequest) {
        return Result.result(ResultCode.USER_LOGIN_SUCCESS, userServiceImpl.getLoginUserMap(httpServletRequest, userParam));
    }

    /**
     * @description: 用户信息注册
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/27 18:53
     */
    @ApiOperation("注册接口")
    @PostMapping("/register")
    public Result registerUser(@RequestBody UserBO userBO, HttpServletRequest httpServletRequest) {
        userServiceImpl.registerUser(userBO, manageRoleId, httpServletRequest);
        return Result.success(ResultCode.USER_REGISTERED_SUCCESS);
    }

    @ApiOperation("获取验证码")
    @GetMapping("/random/image")
    public Result<String> randomImages(HttpServletResponse httpServletResponse, @RequestParam String key) throws IOException {
        return Result.result(ResultCode.AUTH_CODE_SUCCESS, userServiceImpl.getRandomImage(httpServletResponse, key));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result getUserInfoBySession(HttpServletRequest httpServletRequest) {
        return Result.success(userServiceImpl.getUserInfoBySession(httpServletRequest));
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest) {
        userServiceImpl.userLogout(httpServletRequest);
        return Result.success(ResultCode.USER_LOGOUT_SUCCESS);
    }

    @ApiOperation("用户重置密码")
    @PutMapping("/reset/password")
    public Result resetPassWord(HttpServletRequest httpServletRequest) {
        long userId = Long.parseLong(redisService.getObjectFromSessionByKey(httpServletRequest, "userId").toString());
        userServiceImpl.resetPassword(BusinessConstants.USER_DEFAULT_PASSWORD, userId);
        return Result.success(ResultCode.USER_RESET_PASSWORD_SUCCESS);
    }

    @ApiOperation("用户更新密码")
    @PutMapping("/update/password")
    public Result updatePassWord(@RequestParam String oldPassWord,
                                 @RequestParam String newPassWord,
                                 @RequestParam String confirmPassword,
                                 HttpServletRequest httpServletRequest) {
        userServiceImpl.updatePassWord(oldPassWord,newPassWord,confirmPassword,httpServletRequest);
        return Result.success(ResultCode.USER_RESET_PASSWORD_SUCCESS);
    }

    @ApiOperation("获取所有用户数据列表")
    @GetMapping("/all/list")
    public Result getAllUserList() {
        return Result.success(userServiceImpl.getAllUser());
    }

    @ApiOperation("根据用户id批量获取所有用户数据")
    @GetMapping("/userId/all/list")
    public Result getAllUserListByUserId(@RequestParam Long[] userIdArray) {
        return Result.success(userServiceImpl.getAllByUserIds(userIdArray));
    }

    @ApiOperation("新增用户")
    @PostMapping("/add/user")
    public Result addUser(@RequestBody UserBO userBO, HttpServletRequest httpServletRequest) {
        userServiceImpl.addUser(httpServletRequest, userBO);
        return Result.success(ResultCode.SUCCESS);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delete")
    @OperLog(operModul = "用户管理-用户删除",operType = BusinessConstants.LOG_OPERATION_TYPE_DELETE,operDesc = "用户删除操作")
    public Result delUser(@RequestParam Long userId) {
        userServiceImpl.deleteUserById(userId);
        return Result.success(ResultCode.USER_DELETE_SUCCESS);
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping("/delete/batch")
    public Result delBatchUser(@RequestParam Long[] userIds) {
        userServiceImpl.deleteUserByIds(userIds);
        return Result.success(ResultCode.USER_DELETE_SUCCESS);
    }

    @ApiOperation("根据用户名获取所有角色名称")
    @GetMapping("/role")
    public Result getAllRoleByUserName(@RequestParam String userName) {
        return Result.success(userServiceImpl.getRoleByUserName(userName));
    }


    @ApiOperation("根据用户名获取所在部门信息")
    @GetMapping("/depart/info")
    public Result getDepartByUserName(@RequestParam String userName) {
        return Result.success(userServiceImpl.getDepartmentByUserName(userName));
    }




}
