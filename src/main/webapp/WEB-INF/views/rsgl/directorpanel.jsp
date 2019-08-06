<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>人事管理</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Tooplate">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700"
	rel="stylesheet">

<link href="director/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<link rel="stylesheet" href="director/assets/css/tooplate-main.css">

</head>
<body>
	<div class="logo">
		<h1>年级主任</h1>
		<h2>年级主任</h2>
	</div>

	<nav>
		<ul>
			<li><a href="#1"><img src="director/assets/images/user.png"
					alt=""> <em>个人信息</em></a></li>
			<li><a href="#2"><img src="director/assets/images/lizhi.png"
					alt=""> <em>申请离职</em></a></li>
			<li><a href="#3"><img src="director/assets/images/cong.png"
					alt=""> <em>课程调配</em></a></li>
			<li><a href="#4"><img
					src="director/assets/images/shenhe.png" alt=""> <em>教师审批</em></a></li>
			<li><a href="#5"><img
					src="director/assets/images/password.png" alt=""> <em>密码修改</em></a></li>
		</ul>
	</nav>

	<div class="slides">
		<div class="slide" id="1">

			<form id="contact">
				<div class="row">
					<div class="col-md-12">
						<h2>个人信息</h2>
					</div>
					<div class="col-md-1">
						<h6>名字：</h6>
					</div>
					<div class="col-md-2">

						<input name="name" type="text" class="form-control" id="name"
							value="${sessionScope.employee.employeeId }" required="">

					</div>
					<div class="col-md-1">
						<h6>性别：</h6>
					</div>
					<div class="col-md-1">

						<input type="text" id="city" placeholder="gender" name="gender"
							value="${sessionScope.employee.gender }" required="">


					</div>

					<div class="col-md-1">
						<h6>邮箱：</h6>
					</div>
					<div class="col-md-6">

						<input type="email" placeholder="Email" id="email" name="mail"
							value="${sessionScope.employee.mail }" required="">

					</div>


					<div class="col-md-1">
						<h6>电话：</h6>
					</div>
					<div class="col-md-3">

						<input type="text" placeholder="Phone" id="phone" name="phone"
							value="${sessionScope.employee.telephoneNumber }" required="">

					</div>

					<div class="col-md-1">
						<h5>入职日期：</h5>
					</div>
					<div class="col-md-3">

						<input name="date" type="date" class="form-control" id="date"
							value="${sessionScope.employee.entryTime }" required="">

					</div>

					<div class="col-md-1">
						<h6>地址：</h6>
					</div>
					<div class="col-md-11">

						<input type="text" id="address" placeholder="Address"
							name="address" value="${sessionScope.employee.location }"
							required="">

					</div>
			</form>
		</div>
	</div>
	<div class="slide" id="2">

		<form id="contact" action="/rsgl/directorcheck" method="post">
			<div class="row">
				<div class="col-md-12">
					<h2>申请离职</h2>
				</div>
				<div class="col-md-1">
					<h6>名字：</h6>
				</div>
				<div class="col-md-2">

					<input name="employeeName" type="text" class="form-control"
						id="name" required="">

				</div>



				<div class="col-md-1">
					<h6>本人ID</h6>
				</div>
				<div class="col-md-11">

					<input type="text" name="employeeId" class="form-control"
						id="address" value="">

				</div>

				<div class="col-md-12">

					<button type="submit" id="form-submit" class="button">提交</button>

				</div>
		</form>
	</div>
	</div>

	<div class="slide" id="3">
		<div class="show_content">
			<ul class="topnav">
				<li><a id="1" href="#">一班</a></li>
				<li><a id="2" href="#">二班</a></li>
				<li><a id="3" href="#">三班</a></li>
				<li><a id="4" href="#">四班</a></li>
			</ul>
			<div
				class="arrange_class tm-bg-primary-dark tm-block tm-block-taller ">
				<table class="course_1">
					<thead>
						<tr>
							<th scope="col"><h6>课程名</h6></th>
							<th scope="col"><h6>是否空缺</h6></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><h5>语文</h5></td>

							<td><c:if test="${requestScope.check[0]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[0]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>数学</h5></td>
							<td><c:if test="${requestScope.check[1]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[1]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>英语</h5></td>
							<td><c:if test="${requestScope.check[2]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[2]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>体育</h5></td>
							<td><c:if test="${requestScope.check[3]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[3]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>编程</h5></td>
							<td><c:if test="${requestScope.check[4]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[4]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
					</tbody>
				</table>
				<table class="course_2">
					<thead>
						<tr>
							<th scope="col"><h6>课程名</h6></th>
							<th scope="col"><h6>是否空缺</h6></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><h5>语文</h5></td>
							<td><c:if test="${requestScope.check[5]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[5]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>数学</h5></td>
							<td><c:if test="${requestScope.check[6]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[6]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>英语</h5></td>
							<td><c:if test="${requestScope.check[7]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[7]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>体育</h5></td>
							<td><c:if test="${requestScope.check[8]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[8]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>编程</h5></td>
							<td><c:if test="${requestScope.check[9]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[9]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
					</tbody>
				</table>
				<table class="course_3">
					<thead>
						<tr>
							<th scope="col"><h6>课程名</h6></th>
							<th scope="col"><h6>是否空缺</h6></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><h5>语文</h5></td>
							<td><c:if test="${requestScope.check[10]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[10]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>数学</h5></td>
							<td><c:if test="${requestScope.check[11]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[11]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>英语</h5></td>
							<td><c:if test="${requestScope.check[12]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[12]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>体育</h5></td>
							<td><c:if test="${requestScope.check[13]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[13]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
						<tr>
							<td><h5>编程</h5></td>
							<td><c:if test="${requestScope.check[14]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[14]==0 }">
                        	空缺
                        	</c:if></td>

						</tr>
					</tbody>
				</table>
				<table class="course_4">
					<thead>
						<tr>
							<th scope="col"><h6>课程名</h6></th>
							<th scope="col"><h6>是否空缺</h6></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><h5>语文</h5></td>
							<td><c:if test="${requestScope.check[15]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[15]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>数学</h5></td>
							<td><c:if test="${requestScope.check[16]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[16]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>英语</h5></td>
							<td><c:if test="${requestScope.check[17]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[17]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>体育</h5></td>
							<td><c:if test="${requestScope.check[18]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[18]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
						<tr>
							<td><h5>编程</h5></td>
							<td><c:if test="${requestScope.check[19]==1}">
                        	行课
                        	</c:if> <c:if test="${requestScope.check[19]==0 }">
                        	空缺
                        	</c:if></td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>


	</div>

	<div class="slide" id="4">
		<div
			class="listpage tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
			<h2 class="tm-block-title">教师审批</h2>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">单号</th>
						<th scope="col">审核状态</th>
						<th scope="col">新专业</th>
						<th scope="col">旧专业</th>
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				
						<c:forEach items="${ requestScope.majorChages }" var="a">
							<tr>
								<th scope="row"><b>${a.number }</b></th>
								<td>待审核</td>
								<td><b>${a.oldMajor }</b></td>
								<td><b>${a.newMajor }</b></td>

								<td><a
									href="/rsgl/directorcheck?number=${a.number}&_method=delete&judge=1"
									class="change">同意</a></td>
								<td><a
									href="/rsgl/directorcheck?number=${a.number }&_method=delete&judge=0"
									class="change">拒绝</a></td>

							</tr>
						</c:forEach>
					

				</tbody>
			</table>

		</div>
	</div>

	<div class="slide" id="5">
		<form id="contact" action="/rsgl/directorcheck" method="put">
			<div class="row">
				<div class="col-md-12">
					<h2>修改密码</h2>
				</div>
				<div class="col-md-2">
					<h5>旧密码：</h5>
				</div>
				<div class="col-md-10">

					<input name="oldpassword" type="text" class="form-control"
						required="">

				</div>
				<div class="col-md-2">
					<h5>新密码：</h5>
				</div>
				<div class="col-md-10">

					<input name="newPassword" type="text" class="form-control"
						required="">

				</div>
				<div class="col-md-2">
					<h5>确认新密码：</h5>
				</div>
				<div class="col-md-10">

					<input name="oldpassword" type="text" class="form-control"
						required="">

				</div>
				<div class="col-md-12">

					<button type="submit" id="form-submit" class="button">修改</button>

				</div>
		</form>
	</div>
	</div>
	<script src="director/vendor/jquery/jquery.min.js"></script>
	<script src="director/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="director/assets/js/main.js"></script>
</body>

</html>