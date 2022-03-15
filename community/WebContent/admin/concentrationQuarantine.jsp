<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>隔离管理</title>
<link rel="stylesheet" href="./css/style.css" />
<style type="text/css">
/* 集中隔离情况 */
#concentrationquarantine {
	border-collapse: collapse;
	width: 1180px;
	margin-left: 20px;
	margin-top: 20px;
}

#concentrationquarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}

#concentrationquarantine td {
	text-align: left;
	padding: 8px;
}

#concentrationquarantine th {
	text-align: left;
	padding: 8px;
	background-color: #006566;
	color: white;
}

#concentrationquarantine tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>


	<table id="concentrationquarantine" border="0">
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th>集中隔离房间号</th>
			<th>隔离开始时间</th>
			<th>隔离地址</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${concentrationPi.list}" var="user">
			<c:if
				test="${not empty user.concentrationQuarantine.concentrationid}">
				<tr>
					<td>${user.username}</td>
					<td>${user.name}</td>
					<td>${user.concentrationQuarantine.concentrationid}</td>
					<td>${user.concentrationQuarantine.starttime}</td>
					<td>${user.concentrationQuarantine.quarantineaddress}</td>
					<td>
						<form action="/community/deleteConcentrationQuarantine.do"
							method="post">
							<input type="hidden" name="uid" value="${user.getUserid()}">
							<input type="hidden" name="concentrationid"
								value="${user.concentrationQuarantine.concentrationid}">
							<input type="submit" value="删除" />
						</form>
					</td>
					<td>
						<form action="/community/updateConcentrationQuarantine.do"
							method="post">
							<input type="submit" value="更新" />
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<br>

	<a
		href="/community/concentrationQuarantineUserPage.do?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber<= 1}"> onclick="javascript:return false;" </c:if>><input
		type="submit" class="pagination" value="上一页" /></a>
	<a
		href="/community/concentrationQuarantineUserPage.do?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize}"
		<c:if test="${pi.pageNumber>= pi.total}"> onclick="javascript:return false;" </c:if>><input
		type="submit" class="pagination" value="下一页" /></a>

</body>
</html>