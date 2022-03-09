<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户隔离情况</title>
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
   	<a href="allUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}" <c:if test="${pi.pageNumber<= 1}">         onclick="javascript:return false;"          </c:if>>上一页</a>
   	<a href="allUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}" <c:if test="${pi.pageNumber>= pi.total}">  onclick="javascript:return false;"          </c:if>>下一页</a>
</body>
</html>
