package com.wpp.spring.security.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用Security的全局权限注解，需要使用 @EnableGlobalMethodSecurity 注解开启
 *
 * @author wangpp
 */
@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class CatApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatApplication.class, args);
    }

    @RequestMapping( "/" )
    public String index() {
        return "index";
    }

    @RequestMapping( "/home" )
    public String home() {
        return "home";
    }
}
