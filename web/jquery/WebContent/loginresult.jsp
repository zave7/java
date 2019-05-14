<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	System.out.println("jsp : "+request.getAttribute("result"));
    %>
<%=request.getAttribute("result")%>
