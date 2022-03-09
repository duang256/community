<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体温打卡</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="nav">体温打卡></div>
	<hr>
	<!-- 提交体温 -->
	<form action="clockInTemperature.do" method="post">
		<div class="block">
			<label style="width:80px">今日体温:</label> 
			<input type="text" placeholder="请输入今日体温" name="temperature">
			<label style="width:80px">日期:</label> 
			<input type="date" placeholder="请选择今日日期" name="date">
			<input type="submit" style="margin-left:30px" value="提交" />
		</div>
	</form>
	
	<!-- 体温信息显示 -->
	<table id="temperature_table" border="0">
		<tr>
			<th>姓名&emsp;&emsp;&emsp;</th>
			<th>时间&emsp;&emsp;&emsp;</th>
			<th>体温&emsp;&emsp;&emsp;</th>
		</tr>
		<c:forEach items="${user.temperatureList}" var="tem">
			<tr>
				<td>${user.name}</td>
				<td><fmt:formatDate value="${tem.date}" pattern="yyyy-MM-dd"/></td>
				<td>${tem.temperature}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>