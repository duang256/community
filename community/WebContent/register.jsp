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
<script type="text/javascript">

function unameCheck(){
	var unameCheck = document.getElementById("unameCheck");
	unameCheck.innerHTML = "账号有误！";
	
}

</script>
<div style="background-image:linear-gradient(#d7ede2,#014872)">
	<!--头部-->
	<div id="reg_header">
		<div class="reg_h_center">
			<div class="reg_h_left">
				<h2>欢迎来到社区疫情防控管理系统</h2>
			</div>
		</div>
	</div>
	
	<div class="reg_back">
		<div class="reg_left">
			<p>新用户注册</p>
			<p>USER REGISTER</p>
		</div>
		<div class="reg_center">
			<div class="reg_form">
				<form action="userRegister.do" method="get">
					<table>
						<tr>
							<td class="td_left"><label for="username">用户名</label></td>  
							<td class="td_right"><input type="text" name="username"
								placeholder="请输入用户名" id="username" onblur="unameCheck()">  <font id = "unameCheck"></font> </td>
						</tr>
						<tr>
							<td class="td_left"><label for="password">密码</label></td>
							<td class="td_right"><input type="password" name="password"
								placeholder="请输入密码" id="password"></td>
						</tr>				
						<tr>
							<td class="td_left"><label for="name">姓名</label></td>
							<td class="td_right"><input type="text" name="name"
								placeholder="请输入姓名" id="name"></td>
						</tr>
						<tr>
							<td class="td_left"><label>性别</label></td>
							<td class="td_right"><input type="radio" name="sex"
								value="1" checked> 男 <input type="radio"
								name="sex" value="0"> 女</td>
						</tr>
						<tr>
							<td class="td_left"><label for="identityNumber">身份证号</label></td>
							<td class="td_right"><input type="text"
								name="identityNumber" placeholder="请输入您的身份证号"
								id="identityNumber"></td>
						</tr>


						<tr>
							<td class="td_left"><label for="phoneNumber">手机号</label></td>
							<td class="td_right"><input type="text" name="phoneNumber"
								placeholder="请输入您的手机号" id="phoneNumber"></td>
						</tr>

						<tr>
							<td class="td_left"><label for="communityname">社区名称</label></td>
							<td class="td_right"><input type="text" name="communityname"
								placeholder="请输入社区名称" id="communityname"></td>
						</tr>


						<tr>
							<td class="td_left"><label for="location">社区地址</label></td>
							<td class="td_right"><input type="text" name="location"
								placeholder="请输入社区地址" id="location"></td>
						</tr>


						<tr>
							<td class="td_left"><label for="unit">楼栋单元</label></td>
							<td class="td_right"><input type="text" name="unit"
								placeholder="请输入楼栋单元" id="unit"></td>
						</tr>


						<tr>
							<td class="td_left"><label for="building">楼栋号</label></td>
							<td class="td_right"><input type="text" name="building"
								placeholder="请输入楼栋号" id="building"></td>
						</tr>

						<tr>
							<td class="td_left"><label for="room">房间号</label></td>
							<td class="td_right"><input type="text" name="room"
								placeholder="请输入房间号" id="room"></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="注册" id="btn_sub"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="reg_right">
			<p>
				已有账号?<a href="login.html">立即登录</a>
			</p>
		</div>
	</div>
	</div>
</body>
</html>
