<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>隔离管理</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<div class="nav">隔离情况管理></div>
	<hr>
	<ul>
		<li><a class="active" href="/community/homeQuarantineUserPage.do" target="iframe_vaccine">居家隔离</a></li>
		<li><a href="/community/concentrationQuarantineUserPage.do" target="iframe_vaccine">集中隔离</a></li>
	</ul>
	<iframe name="iframe_vaccine" height=600px width=1055px frameborder=0 style="margin-left:10px"
		src="/community/homeQuarantineUserPage.do"></iframe>


	
</body>
</html>