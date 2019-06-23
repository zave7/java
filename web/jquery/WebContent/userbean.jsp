<%@page import="com.kitri.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	//1.request의 속성 (이름 : "c", 타입 : com.kitir.dto.Customer)얻기
	Customer c = (Customer) request.getAttribute("c");
	//2.1속성이 Null인 경우
	// Customer객체 생성하여 c참조변수에 대입
	// c참조변수를 request의 속성 (이름:"c")로 추가
	if(c == null) {
		c = new Customer();
		request.setAttribute("c", c);
	}
%> --%>
<!-- 임포트가 되어있어도 풀패키지 기입 -->
<jsp:useBean id="c" class="com.kitri.dto.Customer" scope="request"/>

<%-- <%c.setId("id1"); %> --%>
<jsp:setProperty property="id" name="c" value="id1"/>

<%-- <%
c.setName(request.getParameter("n"));
%> --%>
<jsp:setProperty property="name" name="c" param="n"/>

<%-- <%=c.getId() %> --%>
<jsp:getProperty property="id" name="c" />




















</body>
</html>