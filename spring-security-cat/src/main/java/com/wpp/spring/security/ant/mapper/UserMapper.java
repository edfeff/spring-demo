package com.wpp.spring.security.ant.mapper;

import com.wpp.spring.security.ant.model.User;

public interface UserMapper {
    void add(User user);

    int update(Integer uid, User user);

    User findById(Integer uid);

    User findByUsername(String username);

    void deleteById(Integer uid);
}
