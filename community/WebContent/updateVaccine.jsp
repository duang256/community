<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改三次疫苗时间</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="nav">疫苗接种情况></div>
	<hr>

	<form action="updateVaccine.do" method="post">
		<div class="block">
			<label style="width:80px">第一针：</label>
			<input type="date" name="firstVaccine">
			<label style="width:80px">第二针：</label>
			<input type="date" name="secondVaccine">
			<label style="width:80px">第三针：</label>
			<input type="date" name="thirdVaccine">
			<input type="submit" style="margin-left:20px" value="提交"/>
		</div>
	</form>

	<table id="vaccine" border="0">
		<tr>
			<th>第一针</th>
			<th>第二针</th>
			<th>第三针</th>
		</tr>
		<c:forEach items="${pi.list}" var="user">
			<tr>
				<td><fmt:formatDate value="${user.firstVaccine}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${user.secondVaccine}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${user.thirdVaccine}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	</table>
	


</body>
</html>