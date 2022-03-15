<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>隔离管理</title>
<link rel="stylesheet" href="./css/style.css" />
<style type="text/css">
/* 居家隔离情况 */
#homequarantine {
	border-collapse: collapse;
	width: 1180px;
	margin-left: 20px;
	margin-top: 20px;
}

#homequarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}

#homequarantine td {
	text-align: left;
	padding: 8px;
}

#homequarantine th {
	text-align: left;
	padding: 8px;
	background-color: #006566;
	color: white;
}

#homequarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}

</style>
</head>
<body>

	<table id="homequarantine" border="0">
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th>住址房间号</th>
			<th>隔离开始时间</th>
			<th>手机号</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${homePi.list}" var="user">
			<c:if test="${not empty user.homeQuarantine.homeid}">
				<tr>
					<td>${user.username}</td>
					<td>${user.name}</td>
					<td>${user.homeQuarantine.homeid}</td>
					<td>${user.homeQuarantine.starttime}</td>
					<td>${user.phoneNumber}</td>
					<td><form action="/community/deleteHomeQuarantine.do" method="post">
							<input type="hidden" name="uid" value="${user.getUserid()}">
							<input type="hidden" name="homeid" value="${user.homeQuarantine.homeid}"> 
							<input type="submit" value="删除" />
						</form>
					</td>
					<td>
						<form action="/community/updateHomeQuarantine.do" method="post">
							<input type="submit" value="更新" />
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table><br>


	<a href="/community/homeQuarantineUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>>
		<input type="submit" class="pagination" value="上一页" /></a>
	<a href="/community/homeQuarantineUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>>
		<input type="submit" class="pagination" value="下一页" /></a>





</body>
</html>