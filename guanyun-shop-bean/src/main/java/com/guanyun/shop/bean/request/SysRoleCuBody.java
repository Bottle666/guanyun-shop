package com.guanyun.shop.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("系统角色操作Body")
public class SysRoleCuBody {

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty("功能列表")
    private List<Integer> functionList;
}
