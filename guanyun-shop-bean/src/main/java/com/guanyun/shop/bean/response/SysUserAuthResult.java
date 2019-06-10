package com.guanyun.shop.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@ApiModel("系统用户授权结果")
public class SysUserAuthResult {

    @ApiModelProperty("侧边栏树结构")
    private List<Map<String, Object>> sideBarTree;

    @ApiModelProperty("页面按钮集合")
    private Map<String, List<String>> buttonMap;
}
