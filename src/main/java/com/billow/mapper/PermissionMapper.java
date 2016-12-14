package com.billow.mapper;

import com.billow.model.Permission;

public interface PermissionMapper {
    int insert(Permission record);

    int insertSelective(Permission record);
}