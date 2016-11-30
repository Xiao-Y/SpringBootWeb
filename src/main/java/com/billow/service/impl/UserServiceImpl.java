package com.billow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billow.mapper.UserMapper;
import com.billow.model.User;
import com.billow.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findUserList() {
		return userMapper.findUserList();
	}

	@Override
	public void saveUserInfo(User user) {
		userMapper.saveUserInfo(user);
		
	}

	// @Override
	// public User getUserInfo(int id) {
	// return userMapper.findUserInfo(id);
	// }

}
