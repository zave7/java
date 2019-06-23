<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="85kb" errorPage="err.jsp"%><!-- 무조건 kb단위 --><!-- 버퍼를 쓰고 싶지 않으면 'none' 값을 주면 된다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i=1; i<=10000; i++) {
	
%>
<%=i%>
<%
}
%>
<%
	//a.txt 파일은 byte단위로 읽기위한 스트림 객체 생성
	FileInputStream fis = null;
	fis = new FileInputStream(new File("a.txt"));
%>
</body>
</html>