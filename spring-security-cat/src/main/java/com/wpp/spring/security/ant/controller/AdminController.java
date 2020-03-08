package com.wpp.spring.security.ant.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * admin 角色的控制器
 *
 * @author wangpp
 */
@RestController
@RequestMapping( "/admin" )
@PreAuthorize( value = "hasRole('ROLE_ADMIN')" )
public class AdminController {

    @RequestMapping( "/start" )
    public String start() {
        return "admin start";
    }

    @RequestMapping( "/stop" )
    public String stop() {
        return "admin stop";
    }
}
