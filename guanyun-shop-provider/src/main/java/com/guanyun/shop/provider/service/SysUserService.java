package com.guanyun.shop.provider.service;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guanyun.shop.bean.entity.SysUser;
import com.guanyun.shop.bean.enumeration.Source;
import com.guanyun.shop.bean.request.SysUserCuBody;
import com.guanyun.shop.bean.request.SysUserLoginBody;
import com.guanyun.shop.bean.request.SysUserSearchBody;
import com.guanyun.shop.bean.response.Payload;
import com.guanyun.shop.bean.response.SysUserLoginResult;
import com.guanyun.shop.provider.config.ConfigProperties;
import com.guanyun.shop.provider.config.FlowException;
import com.guanyun.shop.provider.mapper.SysUserMapper;
import com.guanyun.shop.provider.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author duanlinfei
 * @since 2018-12-12
 */
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {


    //@Autowired
    //private SysUserRoleService sysUserRoleService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ConfigProperties configProperties;

    public SysUser getByName(String name){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);

        return this.getOne(wrapper);
    }

    public SysUser detail(Integer id){
        SysUser sysUser = this.getById(id);
        //List<SysUserRole> userRoleList = sysUserRoleService.listByUserId(id);
        //List<Integer> roleIdList = userRoleList.stream().map(SysUserRole::getSysRoleId).collect(Collectors.toList());
        //sysUser.setRoleIdList(roleIdList);
        return sysUser;
    }

    public Page<SysUser> page(SysUserSearchBody body){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(body.getName()), "name", body.getName());

        Page<SysUser> page = new Page<>(body.getCurrent(), body.getSize());
        page.setDesc("createAt");
        this.page(page, wrapper);
        return page;
    }

    /**
     * 用户登录
     */
    @Validated
    public SysUserLoginResult login(SysUserLoginBody body){
        SysUser sysUser = this.getByName(body.getName());
        if(sysUser == null){
            throw new FlowException("系统用户不存在");
        }
        if(!sysUser.getPassword().equals(SecureUtil.md5(body.getPassword()))){
            throw new FlowException("密码错误");
        }

        return this.genToken(sysUser);
    }

    /**
     * 生成token
     */
    public SysUserLoginResult genToken(SysUser sysUser){
        Payload payload = new Payload();
        payload.setId(sysUser.getId());
        payload.setSource(Source.web);
        payload.setTimestamp(System.currentTimeMillis());
        String token = jwtUtils.genToken(payload);

        SysUserLoginResult result = new SysUserLoginResult();
        result.setToken(token);
        result.setExpiredAt(LocalDateTime.now().plusMinutes(configProperties.getJwt().getWebExpired()));
        return result;
    }

    /**
     * 保存或修改用户
     */
    @Transactional
    public void cu(SysUserCuBody body){
        SysUser sysUser = this.getByName(body.getName());
        if(sysUser != null){
            if(!sysUser.getId().equals(body.getId())){
                throw new FlowException("用户名已存在");
            }
        }

        sysUser = new SysUser();
        sysUser.setId(body.getId());
        sysUser.setName(body.getName());
        sysUser.setNickName(body.getNickName());
        if(!StringUtils.isEmpty(body.getPassword())){
            sysUser.setPassword(SecureUtil.md5(body.getPassword()));
        }
        this.saveOrUpdate(sysUser);

        //同步角色
//        List<SysUserRole> userRoleList = sysUserRoleService.listByUserId(body.getId());
//        Map<Integer, Integer> roleMap = userRoleList.stream().collect(Collectors.toMap(SysUserRole::getSysRoleId, SysUserRole::getId));
//        for (Integer roleId : body.getRoleList()) {
//            if(roleMap.containsKey(roleId)){
//                roleMap.remove(roleId);
//            } else {
//                sysUserRoleService.save(sysUser.getId(), roleId);
//            }
//        }
//        if(roleMap.size() > 0){
//            sysUserRoleService.removeByIds(roleMap.values());
//        }
    }

    /**
     * 删除系统用户
     */
    @Transactional
    public void delete(Integer id){
        this.removeById(id);

        //同步角色
        //sysUserRoleService.delete(id);
    }

}
