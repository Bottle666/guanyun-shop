package com.guanyun.shop.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页Body")
public class PageBody {

    @ApiModelProperty(value = "当前页", example = "1")
    private int current = 1;

    @ApiModelProperty(value = "页大小 默认10", example = "10")
    private int size = 10;

}
