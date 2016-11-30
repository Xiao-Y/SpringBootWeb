<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h2>Hello World!</h2>
	<table>
		<c:forEach var="user" items="${users }">
		<tr>
			<td><input type="checkbox" value="${user.userId }"></td>
			<td>${user.userId }</td>
			<td>
				<a href="/user/prepareForUserUpdate/${user.userId }">${user.userName }</a>
			</td>
			<td>${user.age }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
