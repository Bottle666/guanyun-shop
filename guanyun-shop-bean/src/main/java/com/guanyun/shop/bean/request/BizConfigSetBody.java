package com.guanyun.shop.bean.request;

import com.guanyun.shop.bean.enumeration.BizConfigKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("业务配置设置值Body")
public class BizConfigSetBody<T> {

    @ApiModelProperty("键")
    private BizConfigKey key;

    @ApiModelProperty("值")
    private T value;

    @ApiModelProperty(value = "描述")
    private String description;
}
