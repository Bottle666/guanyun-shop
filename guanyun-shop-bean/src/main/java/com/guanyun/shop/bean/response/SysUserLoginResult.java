package com.guanyun.shop.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("系统用户登录结果")
public class SysUserLoginResult {

    @ApiModelProperty("授权token")
    private String token;

    @ApiModelProperty("失效时间")
    private LocalDateTime expiredAt;
}
