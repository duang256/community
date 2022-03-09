<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="nav">查看公告></div>
	<hr>
	<div class="container_announcement">
		<c:forEach items="${announcement}" var="announce">
			<table id="announcement" border="1">
				<tr>
					<th>标题：${announce.title}</th>
					<th>发布时间：${announce.announcetime}</th>
				</tr>
				<tr>
					<td colspan="2">内容：${announce.content}</td>
				</tr>
			</table>
			<br>
		</c:forEach>
	</div>
</body>
</html>