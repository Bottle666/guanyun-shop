package com.guanyun.shop.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("系统用户登录Body")
public class SysUserLoginBody {

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String name;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
}
