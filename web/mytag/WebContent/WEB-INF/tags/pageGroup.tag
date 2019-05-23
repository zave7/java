<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ attribute name="current" required="true" type="java.lang.Integer"%><%-- 기본형 타입을 쓰면안된다 무조건 래퍼 클래스 --%>
<%@ attribute name="start" required="true" type="java.lang.Integer"%>
<%@ attribute name="end" required="true" type="java.lang.Integer"%>
<%@ attribute name="url" required="true"%>
<%
	for(int i=start; i<=end; i++) {
		if(i==current) {
			%><%=i %>
		<%} else {%>
		<a href="<%=url %>?page=<%=i %>"><%=i %></a>
		<%
			
		}
	}
%>
