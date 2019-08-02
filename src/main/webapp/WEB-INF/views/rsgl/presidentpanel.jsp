<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>人事管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"
	maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="Tooplate">
<link href="president/assets/css/style2.css" rel='stylesheet'
	type='text/css' media="all">
<link href="president/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="president/assets/css/tooplate-main.css">
<link rel="stylesheet" href="president/assets/css/j-forms.css">
<link href="president/assets/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet" href="president/assets/css/templatemo-style.css">

</head>
<body>

	<div class="logo">
		<h2>校长</h2>
	</div>

	<nav>
		<ul>
			<li><a href="#1"><img src="president/assets/images/user.png"
					alt=""> <em>个人信息</em></a></li>
			<li><a href="#2"><img src="president/assets/images/cong.png"
					alt=""> <em>查询</em></a></li>
			<li><a href="#3"><img
					src="president/assets/images/shenhe.png" alt=""> <em>审批</em></a></li>
			<li><a href="#4"><img
					src="president/assets/images/lizhi.png" alt=""> <em>总人事信息</em></a></li>
			<li><a href="#5"><img
					src="president/assets/images/password.png" alt=""> <em>密码修改</em></a></li>
		</ul>
	</nav>
	<div class="slides">
		<div class="slide" id="1">
			<div class="content">

				<div class="main w3l">
					<div class="im-g">
						<img src="president/images/img1.jpg" alt="">
					</div>
					<form class="contact-forms wthree">
						<h1>information</h1>

						<div class="first-line agileits">
							<div class="span8 main-row">
								<div class="input">

									<input type="text" id="first_name" name="employeeName"
										placeholder="First name"
										value="${requestScope.employee.employeeId }" required="">
								</div>
							</div>

						</div>

						<div class="first-line agileits">
							<div class="span6 main-row">
								<div class="input">

									<input type="email" placeholder="Email" id="email" name="mail"
										value="${requestScope.employee.mail }" required="">
								</div>
							</div>
							<div class="span6 main-row">
								<div class="input">

									<input type="text" placeholder="Phone" id="phone" name="phone"
										value="${requestScope.employee.telephoneNumber }" required="">
								</div>
							</div>
						</div>

						<div class="first-line agileits">
							<div class="span8 main-row">
								<div class="input">

									<input type="text" id="city" placeholder="gender" name="gender"
										value="${requestScope.employee.gender }" required="">
								</div>
							</div>

						</div>

						<div class="first-line agileits">
							<div class="span8 main-row">
								<div class="input">

									<input type="text" id="city" placeholder="salary" name="salary"
										value="${requestScope.employee.salary }" required="">
								</div>
							</div>

						</div>

						<div class="main-row">
							<div class="input">

								<input type="text" id="address" placeholder="Address"
									name="address" value="${requestScope.employee.location }"
									required="">
							</div>
						</div>

						<div class="footer">
							<button type="submit" class="primary-btn">Send</button>
							<button type="reset" class="secondary-btn">Reset</button>
						</div>

					</form>
				</div>
			</div>
		</div>



		<div class="slide" id="2">

			<h1 class="header-w3ls">quiry form</h1>
			<div class="appointment-w3">
				<form action="#" method="post">

					<div class="login-w3ls">
						<div class="icons-agile">

							<input type="text" name="employeeId" placeholder="Name">

							<div class="clear"></div>
						</div>
						<div class="icons-agile ">

							<input type="text" name="mail" placeholder="id" required="">

							<div class="clear"></div>
						</div>
						<div class="icons-agile">

							<input type="text" name="position" placeholder="position">


						</div>
						<div class="clear"></div>
						<div class="file-upload"></div>
						<div class="btnn">
							<input type="submit" value="Submit">
						</div>
					</div>
				</form>
			</div>
		</div>




		<div class="slide" id="3">


			<div class="col-12 tm-block-col">

				<table class="table"
					style="background-color: rgba(0, 0, 0, 0.45); height: 80%">

					<thead>
						<tr>
							<th scope="col">单号</th>
							<th scope="col">员工ID</th>
							<th scope="col">员工姓名</th>
							<th scope="col">旧职位</th>
							<th scope="col">新职位</th>
							<th scope="col"></th>
							<th scope="col"></th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${ requestScope.positionChages }" var="a">
							<tr>
								<th scope="row"><b>${a.number }</b></th>
								<td>${a.employeeId }</td>
								<td><b>${a.employeeName }</b></td>
								<td><b>${a.oldMajor }</b></td>
								<td><b>${a.newMajor }</b></td>
								<td><button class="button_agree">同意</button></td>
								<td><button class="button_disagree">拒绝</button></td>

							</tr>
						</c:forEach>


					</tbody>

				</table>
			</div>

		</div>

		<div class="slide" id="4">

			<div class="col-12 tm-block-col">

				<table class="table ">
					<thead>
						<tr>
							<th scope="col">员工ID</th>
							<th scope="col">员工姓名</th>
							<th scope="col">性别</th>
							<th scope="col">职位</th>
							<th scope="col">专业</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.employees }" var="b">
							<tr>
								<th scope="row"><b>${b.employeeId}</b></th>
								<td>
									<div class="tm-status-circle moving"></div>${b.employeeName }
								</td>
								<td><b>${b.gender}</b></td>
								<td><b>${b.position }</b></td>
								<td><b>${b.major }</b></td>


							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<div class="slide" id="5">
			<form id="contact" action="/rsgl/presidentinfo" method="post">
				<div class="row">
					<div class="col-md-12">
						<h2>修改密码</h2>
					</div>
					<div class="col-md-2" style="color: white">
						<h5>旧密码：</h5>
					</div>
					<div class="col-md-10" style="width: 30px">
						<input type="hidden" name="_method" value="PUT" /> 
						<input
							name="oldPassword" type="text" class="form-control" required="">

					</div>
					<div class="col-md-2" style="color: white">
						<h5>新密码：</h5>
					</div>
					<div class="col-md-10">

						<input name="newPassword" type="text" class="form-control"
							required="">

					</div>
					<div class="col-md-2" style="color: white">
						<h5>确认新密码：</h5>
					</div>
					<div class="col-md-10">

						<input name="neewpassword" type="text" class="form-control"
							required="">

					</div>
					<div class="col-md-12">

						<button type="submit" id="form-submit" class="button">修改</button>

					</div>
				</div>

			</form>
		</div>











	</div>





</body>
</html>