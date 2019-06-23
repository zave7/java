<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include.jsp</title>
</head>
<body>
<h3>포함지시자</h3>
<%@ include file="loginresult.jsp" %>
<hr>
<h3>포함태그</h3>
<jsp:include page="loginresult.jsp"/><!-- 반드시 엔드 태그가 있어야 한다!! xml기반이다-->
</body>
</html>