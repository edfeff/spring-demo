package com.wpp.spring.security.ant.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpp
 */
@RestController
@RequestMapping( "/employee" )
@PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_EMPLOYEE')" )
public class EmployeeController {
    @RequestMapping( "/what" )
    public String progress() {
        return "employee doing fucking!!!";
    }
}
