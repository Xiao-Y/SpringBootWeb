<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h2>Hello World!</h2>
	<table border="1" >
	<thead>
		<tr>
			<th></th>
			<th>序号</th>
			<th>用户名</th>
			<th>年龄</th>
			<th>联系方式</th>
			<th>操作</th>
		</tr>
	</thead>
		<c:forEach var="user" items="${users }">
		<tr>
			<td><input type="checkbox" value="${user.userId }"></td>
			<td>${user.userId }</td>
			<td>
				<a href="/user/prepareForUserUpdate/${user.userId }">${user.userName }</a>
			</td>
			<td>${user.age }</td>
			<td>${user.phoneNumber }</td>
			<td></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
