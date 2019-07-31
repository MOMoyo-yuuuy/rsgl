<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonInfoCheck</title>
</head>
<body>
	<table border="1" cellspacing="0" align="center" id="table">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>position</td>
			<td>major</td>
		</tr>
		<tr>
			<td>${employee.employeeId }</td>
			<td>${employee.employeeName }</td>
			<td>${employee.position }</td>
			<td>${employee.major }</td>
		</tr>
	</table>
</body>
</html>