<%@ page import="com.kitri.dto.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Product> productList = (List<Product>) request.getAttribute("list");
    %>
<script>
	$(function() {
		var $divProduct = $("div[class=content]");
		$divProduct.click(function() {
			//alert($(this).find("span.prod_no").text());
			$.ajax({
				url : '/myjquery/productinfo?',
				method : 'get',
				data : 'no=' + $(this).find("span.prod_no").text(),
				success : function(result) {
					$("section").html(result.trim());
				},
				error : function() {
					alert("에러!!");
				}
			});
		});
	});
</script>
<div id="main">
	<div class="productlist">
	<%	int i = 0;
		for(Product product : productList) {
			i++;
	%>
		<div class="content">
		<img src="/myjquery/img/<%=i%>.PNG" alt="<%=product.getProd_name()%>"/><br>
		<span>카테고리 : <%=product.getProductCategory().getCate_name()%></span><br>
		<span>상품번호 : <span class="prod_no"><%=product.getProd_no()%></span></span><br>
		<span>상품명 : <%=product.getProd_name()%></span><br>
		<span>가격 : <%=product.getProd_price()%></span>
		</div>
	<%
		}
	%>
	</div>
</div>
