<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/taglib.jsp"%> 
<html>
<head>
<jsp:include page="/static/public.jsp"/>
<script type="text/javascript">
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
	 <!-- 分页start -->
     <x:pager pageSize="${userModel.pageSize }" pageNo="${userModel.pageNo }" recordCount="${userModel.recordCount }" url="/user/findUserList" />
     <!-- 分页end -->
</body>
</html>
