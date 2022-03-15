<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<title>注册</title>
<link rel="stylesheet" href="css/register.css">
</head>
<body>
	<div style="background-image: linear-gradient(#d7ede2, #014872)">
		<!--头部-->
		<div id="reg_header">
			<h2>欢迎来到社区疫情防控管理系统</h2>
		</div>

		<div class="reg_back">
			<div class="reg_left">
				<p>新用户注册</p>
				<p>USER REGISTER</p>
			</div>

			<div class="reg_center">
				<form action="userRegister.do" method="get">

					<label for="username">用户名：</label> 
					<input type="text" name="username" placeholder="请输入用户名" id="username"> 
					<font id="unameCheck"></font><br>

					<label for="password">密码：</label> 
					<input type="password" name="password" placeholder="请输入密码" id="password"><br>


					<label for="name">姓名：</label> 
					<input type="text" name="name" placeholder="请输入姓名" id="name"><br> 
					
					<label>性别：</label> 
					<input type="radio" name="sex" value="1" checked> 男 &nbsp;
					<input type="radio" name="sex" value="0"> 女<br> 
					
					<label for="identityNumber">身份证号：</label> 
					<input type="text" name="identityNumber" placeholder="请输入您的身份证号" id="identityNumber"><br>

					<label for="phoneNumber">手机号：</label> 
					<input type="text" name="phoneNumber" placeholder="请输入您的手机号" id="phoneNumber"><br>

					<label for="communityname">社区名称：</label> 
					<input type="text" name="communityname" placeholder="请输入社区名称" id="communityname"><br>

					<label for="location">社区地址：</label> 
					<input type="text" name="location" placeholder="请输入社区地址" id="location"><br>

					<label for="unit">楼栋单元：</label> 
					<input type="text" name="unit" placeholder="请输入楼栋单元" id="unit"><br> 
					
					<label for="building">楼栋号：</label> 
					<input type="text" name="building" placeholder="请输入楼栋号" id="building"><br>
					 
					<label for="room">房间号：</label> <input type="text" name="room" placeholder="请输入房间号" id="room"><br> 
						
					<input type="submit" value="注册" id="btn_sub">
					
				</form>
			</div>

			<div class="reg_right">
				<p>
					已有账号?<a href="login.jsp">立即登录</a>
				</p>
			</div>

		</div>
	</div>
</body>
</html>
