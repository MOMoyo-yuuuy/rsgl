<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Tooplate">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700"
	rel="stylesheet">

<title>教师</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- Additional CSS Files -->
<link rel="stylesheet" href="assets/css/main.css">
s
<style type="text/css">
body {
	background: url(assets/images/5.jpg) no-repeat center center fixed;
	background-size: cover;
	height: 100%;
}

form#apply {
	margin-top: 200px;
	margin-left: 38%;
	text-align: center;
	background: rgba(0, 0, 0, 0.65);
	-webkit-border-radius: 5px;
	border-radius: 5px;
	padding: 20px;
	width: 400px;
	height: 300px;
}

form#apply legend {
	margin-left: 43%;
	color: #fff;
	font-size: 25px;
	font-weight: bold;
	padding-bottom: 10px;
	text-shadow: 0 1px 1px #c0d576;
}

form#apply ol li {
	background: #b9cf6a;
	background: rgba(255, 255, 255, .3);
	border-color: #e3ebc3;
	border-color: rgba(255, 255, 255, .6);
	border-style: solid;
	border-width: 2px;
	-webkit-border-radius: 5px;
	line-height: 50px;
	list-style: none;
	padding: 5px 10px;
	margin-bottom: 50px;
}

form#apply ol ol li {
	background: none;
	border: none;
	float: left;
}

form#apply label {
	float: left;
	font-size: 13px;
	width: 110px;
	color: #fff;
}

form#apply input:not ([type=radio] ), form#apply textarea {
	background: #ffffff;
	border: #FC3 solid 1px;
	-webkit-border-radius: 3px;
	font: italic 13px Georgia, "Times New Roman", Times, serif;
	outline: none;
	padding: 5px;
	width: 200px;
}

form#apply input:not ([type=submit] ):focus, form#apply textarea:focus {
	background: #eaeaea;
	border: #F00 solid 1px;
}

form#apply input[type=radio] {
	float: left;
	margin-right: 5px;
}
</style>
</head>
<body>
	<div class="logo">
		<a href="/rsgl/infocheck">返回主页</a>
	</div>
	<div class="result">
		<h1>申请</h1>
	</div>
	<table id="mytable1" cellspacing="0" summary="teacher">
		<caption></caption>
		<tr>
			<th scope="row" abbr="name" class="spec">申请人ID</th>
			<td>${sessionScope.employeeId }</td>
		</tr>
		<tr>
			<th scope="row" abbr="result" class="specalt">申请结果</th>
			<td class="alt">${sessionScope.result }</td>
		</tr>
	</table>
</body>
</html>