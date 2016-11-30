package com.billow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billow.model.User;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
public class SwaggerController {

	/*
	 * http://localhost:8080/swagger/index.html
	 */
	@ApiOperation(value = "Get all users", notes = "requires noting")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();

		User user = new User();
		user.setUserName("hello");
		list.add(user);

		User user2 = new User();
		user.setUserName("world");
		list.add(user2);
		return list;
	}

	@ApiOperation(value = "Get user with id", notes = "requires the id of user")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUserById(@PathVariable String name) {
		User user = new User();
		user.setUserName("hello world");
		return user;
	}
}