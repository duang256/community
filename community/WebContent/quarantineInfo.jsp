<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>
</head>
<body>
<table border="1" >
   		<tr>
   			<th>居家隔离id</th>
   			<th>集中隔离id</th>
   		</tr>
   		
   		<c:forEach items="${pi.list}" var="user">
   			<tr>
   				<td>${user.homeQuarantime.homeid}</td>
   				<td>${user.concentrationQuarantine.concentrationid}</td>
   			</tr>
   		</c:forEach>
   	
   	</table>
</body>
</html>