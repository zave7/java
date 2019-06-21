<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:if test="${requestScope.registerInfo != null}">
${requestScope.registerInfo.name}님 회원가입을 환영합니다<br>
가입하신 정보는 아래와 같습니다.<br>
아이디 : ${requestScope.registerInfo.id}<br>
이메일 : ${requestScope.registerInfo.emailId}@${requestScope.registerInfo.emailDomain}<br>
전화번호 : ${requestScope.registerInfo.tel1}-${requestScope.registerInfo.tel2}-${requestScope.registerInfo.tel3}<br>
주소 : ${requestScope.registerInfo.zipcode} ${requestScope.registerInfo.address} ${requestScope.registerInfo.addressDetail}<br>
로그인 후 모든 서비스를 이용할 수 있습니다<br>
<a href="${root}/user/login.kitri">로그인</a>
</c:if>
<c:if test="${requestScope.registerInfo == null}">
	<c:redirect url="#"/>
</c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>