package com.billow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * excel操作
 * 
 * @author liuyongtao
 * 
 * @date 2016年11月25日 下午5:46:44
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

	@RequestMapping("/indexExcel")
	public String indexExcel() {
		return "excel/indexExcel";
	}

}
