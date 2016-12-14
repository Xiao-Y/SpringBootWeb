package com.billow.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.billow.annotation.validator.CannotContainSpaces;
import com.billow.annotation.validator.PhoneNumber;

public class User extends BaseModel {

	private Integer userId;

	@NotEmpty(message = "姓名不能为空")
	@Length(min = 5, message = "用户名不能少于5")
	@CannotContainSpaces(message = "用户名不能包含空格")
	private String userName;

	@Max(value = 120, message = "年龄不能大于120岁")
	@Min(value = 18, message = "必须年满18岁！")
	@NotNull(message = "年龄不能为空")
	private Integer age;

	private String password;

	@PhoneNumber
	private String phoneNumber;

	private List<Article> articles;
	private List<Role> roles;

	public User() {
		super();
	}

	public User(String userName, Integer age, String phoneNumber) {
		super();
		this.userName = userName;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", articles=" + articles + ", roles=" + roles + "]";
	}

}
