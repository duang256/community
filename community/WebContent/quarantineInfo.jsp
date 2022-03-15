<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#homequarantine {
	border-collapse: collapse;
	width: 1200px;
	margin-left: 20px;
	margin-top: 40px;
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

#concentrationquarantine {
	border-collapse: collapse;
	width: 1200px;
	margin-left: 20px;
	margin-top: 40px;
}

#concentrationquarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}

#concentrationquarantine td {
	text-align: left;
	padding: 8px;
}

#concentrationquarantine th {
	text-align: left;
	padding: 8px;
	background-color: #006566;
	color: white;
}

#concentrationquarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>增加</title>
</head>
<body>
	<div class="nav">隔离情况信息></div>
	<hr>
	<table id="homequarantine" border="0">
			<c:if test="${not empty user.homeQuarantine.homeid}">
				<tr>
					<th>隔离方式</th>
					<th>用户名字</th>
					<th>隔离开始时间</th>
				</tr>
				<tr>
					<td>居家隔离</td>
					<td>${user.name}</td>
					<td>${user.homeQuarantine.starttime}</td>
				</tr>
			</c:if>
	</table>
	
	<table id="concentrationquarantine" border="0">
			<c:if test="${not empty user.concentrationQuarantine.concentrationid}">
				<tr>
					<th>隔离方式</th>
					<th>用户名字</th>
					<th>隔离开始时间</th>
					<th>隔离地址</th>
				</tr>
				<tr>
					<td>集中隔离</td>
					<td>${user.name}</td>
					<td>${user.concentrationQuarantine.starttime}</td>
					<td>${user.concentrationQuarantine.quarantineaddress}</td>
				</tr>
			</c:if>
	</table>
	
</body>
</html>