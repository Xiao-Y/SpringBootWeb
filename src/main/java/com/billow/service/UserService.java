package com.billow.service;

import java.util.List;

import com.billow.model.User;

public interface UserService {

	// public User getUserInfo(int id);
	public List<User> findUserList();

	public void saveUserInfo(User user);
}
