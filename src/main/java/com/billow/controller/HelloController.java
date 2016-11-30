package com.billow.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 视图模板<br/>
 * 返回结果为视图文件路径。视图相关文件默认放置在路径 resource/templates下
 * 
 * @author liuyongtao
 * 
 * @date 2016年9月30日 下午2:52:13
 */
@Controller
public class HelloController {

	private Logger logger = Logger.getLogger(HelloController.class);

	/**
	 * http://localhost:8080/hello?name=cn.7player
	 */
	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		logger.info("hello");
		model.addAttribute("name", name);
		return "hello";
	}

}
