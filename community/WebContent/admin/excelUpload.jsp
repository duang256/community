<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批量导入</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<div class="nav">用户信息批量导入></div>
	<hr>

	<div class="block">
		<form action="../ExcelUploadServlet.do" method="post" enctype="multipart/form-data">
			<label>请选择需要导入的excel文件：</label>
			<input type="file" style="margin-left:20px; font-size:0.4cm" name="excel"><br>
			<label style="margin-left:210px; padding:10px">${excelMsg}</label><br>
			<input type="submit" style="margin-left:570px; margin-top:20px" value="导入"><br>
			
		</form>
	</div>


</body>
</html>