<%@ page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product product = (Product) request.getAttribute("product");
    	int imgNo = Integer.parseInt(product.getProd_no());
    %>
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
		<img src="/myjquery/img/<%=imgNo%>.PNG"/><br>
		<span>상품명 : <%=product.getProd_name()%></span><br><br>
		<span>상품설명 : <%=product.getProd_detail()%></span><br><br>
		<span>상품번호 : <span class="goodNo"><%=product.getProd_no()%></span></span><br><br>
		<span>가격 : <%=product.getProd_price()%></span><br><br>
		<!-- <form action="addcart" method="get"> -->
		<%-- <input type="hidden" name="no" value="<%=product.getProd_no()%>"/> --%>
		<span>수량 : <input type="number" value="1" name="count" min="1" max="9999" maxlength="5"></span><br><br>
		<button>장바구니 담기</button>
		<!-- </form> -->
</div>