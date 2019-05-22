<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL : JspStandardTagLibrary -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
<c:set var="num" value="${param.num}"></c:set><%--int num = Integer.parseInt(request.getParameter("num")); --%>
요청전달데이터 : ${num}
<c:if test="${num%2==0}">						<%--if(){} --%>
짝수입니다.<br>
</c:if>
<hr>
<c:choose>
	<c:when test="${num%2==0}">
		짝수입니다
	</c:when>
	<c:otherwise>
		홀수입니다
	</c:otherwise>
</c:choose>
<hr>
<c:forEach begin="1" end="10" step="1" var="i"><%--for(int i=1; i<=10; i++) {} --%>
${i}
</c:forEach>
<c:set var="total" value="0"></c:set>
<c:forEach begin="1" end="10" var="i">
	<c:set var="total" value="${total+i}"></c:set><!-- 이미 있으면 그 변수를 사용 -->
</c:forEach>
1~10 합 : ${total}
<hr>
<%
List<String> list = new ArrayList<String>();
list.add("one");list.add("two");list.add("three");
request.setAttribute("list", list);
%>
<%--for(String e : (String)(request.getAttribute("list"))) --%>
<c:forEach var="e" items="${requestScope.list}">
	${e}<br>
</c:forEach>
<hr>
<c:forEach var="e" items="${requestScope.list}" varStatus="obj">
	${obj.index} - ${e} : ${obj.count}회 <br>
</c:forEach>
<hr>
<%
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("one", 1);
	map.put("two", 2);
	map.put("three", 3);
	request.setAttribute("map", map);
%>
<c:forEach var="e1" items="${requestScope.map}">
	${e1.key} : ${e1.value} <br>
</c:forEach>

</body>
</html>