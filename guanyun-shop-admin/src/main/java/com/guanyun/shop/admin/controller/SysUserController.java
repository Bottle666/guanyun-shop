package com.guanyun.shop.admin.controller;

import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guanyun.shop.bean.annotation.CurrentUser;
import com.guanyun.shop.bean.entity.SysUser;
import com.guanyun.shop.bean.request.SysUserCuBody;
import com.guanyun.shop.bean.request.SysUserLoginBody;
import com.guanyun.shop.bean.request.SysUserSearchBody;
import com.guanyun.shop.bean.response.ResponseData;
import com.guanyun.shop.bean.response.SysUserAuthResult;
import com.guanyun.shop.bean.response.SysUserLoginResult;
import com.guanyun.shop.provider.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("sysUser")
@Api(value = "sysUser", tags = "系统用户相关接口")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    //@Autowired
    //private SysFunctionService sysFunctionService;

    @Permission(action = Action.Skip)
    @PostMapping("login")
    @ApiOperation("系统用户登录")
    public ResponseData<SysUserLoginResult> login(@RequestBody SysUserLoginBody body){
        SysUserLoginResult result = sysUserService.login(body);
        return ResponseData.succeed(result);
    }

    @PostMapping("refresh/token")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("刷新token")
    public ResponseData<SysUserLoginResult> refreshToken(@ApiIgnore @CurrentUser SysUser sysUser){
        SysUserLoginResult result = sysUserService.genToken(sysUser);
        return ResponseData.succeed(result);
    }

    @GetMapping("info")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("系统用户信息")
    public ResponseData<SysUser> info(@ApiIgnore @CurrentUser SysUser sysUser){
        return ResponseData.succeed(sysUser);
    }

//    @PostMapping("auth")
//    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
//    @ApiOperation("用户授权结果")
//    public ResponseData<SysUserAuthResult> auth(@ApiIgnore @CurrentUser SysUser sysUser){
//        SysUserAuthResult result = sysFunctionService.userAuth(sysUser.getId());
//        return ResponseData.succeed(result);
//    }

    @PostMapping("page")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("用户列表")
    public ResponseData<Page<SysUser>> page(@RequestBody SysUserSearchBody body){
        Page<SysUser> page = sysUserService.page(body);
        return ResponseData.succeed(page);
    }

    @PostMapping("detail/{id}")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("系统用户详情")
    public ResponseData<SysUser> detail(@PathVariable Integer id){
        SysUser sysUser = sysUserService.detail(id);
        return ResponseData.succeed(sysUser);
    }

    @PostMapping("cu")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("保存或修改用户")
    public ResponseData cu(@RequestBody SysUserCuBody body){
        sysUserService.cu(body);
        return ResponseData.succeed();
    }

    @PostMapping("delete/{id}")
    @ApiImplicitParam(paramType = "header", name = "Authorization", dataType = "String", required = true, value = "token")
    @ApiOperation("删除用户")
    public ResponseData delete(@PathVariable Integer id){
        sysUserService.delete(id);
        return ResponseData.succeed();
    }
}
