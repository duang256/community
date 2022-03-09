<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社区疫情防控管理系统</title>
<link rel="stylesheet" href="css/style.css" />
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<body>
	<div class="container">
		<div class="header">
			<span style="margin-top: 10px; margin-left: 20px; float: left;">社区疫情防控管理系统后台</span>
			<a class="welcome" href="">${admin.username} |</a>

		</div>

		<div class="main">
			<div class="left">
				<div class="menu_box">
					<div class="menu_title">
						<img src="../images/todayEpidemic.png"><span>今日疫情</span>
					</div>
				</div>
				<div class="tab">
					<a class="tab_content" href="../todayEpidemic.do" target="context">今日疫情</a>
				</div>
				<div class="menu_box">
					<div class="menu_title">
						<img src="../images/announcement.png"><span>公告</span>
					</div>
				</div>
				<div class="tab">
					<a class="tab_content" href="../selectAllAnnouncement.do" target="context">查看公告</a> 
					<a class="tab_content" href="addAnnounce.jsp" target="context">发布公告</a>
				</div>

				<div class="menu_box">
					<div class="menu_title">
						<img src="../images/personal.png"><span>用户管理</span>
					</div>
				</div>
				<div class="tab">
					<a class="tab_content" href="../allUserPage.do" target="context">住户信息</a>
					<a class="tab_content" href="../vaccineUserPage.do" target="context">疫苗接种信息</a>
					<a class="tab_content" href="/community/excelUpload.jsp" target="context">excel表导入</a>
				</div>
			</div>

			<div class="right">
				<iframe name="context" height=720px width=1200px frameborder=0 src="../todayEpidemic.do"></iframe>
			</div>
		</div>



	</div>
</body>
</html>