package com.billow.model;

/**
 * 文章
 * 
 * @author liuyongtao
 * 
 * @date 2016年10月8日 下午3:45:36
 */
public class Article {

	private int articleId;
	private int userId;
	private String title;
	private String content;
	private User user;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", userId=" + userId + ", title=" + title + ", content=" + content + ", user=" + user + "]";
	}
}
