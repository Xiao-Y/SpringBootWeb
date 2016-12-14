package com.billow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billow.mapper.UserMapper;
import com.billow.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class AppTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void getUserList() {
		List<User> userList = userMapper.findUserList(null);
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void batchInsertUser() {
		List<User> users = new ArrayList<>();
		users.add(new User("qqq", 23, "15507543456"));
		users.add(new User("sss", 22, "15502543456"));
		users.add(new User("www", 24, "15506543456"));
		users.add(new User("rrr", 26, "15507573456"));
		users.add(new User("ggg", 27, "15507213345"));
		users.add(new User("ccc", 28, "15507547656"));
		userMapper.batchInsertUser(users);
	}
}
