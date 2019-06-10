package com.guanyun.shop.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * MVC配置
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-config-enable
 */
@Configuration
@EnableWebMvc
public class WebMvcConf implements WebMvcConfigurer {

    @Autowired
    private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/",
                "classpath:/META-INF/resources/", //swagger静态资源
                "classpath:/resources/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
            argumentResolvers.add(currentUserMethodArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePathPatterns = new String[]{
                "/error", //错误页面
                "/swagger-resources/**"}; //swagger相关资源

        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
    }
}
