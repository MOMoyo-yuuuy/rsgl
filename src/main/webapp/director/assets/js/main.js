jQuery(document).ready(function($) {

    'use strict';     
        
        $(function() {
  
        function showSlide(n) {
            $body.unbind("mousewheel");
            currSlide = Math.min(Math.max(0, currSlide + n), $slide.length-1);
            var displacment = window.innerWidth*currSlide;
            $slides.css('transform', 'translateX(-' + displacment + 'px)');
            setTimeout(bind, 700);
            $('nav a.active').removeClass('active');
            $($('a')[currSlide]).addClass('active');
            
        }
      
        function bind() {
             $body.bind('false', mouseEvent);
          }
      
        function mouseEvent(e, delta) {
            showSlide(delta >= 0 ? -1 : 1);
            e.preventDefault();
        }
        
        $('nav a, .main-btn a').click(function(e) {
            var newslide = parseInt($(this).attr('href')[1]);
            var diff = newslide - currSlide - 1;
            showSlide(diff); 
            e.preventDefault();
        });

      
        $(window).resize(function(){
          
          var displacment = window.innerWidth*currSlide;
          $slides.css('transform', 'translateX(-'+displacment+'px)');
        });
        
       
        var $body = $('body');
        var currSlide = 0;
        var $slides = $('.slides');
        var $slide = $('.slide');
      
        $($('nav a')[0]).addClass('active');
        
        $body.bind('false', mouseEvent);
    })        

        $(function(){
               $("td button.button_agree").click(function(){
                    var content=$(this)
                    var status=$(this).parents("tr").find("td>div.status")
                    status.removeClass().addClass("status agree");
                    // alert("修改成功");
               });

                $("td button.button_disagree").click(function(){
                    var content=$(this)
                    var status=$(this).parents("tr").find("td>div.status")
                    status.removeClass().addClass("status disagree");
                    // alert("修改成功");
               });

                 $("td button.button_notdis").click(function(){
                    var content=$(this)
                    var status=$(this).parents("tr").find("td>div.status")
                    status.removeClass().addClass("status notdis");
                    // alert("修改成功");
               });
        });

        $(function(){
            $($("ul.topnav li")[0]).addClass("selected");
            $("table.course_1").css("display","block");
            function showtable(n){
                var tables=$("div.arrange_class table");
                for (var i = 0; i < tables.length; i++) {
                    $($("div.arrange_class table")[i]).css("display","none");
                }
                $($("div.arrange_class table")[n]).css("display","block");
            }
            $("ul.topnav li").click(function(e){
                    var tablenum = parseInt($(this).find("a").attr("id")[0]);
                    $(this).parents("ul.topnav").find("li").removeClass("selected");
                    $(this).addClass("selected");
                    var table=tablenum-1;
                    showtable(table); 
                    e.preventDefault();
            })
         });

        $(window).on("scroll", function() {
            if($(window).scrollTop() > 100) {
                $(".header").addClass("active");
            } else {
                //remove the background property so it comes transparent again (defined in your css)
               $(".header").removeClass("active");
            }
        });


});
