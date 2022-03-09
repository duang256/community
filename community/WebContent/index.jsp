<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社区疫情防控管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<body>
<div class="container">

	<div class="header">
		<span style="margin-top: 10px;margin-left:20px; float: left; ">社区疫情防控管理系统</span>
		<a class="welcome" href="userInfo.jsp" target="context">${user.username} |</a>
		<a class="logout" href="logout.do">退出登录</a>
	</div>
	
	<div class="main">
		<div class="left">
			<div class="menu_box">
				<div class="menu_title">
					<img src="images/todayEpidemic.png"><span>今日疫情</span>
				</div>
			</div>
			<div class="tab">
				<a class="tab_content" href="todayEpidemic.do" target="context">今日疫情</a>
			</div>
			<div class="menu_box">
				<div class="menu_title">
					<img src="images/announcement.png"><span>公告</span>
				</div>
			</div>
			<div class="tab">
				<a class="tab_content" href="selectAllAnnouncement.do" target="context">查看公告</a>
			</div>

			<div class="menu_box">
				<div class="menu_title">
					<img src="images/personal.png"><span>个人管理</span>
				</div>
			</div>
			<div class="tab">
				<a class="tab_content" href="updateUserInfo.jsp" target="context">修改个人信息</a>
				<a class="tab_content" href="addTemperature.jsp" target="context">体温打卡</a>
				<a class="tab_content" href="dateToString.do" target="context">核酸检测情况</a>
				<a class="tab_content" href="updateVaccine.jsp" target="context">疫苗接种情况</a>
				<a class="tab_content" href="quarantineInfo.jsp" target="context">隔离情况</a>
			</div>
		</div>
	
		<div class="right">
			<iframe name="context" height=720px width=1200px frameborder=0 src="todayEpidemic.do"></iframe>
		</div>
	</div>
</div>

</body>
</html>