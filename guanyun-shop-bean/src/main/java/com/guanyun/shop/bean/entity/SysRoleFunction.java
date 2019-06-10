//package com.guanyun.shop.bean.entity;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * <p>
// * 系统角色功能表
// * </p>
// *
// * @author guanyun
// * @since 2018-12-12
// */
//@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
//@ApiModel(value="SysRoleFunction对象", description="系统角色功能表")
//public class SysRoleFunction implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @ApiModelProperty(value = "系统角色功能ID")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    @ApiModelProperty(value = "系统角色ID")
//    @TableField("sysRoleId")
//    private Integer sysRoleId;
//
//    @ApiModelProperty(value = "系统功能ID")
//    @TableField("sysFunctionId")
//    private Integer sysFunctionId;
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(value = "createAt", fill = FieldFill.INSERT)
//    private LocalDateTime createAt;
//
//    @ApiModelProperty(value = "更新时间")
//    @TableField(value = "updateAt", fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateAt;
//
//
//}
