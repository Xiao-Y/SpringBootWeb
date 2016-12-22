package com.billow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utils.StringUtils;
import utils.ToolsUtils;

import com.billow.mapper.ArticleMapper;
import com.billow.mapper.UserMapper;
import com.billow.model.Article;
import com.billow.model.User;
import com.billow.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<User> findUserList(User user) {
		return userMapper.findUserList(user);
	}

	@Override
	public void saveUserInfo(User user) {
		userMapper.saveUserInfo(user);

	}

	@Override
	public void updateUserInfo(User user) {
		userMapper.updateUserInfo(user);
	}

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	@Transactional
	@Override
	public void deleteUserByUserId(Integer userId) {
		User user = userMapper.findUserById(userId);
		List<Article> articles = user.getArticles();
		if (StringUtils.isNotEmpty(articles)) {
			List<Integer> listObject = ToolsUtils.getListByFieldValue(articles, "articleId");
			if (StringUtils.isNotEmpty(listObject)) {
				Integer[] articleIds = new Integer[listObject.size()];
				listObject.toArray(articleIds);
				articleMapper.deleteUserByArticleIds(articleIds);
			}
		}
		userMapper.deleteUserByUserId(userId);
	}

	@Override
	public int findUserCount(User user) {
		return userMapper.findUserCount(user);
	}
}
