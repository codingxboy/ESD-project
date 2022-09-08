package com.yunhe.company.oa.domain.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/22 16:22
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 990678158478242608L;
    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
