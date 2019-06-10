package com.guanyun.shop.bean.response;

import com.guanyun.shop.bean.enumeration.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("token负载")
public class Payload {

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("来源(ios,android,web)")
    private Source source;

    @ApiModelProperty("时间戳")
    private Long timestamp;
}
