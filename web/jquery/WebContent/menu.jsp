<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<%String id = (String) session.getAttribute("loginInfo"); 
		if(id == null) {
	%>
	<li><a href="user/login.html">로그인</a></li>
	<li><a href="user/signup.html">가입</a></li>
	<%} else { %>
	<li><a href="logout">로그아웃</a></li>
	<%} %>
</ul>