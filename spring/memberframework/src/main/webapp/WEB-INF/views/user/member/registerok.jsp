<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:if test="${userInfo != null}">
${userInfo.name}님 회원가입을 환영합니다<br>
가입하신 정보는 아래와 같습니다.<br>
아이디 : ${userInfo.id}<br>
이메일 : ${userInfo.emailId}@${userInfo.emailDomain}<br>
전화번호 : ${userInfo.tel1}-${userInfo.tel2}-${userInfo.tel3}<br>
주소 : ${userInfo.zipcode} ${userInfo.address} ${userInfo.addressDetail}<br>
로그인 후 모든 서비스를 이용할 수 있습니다<br>
<a href="${root}/user?act=mvlogin">로그인</a>
</c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>