<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/template/top.jsp" %>
<style>
	.menulist {
		width: 230px;
	}
	.category {
		padding: 5px 10px;
		cursor: pointer;
		position: relative;
		font-weight: bold;
		text-align: left;
		background-color: black;
		color: white;
	}
	.menu {
		text-align: left;
		display: none; 
	}
	.menu a {
		display: block;
		background-color: gray;
		padding: 10px;
		text-decoration: none;
		color: white;
	}
	.menu a:hover {
		color: #000000;
		text-decoration: underline;	
	}
</style>
<script>
	$(document).ready(function() {
		$("#boardmenu p.category").click(function() {
			$(this).next("div.menu").slideDown(500).siblings("div.menu").slideUp(500);
		});
	});
</script>
<c:set var="boardmenu" value="${requestScope.boardmenu}"></c:set>

<div class="menulist" id="boardmenu">
		<c:set var="idx" value="0"></c:set>
	<c:forEach varStatus="i" var="board" items="${boardmenu}">
		<c:if test="${idx != board.ccode}">
			<p class="category">${board.cname}</p>
		<c:set var="idx" value="${board.ccode}"></c:set>
		<div class="menu">
		</c:if>
		<a href="${root}/${board.control}/list?bcode=${board.bcode}&pg=1&key=&word=">${board.bname}</a>
		<c:if test="${i.index < boardmenu.size()-1 }">
			<c:if test="${idx != boardmenu.get(i.index+1).ccode}">
			</div>
			</c:if>
		</c:if>
	</c:forEach>
	</div>
</div>
<%@ include file="/WEB-INF/views/commons/template/bottom.jsp" %>