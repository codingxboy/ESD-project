package com.yunhe.company.erp.common.vo;
import com.yunhe.entity.domain.erp.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentVO
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/11 21:39
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVO {
    private String departName;
    private List<User> userList;
    private Map<String, Integer> userCount;
}
