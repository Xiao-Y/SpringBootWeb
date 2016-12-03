<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/taglib.jsp"%> 
<html>
<head>
<jsp:include page="/static/public.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${update == 'update'}"><!-- 更新 -->
			<sf:form action="${ctx }/user/updateUserInfo" method="post" modelAttribute="user">
				<input type="hidden" name="userId" value="${user.userId }"> 
				用户名：<input type="text" name="userName" value="${user.userName }"><sf:errors path="userName"/><br> 
				年龄：<input type="text" name="age" value="${user.age }"><sf:errors path="age"/><br>
				联系方式：<input type="text" name="phoneNumber" value="${user.phoneNumber }"><sf:errors path="phoneNumber"/><br>
				<input type="submit" value="提交">
				<!-- 显示所有的错误信息 -->
				<p><sf:errors path="*"/></p>
			</sf:form>
		</c:when>
		<c:otherwise><!-- 新增 -->
			<sf:form action="${ctx }/user/submitUserInfo" method="post" modelAttribute="user">
				用户名：<input type="text" name="userName" value="${user.userName }"><sf:errors path="userName"/><br> 
				年龄：<input type="text" name="age" value="${user.age }"><sf:errors path="age"/><br>
				联系方式：<input type="text" name="phoneNumber" value="${user.phoneNumber }"><sf:errors path="phoneNumber"/><br>
				<input type="submit" value="提交">
				<p><sf:errors path="*"/></p>
			</sf:form>
		</c:otherwise>
	</c:choose>
</body>
</html>