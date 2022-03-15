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
	<table id="uservaccine" border="0">
		<tr>
			<th>姓名</th>
			<th>第一针</th>
			<th>第二针</th>
			<th>第三针</th>
			<th>电话</th>
		</tr>
		<c:forEach items="${pi.list}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>
					<c:if test="${empty user.firstVaccine}">未接种</c:if> 
					<c:if test="${not empty user.firstVaccine}">${user.firstVaccine}</c:if>
				</td>
				<td>
					<c:if test="${empty user.secondVaccine}">未接种</c:if> 
					<c:if test="${not empty user.secondVaccine}">${user.secondVaccine}</c:if>
				</td>
				<td>
					<c:if test="${empty user.thirdVaccine}">未接种</c:if> 
					<c:if test="${not empty user.thirdVaccine}">${user.thirdVaccine}</c:if>
				</td>
				<td>${user.phoneNumber}</td>
			</tr>
		</c:forEach>
	</table>

	<a
		href="/community/allVaccineUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>><input
		type="submit" class="pagination" value="下一页" /></a>

	<a
		href="/community/allVaccineUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>><input
		type="submit" class="pagination" value="上一页" /></a>


</body>
</html>
