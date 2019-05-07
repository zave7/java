<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int i;
	int j;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span {
		display: inline-block;
		border: 1px solid black;
		width: 150px;
	}
	.s0 {
		background-color: orange;
	}
	.s1 {
		background-color: gray;
	}
</style>
</head>
<body>
	<div align="center">
	<h3>*** 구구단 ***</h3>
		<%
			for(int i = 1; i<=9; i++) {
				for(int j = 2; j<=9; j++) {
					out.println("<span class=\"s"+(j%2)+"\">" + j + " * " + i + " = " + (j*i) + "</span>");
				}
				out.println("<br>");
			}
		%>	
	<hr>
	
	<h3>*** 구구단 ***</h3>
		<%
			for(i = 1; i<=9; i++) {
				for(j = 2; j<=9; j++) { %>
				<span class="s<%= j%2%>"><%= j + " * " + i + " = " + (j*i)%></span>
				<%}%>
				<br>
			<%}%>
	<hr>
	
	<h3>*** 구구단 ***</h3>
		<%
			for(i = 1; i<=9; i++) {
				for(j = 2; j<=9; j++) { %>
				<span class="s<%= j%2%>"><%= j + " * " + i + " = " + (j*i)%></span>
				<%}
				out.println("<br>");
			}%>
	<hr>
	</div>
</body>
</html>