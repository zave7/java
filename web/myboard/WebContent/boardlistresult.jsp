<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	div.boardlist {
		text-align: center;
		width: 700px;
		margin: 0 auto;
		border-collapse: collapse;
	}
	div.boardlist th, td{
	text-align: center;
	width: 150px;
	border: 1px solid gray;
	}
</style>
<div class="boardlist">
	<c:set var="pageBean" value="${requestScope.pageBean}"></c:set>
	<c:set var="totalPage" value="${pageBean.totalPage}"></c:set>
	<table>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
			<c:forEach var="rep" items="${pageBean.list}">
				<tr>	
					<td>${rep.board_seq}</td>
					<td><a href="boarddetail?board_seq=${rep.board_seq}">${rep.board_subject}</a></td>
					<td>${rep.board_writer}</td>
					<td><fmt:formatDate pattern="yy-MM-dd" value="${rep.board_date}"/></td>
					<td>${board_viewCount}</td>
				</tr>
			</c:forEach>
	</table>
		<br>
			<tf:pageGroup end="${pageBean.endPage}" url="${pageBean.url}" current="${pageBean.currentPage}" start="${pageBean.startPage}" totalPage="${totalPage}"/>
</div>