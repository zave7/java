<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <style>
    	section>div.vieworder>table td, th {
			border: 1px solid gray;
			width: 100px;
			text-align: center;
			border-collapse: collapse;    	
    	}
    	section>div.vieworder {
    		text-align: center;
    	}
    	section>div.vieworder>table {
    		width: 80%;
    		margin: 0 auto;
    	}
    </style>
    <div class="vieworder">
    <h3>주문내역보기</h3>
    <table style="border: 1px solid gray;">
    <tr>
    	<th>주문번호</th><th>주문일자</th><th>주문상품번호</th><th>상품명</th><th>가격</th><th>주문수량</th>
    </tr>
    <c:set var="list" value="${requestScope.orderList}"></c:set>
    <c:forEach var="info" items="${list}">
    	<c:set var="lines" value="${info.lines}"></c:set>
    	<c:set var="size" value="${fn:length(lines)}"></c:set> 
    	<tr>
    		<td rowspan="${size}">${info.order_no}</td>
    		<td rowspan="${size}">${info.order_dt}</td>
    		
    		<c:forEach var="line" items="${lines}">
    			<c:set var="p" value="${line.product}"></c:set>
    			<td>${p.prod_no}</td>
    			<td>${p.prod_name}</td>
    			<td>${p.prod_price}</td>
    			<td>${line.order_quantity}</td>
    	</tr>
    		</c:forEach>
    	
    </c:forEach>
<%-- <% List<OrderInfo> list = (List)request.getAttribute("orderList");
	for(OrderInfo info : list) {
%>
	<tr>
<%
		int order_no = info.getOrder_no();//주문번호
		Date order_dt = info.getOrder_dt();//주문일자
		List<OrderLine> lines = info.getLines();
		int size = lines.size();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
		<td rowspan="<%=size%>"><%=order_no%></td><td rowspan="<%=size%>"><%=sdf.format(order_dt)%></td>
		
<%		
		for(OrderLine line : lines) {
			Product p = line.getProduct();
			String prod_no = p.getProd_no();
			String prod_name = p.getProd_name();
			int prod_price = p.getProd_price();
			int prod_quantity = line.getOrder_quantity();
%>
		<td><%=prod_no%></td><td><%=prod_name%></td><td><%=prod_price%></td><td><%=prod_quantity%></td>
	</tr>	
<%
		}//end line	
%>	
<%	
	}//end info
%> --%>
</table>
</div>
