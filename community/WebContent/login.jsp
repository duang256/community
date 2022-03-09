<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
	function change() {
		$("#code").attr("src", "validateCode.do?" + Math.random());
	}
</script>
<body>

	<div class="table">
		<div class="div-body">
			<div class="panel-login">
				<div class="panel-login-left">
					<!--<p><a href="index.html">登录</a></p>-->
				</div>
				<div class="panel-login-right">
					<!-- 
                         <div class="input-type-login">
                            <p>用户登录</p>
                            <input type="text" placeholder="用户名" class="text-style input">
                            <input type="password" placeholder="密码" class="text-style input">
                            <input type="text" placeholder="验证码" onclick="JavaScript:this.value='' "/  class="text-style input">
                            <cite><img id="code" src="validateCode.do" onclick="change()"></cite><br>
                            <input type="submit" value="登录"  class="button-style input">
							<a href="#" class="a-register">还没有账号，进行注册啦！</a>
							
                         -->

					<div class="input-type-login">
						<p>用户登录</p>
						<form action="login.do" method="post">
							<input type="text" placeholder="用户名" name="username"
								class="text-style input"> <br> <input
								type="password" placeholder="密码" name="password"
								class="text-style input"> <br> <input name="code"
								type="text" placeholder="验证码" value="验证码"
								onclick="JavaScript:this.value='' " class="text-style input" /><cite><img
								id="code" src="validateCode.do" onclick="change()"></cite><br>
							<input type="submit" value="登录" class="button-style input">
							<br>
						</form>
					</div>
				</div>
			</div>

		</div>
		<div class="panel-other">
			<div class="panel-other-top"></div>
			<div class="panel-other-bottom"></div>
		</div>
	</div>

</body>
</html>