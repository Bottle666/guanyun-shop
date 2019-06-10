package com.guanyun.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.guanyun.shop")
public class GuanyunShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuanyunShopAdminApplication.class, args);
    }
}

