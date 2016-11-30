package com.billow.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billow.model.User;
import com.billow.service.UserService;

/**
 * 返回JSON
 * 
 * @author liuyongtao
 * 
 * @date 2016年10月8日 上午8:46:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/*
	 * http://localhost:8080/findUserList
	 */
	@RequestMapping("/findUserList")
	@ResponseBody
	public List<User> findUserList() {
		List<User> users = userService.findUserList();
		for (User user : users) {
			logger.info(user);
		}
		return users;
	}

	@RequestMapping("/findUserList2")
	public String findUserList2(Model model) {
		List<User> users = userService.findUserList();
		for (User user : users) {
			logger.info(user);
		}
		model.addAttribute("users", users);
		return "user/findUserList2";
	}

	@RequestMapping("/prepareForUserAdd")
	public String prepareForUserAdd() {
		return "user/prepareForUserAdd";
	}

	@RequestMapping("/submitUserInfo")
	public String submitUserInfo(User user) {
		userService.saveUserInfo(user);
		System.out.println(user);
		return "success";
	}
}
