package com.guanyun.shop.bean.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("系统用户操作Body")
public class SysUserCuBody {

    @JsonIgnore
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty("角色列表")
    private List<Integer> roleList;
}
