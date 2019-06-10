package com.guanyun.shop.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Conf {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(this.buildApiInfo("平台后台相关接口"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.guanyun.shop.admin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo(String title){
        return new ApiInfoBuilder().title(title).build();
    }
}
