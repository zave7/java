<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semantic</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<style>
	a {
		color: red;
	}
</style>
<script>
	$(function(){
		//dom트리에서 nav > ul > li > a객체들 찾기
		var aArr = $("nav>ul>li>a");
		$(aArr).click(function() {
			var vurl = $(this).attr("href");
			if(vurl == 'logout') {
				$.ajax({
					url : vurl,
					method : 'get',
					success : function(result) {
						location.href = "/myjquery/semantic.jsp";
					}
				});
			} else {
				$.ajax({
					url : vurl,
					method : 'get',
					success : function(result) {
						$("section").html(result);
					}
				});
			}
			
			return false;
		});
	});
</script>
<style>
	header {
		background-iamge: url("cat.jpg");
	}
	nav li {
		list-style: none;
		display: inline-block;
	}
	nav ul {
		padding-left: 0px;
	}
	footer {
		position: fixed;
		bottom: 0px;
		width: 100%;
		background-color: gray;
	}
</style>
</head>
<body>
<header>
	<h1>HEADER</h1>
</header>
<nav>Menu
<jsp:include page="menu.jsp"/>
</nav>
<section>Content</section>
<footer>
	<h2>FOOTER</h2>
</footer>
</body>
</html>