<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%
	Cookie[] cookie = request.getCookies();
	String svid = "";
	String ckid = "";
	if(cookie != null) {
		for(Cookie c : cookie) {
			System.out.println("쿠키 찾는중!");
			System.out.println(c.getName());
			if("kid_inf".equals(c.getName())) {
				System.out.println("쿠키 찾음");
				svid = c.getValue(); // 같은 쿠키 이름은 덮어 씌워진다
				ckid = " checked";
				break;
			}
		}
	}
	
%>
<script type="text/javascript">
$(document).ready(function() {
	//alert(<%=ckid%>);
});

function login() {
	console.log("콘솔로그");
	if(document.getElementById("loginBtn").value = "") {
	console.log("1");
		alert("아이디를 입력해주세요");
		return;
	} else if(document.getElementById("moveRegisterBtn").value = "") {
	console.log("2");
		alert("비밀번호를 입력해주세요");
		return;
	} else {
		document.getElementById("loginform").action = "${root}/user?act=login";
		console.log("3");
		document.getElementById("loginform").submit();
	}
}
function mvjoin() {
	document.location.href = "${root}/user?act=mvjoin";
}
</script>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>로그인</h2>
		<form id="loginform" method="post" action="">
			<input type="hidden" name="act" value="login">
			<div class="form-group" align="right">
				<label for=""><input type="checkbox" class="form-control" name="idsave" value="idsave" <%=ckid%>>아이디 저장</label>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" value="<%=svid%>" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" id="loginBtn" onclick="javascript:login();">로그인</button>
				<button type="button" class="btn btn-primary" id="moveRegisterBtn" onclick="javascript:mvjoin();">회원가입</button>
			</div>
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>