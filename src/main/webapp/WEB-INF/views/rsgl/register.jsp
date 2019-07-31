<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<form action="/rsgl/register" method="POST">>
		EmployeeID:<input type="text" name="employeeId" value="enter your id" /><br/>
		EmployeeName:<input type="text" name="employeeName" value="enter your name"/><br/>
		Password:<input type="text" name="password" value="enter your password"/><br/>
		Major:<input type="text" name="major" value="enter your major"/><br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>