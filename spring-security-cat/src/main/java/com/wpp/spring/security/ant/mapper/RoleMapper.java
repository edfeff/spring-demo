package com.wpp.spring.security.ant.mapper;

import com.wpp.spring.security.ant.model.Role;

public interface RoleMapper {
    void add(Role role);

    int update(Integer rid, Role role);

    Role findById(Integer rid);

    Role findByRolename(String rolename);

    void deleteById(Integer uid);
}
