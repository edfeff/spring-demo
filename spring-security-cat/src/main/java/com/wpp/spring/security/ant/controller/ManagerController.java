package com.wpp.spring.security.ant.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PreAuthorize( "#id<10 and principal.username.equals(#username) or #user.username.equals('admin')" )
    @PostAuthorize( "returnObject%2==0" )
    public Integer test(Integer id, String username, User user) {
        return id;
    }

    @PreFilter( "filterObject%2==0" )
    @PostFilter( "filterObject%3==0" )
    public List<Integer> test2(List<Integer> list) {
        return list;
    }

}
