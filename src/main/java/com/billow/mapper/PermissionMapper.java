package com.billow.mapper;

import com.billow.model.Permission;

public interface PermissionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
}