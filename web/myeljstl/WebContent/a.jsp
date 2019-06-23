<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    %>
    <%
    	Thread.sleep(2*1000);
    System.out.println("요청응답");
    %><%=id%>(<%=name%>)님 응답결과입니다.