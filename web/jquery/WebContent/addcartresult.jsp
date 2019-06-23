<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(function() {
		var $arr = $("div.resultCart>button");
		$($arr[0]).click(function() {
			$("nav>ul>li>a[href=productlist]").trigger("click");
			return false;
		});
		$($arr[1]).click(function() {
			$("nav>ul>li>a[href=viewcart]").trigger("click");
			return false;
		});
	});
</script>
<div class="resultCart">
<span>장바구니에 넣었습니다!!</span>
<button>상품목록으로가기</button>
<button>장바구니보기</button>
</div>
