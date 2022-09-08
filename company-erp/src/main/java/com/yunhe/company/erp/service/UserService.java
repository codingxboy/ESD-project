package com.yunhe.company.erp.service;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.common.bo.UserBO;
import com.yunhe.entity.domain.erp.Department;
import com.yunhe.entity.domain.erp.User;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    User getUserByName(String userName);

    Result checkUserIsEffective(User user);

    int validateUser(String loginName,String passWord);

    User getUserByLoginName(String loginName);

    String getRoleTypeByUserId(Long userId);

    JSONArray getBtnStrArrayById(Long userId);

    List<User> getUserListByLoginName(String loginName);

    List<User> getUserListByUserName(String userName);

    void checkUserNameAndLoginName(UserBO userBO);

    UserBO registerUser(UserBO userBO, Integer manageRoleId, HttpServletRequest request);

    Long getIdByLoginName(String loginName);

    Long getUserId(HttpServletRequest request);

    Map<String, Object> getLoginUserMap(HttpServletRequest httpServletRequest,User userParam);

    String getRandomImage(HttpServletResponse httpServletResponse, @RequestParam String key) throws IOException;

    User getUserInfoBySession(HttpServletRequest httpServletRequest);

    Result<?> updatePassWord(String oldPassWord,String newPassWord,String confirmPassword,HttpServletRequest httpServletRequest);

    void userLogout(HttpServletRequest httpServletRequest);

    List<User> getAllUser();

    void addUser(HttpServletRequest httpServletRequest,UserBO userBO);

    List<User> getAllByUserIds(Long[] userIdArray);

    boolean deleteUserById(Long userId);

    boolean deleteUserByIds(Long[] userIds);
    /**
     * 添加用户和用户角色
     */
    void addUserWithRole(User user,String role);
    /**
     * 根据用户名获取用户角色
     */
    Map<String, List<String>> getRoleByUserName(String userName);

    /**
     * 根据用户名获取所在部门信息
     */
    Map<String,List<Department>> getDepartmentByUserName(String userName);
}
