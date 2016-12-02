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

	/**
	 * 查询某个人发表的所有文章
	 * 
	 * <br>
	 * added by liuyongtao<br>
	 * 
	 * @param id
	 * @return
	 * 
	 * @date 2016年10月8日 下午3:48:44
	 */
	// public User getUserArticles(int id);
}
