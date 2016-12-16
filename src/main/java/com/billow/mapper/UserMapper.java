package com.billow.mapper;

import java.util.List;

import com.billow.model.User;

public interface UserMapper {

	public User findUserById(int userId);

	public List<User> findUserList(User user);

	public void saveUserInfo(User user);

	public void updateUserInfo(User user);

	public void deleteUserByUserId(Integer userId);

	public void deleteUserByUserIds(Integer[] userId);

	public int findUserCount(User user);

	public void batchInsertUser(List<User> users);
	
	public void findRoleByUserId(Integer userId);
}
