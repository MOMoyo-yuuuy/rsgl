<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>人事管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Tooplate">
	<link href="president/assets/css/style2.css" rel='stylesheet' type='text/css' media="all">
    <link href="president/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="president/assets/css/tooplate-main.css">
    <link rel="stylesheet" href="president/assets/css/j-forms.css">
    <link href="president/assets/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="president/assets/css/templatemo-style.css">
    
</head>
<body style="background: url(president/assets/images/contact-bg2.jpg)">

		 


          		
<div class="col-12 tm-block-col">
                   
                        <table class="table " style="margin:auto;margin-top:100px" >
                            <thead>
                                <tr>
                                    <th scope="col">员工ID</th>
                                    <th scope="col">员工姓名</th>
                                    <th scope="col">性别</th>
                                    <th scope="col">职位</th>
                                    <th scope="col">专业</th>
                                    
                                </tr>
                            </thead>
                            <tbody >
                                <tr>
                                    <td>
                                        <div class="tm-status-circle moving">
                                        </div>${requestScope.employee.employeeId }
                                    </td>
                                    <td><b>${requestScope.employee.employeeName }</b></td>
                                    <td><b>${requestScope.employee.gender}</b></td>
                                    <td><b>${requestScope.employee.position }</b></td>
                                    <td><b>${requestScope.employee.major }</b></td>
                                   
                                   
                                </tr>
                            </tbody>
                        </table>
                    </div>
                
            </div>

 







 


</div>


 


</body>
</html>