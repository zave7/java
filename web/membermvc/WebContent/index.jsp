<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String root = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main {
		margin: auto auto;
	}
</style>
</head>
<body>
	<div id="main">
		<h3>jsp을 이용한 회원가입 &amp; 로그인</h3>
		<a href="<%=root%>/user/member.jsp">회원가입</a>
		<a href="<%=root%>/user/login.jsp">로그인</a>
	</div>
</body>
</html>