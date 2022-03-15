<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>疫苗接种表</title>
<link rel="stylesheet" href="./admin/css/style.css" />
</head>
<body>
	<table id="unuservaccine" border="0">
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th>第一针</th>
			<th>第二针</th>
		</tr>
		<c:if test="${empty user.thirdVaccine}">
			<c:forEach items="${vaccinepi.list}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.name}</td>
					<td>${user.firstVaccine}</td>
					<td>${user.secondVaccine}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

	<a
		href="/community/vaccineUserPage.do?vpageNumber=${vaccinepi.pageNumber+1 }&vpageSize=${vaccinepi.pageSize}"
		<c:if test="${vaccinepi.pageNumber>= vaccinepi.total}"> onclick="javascript:return false;" </c:if>><input type="submit" class="pagination" value="下一页" /></a>

	<a
		href="/community/vaccineUserPage.do?vpageNumber=${vaccinepi.pageNumber-1 }&vpageSize=${vaccinepi.pageSize}"
		<c:if test="${vaccinepi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>><input type="submit" class="pagination" value="上一页" /></a>
	
</body>
</html>
