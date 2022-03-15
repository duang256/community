<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="table">
		<div class="div-body">
			<div class="panel-login">
				<div class="panel-login-left">
				</div>
				<div class="panel-login-right">
					<div class="input-type-login">
						<p>管理员登录</p>
						<form action="../adminLogin.do" method="post">
							<input type="text" placeholder="请输入用户名" name="username" class="text-style input"> <br> 
							<input type="password" placeholder="请输入密码" name="password" class="text-style input"> <br> 
							<input type="submit" value="登录" class="button-style input"> <br>
							<font color = "red">${msg}</font>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="panel-other">
		<div class="panel-other-top"></div>
		<div class="panel-other-bottom"></div>
	</div>

	<span style="color: red">${msg}</span>
</body>
</html>