package com.billow.service;

import java.util.List;

import com.billow.model.User;

public interface UserService {

	public List<User> findUserList(User user);

	public void saveUserInfo(User user);

	public void updateUserInfo(User user);

	public User findUserById(int id);

	public void deleteUserByUserId(Integer userId);

	public int findUserCount(User user);
}
