package com.wpp.spring.security.ant.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpp
 */
@RestController
@RequestMapping( "/manager" )
@PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')" )
public class ManagerController {
    @RequestMapping( "/progress" )
    public String progress() {
        return "manager finish 80%";
    }
}
