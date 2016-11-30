package com.billow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * 
	 * 
	 * <br>
	 * added by liuyongtao<br>
	 * 
	 * @return
	 * 
	 * @date 2016年11月28日 下午4:53:37
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
