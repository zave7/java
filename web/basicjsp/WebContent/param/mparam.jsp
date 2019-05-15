<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] fruit = request.getParameterValues("fruit");
		
		String color = age == 10 ? "red" : "blue";
		
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		
		<span><%= name%>(<span style="color: <%= color %>"><%= age %></span>)</span>님 안녕하세요<br>
		당신이 좋아하는 과일은<br>
		
		<%
		String fruitStr = "";
		int len = 0;
		if(fruit != null)
			len = fruit.length;
		if(len != 0) {
			fruitStr += fruit[0];
			for (int i = 1; i < len; i++) {
				fruitStr += ", " + fruit[i];
			}
			%>
			<%= fruitStr %>입니다
		<%
		} else {
		%>
			없습니다
		<%
		}
		%>
</body>
</html>