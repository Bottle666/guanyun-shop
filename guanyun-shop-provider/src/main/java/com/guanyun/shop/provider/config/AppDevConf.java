package com.guanyun.shop.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:config/config-dev.properties")
public class AppDevConf {

}
