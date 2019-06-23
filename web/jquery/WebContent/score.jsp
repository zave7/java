<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
    	double count = 0;
    	int star = 0;
    	double avg = 0;
%>
<%
	count++;
	int star = Integer.parseInt(request.getParameter("star"));
	this.star += star;
	this.avg = ((int) (this.star/this.count)*10)/10.0;
	System.out.println(Math.round(this.avg*10)/10.0);
%>참여자수: <%=this.count%>명<br>총 별점: <%=this.star%><br>평균 별점: <%=Math.round(this.avg*10)/10.0%>