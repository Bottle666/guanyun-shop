package com.guanyun.shop.admin.config;

import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Permission;
import com.guanyun.shop.bean.entity.SysUser;
import com.guanyun.shop.bean.enumeration.ErrorCode;
import com.guanyun.shop.bean.response.Payload;
import com.guanyun.shop.provider.config.FlowException;
import com.guanyun.shop.provider.service.SysUserService;
import com.guanyun.shop.provider.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 授权拦截器
 */
@Component
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private SysUserService sysUserService;

    @Override
    @SuppressWarnings("Duplicates")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //注解权限判断
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Permission pm = method.getAnnotation(Permission.class);
        String authorization = request.getHeader("Authorization");
        if (pm != null && pm.action() == Action.Skip) {
            try {
                Payload payload = jwtUtils.parser(authorization);
                SysUser sysUser = sysUserService.getById(payload.getId());
                request.setAttribute("sysUser", sysUser);
            } catch (FlowException ignored) { }
            return true;
        }

        //权限判断
        Payload payload = jwtUtils.parser(authorization);
        SysUser sysUser = sysUserService.getById(payload.getId());
        if(sysUser == null){
            throw new FlowException("系统用户不存在");
        }

        //功能判断
        if(pm != null && !StringUtils.isEmpty(pm.value())){
            //TODO ...
            throw new FlowException("无权访问", ErrorCode.forbidden);
        }

        request.setAttribute("sysUser", sysUser);
        return true;
    }
}
