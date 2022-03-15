<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>
<link rel="stylesheet" href="./admin/css/style.css" />
</head>
<body>
	<form action="/community/updateHomeQuarantine.do" method="post">
		<div class="nav">全部住户信息></div>
		<hr>

		<div class="block">
			<input type="hidden" name="id" value="${id}"><br>

			<label for="status">状态</label> 
			<select name="status">
				<option value="疑似">疑似</option>
			</select> 


			<label for="starttime">居家隔离时间</label>
			<input type="date" placeholder="请选择居家隔离时间" name="starttime" id="starttime"> 
			<input type="submit" value="提交">
		</div>
	</form>

</body>
</html>