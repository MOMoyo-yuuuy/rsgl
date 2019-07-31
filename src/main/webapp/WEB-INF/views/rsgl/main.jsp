<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/rsgl/login" method="POST">>
		EmployeeID:<input type="text" name="employeeId" value="enter your id" /><br/>
		Password:<input type="text" name="password" value="enter your password"/><br/>
		<input type="submit" value="登陆"/>
	</form>
	<div>
		<a href="/rsgl/registerE">注册</a>
	</div>
</body>
</html>