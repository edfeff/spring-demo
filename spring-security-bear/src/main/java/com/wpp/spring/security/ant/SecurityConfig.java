package com.wpp.spring.security.ant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 适用于最简单的只需要登陆就可以执行所有操作的样例
 * 1. 配置用户名和密码
 * 2. 配置密码编码器
 * 3. 配置有无权限页
 * 4. 配置静态资源页
 *
 * @author wangpp
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value( "${system.admin.username}" )
    private String username;
    @Value( "${system.admin.password}" )
    private String password;

    /**
     * 简单的登陆功能
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(username)
                .password(password)
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin()
        ;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
