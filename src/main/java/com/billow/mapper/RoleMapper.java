package com.billow.mapper;

import com.billow.model.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}