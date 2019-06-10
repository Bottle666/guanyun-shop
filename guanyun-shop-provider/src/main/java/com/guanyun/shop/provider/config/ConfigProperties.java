package com.guanyun.shop.provider.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigProperties {

    @Value("${app.env}")
    private String appEnv;

    @Autowired
    private Jwt jwt;

    @Autowired
    private Domain domain;

    @Data
    @Component
    @ConfigurationProperties(prefix = "jwt")
    public static class Jwt {

        private String key;

        private Integer webExpired;

        private Integer appExpired;
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "domain")
    public static class Domain {

        private String oss;
    }
}
