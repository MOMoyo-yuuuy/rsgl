<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <link rel="stylesheet" href="assets/css/main.css?v=1.0">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/j-forms.css">
  </head>
  <body>
  <div class="logo">
            <h1>教师</h1>
        </div>
        <nav>
          <ul>
            <li><a href="#1"><img src="assets/images/icon-1.png" alt=""> <em>个人信息</em></a></li>
            <li><a href="#2"><img src="assets/images/icon-3.png" alt=""> <em>申请职称变动</em></a></li>
            <li><a href="#3"><img src="assets/images/icon-2.png" alt=""> <em>申请离职</em></a></li>
            <li><a href="#4"><img src="assets/images/icon-4.png" alt=""> <em>申请专业修改</em></a></li>
            <li><a href="#5"><img src="assets/images/icon-5.png" alt=""> <em>修改密码</em></a></li>
          </ul>
        </nav>
        
<div class="slides">
    <div class="slide" id="1">
        <h1>个人信息</h1>
        <table id="mytable" cellspacing="0" summary="teacher">
<caption> </caption>
  <tr>
    <th scope="row" abbr="name" class="spec">名字</th>
    <td >${sessionScope.employee.employeeName }</td>
  </tr>
  <tr>
    <th scope="row" abbr="sex" class="specalt">性别</th>
    <td class="alt">${sessionScope.employee.gender }</td>
  </tr>
  <tr>
    <th scope="row" abbr="email" class="spec">邮箱</th>
    <td>${sessionScope.employee.mail }</td>
  </tr>
  <tr>
    <th scope="row" abbr="phone" class="specalt">电话</th>
    <td class="alt">${sessionScope.employee.telephoneNumber }</td>
  </tr>
  <tr>
    <th scope="row" abbr="title" class="spec">职称</th>
    <td >${sessionScope.employee.position }</td>
  </tr>
  <tr>
    <th scope="row" abbr="grade" class="specalt">入职时间</th>
    <td class="alt"><fmt:formatDate value= "${sessionScope.employee.entryTime }" pattern="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <th scope="row" abbr="major" class="spec">专业</th>
    <td >${sessionScope.employee.major }</td>
  </tr>
  <tr>
    <th scope="row" abbr="address" class="specalt">地址</th>
    <td class="alt">${sessionScope.employee.location }</td>
  </tr>
  <tr class="salary">
    <th scope="row" abbr="salary" class="spec">薪水</th>
    <td >${sessionScope.employee.salary}</td>
  </tr>
</table>
  <button class="see" type="button">查看薪水</button>
  <br>
    <a href="/rsgl/infoupdateE" class="change">修改个人信息</a>
    </div>



 <div class="slide" id="2">
    <br>
    <br>
    <br>
  <div class="main w3l">
    <button id= "K" type="instructor" class="see">辅导员</button>
    <form class="contact-forms wthree" action="/rsgl/positionchange" method="post">
     <div class="main-row">
                        <div  class="input" id="J" style="display: none">
                        	<input type="hidden" name="position" value="assistant"/>
                            <p style="color:white">员工ID</p>
                            <input type="text" id="name" placeholder="ID" name="employeeId" required="">
                            <div class="main-row">
                        <div class="input">
                            <p style="color:white">申请原因</p>
                            <br>
                            <a href="#" class="upload"><h6>点击这里上传文件</h6>
                            <input type="file" name="file" ></a>
                        </div>
                    </div>
                        </div>
                    </div>
                     <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    </div>
                </form>
                </div>

       
       <div class="main w3l">
    <button id="P" type="headman" class="see">年级主任</button>
    <form class="contact-forms wthree" action="/rsgl/positionchange" method="post">
     <div class="main-row">
                        <div  class="input"  id="M"  style="display: none">
                        	<input type="hidden" name="position" value="director"/>
                            <p style="color:white">员工ID</p>
                            <input type="text" id="name" placeholder="ID" name="employeeId" required="">
                            <div class="main-row">
                        <div class="input">
                            <p style="color:white">申请原因</p>
                            <br>
                            <a href="#" class="upload"><h6>点击这里上传文件</h6>
                            <input type="file" name="file" ></a>
                        </div>
                    </div>
                        </div>
                    </div>
                     <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    </div>
                </form>
                </div>
                <a href="/rsgl/positionresult" class="change">申请结果</a>

<script type="text/javascript">
    buttonK = document.getElementById("K");
    buttonP = document.getElementById("P");
    divJ = document.getElementById("J");
    divM = document.getElementById("M");
    buttonK.onclick = function(e){
        divJ.style.display="block";
        divM.style.display="none";
    }

    buttonP.onclick = function(e){
        divM.style.display="block";
        divJ.style.display="none";
    }

</script>
    </div>





