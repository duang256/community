<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<body>
	<div class="nav">个人信息></div>
	<hr>
	<div class="block">
		<label>用户名：</label>${user.username}<br>
		<label>姓名：</label>${user.name}<br>
		<label>性别:</label>
		<c:if test="${user.sex==1}" var="sex">
			<input type="radio" name="sex" value="1" checked/>男
			<input type="radio" disabled/>女
		</c:if>
		<c:if test="${user.sex==0}" var="sex">
			<input type="radio" disabled/>男
			<input type="radio" name="sex" value="0" checked/>女
		</c:if>
		<br>
		<label>身份证号：</label>${user.identityNumber}<br>
		<label>手机号：</label> ${user.phoneNumber}<br>
		<label>所在社区：</label>${user.communityInfo.communityname}<br>
		<label>社区地址：</label>${user.communityInfo.location}<br>
		<label>具体住址：</label>${user.household.unit}单元 ${user.household.buliding}栋${user.household.room}<br>
	</div>
</body>
</html>