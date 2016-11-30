package com.billow.model;

/**
 * 文章
 * 
 * @author liuyongtao
 * 
 * @date 2016年10月8日 下午3:45:36
 */
public class Article {

	private int id;
	private int userid;
	private String title;
	private String content;
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", userid=" + userid + ", title=" + title + ", content=" + content + ", user=" + user + "]";
	}
}
