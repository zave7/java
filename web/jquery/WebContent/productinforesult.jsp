<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product product = (Product) request.getAttribute("product");
    	int imgNo = Integer.parseInt(product.getProd_no());
    %>
<div class="productdetail">
		<img src="/myjquery/img/<%=imgNo%>.PNG"/><br>
		<div>
		<span>상품명 : <%=product.getProd_name()%></span><br><br>
		<span>상품설명 : <%=product.getProd_detail()%></span><br><br>
		<span>상품번호 : <%=product.getProd_no()%></span><br><br>
		<span>가격 : <%=product.getProd_price()%></span><br><br>
		<span>수량 : <input type="number" value="1" name="count" min="1" max="9999" maxlength="5"></span><br><br>
		<button>장바구니 담기</button>
		</div>
</div>