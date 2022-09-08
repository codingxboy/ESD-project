package com.yunhe.company.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.common.core.tree.DepartTree;
import com.yunhe.company.erp.common.vo.DepartmentListVO;
import com.yunhe.company.erp.common.vo.DepartmentVO;
import com.yunhe.entity.domain.erp.Department;
import com.yunhe.entity.domain.erp.User;


import java.util.List;
import java.util.Map;

public interface DepartmentService extends IService<Department> {

    List<DepartTree> getAllDepart();

    List<DepartmentVO> getAllUserDepart();

    List<Department> getByDepartId(Long departId);

    Map<String, List<User>> getUserByDepartName(String departName);

    List<Long> getDepartIdByDepartName(List<String> departName);

    Long getDepartIdByDepartName(String departName);

//    DepartmentListVO getAllUserDepartByStream();

    List<Department> getDepartByUser(String userName);

    void addDepart(Department department);

    Boolean checkDepartName(String departName);

    List<DepartmentListVO> getDepartMenu();
}
