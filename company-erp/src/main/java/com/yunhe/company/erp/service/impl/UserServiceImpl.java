package com.yunhe.company.erp.service.impl;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.constants.ExceptionCodeConstants;
import com.yunhe.common.core.result.Result;
import com.yunhe.common.core.result.ResultCode;
import com.yunhe.common.core.util.Md5Util;
import com.yunhe.common.core.util.SpringContextUtil;
import com.yunhe.common.core.util.StringUtil;
import com.yunhe.common.core.util.ToolsUtil;
import com.yunhe.common.web.exception.BizException;
import com.yunhe.company.erp.common.bo.UserBO;
import com.yunhe.company.erp.common.redis.RedisService;
import com.yunhe.company.erp.generator.mappers.OrgaUserRelMapper;
import com.yunhe.company.erp.generator.mappers.UserBOMapper;
import com.yunhe.company.erp.generator.mappers.UserMapper;
import com.yunhe.company.erp.generator.utils.RandImageUtils;
import com.yunhe.company.erp.service.UserService;
import com.yunhe.entity.domain.erp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/22 15:08
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserBOMapper userBOMapper;
    @Resource
    private OrgaUserRelMapper orgaUserRelMapper;
    @Autowired
    private UserBusinessServiceImpl userBusinessServiceImpl;
    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @Autowired
    private FunctionServiceImpl functionServiceImpl;
    @Autowired
    private RedisService redisService;
    @Autowired
    private LogServiceImpl logServiceImpl;
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @Override
    public User getUserByName(String userName) {
        User user = new User();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> usersList = userMapper.selectByExample(userExample);
        if (usersList.size() > 0) {
            user = usersList.get(0);
        }
        return user;
    }

    /**
     * @description: 根据用户id获取用户信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/2 15:20
     */
    public User getUserById(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new BizException("根据用户id获取用户信息异常");
        }
        return user;
    }

    /**
     * @description: 用户重置密码
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/2 16:12
     */
    public void resetPassword(String password, Long userId) {
        User user = getUserById(userId);
        logServiceImpl.insertLogWithUserId(user.getId(), "用户", BusinessConstants.LOG_OPERATION_TYPE_EDIT + user.getLoginName(), SpringContextUtil.getHttpServletRequest());
        String loginName = user.getLoginName();
        if ("admin".equals(loginName)) {
            logger.error("超级管理员禁止重置密码");
            throw new BizException("超级管理员禁止重置密码");
        } else {
            user.setPassWord(Md5Util.generate(password, user.getSalt()));
            userMapper.updateByPrimaryKey(user);
        }
    }

    /**
     * @description: 校验用户是否有效
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/25 17:03
     */
    @Override
    public Result checkUserIsEffective(User user) {
        Result<?> result = new Result<>();
        //查询用户，用户不存在
        if (user == null) {
            result.setCode("500");
//            sysBaseAPI.addLog("用户登录失败，用户不存在", CommonConstants.LOG_TYPE_1, null);
        }
        //根据用户信息查询，该用户已注销
//        if (CommonConstants.DEL_FLAG_1.toString().equals(user.))
        return Result.failed();
    }

    /**
     * @description: 检验用户登录名密码登录
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 11:16
     */
    @Override
    public int validateUser(String loginName, String passWord) {
        List<User> list;
        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andLoginNameEqualTo(loginName);
            list = userMapper.selectByExample(userExample);
            if (list != null && list.size() == 0) {
                return ExceptionCodeConstants.USER_NOT_EXIST;
            } else if (list.size() == 1) {
                if (list.get(0).getStatus() != 0) {
                    return ExceptionCodeConstants.BLACK_USER;
                }
            }
        } catch (Exception exception) {
            logger.error("~~~~~~~~~~~~~~~~~~验证用户登录名登录异常~~~~~~~~~~~~~~~~~~", exception);
            return ExceptionCodeConstants.USER_ACCESS_EXCEPTION;
        }
        try {
            UserExample userExample = new UserExample();
            String realPassWord = Md5Util.generate(passWord, list.get(0).getSalt());
            userExample.createCriteria().andLoginNameEqualTo(loginName).andPassWordEqualTo(realPassWord).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
            list = userMapper.selectByExample(userExample);
            if (list != null && list.size() == 0) {
                logger.error("~~~~~~~~~~~~~~~~~~用户名或密码错误~~~~~~~~~~~~~~~~~~");
                return ExceptionCodeConstants.USER_PASSWORD_ERROR;
            }
        } catch (Exception exception) {
            logger.error("~~~~~~~~~~~~~~~~~~~~~~~~验证用户密码后台异常~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", exception);
            return ExceptionCodeConstants.USER_ACCESS_EXCEPTION;
        }
        return ExceptionCodeConstants.USER_CONDITION_FIT;
    }

    @Override
    public User getUserByLoginName(String loginName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<User> userList = null;
        try {
            userList = userMapper.selectByExample(userExample);
        } catch (Exception exception) {
            throw new BizException("数据查询异常", exception);
        }
        User user = null;
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
        }
        return user;
    }

    /**
     * @description: 根据用户id查询角色类型
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 14:55
     */
    @Override
    public String getRoleTypeByUserId(Long userId) {
        List<UserBusiness> userRoleList = userBusinessServiceImpl.getBasicData(String.valueOf(userId), "UserRole");
        UserBusiness userBusiness = null;
        if (userRoleList.size() > 0) {
            userBusiness = userRoleList.get(0);
            String value = userBusiness.getValue();
            String roleId = null;
            if (value != null) {
                value = value.replaceAll("\\[\\]", ",").replace("[", "").replace("]", "");
            }
            String[] valuesArray = value.split(",");
            if (valuesArray.length > 0) {
                roleId = valuesArray[0];
            }
            Role roleWithoutTenant = roleServiceImpl.getRoleWithoutTenant(Long.parseLong(roleId));
            if (roleWithoutTenant != null) {
                return roleWithoutTenant.getType();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @description: 用户的按钮权限
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 17:12
     */
    @Override
    public JSONArray getBtnStrArrayById(Long userId) {
        JSONArray btnStrArr = new JSONArray();
        List<UserBusiness> userRole = userBusinessServiceImpl.getBasicData(String.valueOf(userId), "UserRole");
        if (userRole != null && userRole.size() > 0) {
            String roleValue = userRole.get(0).getValue();
            if (StringUtil.isNotEmpty(roleValue) && roleValue.contains("[") && roleValue.contains("]")) {
                roleValue = roleValue.replace("[", "").replace("]", "");
                List<UserBusiness> roleFunctions = userBusinessServiceImpl.getBasicData(roleValue, "RoleFunctions");
                if (roleFunctions != null && roleFunctions.size() > 0) {
                    String btnStr = roleFunctions.get(0).getBtnStr();
                    if (StringUtil.isNotEmpty(btnStr)) {
                        btnStrArr = JSONArray.parseArray(btnStr);
                    }
                }

            }
        }
        //将数组中的funId转为url
        JSONArray btnStrWithUrlArr = new JSONArray();
        if (btnStrArr.size() > 0) {
            List<Function> functionList = functionServiceImpl.getFunction();
            HashMap<Long, String> functionMap = new HashMap<>();
            for (Function function : functionList) {
                functionMap.put(function.getId(), function.getUrl());
            }
            for (Object obj : btnStrArr) {
                JSONObject jsonObject = JSONObject.parseObject(obj.toString());
                Long funId = jsonObject.getLong("funId");
                JSONObject btnStrWithUrlObject = new JSONObject();
                btnStrWithUrlObject.put("url", functionMap.get(funId));
                btnStrWithUrlObject.put("btnStr", jsonObject.getString("btnStr"));
                btnStrWithUrlArr.add(btnStrWithUrlObject);
            }
        }
        return btnStrWithUrlArr;

    }

    /**
     * @description: 根据用户登录名获取用户列表
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/27 17:08
     */
    @Override
    public List<User> getUserListByLoginName(String loginName) {
        return userBOMapper.getUserListByUserNameOrLoginName(null, loginName);
    }

    /**
     * @description: 根据用户名获取用户列表
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/27 17:57
     */
    @Override
    public List<User> getUserListByUserName(String userName) {
        userBOMapper.getUserListByUserNameOrLoginName(userName, null).stream().forEach(System.out::println);
        return userBOMapper.getUserListByUserNameOrLoginName(userName, null);
    }

    /**
     * @description: 检查用户名称和登录名不能重复
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/27 17:59
     */
    @Override
    public void checkUserNameAndLoginName(UserBO userBO) {
        List<User> userList;
        if (userBO == null) {
            return;
        }
        //检查登录名
        if (StringUtil.isNotEmpty(userBO.getLoginName())) {
            userList = this.getUserListByLoginName(userBO.getLoginName());
            if (userList != null && userList.size() > 0) {
                if (userList.size() == 1) {
                    logger.error("登录名" + userBO.getLoginName() + ResultCode.LOGIN_NAME_ALREADY_EXISTS_IN_THE_SYSTEM);
                    throw new BizException(ResultCode.LOGIN_NAME_ALREADY_EXISTS_IN_THE_SYSTEM);
                }
            }
        }
        //检查用户名
        if (StringUtil.isNotEmpty(userBO.getUserName())) {
            userList = this.getUserListByUserName(userBO.getUserName());
            if (userList != null && userList.size() > 0) {
                logger.error("用户名" + userBO.getUserName() + ResultCode.USER_NAME_ALREADY_EXISTS_IN_THE_SYSTEM);
                throw new BizException(ResultCode.USER_NAME_ALREADY_EXISTS_IN_THE_SYSTEM);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    @Override
    public UserBO registerUser(UserBO userBO, Integer manageRoleId, HttpServletRequest request) {
        this.checkUserNameAndLoginName(userBO);
        UserBO userBOS = new UserBO();
        if (BusinessConstants.DEFAULT_MANAGER.equals(userBO.getLoginName())) {
            throw new BizException(ResultCode.USER_NAME_LIMIT_USE_MSG);
        } else {
            logger.error(userBO.getLoginName());
            userBOS.setIsSystem(BusinessConstants.USER_NOT_SYSTEM);
            if (userBOS.getIsManager() == null) {
                userBOS.setIsManager(BusinessConstants.USER_NOT_MANAGER);
            }
            userBOS.setStatus(BusinessConstants.USER_STATUS_NORMAL);
            int result = 0;
            try {
                String md5Salt = Md5Util.getMd5Salt(8);
                BeanUtils.copyProperties(userBO, userBOS);
                userBOS.setSalt(md5Salt);
                logger.error("盐值为：{}", md5Salt);
                String password = Md5Util.generate(userBO.getPassWord(), md5Salt);
                userBOS.setPassWord(password);
                result = userMapper.insertSelective(userBOS);
                Long userId = this.getIdByLoginName(userBO.getLoginName());
                userBOS.setId(userId);
            } catch (Exception exception) {
                exception.printStackTrace();
                logger.error("用户注册异常");
//                throw new BizException("用户注册写入异常", exception);
            }
            //新增用户与角色的关系
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", "UserRole");
            jsonObject.put("keyId", userBOS.getId());
            JSONArray userArr = new JSONArray();
            userArr.add(manageRoleId);
            jsonObject.put("value", userArr.toJSONString());
            userBusinessServiceImpl.insertUserBusiness(jsonObject, request);
            logger.info("===============注册用户信息完成===============");
            if (result > 0) {
                return userBOS;
            }
            return null;
        }
    }

    /**
     * @description: 根据登录名获取id
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/28 10:06
     */
    @Override
    public Long getIdByLoginName(String loginName) {
        Long userId = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() > 0) {
            userId = userList.get(0).getId();
        }
        return userId;
    }

    /**
     * @description: 获取用户id
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/28 11:04
     */
    @Override
    public Long getUserId(HttpServletRequest request) {
        Object userId = redisService.getObjectFromSessionByKey(request, "userId");
        Long userIds = null;
        if (userId != null) {
            userIds = Long.parseLong(userId.toString());
        }
        return userIds;
    }

    @Override
    public Map<String, Object> getLoginUserMap(HttpServletRequest httpServletRequest, User userParam) {
        logger.info("《《《《《《《《《 用户登录login方法调用开始 》》》》》》》》》");
        //判断用户是否已经登录过，如已登录则不再处理
//        Object userId = redisService.getObjectFromSessionByKey(httpServletRequest, "userId");
//        if (userId != null) {
//            logger.info("《《《《《《《《《 用户已经登录过了，login方法调用结束 》》》》》》》》》");
//            throw new BizException("你已登录，不能重复登录账号");
//        }
//        redisService.deleteObjectBySession(httpServletRequest,"userId");
        User user = null;
        int userStatus;
        String msgTip = "";
        userStatus = this.validateUser(userParam.getLoginName(), userParam.getPassWord());
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        switch (userStatus) {
            case ExceptionCodeConstants.USER_NOT_EXIST:
                msgTip = BusinessConstants.USER_NOT_EXIST;
                break;
            case ExceptionCodeConstants.USER_PASSWORD_ERROR:
                msgTip = BusinessConstants.USER_PASSWORD_ERROR;
                break;
            case ExceptionCodeConstants.BLACK_USER:
                msgTip = BusinessConstants.BLACK_USER;
                break;
            case ExceptionCodeConstants.USER_ACCESS_EXCEPTION:
                msgTip = BusinessConstants.USER_ACCESS_EXCEPTION;
                break;
            case ExceptionCodeConstants.USER_CONDITION_FIT:
                msgTip = BusinessConstants.USER_CONDITION_FIT;
                //验证通过，可以登录，放入session，记录登录日志
                user = this.getUserByLoginName(userParam.getLoginName());
                redisService.storageObjectBySession(token, "userId", user.getId());
                redisService.storageObjectBySession(token, "loginName", user.getLoginName());
                break;
            default:
                break;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("msgTip", msgTip);
        if (user != null) {
            String roleTypeByUserId = this.getRoleTypeByUserId(user.getId());
            redisService.storageObjectBySession(token, "roleType", roleTypeByUserId);
            redisService.storageObjectBySession(token, "client", ToolsUtil.getLocalIp(httpServletRequest));
            logServiceImpl.insertLogWithUserId(user.getId(), "用户", user.getLoginName() + BusinessConstants.LOG_OPERATION_TYPE_LOGIN, SpringContextUtil.getHttpServletRequest());
            JSONArray btnStrArrayById = this.getBtnStrArrayById(user.getId());
            map.put("user", user);
            map.put("token", token);
            //用户的按钮权限
            if (!"admin".equals(user.getLoginName())) {
                map.put("userBtn", btnStrArrayById);
            }
            map.put("roleType", roleTypeByUserId);
        }
        logger.info("《《《《《《《《《 用户登录login方法调用结束 》》》》》》》》》");
        return map;
    }

    /**
     * @description: 获取验证码
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/5 14:44
     */
    @Override
    public String getRandomImage(HttpServletResponse httpServletResponse, String key) throws IOException {
        //生成验证码
        String checkCode = RandomUtil.randomString(BusinessConstants.BASE_CHECK_CODES, 4);
        String realCode = Md5Util.md5Encode(checkCode.toLowerCase() + key, "utf-8");
        logger.info("获取验证码，Redis checkCode = {}，key = {}", checkCode, key);
        //存到redis中
        redisService.set(realCode, checkCode.toLowerCase(), 60);
        RandImageUtils.generate(httpServletResponse, checkCode);
        return RandImageUtils.generate(checkCode);
    }

    /**
     * @description: 获取用户信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/5 16:23
     */
    @Override
    public User getUserInfoBySession(HttpServletRequest httpServletRequest) {
        Long userId = Long.parseLong(redisService.getObjectFromSessionByKey(httpServletRequest, "userId").toString());
        return this.getUserById(userId);
    }

    @Override
    public Result updatePassWord(String oldPassWord, String newPassWord, String confirmPassword, HttpServletRequest httpServletRequest) {
        User user = this.getUserInfoBySession(httpServletRequest);
        String oldPassword = Md5Util.generate(oldPassWord, user.getSalt());
        if (user.getLoginName().equals(user.getLoginName())) {
            return Result.failed("用户只能修改自己的密码");
        } else if ("admin".equals(user.getLoginName())) {
            return Result.failed("超级管理员不允许更改密码");
        } else if (newPassWord.isEmpty()) {
            return Result.failed("新密码不允许为空");
        } else if (oldPassword.equals(user.getPassWord())) {
            return Result.failed("原密码输入错误");
        } else if (newPassWord.equals(confirmPassword)) {
            return Result.failed("两次输入的密码不一致");
        }
        String realPassword = Md5Util.generate(newPassWord, user.getSalt());
        user.setPassWord(realPassword);
        this.updateUserByObj(user);
        return Result.success(ResultCode.USER_RESET_PASSWORD_SUCCESS);
    }

    @Override
    public void userLogout(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(BusinessConstants.ACCESS_TOKEN);
        logger.info("用户登录的token为，token={}", token);
        long userId = Long.parseLong(redisService.getObjectFromSessionByKey(httpServletRequest, "userId").toString());
        User user = this.getUserById(userId);
        if (user != null) {
            logServiceImpl.insertLogWithUserId(userId, "用户", user.getLoginName() + BusinessConstants.LOG_OPERATION_TYPE_LOGIN_OUT, SpringContextUtil.getHttpServletRequest());
//                redisService.deleteObjectBySession(httpServletRequest, "userId");
            redisService.deleteRedisCache(token);
        } else {
            throw new BizException("用户信息不存在，登出失败");
        }
    }

    /**
     * @description: 获取全部的用户数据列表
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/8 14:23
     */
    @Override
    public List<User> getAllUser() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        return userMapper.selectByExample(userExample);
    }

    /**
     * @description: 添加用户
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/8 15:29
     */
    @Override
    public void addUser(HttpServletRequest httpServletRequest, UserBO userBO) {
        /**
         * 新增用户默认设置
         * 1、密码默认123456
         * 2是否系统自带默认为非系统自带
         * 3是否管理者默认为员工
         * 4默认用户状态为正常
         * */
        if (BusinessConstants.DEFAULT_MANAGER.equals(userBO.getUserName())) {
            throw new BizException("此用户名限制使用");
        } else {
            //检查用户名和登录名
            this.checkUserNameAndLoginName(userBO);
            //新增用户信息
            String md5Salt = Md5Util.getMd5Salt(8);
            userBO.setPassWord(Md5Util.generate(userBO.getPassWord(), md5Salt));
            userBO.setSalt(md5Salt);
            userBO.setIsSystem(BusinessConstants.USER_NOT_SYSTEM);
            if (userBO.getIsManager() == null) {
                userBO.setIsManager(BusinessConstants.USER_NOT_MANAGER);
            }
            userBO.setStatus(BusinessConstants.USER_STATUS_NORMAL);
            userMapper.insertSelective(userBO);
            //根据用户名查询id
            Long userId = this.getIdByLoginName(userBO.getLoginName());
            if (userBO.getRoleId() != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", "UserRole");
                jsonObject.put("keyId", userId);
                jsonObject.put("value", "[" + userBO.getRoleId() + "]");
                userBusinessServiceImpl.insertUserBusiness(jsonObject, httpServletRequest);
            }
            //新增用户和机构关联关系
            OrgaUserRel orgaUserRel = new OrgaUserRel();
            //机构id
            orgaUserRel.setOrgaId(userBO.getOrgaId());
            orgaUserRel.setUserId(userId);
            //用户在机构中的排序
            orgaUserRel.setUserBlngOrgaDsplSeq(userBO.getUserBlngOrgaDsplSeq());
            orgaUserRelMapper.insert(orgaUserRel);
            logServiceImpl.insertLogWithUserId(userId, "用户", BusinessConstants.LOG_OPERATION_TYPE_ADD, httpServletRequest);
        }
    }

    @Override
    public List<User> getAllByUserIds(Long[] userIdArray) {
        List<User> userList = null;
        try {
            userList = userMapper.getUserByUserId(userIdArray);
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("根据userIds获取用户信息错误");
        }
        assert userList != null;
        return userList.stream().map(s -> User.builder().userName(s.getUserName())
                .departId(s.getDepartId())
                .email(s.getEmail())
                .description(s.getDescription())
                .loginName(s.getLoginName())
                .phoneNum(s.getPhoneNum())
                .position(s.getPosition())
                .remark(s.getRemark())
                .id(s.getId())
                .build()).collect(Collectors.toList());
    }

    /**
     * @description: 根据id删除用户
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/10 14:27
     */
    @Override
    public boolean deleteUserById(Long userId) {
        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(userId);
            List<User> userList = userMapper.selectByExample(userExample);
            if (userList!=null&&userList.size()>0){
                this.removeById(userId);
                logServiceImpl.insertLogWithUserId(userId, "用户", BusinessConstants.LOG_OPERATION_TYPE_DELETE, SpringContextUtil.getHttpServletRequest());
            }else {
                throw new BizException("删除错误，该用户不存在");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("根据用户id删除用户错误", exception);
        }
        return false;
    }

    /**
     * @description: 根据id批量删除用户
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/10 14:27
     */
    @Override
    public boolean deleteUserByIds(Long[] userIds) {
        for (int i = 0; i < userIds.length; i++) {
            logger.error("userIds的值为：userids={}", userIds[i]);
            logServiceImpl.insertLogWithUserId(userIds[i], "用户", BusinessConstants.LOG_OPERATION_TYPE_DELETE, SpringContextUtil.getHttpServletRequest());
        }
        this.removeByIds(Arrays.asList(userIds));
        return false;
    }

    /**
     * @description: 添加用户和用户角色
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/10 15:56
     */
    @Override
    public void addUserWithRole(User user, String role) {
    }

    /**
     * @description: 根据用户名获取用户角色
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/10 15:56
     */
    @Override
    public Map<String, List<String>> getRoleByUserName(String userName) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (StringUtil.isNotEmpty(userName)) {
            User user = this.getUserByName(userName);
            List<UserBusiness> userBusinessBykeyId = userBusinessServiceImpl.getUserBusinessBykeyId(user.getId());
//            List<String> collect = userBusinessBykeyId.stream().map(UserBusiness::getValue).collect(Collectors.toList());
            List<String> stringList = userBusinessBykeyId.stream().map(s -> s.getValue().replace('[', ' ').replace(']', ' ').trim()).collect(Collectors.toList());
            List<String> roleList = Arrays.asList(stringList.get(0).split("  "));
            logger.error("用户的角色id为: ,strings1={}", roleList);
//            List<Long> roleIdList = userBusinessBykeyId.stream().map(s->Long.parseLong(s.getValue())).collect(Collectors.toList());
            for (String roleId : roleList) {
                String name = roleServiceImpl.getRoleWithoutTenant(Long.parseLong(roleId)).getName();
                list.add(name);
                map.put("userRole", list);
            }
        }
        return map;
    }
    /**
     * @description: 根据用户名获取所在部门信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 17:18
     */
    @Override
    public Map<String,List<Department>> getDepartmentByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        Map<String, List<Department>> map = new HashMap<>();
        List<Department> list = new ArrayList<>();
        if (userList!=null&&userList.size()>0) {
            Integer integer = userList.stream().map(User::getDepartId).collect(Collectors.toList()).get(0);
            List<Department> byDepartId = departmentServiceImpl.getByDepartId(Long.parseLong(integer.toString()));
            byDepartId.forEach(s -> {
                list.add(s);
                map.put(userName, list);
            });
        }
        return map;
    }


    /**
     * @description:
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/2 18:31
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void updateUserByObj(User user) {
        logServiceImpl.insertLogWithUserId(user.getId(), "用户", BusinessConstants.LOG_OPERATION_TYPE_EDIT + user.getLoginName(), SpringContextUtil.getHttpServletRequest());
        try {
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error(user.getLoginName() + "更新用户信息错误", exception);
        }
    }

    /**
     * @description: 获取当前用户的信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/8 16:36
     */
    public User getCurrentUser() {
        Long userId = Long.parseLong(redisService.getObjectFromSessionByKey(SpringContextUtil.getHttpServletRequest(), "userId").toString());
        return getUserById(userId);
    }

}
