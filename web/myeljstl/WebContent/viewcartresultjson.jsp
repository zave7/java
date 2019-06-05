<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.Set"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Map<Product, Integer> map = (HashMap<Product, Integer>)request.getAttribute("reqCart");
	Set<Product> keys = map.keySet();
	Gson gson = new Gson();
	JsonArray jsonArray = new JsonArray();
		
	for(Product p : keys) {
		JsonObject jsonObject = new JsonObject();
		String prod_no = p.getProd_no();
		String prod_name = p.getProd_name();
		int prod_price = p.getProd_price();
		int quantity = map.get(p);
		jsonObject.addProperty("prod_no", prod_no);
		jsonObject.addProperty("prod_name", prod_name);
		jsonObject.addProperty("prod_price", prod_price);
		jsonObject.addProperty("quantity", quantity);
		jsonArray.add(jsonObject);
	}
	System.out.println(jsonArray);
%><%=jsonArray%>