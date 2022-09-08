package com.yunhe.company.erp.generator.mappers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yunhe.entity.domain.erp.Department;
import com.yunhe.entity.domain.erp.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department> {
    long countByExample(DepartmentExample example);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
}
