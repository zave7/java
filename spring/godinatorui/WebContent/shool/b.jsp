<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* { margin:0px;padding:0px;}
ul { list-style:none;}
a { text-decoration:none;}
img { border:none; vertical-align:top;}

.carousel{
    width: 550px; margin: 0 auto;
    background-color: aqua;
    position: relative;
}

.carousel .view{
    width: 450px; margin: 0 auto;
    background-color: pink;
    overflow: hidden;
}

.carousel .view .list{
    width: 1350px; margin-left: -450px;
}
.carousel .view .list:after{content: "";display: block;clear: both;}

.carousel .view .list > li{
    float:left;
}
.carousel .view .list > li ul:after{content: "";display: block;clear: both;}

.carousel .view .list > li ul li{
    float: left;
    width: 130px; height: 150px;
    margin-left: 10px; margin-right: 10px;
}
.carousel .view .list > li ul li.a1{background-color: red;} 
.carousel .view .list > li ul li.a2{background-color: green;} 
.carousel .view .list > li ul li.a3{background-color: gray;} 
.carousel .view .list > li ul li.a4{background-color: darkgray;} 
.carousel .view .list > li ul li.a5{background-color: firebrick;} 
.carousel .view .list > li ul li.a6{background-color: purple;} 
.carousel .view .list > li ul li.a7{background-color: orange;} 
.carousel .view .list > li ul li.a8{background-color: blue;} 
.carousel .view .list > li ul li.a9{background-color: blueviolet;} 

.carousel .prev{
    position: absolute; width: 25px; height: 50px; background-color: #000; color:#fff;
    left: 0; top: 50%;
    -webkit-transform: translateY(-50%);
    -ms-transform: translateY(-50%);
    -o-transform:translateY(-50%);
    transform: translateY(-50%);
}

.carousel .next{
    position: absolute; width: 50px; height: 50px; background-color: #000; color:#fff;
    right: 0; top: 50%;
    -webkit-transform: translateY(-50%);
    -ms-transform: translateY(-50%);
    -o-transform:translateY(-50%);
    transform: translateY(-50%);
}
</style>
<script src="assets/js/jquery.min.js"></script>
<script>
$(document).ready(function(){
    
	   $('.prev').click(function(){
	       $('.list').stop().animate({'margin-left':'-900px'},function(){
	           $('.list>li').eq(0).appendTo('.list');
	           $('.list').css({'margin-left':'-450px'});
	       });
	   });
	   $('.next').click(function(){
	       $('.list').stop().animate({'margin-left':'0px'},function(){
	           $('.list>li').eq(1).prependTo('.list');
	           $('.list').css({'margin-left':'-450px'});
	       });
	   });
	   
	   var auto = setInterval(function(){
	   		$('.list').stop().animate({'margin-left':'0px'},function(){
	           $('.list>li').eq(1).prependTo('.list');
	           $('.list').css({'margin-left':'-450px'});
	       });
	   },2000);
	   
	   /* 마우스 올렸을때 캐러셀 자동 멈춤 */
	   $('.carousel').mouseenter(function(){
	        clearInterval(auto);  
	   });
	   
	   /* 마우스 내렸을때 캐러셀 자동 다시실행 */
	   $('.carousel').mouseleave(function(){
	        auto = setInterval(function(){
	         		$('.list').stop().animate({'margin-left':'0px'},function(){
	           $('.list>li').eq(1).prependTo('.list');
	           $('.list').css({'margin-left':'-450px'});
	        });
	    },2000);
	   });
	});
</script>
</head>
<body>
<div class="carousel">
        <div class="view">
            <ul class="list">
                <li>
                   <ul>
                       <li class="a1"><a href="#">메뉴1</a></li>
                       <li class="a2"><a href="#">메뉴2</a></li>
                       <li class="a3"><a href="#">메뉴3</a></li>
                   </ul>
                </li>
                <li>
                    <ul>
                       <li class="a4"><a href="#">메뉴4</a></li>
                       <li class="a5"><a href="#">메뉴5</a></li>
                       <li class="a6"><a href="#">메뉴6</a></li>
                   </ul>
                </li>
                <li>
                    <ul>
                       <li class="a7"><a href="#">메뉴7</a></li>
                       <li class="a8"><a href="#">메뉴8</a></li>
                       <li class="a9"><a href="#">메뉴9</a></li>
                   </ul>
                </li>
            </ul>
        </div>
        <p class="prev">이<br>전</p>
        <p class="next">이<br>후</p>
    </div>
</body>
</html>