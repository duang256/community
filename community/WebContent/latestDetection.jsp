<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最后一次核酸信息</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<div class="nav">核酸检测信息></div>
	<hr>
	<div class="block">
		<label>最近一次提交核酸检测结果时间：</label>
		<input type="datetime-local" value="${date}" readonly><br>
		<form action="latestDetection.do" method="post">
			<label>更新最近一次核酸检测时间：
			</label>
			<input type="datetime-local" name="latestDetection">
			<input type="submit" style="margin-left:20px; margin-top:20px;" value="更新">
		</form>
	</div>
</body>
</html>