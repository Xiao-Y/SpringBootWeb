<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#userName").on("keyup",function(){
			var userName = $("#userName").val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/user/searchUser?userName=" + userName,
				data : {
					userName : userName
				},
				dataType : "json",
				success : function(msg) {
					if(msg != ''){
						var datas = eval('(' + msg + ')');
						console.info(datas);
						$("#userName").autocomplete(datas, {
							formatItem: function (row, i, max) {
								console.info(row);
								return "<table width='400px'><tr><td align='left'>" + row + "</td></tr></table>";
							},
							formatMatch: function(row, i, max){
								return row;
							}
						});
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>List</h2>
	<input type="text" id="userName" name="userName" id="tags">
	<table border="1">
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
				<td><a href="/user/prepareForUserUpdate/${user.userId }">${user.userName }</a>
				</td>
				<td>${user.age }</td>
				<td>${user.phoneNumber }</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
