<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.contents {
		width: 300px;
		height: 50px;
		border: 1px solid gray;
	}
</style>
</head>
<body>
<form method="post" action="/basicjsp/param/sparam.jsp">
<div align="center">
		<div class="contents"><span>이름 : </span><input type="text" name="name"></div>
		<div class="contents"><span>아이디 : </span><input type="text" name="id"></div>
		<div class="contents"><span>연령 : </span>
		<select name="age">
			<option value="10">10대이하</option>
			<option value="20">20대이하</option>
			<option value="30">30대이하</option>
			<option value="40">40대이하</option>
			<option value="50">50대이하</option>
		</select></div>
		<div align="center"><input type="submit" value="전송"></div>
	</div>
</form>
</body>
</html>