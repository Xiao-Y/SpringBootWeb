package com.billow.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping("/findUserList2")
	@ResponseBody
	public List<User> findUserList2() {
		List<User> users = userService.findUserList();
		for (User user : users) {
			logger.info(user);
		}
		return users;
	}

	@RequestMapping("/findUserList")
	public String findUserList(Model model) {
		List<User> users = userService.findUserList();
		for (User user : users) {
			logger.info(user);
		}
		model.addAttribute("users", users);
		return "user/findUserList2";
	}

	@RequestMapping("/prepareForUserAdd")
	public String prepareForUserAdd(Model model) {
		// 因为jsp中使用了modelAttribute属性，所以必须在request域中有一个"user"
		model.addAttribute("user", new User());
		return "user/prepareForUserAdd";
	}

	@RequestMapping("/submitUserInfo")
	public String submitUserInfo(@Valid User user, BindingResult result, Model model) {
		// @Valid 表示按照在实体上标记的注解验证参数
		if (result.hasErrors()) {
			// List<ObjectError> list = result.getAllErrors();
			// for (ObjectError error : list) {
			// System.out.println(error.getCode() + "---" + error.getArguments()
			// + "---" + error.getDefaultMessage());
			// }
			return "user/prepareForUserAdd";
		}
		userService.saveUserInfo(user);
		return "success";
	}

	@RequestMapping(value = "/prepareForUserUpdate/{userId}", method = RequestMethod.GET)
	public String prepareForUserUpdate(@PathVariable Integer userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("update", "update");
		return "user/prepareForUserAdd";
	}

	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 标识是更新时校验的错误，对隐藏域中userId赋值
			model.addAttribute("update", "update");
			return "user/prepareForUserAdd";
		}
		userService.updateUserInfo(user);
		return "success";
	}
}
