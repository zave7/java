<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
	<c:set var="id" value="${sessionScope.loginInfo}"></c:set>

	<c:choose>
		<c:when test="${empty id}">
			<%-- null 이거나 값이 비어있으면 true 반환 --%>
			<li><a href="user/login.html">로그인</a></li>
			<li><a href="user/signup.html">가입</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>

	<li><a href="productlist">상품목록</a></li>
	<li><a href="viewcart">장바구니보기</a></li>

	<c:if test="${!empty id}">
		<li><a href="vieworder">주문목록보기</a></li>
	</c:if>
</ul>