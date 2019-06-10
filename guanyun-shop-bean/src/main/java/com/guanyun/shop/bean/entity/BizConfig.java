package com.guanyun.shop.bean.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.guanyun.shop.bean.enumeration.BizConfigKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 业务配置表
 * </p>
 *
 * @author guanyun
 * @since 2018-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_biz_config")
@ApiModel(value="BizConfig对象", description="业务配置表")
public class BizConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "业务配置ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "键")
    private BizConfigKey bizKey;

    @ApiModelProperty(value = "值")
    private String bizValue;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createAt", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updateAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;


}
