<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册</title>
		<link rel="stylesheet" href="./css/register.css">
	</head>
	<body>
		<div class="head">
			<img src="" alt="">
		</div>
		<div class="form">
			<h2>
				<span>注册</span>
			</h2>
			
			<form action="userRegister.do" method="get">
			<div class="form-area">
				<!-- 当要出现错误提示时需要配合js，只需加上haserror即可，即：<div class="form-item haserror"> -->
				<div class="form-item">
						用户名&nbsp;&nbsp;&nbsp;<input type="text" name="username" placeholder="长度不超过16个字符，由中文、英文字母大小写或数字组成"><br>
				</div>

				<div class="form-item">
						密码&nbsp;&nbsp;&nbsp;<input type="password" name="password" placeholder="6-16个字符组成，区分大小写"><br>
				</div>

				<div class="form-item">
						姓名&nbsp;&nbsp;&nbsp;<input type="text" name="name" placeholder="长度不超过16位字符"><br>
				</div>

				<div class="form-item">
						性别&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="1">男&nbsp;
						<input type="radio" name="sex" value="0">女<br />
				</div>

				<div class="form-item">
						身份证&nbsp;&nbsp;&nbsp;<input type="text" name="identitynumber" placeholder="18位身份证号"><br>
				</div>

				<div class="form-item">
						手机号&nbsp;&nbsp;&nbsp;<input type="text" name="phonenumber" placeholder="11位手机号"><br>
				</div>
				
				<div class="form-item">
						社区名称&nbsp;&nbsp;&nbsp;<input type="text" name="communityname"><br>
				</div>
				
				<div class="form-item">
						社区地址&nbsp;&nbsp;&nbsp;<input type="text" name="location"><br>
				</div>

				<div class="form-item">
						楼栋单元&nbsp;&nbsp;&nbsp;<input type="text" name="unit"><br>
				</div>

				<div class="form-item">
						楼栋号&nbsp;&nbsp;&nbsp;<input type="text" name="building"><br>
				</div>

				<div class="form-item">
						房间号&nbsp;&nbsp;&nbsp;<input type="text" name="room" placeholder="4位房间号，例如0503为5层03房"><br>
				</div>



				<div class="form-item">
					<input type="submit" value="注册">
<!-- 					<button disabled class="fill">注册</button> -->
				</div>

				<div class="readme txtright">
					<a href="">已有账号，直接登录></a>
				</div>
			</div>

			</form>
			
		</div>
	</body>
</html>
