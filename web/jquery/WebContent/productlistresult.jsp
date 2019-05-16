<%@ page import="com.kitri.dto.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Product> productList = (List<Product>) request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#main {
		text-align: center;
		align-content: center;
	}
	#main>.productlist {
		margin: 0 auto;
	}
	.productlist>.content {
		display: inline-block;
		width: 200px;
		height: 300px;
		border: 1px solid gray;
		margin: 20px auto;
	}
	.productlist>.content:hover {
		cursor: pointer;
	}
	img {
		width: 200px;
		height: 200px;
	}
	.productdetail {
		display: inline-block;
		border: 1px solid gray;
		width: 700px;
		margin: 20px auto;
		text-align: left;
	}
	.productdetail>img {
		float: left;
		width: 300px;
		height: 300px;
	}
	.productdetail>div {
		display: inline-block;
		margin-left: 30px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		var $divProduct = $("div[class=content]");
		$divProduct.click(function() {
			//alert($(this).find("span.prod_no").text());
			$.ajax({
				url : '/myjquery/productinfo?no=' + $(this).find("span.prod_no").text(),
				method : 'get',
				success : function(result) {
					//alert(result);
					$("#main").html(result);
				},
				error : function() {
					alert("에러!!");
				}
			});
		});
	});
</script>
</head>
<body>
<div id="main">
	<div class="productlist">
	<%	int i = 0;
		for(Product product : productList) {
			i++;
	%>
		<div class="content">
		<img src="/myjquery/img/<%=i%>.PNG"/><br>
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
</body>
</html>