//package com.guanyun.shop.bean.entity;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.guanyun.shop.bean.enumeration.FunctionType;
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
// * 系统功能表
// * </p>
// *
// * @author guanyun
// * @since 2018-12-12
// */
//@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
//@ApiModel(value="SysFunction对象", description="系统功能表")
//public class SysFunction implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @ApiModelProperty(value = "系统功能ID")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    @ApiModelProperty(value = "父节点ID")
//    @TableField("parentId")
//    private Integer parentId;
//
//    @ApiModelProperty(value = "类型(menu=菜单 page=页面 button=按钮)")
//    private FunctionType type;
//
//    @ApiModelProperty(value = "名称")
//    private String name;
//
//    @JsonIgnore
//    @ApiModelProperty(value = "图标")
//    private String icon;
//
//    @ApiModelProperty(value = "权限标示")
//    private String permission;
//
//    @ApiModelProperty(value = "排序号")
//    private Integer seq;
//
//    @ApiModelProperty(value = "描述")
//    private String description;
//
//    @ApiModelProperty(value = "创建时间", hidden = true)
//    @TableField(value = "createAt", fill = FieldFill.INSERT)
//    private LocalDateTime createAt;
//
//    @ApiModelProperty(value = "修改时间", hidden = true)
//    @TableField(value = "updateAt", fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateAt;
//
//    @ApiModelProperty("是否选中")
//    private transient boolean isCheck;
//}
