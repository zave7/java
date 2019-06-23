<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
	    <c:if test="${userInfo != null}">
	    <script type="text/javascript">
	    function deleteMember() {
	    	if(confirm("정말로 탈퇴??")) {
	    		$(location).attr("href", "${root}/user/delete");
	    	}
	    }
	    </script>
	    <span>${userInfo.name}(${userInfo.id})님 안녕하세요!!</span>
	    <a href="${root}/user/logout.kitri">로그아웃</a>
	    <a href="${root}/user/modify">정보수정</a>
	    <a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
	    <c:if test="${'admin' == userInfo.id}">
	    <a href="${root}/admin/mvmemberlist.kitri">관리자</a>
	    </c:if>
	  </c:if>
	  <c:if test="${sessionScope.userInfo == null}">
	    <c:redirect url="/user/login.kitri"/>
    </c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>