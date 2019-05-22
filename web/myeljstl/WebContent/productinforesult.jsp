<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="product" value="${requestScope.product}"></c:set>
<fmt:parseNumber var="i" value="${product.prod_no}"></fmt:parseNumber>
    <script>
    	$(function () {
    		var $cartBtn = $(".productdetail>button");
    		var $no = $(".productdetail .goodNo").text().trim();
    		var $count = $(".productdetail input[name=count]").val();
    		$cartBtn.click(function() {
    			$.ajax({
    				url : 'addcart',
    				method : 'get',
    				data : 'no=' + $no + '&count=' + $count,
    				success : function(result) {
    					var $resultCart = $("section").find('div.productdetail>div[classname=resultCartDiv]');
    					if($resultCart.length) {
    						$resultCart.html(result.trim());
    					} else {
    						$("div.productdetail").append($('<div />', {
    							className : 'resultCartDiv',
    							click : function() {
    								alert("동적 생성 클릭");
    							}
    						}).append(result.trim()));
    					}
    					//$("section").html(result.trim());
    				},
    				error : function() {
    					
    				}
    			});
    			return false;
    		});
    	});
    </script>
<div class="productdetail">
		<img src="/myeljstl/img/${i}.PNG"/><br>
		<span>상품명 : ${product.prod_name}</span><br><br>
		<span>상품설명 : ${product.prod_detail}</span><br><br>
		<span>상품번호 : <span class="goodNo">${product.prod_no}</span></span><br><br>
		<span>가격 : <fmt:formatNumber value="${product.prod_price}" type="currency" currencySymbol="\"></fmt:formatNumber></span><br><br>
		<!-- <form action="addcart" method="get"> -->
		<%-- <input type="hidden" name="no" value="<%=product.getProd_no()%>"/> --%>
		<span>수량 : <input type="number" value="1" name="count" min="1" max="9999" maxlength="5"></span><br><br>
		<button>장바구니 담기</button>
		<!-- </form> -->
</div>