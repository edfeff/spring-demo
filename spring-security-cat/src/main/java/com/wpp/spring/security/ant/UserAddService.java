package com.wpp.spring.security.ant;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wangpp
 */
@Component
public class UserAddService {
    /**
     * 添加3个用户
     *
     * @param auth
     * @throws Exception
     */
    public void add(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("emp").password("123456").roles("EMPLOYEE")
                .and()
                .withUser("manager").password("123456").roles("MANAGER");

    }
}
