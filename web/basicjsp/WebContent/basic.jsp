<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
    String name;
	int age;
	
	public void init() { //원칙적으로는 throws 해주는게 맞지만 알아서 해준다
		name = "권영찬";
		age = 23;
	}
%>
<%
	String color = age >= 18 ? "red" : "blue";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span {
		color: <%=color%>
	}
</style>
</head>
<body>
<div>
<%= name %>(<span><% out.print(age); %></span>)님 안녕하세요.<br>
<%= name %>(<span><%= age %></span>)님 안녕하세요.<br>
</div>
</body>
</html>