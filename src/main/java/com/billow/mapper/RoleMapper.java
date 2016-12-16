package com.billow.mapper;

import java.util.List;

import com.billow.model.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * 级联查询出用户信息
	 * 
	 * <br>
	 * added by liuyongtao<br>
	 * 
	 * @param id
	 * @return
	 * 
	 * @date 2016年12月15日 上午8:54:38
	 */
	Role findRoleByRoleId(Integer id);

	List<Role> findRoleList(Role role);

	int findRoleCount(Role role);

	void batchInsertRole(List<Role> roles);
}