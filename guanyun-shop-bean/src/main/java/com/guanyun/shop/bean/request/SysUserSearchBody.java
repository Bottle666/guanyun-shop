package com.guanyun.shop.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("系统用户搜索Body")
public class SysUserSearchBody extends PageBody {

    @ApiModelProperty("用户名")
    private String name;
}
