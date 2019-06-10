package com.guanyun.shop.provider.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableCaching
@PropertySource("classpath:config/config.properties")
public class AppConf implements InitializingBean {


//    @Autowired
//    private ConfigProperties configProperties;
//
    @Override
    public void afterPropertiesSet() throws Exception {
//        //填充Oss域名前缀
//        String domainOss = WebProtocol.http.getPrefix() + configProperties.getDomain().getOss() + "/";
//        OssKeySerializer.domainOss = domainOss;
//        OssKeyListSerializer.domainOss = domainOss;
    }
//
//    @Bean
//    public RestTemplate restTemplate(){
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectTimeout(60000);
//        httpRequestFactory.setReadTimeout(60000);
//
//        return new RestTemplate(httpRequestFactory);
//    }
//
//    /**
//     * 跨域访问设置
//     */
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(source);
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> {
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN);
//
//            builder.featuresToEnable(MapperFeature.DEFAULT_VIEW_INCLUSION);
//            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
//            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
//        };
//    }
}
