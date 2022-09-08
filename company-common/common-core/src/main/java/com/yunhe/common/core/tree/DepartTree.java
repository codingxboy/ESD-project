package com.yunhe.common.core.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @ClassName DepartTree
 * @Description TODO 部门树状结构
 * @Author xiaozuqin
 * @Date 2022/8/11 15:59
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartTree implements Comparable<DepartTree>{
    /**
     *节点
     */
    private long id;
    /**
     *父节点
     */
    private long parentId;
    /**
     *部门名称
     */
    private String departName;
    /**
     *是否是父节点
     */
    private boolean isParentId;
    /**
     *状态
     */
    private String status;
    /**
     *排序
     */
    private Integer sort;
    /**
     *数据
     */
    private Object data;

    @Override
    public int compareTo(@NotNull DepartTree o) {
        return this.getSort()-o.getSort();
    }
}
