package com.yunhe.common.core.base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName BasePageQuery
 * @Description TODO 基础分页请求对象
 * @Author xiaozuqin
 * @Date 2022/7/20 16:25
 * @Version 1.0
 */
@Data
@ApiModel
public class BasePageQuery {

    @ApiModelProperty(value = "页码", example = "1")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;
}
