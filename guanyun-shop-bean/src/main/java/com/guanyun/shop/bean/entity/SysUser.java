package com.guanyun.shop.bean.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author guanyun
 * @since 2018-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="系统用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "图像")
    private String avatar;

    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

//    @ApiModelProperty("登录时间戳")
//    private Long timestamp;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createAt", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "updateAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

    @ApiModelProperty("角色ID列表")
    private transient List<Integer> roleIdList;
}
