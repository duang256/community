<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加公告</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<form action="../addAnnouncement.do" method="post">
		<div class="block">
			<label>标题：</label><input type="text" name="title"><br> 
			<label>发表时间：</label><input id="announcetime" type="datetime-local" name="announcetime"><br> 
			<label style="vertical-align: top">内容：</label> 
			
			<textarea style="width: 400px; height: 250px; margin-top: 18px; margin-left: 0.08cm;" name="content"></textarea><br>
			<input type="submit" style="margin-left: 753px; margin-top: 20px;" value="发布">
		</div>
	</form>
</body>
</html>