<div class="slide" id="3">
 <div class="main w3l">
            <form class="contact-forms wthree" action="/rsgl/leave" method="post">
                <!-- end /.header-->
                       
                    <div class="first-line agileits">
                        <div class="span8 main-row">
                            <div class="input">
                                <p style="color:white">员工ID</p>
                                <input type="text" id="name" placeholder="Name" name="employeeId" required="">
                            </div>
                        </div>
                        
                    </div>
                   <div class="main-row">
                     <p style="color:white">职称</p>
                        <label class="input select">
                            <select name="position">
                                <option value="none" selected disabled="">职称</option>
                                <option value="teacher">普通教师</option>
                                <option value="headman"> 年级组长</option>
                                <option value="instructor"> 辅导员</option>
                            </select>
                            <i></i>
                        </label>
                    </div>
                    
                     <div class="main-row">
                        <div class="input">
                            <p style="color:white">离职原因</p>
                            <br>
                            <a href="#" class="upload"><h6>点击这里上传文件</h6>
                            <input type="file" name="file" ></a>
                        </div>
                    </div>

                <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    <button type="reset" class="secondary-btn">Reset</button>
                </div>
                <!-- end /.footer -->

            </form>
        </div>
</div>


            <div class="slide" id="4">
                <div class="main w3l">
            <form class="contact-forms wthree" action="/rsgl/majorchange" method="post">
                       
                   <div class="main-row">
                     <p style="color:white">原专业</p>
                        <label class="input select">
                            <select name="oldMajor">
                                <option value="none" selected disabled="">原专业</option>
                                <option value="chinese">语文</option>
                                <option value="math">数学</option>
                                <option value="english">英语</option>
                                <option value="pe">体育</option>
                                <option value="coding">计算机</option>
                            </select>
                            <i></i>
                        </label>
                    </div>

                    <div class="main-row">
                     <p style="color:white">新专业</p>
                        <label class="input select">
                            <select name="major">
                                <option value="none" selected disabled="">新专业</option>
                                <option value="chinese">语文</option>
                                <option value="math">数学</option>
                                <option value="english">英语</option>
                                <option value="pe">体育</option>
                                <option value="coding">计算机</option>
                            </select>
                            <i></i>
                        </label>
                    </div>
                    
                     <div class="main-row">
                        <div class="input">
                            <p style="color:white">申请原因</p>
                            <br>
                            <a href="#" class="upload"><h6>点击这里上传文件</h6>
                            <input type="file" name="file" ></a>
                        </div>
                    </div>

                <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    <button type="reset" class="secondary-btn">Reset</button>
                </div>
                <!-- end /.footer -->

            </form>
        </div>
        <a href="/rsgl/majorresult" class="change">申请结果</a>
        </div>



        <div class="slide" id="5">
            <div class="main w3l">
            <form class="contact-forms wthree" method="post" action="/rsgl/teacherpasswordchange">
               
                    <div class="main-row">
                        <div class="input">
                            <p style="color:white">原密码</p>
                            <input type="password" id="old-passwd" placeholder="Old-Passwd" name="old-passwd" required="">
                        </div>
                    </div>
                     <div class="main-row">
                        <div class="input">
                            <p style="color:white">新密码</p>
                            <input type="password" id="new-passwd" placeholder="New-Passwd" name="newPassword" required="">
                        </div>
                    </div>

                <div class="footer">
                    <button type="submit" class="primary-btn">Send</button>
                    <button type="reset" class="secondary-btn">Reset</button>
                </div>
                <!-- end /.footer -->

            </form>
        </div>
    </div>
</div>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/main.js"></script>
     <script type="text/javascript">
        $(document).ready(function() {

            // navigation click actions 
            $('.scroll-link').on('click', function(event){
                event.preventDefault();
                var sectionID = $(this).attr("data-id");
                scrollToID('#' + sectionID, 750);
            });
            // scroll to top action
            $('.scroll-top').on('click', function(event) {
                event.preventDefault();
                $('html, body').animate({scrollTop:0}, 'slow');         
            });
            // mobile nav toggle
            $('#nav-toggle').on('click', function (event) {
                event.preventDefault();
                $('#main-nav').toggleClass("open");
            });
        });
        // scroll function
        function scrollToID(id, speed){
            var offSet = 0;
            var targetOffset = $(id).offset().top - offSet;
            var mainNav = $('#main-nav');
            $('html,body').animate({scrollTop:targetOffset}, speed);
            if (mainNav.hasClass("open")) {
                mainNav.css("height", "1px").removeClass("in").addClass("collapse");
                mainNav.removeClass("open");
            }
        }
        if (typeof console === "undefined") {
            console = {
                log: function() { }
            };
        }
    </script>
    </body>
</html>