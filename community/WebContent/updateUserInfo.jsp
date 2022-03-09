<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="nav">修改个人信息></div>
	<hr>
	
	<form action="updateUser.do" method="post">
		<div class="block">
			<label>用户名：</label><input type="text" name="username" value="${user.username}"><br>
			<label>密码：</label><input type="text" name="password" value="${user.password}"><br>
			<label>姓名：</label><input type="text"name="name" value="${user.name}"><br>
			<label>性别：</label>
			<input type="radio" name="sex" value="1"
			<c:choose><c:when test="${user.sex==1}"> checked </c:when> </c:choose> />男&emsp;
			<input type="radio" name="sex" value="0"
			<c:choose><c:when test="${user.sex==0}"> checked </c:when> </c:choose> />女&emsp;
			<br>
			<label>身份证号：</label><input type="text" name="identityNumber" value="${user.identityNumber}"><br>
			<label>手机号：</label><input type="text" name="phoneNumber" value="${user.phoneNumber}"><br>
			<input type="submit" style="margin-left:553px; margin-top:20px;" value="保存">
		</div>
	</form>


</body>
</html>