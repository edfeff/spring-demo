package com.wpp.spring.security.ant;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangpp
 */
@Component
public class UserAddService implements UserDetailsService {
    public static final Map<String, UserDetails> INTERNAL_USER_STORE = new HashMap<>();

    static {

        UserDetails admin = User.builder().username("admin").password("admin").roles("ADMIN").build();
        UserDetails manager = User.builder().username("manager").password("123456").roles("MANAGER").build();
        UserDetails employee = User.builder().username("emp").password("123456").roles("EMPLOYEE").build();
        INTERNAL_USER_STORE.put("admin", admin);
        INTERNAL_USER_STORE.put("manager", manager);
        INTERNAL_USER_STORE.put("emp", employee);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return INTERNAL_USER_STORE.get(s);
    }
}
