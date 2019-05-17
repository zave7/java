<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	1.data get
	request.setCharacterEncoding("utf-8");//요청이 들어온 놈의 캐릭터 셋을 uft-8해라
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	int age = Integer.parseInt(request.getParameter("age"));
//	2.logic
	String color = age == 10 ? "red" : "blue";
//	3.response page : 안효인(java2)님 안녕하세요.
	//response.setContentType("text/html;charset=utf-8;");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<span><%= name %>(<span style="color: <%= color%>"><%= id %></span>)님 안녕하세요</span>

</body>
</html>