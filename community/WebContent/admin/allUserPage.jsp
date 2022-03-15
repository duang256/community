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
			<th>隔离状态</th>
			<th></th>
			<th></th>
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
				<td><c:if test="${not empty user.homeQuarantine}">居家隔离</c:if> <c:if
						test="${not empty user.concentrationQuarantine}">集中隔离</c:if> <c:if
						test="${empty user.homeQuarantine && empty user.concentrationQuarantine}">未隔离</c:if>
				</td>



				<td><c:if
						test="${empty user.homeQuarantine &&  empty user.concentrationQuarantine}">
						<form action="/community/getHomeId.do" method="post">
							<input type="hidden" name="id" value="${user.userid}"><br>
							<input type="submit" value="设为居家隔离" />
						</form>
					</c:if></td>
				<td><c:if
						test="${empty user.homeQuarantine &&  empty user.concentrationQuarantine}">
						<form action="/community/getConcentrationId.do" method="post">
							<input type="hidden" name="id" value="${user.userid}"><br>
							<input type="submit" value="设为集中隔离" />
						</form>
					</c:if></td>

			</tr>
		</c:forEach>

	</table>
	<br>


	<a
		href="/community/allUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>>
		<input type="submit" class="pagination" value="下一页" />
	</a>
	<a
		href="/community/allUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>><input
		type="submit" class="pagination" value="上一页" /></a>







</body>
</html>
