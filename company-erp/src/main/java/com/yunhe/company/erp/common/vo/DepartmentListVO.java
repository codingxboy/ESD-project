package com.yunhe.company.erp.common.vo;
import com.yunhe.entity.domain.erp.Department;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentListVO
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/12 11:59
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentListVO extends Department {
    private List<DepartmentListVO> departList;
}
