<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<body>
${user.username} 欢迎回来
<a href="http://localhost:9090/community/logout.do">退出登录</a>
<form action="" method="post">
    <%--隐藏用户的id--%>
    <input type="hidden" name="id" value="${user.userid}">

	    ${user.username}<br>
	    ${user.password}<br>
	    ${user.name}<br>
	    ${user.sex}<br>
	    ${user.identityNumber}<br>
	    ${user.phoneNumber}<br>
	    ${user.communityInfo.communityname}<br>
	    ${user.communityInfo.location}<br>
	    ${user.household.unit}<br>
	    ${user.household.buliding}<br>
	    ${user.household.room}<br>
	   <a href="http://localhost:8080/community/todayEpidemic.do">今日疫情</a>
	    
</form>
</body>
</html>