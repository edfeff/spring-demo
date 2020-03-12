package com.wpp.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api()
@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    @GetMapping("/test1")
    public String test1(String username, String password) {
        return username + ":" + password;
    }
}
