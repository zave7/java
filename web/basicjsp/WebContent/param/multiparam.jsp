<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main {
		text-align: center;
	}
	.contents {
		width: 400px;
		height: 30px;
		text-align: left;
		border: 1px solid gray;
		margin: 10px auto;
	}

</style>
</head>
<body>
<form method="get" action="/basicjsp/param/mparam.jsp">
	<div id="main">
		<h1>다중</h1>
		<div class="contents"> 이름 : <input type="text" name="name" placeholder="이름을 입력해주세요"></div>
		<div class="contents"> 아이디 : <input type="text" name="id" placeholder="아이디를 입력해주세요"></div>
		<div class="contents"> 연령 : 
			<select name="age">
				<option value="10">10대</option>
				<option value="20">20대</option>
				<option value="30">30대</option>
				<option value="40">40대</option>
				<option value="50">50대</option>
			</select>
		</div>
		<div class="contents"> 좋아하는 과일? 
			<label><input type="checkbox" name="fruit" value="사과">사과 </label> 
			<label><input type="checkbox" name="fruit" value="바나나">바나나 </label>
			<label><input type="checkbox" name="fruit" value="수박">수박 </label>
			<label><input type="checkbox" name="fruit" value="딸기">딸기 </label>
		</div>
		<div><input type="submit" value="전송"></div>
	</div>
</form>
</body>
</html>