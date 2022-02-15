<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
		function change(){
            $("#code").attr("src","validateCode.do?"+Math.random());
        }
</script>
<body>
	登录<br>
	<form action="login.do" method="post">
		用户名<input type="text" name="username"> <br>
		密码<input type="password" name="password"> <br>
		<input name="code" type="text" value="验证码" onclick="JavaScript:this.value='' "/><cite><img id="code" src="validateCode.do" onclick="change()"></cite><br>
		<input type="checkbox" name="remember" value="1"/>自动登录    <input type="submit" value="登录">
	</form>
	<span style="color: red">${msg}</span>
</body>
</html>