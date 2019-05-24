<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ attribute name="current" required="true" type="java.lang.Integer"%><%-- 기본형 타입을 쓰면안된다 무조건 래퍼 클래스 --%>
<%@ attribute name="start" required="true" type="java.lang.Integer"%>
<%@ attribute name="end" required="true" type="java.lang.Integer"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer"%>
<%
	System.out.println("start "+start);
	System.out.println("end "+end);
	System.out.println("current "+current);
	System.out.println("totalPage  "+totalPage);
	if(start != 1) {%>
		<a href="<%=url %>?currentPage=<%=start-1%>">&#9664;</a> 
	<%}
	for(int i=start; i<=end; i++) {
		if(i==current) {
			%><%=i %>
		<%} else {%>
		<a href="<%=url %>?currentPage=<%=i %>"><%=i %></a>
		<%
		}
	}
	System.out.println("end != totalPage "+(end != totalPage));
	System.out.println("end == totalPage "+(end == totalPage));
	if(end == totalPage) {
%> <a href="<%=url %>?currentPage=<%=end+1%>">&#9654;</a>
<%
	}
%>

