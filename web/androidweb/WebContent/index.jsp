<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kitri.dto.Product" %>
<%@ page import="com.kitri.dto.ProductCategory" %>
    <% String method = request.getMethod(); 
    	String opt = request.getParameter("opt");
    	if(opt == null || opt.isEmpty()) {
    		opt = "default";
    	}
    %>
<%-- {
	"method" : "<%=method%>",
	"status" : 1,
	"msg" : "안드로이드용 WEB Application 입니다!",
	"opt" : "<%=opt%>
} --%>
<%--[{"prod_no" : "001", "prod_name" : "아메리카노1", "prod_price" : 2501},
 {"prod_no" : "002", "prod_name" : "아메리카노2", "prod_price" : 2502},
 {"prod_no" : "003", "prod_name" : "아메리카노3", "prod_price" : 2503}
] --%>
<% List<Product> list = new ArrayList<>();
	Product product = new Product();
	list.add(new Product("001", "아메리카노", 1000, null, null));
	list.add(new Product("002", "아이스 아메리카노", 2000, null, null));
	list.add(new Product("003", "라떼", 3000, null, null));
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.writeValue(out, list);
%>