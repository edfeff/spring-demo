package com.wpp.spring.security.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpp
 */
@SpringBootApplication
@RestController
public class AntApplication {
    public static void main(String[] args) {
        SpringApplication.run(AntApplication.class, args);
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
