package com.guanyun.shop.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("系统角色搜索Body")
public class SysRoleSearchBody extends PageBody {

    @ApiModelProperty("名称")
    private String name;
}
