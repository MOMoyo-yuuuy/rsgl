<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Tooplate">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>教师 </title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/j-forms.css">
  </head>
  <body>
    <div class="logo">
            <a href="/rsgl/infocheck">返回主页</a>
        </div>
    <h1>个人信息</h1>
    <br>
    <br>
    <br>
        <div class="main w3l">
            <form class="contact-forms wthree">
                    <div class="first-line agileits">
                        <div class="span6 main-row">
                            <div class="input">
                                <p style="color:white">姓名</p>
                                <input type="text" id="name" name="employeeName" Placeholder="name" required="">
                            </div>
                        </div>
                        <div class="span6 main-row">
                            <div class="input">
                                <p style="color:white">性别</p>
                                <input type="text" id="sex" name="gender" Placeholder="sex" required="">
                                
                            </div>
                        </div>
                    </div>
                    <!-- end name -->

                    <!-- start email phone -->
                    <div class="first-line agileits">
                        <div class="span6 main-row">
                            <div class="input">
                                <p style="color:white">邮箱</p>
                                <input type="email" placeholder="Email" id="email" name="mail" required="">
                            </div>
                        </div>
                        <div class="span6 main-row">
                            <div class="input">
                                <p style="color:white">电话</p>
                                <input type="text" placeholder="Phone" id="phone" name="telephoneNumber" required="">
                            </div>
                        </div>
                    </div>
                

                    <!-- start address -->
                    <div class="main-row">
                        <div class="input">
                            <p style="color:white">住址</p>
                            <input type="text" id="address" placeholder="Address" name="location" required="">
                        </div>
                    </div>
                    

                <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    <button type="reset" class="secondary-btn">Reset</button>
                </div>
            </form>
        </div>
    </body>
</html>