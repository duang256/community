<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="ExcelUploadServlet.do" method="post" enctype="multipart/form-data">
	选择excel文件<input type="file" name="excel"><br>
	<input type="submit" value="上传excel文件"><br>
</form>
<font>${msg}</font>
</body>
</html>