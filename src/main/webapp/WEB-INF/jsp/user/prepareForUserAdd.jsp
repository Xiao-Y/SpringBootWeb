<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${update == 'update'}">
			<form action="/user/updateUserInfo" method="post">
		</c:when>
		<c:otherwise>
			<form action="/user/submitUserInfo" method="post">
		</c:otherwise>
	</c:choose>
		<input type="hidden" name="userId" value="${user.userId }"> 
		用户名：<input type="text" name="userName" value="${user.userName }"><br> 
		年龄：<input type="text" name="age" value="${user.age }"><br>
		 <input type="submit" value="提交">
	</form>
</body>
</html>