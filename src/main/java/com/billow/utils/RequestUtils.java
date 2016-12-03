package com.billow.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * request请求的工具类
 * 
 * @author XiaoY
 * @date: 2015年11月18日 下午10:14:35
 */
public class RequestUtils {

	/**
	 * 获取当前页
	 * 
	 * @param request
	 * @return
	 * @date 2015年11月18日 下午10:11:23
	 */
	public static Integer getTargetPage(HttpServletRequest request) {
		String targetPageStr = request.getParameter("pageNo");
		Integer targetPage;
		try {
			targetPage = Integer.parseInt(targetPageStr);
		} catch (Exception e) {
			targetPage = 1;
		}
		return targetPage;
	}

	/**
	 * 获取当前页大小
	 * 
	 * @param request
	 * @return
	 * @date 2015年11月18日 下午10:11:23
	 */
	public static Integer getPageSize(HttpServletRequest request) {
		String sizeStr = request.getParameter("pageSize");
		Integer size;
		try {
			size = Integer.parseInt(sizeStr);
		} catch (Exception e) {
			size = 10;
		}
		return size;
	}
}
