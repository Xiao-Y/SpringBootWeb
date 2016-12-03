package com.billow.plug;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @explain 自定义分页标签 <br/>
 *          使用方式: &lt x:pager pageSize="10" pageNo="1" recordCount="100" url="index.jsp" / &gt
 * @author XiaoY
 * @date: 2016年1月1日 下午9:52:39
 */
public class PageResult extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String url; // 请求url
	private int pageSize = 10; // 每页要显示的记录数
	private int pageNo = 1; // 当前页号
	private int recordCount; // 总记录数

	public int doStartTag() throws JspException {

		int pageCount = (recordCount + pageSize - 1) / pageSize; // 计算总页数

		StringBuilder sb = new StringBuilder();
		if (recordCount > 0) {
			sb.append("\r\n<div class=\"page mt10\">\r\n");
			sb.append("\r\n<div class=\"pagination\">\r\n");
			sb.append("\r\n<ul>\r\n");
			if (pageNo > pageCount) { // 页号越界处理
				pageNo = pageCount;
			}
			if (pageNo < 1) {
				pageNo = 1;
			}
			sb.append("<form method='post' action='' name='qPagerForm'>\r\n");
			// 获取请求中的所有参数
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null; // 参数名
			String value = null; // 参数值
			// 把所有的请求参数当作隐藏表单域
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				value = request.getParameter(name);
				// 去除页号
				if (name.equals("pageNo")) {
					if (value != null && !value.equals("")) {
						pageNo = Integer.parseInt(value);
					}
					continue;
				}
				sb.append("<input type='hidden' name='" + name + "' value='" + value + "'/>\r\n");
			}
			// 把当前页号设置成请求参数
			sb.append("<input type='hidden' name='" + "pageNo" + "' value='" + pageNo + "'/>\r\n");
			// sb.append("&nbsp;共<strong>" + recordCount + "</strong>项，<strong>" + pageCount + "</strong>页:&nbsp;\r\n");

			if (pageNo == 1) {
				// 首页
				sb.append("<li class=\"disabled\"><span>首页</span></li>\r\n");
				sb.append("<li class=\"disabled\"><span>上一页</span></li>\r\n");
			} else {
				sb.append("<li class=\"first-child\"><a href='#' onClick='turnOverPage(1)'>首页</a></li>\r\n");
				sb.append("<li><a href='#' onClick='turnOverPage(" + (pageNo - 1) + ")'>上一页</a></li>\r\n");
			}

			// 每次最多显示8个
			if (pageCount <= 8) {
				for (int i = 1; i <= pageCount; i++) {
					if (pageNo == i) { // 判断是否是当前页
						sb.append("<li class=\"active\"><span>" + i + "</span></li>\r\n");
					} else {
						sb.append("<li><a href='#' onClick='turnOverPage(" + i + ")'>" + i + "</a></li>\r\n");
					}
				}
			} else if (pageCount > 8) {
				if (this.pageNo > 8) {
					for (int i = 7; i >= 0; i--) {
						if (pageNo == i) { // 判断是否是当前页
							sb.append("<li class=\"active\"><span>" + (this.pageNo - i) + "</span></li>\r\n");
						} else {
							sb.append("<li><a href='#' onClick='turnOverPage(" + (this.pageNo - i) + ")'>"
									+ (this.pageNo - i) + "</a></li>\r\n");
						}
					}
				} else {
					for (int i = 1; i <= 8; i++) {
						if (pageNo == i) { // 判断是否是当前页
							sb.append("<li class=\"active\"><span>" + i + "</span></li>\r\n");
						} else {
							sb.append("<li><a href='#' onClick='turnOverPage(" + i + ")'>" + i + "</a></li>\r\n");
						}
					}
				}
			}

			// 下一页的处理
			if (pageNo == pageCount) {
				sb.append("<li class=\"disabled\"><span>下一页</span></li>\r\n");
				sb.append("<li class=\"disabled\"><span>末页</span></li>\r\n");
			} else {
				sb.append("<li><a href='#' onClick='turnOverPage(" + (pageNo + 1) + ")'>下一页</a></li>\r\n");
				// 末页
				sb.append("<li class=\"last-child\"><a href='#' onClick='turnOverPage(" + pageCount
						+ ")'>末页</a></li>\r\n");
			}
			sb.append("<li class=\"disabled\"><span>" + pageNo + "/" + pageCount + ",共" + recordCount
					+ "条数据</span></li>\r\n");
			sb.append("</form>\r\n");

			// 翻页
			sb.append("<script type='text/javascript'>");
			sb.append("function turnOverPage(no){");
			sb.append("var qForm=document.qPagerForm;");
			sb.append("if(no>" + pageCount + "){no=" + pageCount + ";}");
			sb.append("if(no<1){no=1;}");
			sb.append("qForm.pageNo.value=no;");
			sb.append("qForm.action='" + url + "';");
			sb.append("qForm.submit();} </script>");
			sb.append("</ul>");
			sb.append("</div>");
			sb.append("</div>");
		}
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
}
