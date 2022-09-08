package com.yunhe.common.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunhe.common.core.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName BaseEntity
 * @Description TODO 基础实体对象
 * @Author xiaozuqin
 * @Date 2022/7/20 15:57
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 3892083963145311279L;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @Excel(name = "创建人", width = 15)
    private String creatorBy;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    @Excel(name = "更新人", width = 15)
    private String updaterBy;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    @Excel(name = "备注", width = 1000)
    private String remark;

    public String getUpdateBy()
    {
        return updaterBy;
    }
    public String getCreatorBy()
    {
        return creatorBy;
    }
}
