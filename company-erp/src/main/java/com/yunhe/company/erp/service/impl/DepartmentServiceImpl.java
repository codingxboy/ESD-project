package com.yunhe.company.erp.service.impl;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.tree.DepartTree;
import com.yunhe.company.erp.common.vo.DepartmentListVO;
import com.yunhe.company.erp.common.vo.DepartmentVO;
import com.yunhe.company.erp.generator.mappers.DepartmentMapper;
import com.yunhe.company.erp.generator.mappers.UserMapper;
import com.yunhe.company.erp.service.DepartmentService;
import com.yunhe.entity.domain.erp.Department;
import com.yunhe.entity.domain.erp.DepartmentExample;
import com.yunhe.entity.domain.erp.User;
import com.yunhe.entity.domain.erp.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/11 14:57
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserServiceImpl userServiceImpl;

    @Override
    public List<DepartTree> getAllDepart() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        List<DepartTree> departTree = new ArrayList<>();
        departmentList.forEach(s -> {
            DepartTree departTree1 = new DepartTree(s.getId(), s.getParentId(), s.getName(), s.getIsParent(), s.getStatus(), s.getSort(), s);
            departTree.add(departTree1);
        });
        return departTree;
    }

    /**
     * @description: 获取全部部门以及员工信息 改进版
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 21:49
     */
    @Override
    public List<DepartmentVO> getAllUserDepart() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        DepartmentVO departmentVO = new DepartmentVO();
        List<String> departName = departments.stream().map(s -> s.getName()).collect(Collectors.toList());
        List<DepartmentVO> list = new ArrayList<>();
        for (String departNameList : departName) {
            departmentVO.setDepartName(departNameList);
            logger.error("部门名称为: ,departName={}", departNameList);
            Long departId = this.getDepartIdByDepartName(departNameList);
            UserExample userExample = new UserExample();
            userExample.createCriteria().andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL).andDepartIdEqualTo(Integer.parseInt(departId.toString()));
            List<User> userList = userMapper.selectByExample(userExample);
            departmentVO.setUserList(userList);
            logger.error("部门下属员工信息有: ,userList={}", userList);
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("depart_id", departId);
            int userCountByDepart = userServiceImpl.count(queryWrapper);
            Map<String, Integer> map = new HashMap<>();
            map.put(departmentVO.getDepartName() + "部门员工总人数为:", userCountByDepart);
            logger.error(departmentVO.getDepartName() + "部门员工总人数为 : ,userCountByDepart={}", userCountByDepart);
            departmentVO.setUserCount(map);
        }
        list.add(departmentVO);
        return list;
    }

    /**
     * @description: 改版方法
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/12 11:36
     */
    /*@Override
    public DepartmentListVO getAllUserDepartByStream() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        DepartmentVO departmentVO = new DepartmentVO();
        List<String> departName = departments.stream().map(s -> s.getName()).collect(Collectors.toList());
        List<DepartmentVO> list = new ArrayList<>();
//        Long departInfo = this.getDepartIdByDepartName(departName.get(0));
        List<Long> idByDepartName = this.getDepartIdByDepartName(departName);
        UserExample userExample = new UserExample();
//        userExample.createCriteria().andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL).andDepartIdEqualTo(Integer.parseInt(departInfo.toString()));
        List<Integer> longs = JSONArray.parseArray(idByDepartName.toString(), Integer.class);
        userExample.createCriteria().andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL).andDepartIdIn(longs);
        List<User> userList = userMapper.selectByExample(userExample);
        userList.stream().forEach(s->{
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("depart_id", departName.get(0));
            int userCountByDepart = userServiceImpl.count(queryWrapper);
            logger.error(departName.get(0) + "部门员工总人数为 : ,userCountByDepart={}", userCountByDepart);
        });
        return DepartmentListVO.builder().departName(departName.get(0)).userList(userList).build();
    }*/



    /**
     * @description: 根据部门id获取部门信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 17:27
     */
    @Override
    public List<Department> getByDepartId(Long departId) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andIdEqualTo(departId);
        return departmentMapper.selectByExample(departmentExample);
    }

    /**
     * @description: 根据部门名称获取部门所在人员信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 17:57
     */
    @Override
    public Map<String, List<User>> getUserByDepartName(String departName) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andNameEqualTo(departName);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        Long departId = departments.stream().map(Department::getId).collect(Collectors.toList()).get(0);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andDepartIdEqualTo(Integer.parseInt(departId.toString()));
        List<User> userList = userMapper.selectByExample(userExample);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("depart_id", departId);
        int userCount = userServiceImpl.count(wrapper);
        logger.error(departName + " 所在部门总人数为: userCount={}", userCount);
        List<User> list = new ArrayList<>();
        Map<String, List<User>> map = new HashMap<>();
        userList.forEach(s -> {
            list.add(s);
            map.put(departName, list);
        });
        return map;
    }

    /**
     * @description: 根据多个部门名称获取多个部门id
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 22:32
     */
    @Override
    public List<Long> getDepartIdByDepartName(List<String> departName) {
        List<Long> list = new ArrayList<>();
        departName.stream().forEach(s -> {
            DepartmentExample departmentExample = new DepartmentExample();
            departmentExample.createCriteria().andNameEqualTo(s).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<Department> departments = departmentMapper.selectByExample(departmentExample);
            List<Long> collect = departments.stream().map(Department::getId).collect(Collectors.toList());
            list.addAll(collect);
        });
        return list;
    }

    /**
     * @description: 根据部门名称获取部门id
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/11 22:50
     */
    @Override
    public Long getDepartIdByDepartName(String departName) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andNameEqualTo(departName);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        if (departments != null && departments.size() > 0) {
            return departments.stream().map(s -> s.getId()).collect(Collectors.toList()).get(0);
        }
        return null;
    }
    /**
     * @description: 根据用户名获取用户部门信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/12 16:53
     */
    @Override
    public List<Department> getDepartByUser(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<User> userList = userMapper.selectByExample(userExample);
        Integer integer = userList.stream().map(s -> s.getDepartId()).collect(Collectors.toList()).get(0);
        return this.getByDepartId(Long.parseLong(integer.toString()));
    }
    /**
     * @description: 新增部门数据
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/12 17:06
     */
    @Override
    public void addDepart(Department department) {
        if (department!=null){
            if (!checkDepartName(department.getName())){
                throw new RuntimeException(BusinessConstants.DEPARTNAME_EXIST);
            }
            department.setId(null);
            if (department.getIsParent()){
                department.setParentId(0L);
            }
            department.setParentId(1L);
        }
    }
    /**
     * @description: 检查部门名是否重复
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/12 17:31
     */
    @Override
    public Boolean checkDepartName(String departName) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andNameEqualTo(departName).andStatusEqualTo(BusinessConstants.DEPART_STATUS_NORMAL);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        List<String> departNameList = departments.stream().map(s -> s.getName()).collect(Collectors.toList());
        if (departNameList.contains(departName)){
            return false;
        }
        return true;
    }
    /**
     * @description: 获取部门树形菜单
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/15 15:58
     */
    @Override
    public List<DepartmentListVO> getDepartMenu() {
        //h获取部门父节点
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED).andStatusEqualTo(BusinessConstants.DEPART_STATUS_NORMAL);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        List<DepartmentListVO> departMenuList=new ArrayList<>();
        departments.stream().forEach(s->{
            DepartmentListVO departmentListVO = new DepartmentListVO();
            BeanUtils.copyProperties(s, departmentListVO);
            departMenuList.add(departmentListVO);
        });
        List<DepartmentListVO> departMenuLists=new ArrayList<>();
        if (!CollectionUtil.isEmpty(departments)){
            departMenuLists = departMenuList.stream().filter(department -> department.getParentId() == 0).collect(Collectors.toList());
            Map<Long, List<DepartmentListVO>> departMap = departMenuList.stream().collect(Collectors.groupingBy(DepartmentListVO::getParentId));
            recursionFnTree(departMenuLists, departMap);
        }
        return departMenuLists;
    }
    /**
     * @description: 递归遍历节点
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/15 17:46
     */
    private void recursionFnTree(List<DepartmentListVO> list, Map<Long, List<DepartmentListVO>> map){
        for (DepartmentListVO departmentListVO:list){
            List<DepartmentListVO> departmentListVOList = map.get(departmentListVO.getId());
            departmentListVO.setDepartList(departmentListVOList);
            if (departmentListVOList!=null&&departmentListVOList.size()>0){
                recursionFnTree(departmentListVOList, map);
            }
        }
    }

}
