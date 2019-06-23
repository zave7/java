<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	div.boarddetail {
		width: 80%;
		margin: 0 auto;
		border: 2px solid orange;
	}
	div.boarddetail>div.subject>p.author {
		text-align: right;
		display: inline-block;
		border: 1px solid gray;
	}
</style>
<style>
	
</style>
<div class="boarddetail">
	<c:set var="repBoard" value="${requestScope.repBoard}"></c:set>
	<div class="subject">
		<h1>${repBoard.board_subject}</h1>
		<p class="author">
		<span>작성자 : ${repBoard.board_writer}</span> 
		<span>작성일자 : ${repBoard.board_date}</span>
		</p>
	</div>
	<div class="content">
		<textarea readonly="readonly" rows="50" cols="50">${repBoard.board_contents}</textarea>
	</div>
	<div class="list">
		<button value="sdf">이전 글</button>
		<button>목록으로</button>
		<button>다음 글</button>
	</div>

</div>