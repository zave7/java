<%@ page import="com.kitri.dto.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="productlist" value="${requestScope.list}"></c:set>
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
${requestScope.servletContext.contextPath}
<div id="main">
	<div class="productlist">
	<c:forEach var="product" items="${productlist}" varStatus="i">
		<div class="content">
		<img src="${requestScope.servletContext.contextPath}/img${i.count}.PNG" alt="${product.prod_name}"/><br>
		<span>카테고리 : ${product.productCategory.cate_name}</span><br>
		<span>상품번호 : <span class="prod_no">${product.prod_no}</span></span><br>
		<span>상품명 : ${product.prod_name}</span><br>
		<span>가격 : ${product.prod_price}</span>
		</div>
	</c:forEach>
	</div>
</div>
