<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看全部用户信息</title>
<link rel="stylesheet" href="./admin/css/style.css" />
</head>
<body>
	<div class="nav">全部住户信息></div>
	<hr>
	<table id="allUser" border="0">
		<tr>
			<th>账号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>手机号</th>
			<th>状态</th>
			<th>最近一次核酸检测时间</th>
		</tr>

		<c:forEach items="${pi.list}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td><c:if test="${user.sex==1}">男</c:if> <c:if
						test="${user.sex==0}">女</c:if></td>
				<td>${user.identityNumber}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.status}</td>
				<td>${user.latestDetection}</td>
			</tr>
		</c:forEach>

	</table>
	<a
		href="/community/allUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>>上一页</a>
	<a
		href="/community/allUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>>下一页</a>
		
		
		<table id="uservaccine" border="0">
			<tr>
				<th>用户名</th>
				<th>姓名</th>
				<th>第一针</th>
				<th>第二针</th>
				<th>第三针</th>
			</tr>
			<c:forEach items="${pi.list}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.name}</td>
					<td>${user.firstVaccine}</td>
					<td>${user.secondVaccine}</td>
					<td>${user.thirdVaccine}</td>
				</tr>
			</c:forEach>
		</table>
		
	<a
		href="vaccineUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>>上一页</a>
	<a
		href="vaccineUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>>下一页</a>
		
		
		
		
</body>
</html>
