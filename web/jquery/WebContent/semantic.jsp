<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semantic</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	$(function(){
		//dom트리에서 nav > ul > li > a객체들 찾기
		var aArr = $("nav>ul>li>a");
		$(aArr).click(function() {
			var vurl = $(this).attr("href");
			$.ajax({
				url : vurl,
				method : 'get',
				success : function(result) {
					$("section").html(result);
				}
			});
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
	<ul>
		<li><a href="user/login.html">로그인</a></li>
		<li><a href="user/signup.html">가입</a></li>
	</ul>
</nav>
<section>Content</section>
<footer>
	<h2>FOOTER</h2>
</footer>
</body>
</html>