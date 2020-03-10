package com.wpp.spring.security.ant.mapper;

import com.wpp.spring.security.ant.model.Permission;

public interface PermissionMapper {
    void add(Permission permission);

    int update(Integer rid, Permission permission);

    Permission findById(Integer pid);

    Permission findByPermissionName(String permission);

    void deleteById(Integer pid);
}
