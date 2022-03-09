<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>
</head>
<body>
<form action="updateHomeQuarantime.do" method="post">
	<div class ="block">
	<label for="uid">uid</label><input type="text"  placeholder="请输入uid" name="uid" id="uid"></div>
	<div class="block">
	<label for="status">状态</label><input type="text"  placeholder="请输入隔离状态" name="status" id="status"></div>
	<div class ="block">
	<label for="starttime">居家隔离时间</label><input type="date"  placeholder="请选择居家隔离时间" name="starttime" id="starttime"></div>
	<input type="submit" value="提交">
</form>

</body>
</html>