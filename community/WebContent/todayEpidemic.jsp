<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>今日疫情</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="nav">今日疫情></div>
	<hr>
	<table id="todayEpidemic" border="1">
		<tr>
			<th>疑似</th>
			<th>密接</th>
			<th>确诊</th>
		</tr>
		<c:forEach items="${requestScope.todayEpidemic}" var="todayEpidemic">
			<td>${todayEpidemic}</td>
		</c:forEach>
	</table>

</body>
</html>