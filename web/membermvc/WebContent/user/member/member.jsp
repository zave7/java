<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	 
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
});
var resultView;
var idcount = 1;
function idcheck() {
	console.log("idcheck");
	resultView = document.getElementById("idresult"); //div
	var searchId = document.getElementById("id").value;
	if(searchId.length < 5 || searchId.length > 16) {
		resultView.innerHTML = '<font color="gray">아이디는 5자이상 16자 이하입니다.</font>';
	} else {
		var params = "act=idcheck&sid=" + searchId;
		sendRequest("<%=root%>/user", params, idcheckResult, "GET");
	}
}
function idcheckResult() {
	if(httpRequest.readyState == 4) {//원하는 정상적인 데이터가 넘어오는 경우, 정상적이지 않은 데이터가 넘어오는 경우(에러)
		if(httpRequest.status == 200) {
			var result = httpRequest.responseXML;
			//결과값을 배열로 가져온다 태그는 여려개 일 수 있기 때문!!
			idcount = parseInt(result.getElementsByTagName("cnt")[0].firstChild.data); 
			if(idcount == 0) {
				resultView.innerHTML = '<font color="blue">사용 가능한 아이디입니다</font>';
			} else {
				resultView.innerHTML = '<font color="red">이미 사용중인 아이디입니다</font>';
			}
		}
	} else {
		//로딩중..
	}
}

function register() {
	if(document.getElementById("name").value == "") {
		alert("이름입력!");
		return;
	} else if (idcount != 0) {
		alert("아이디 중복검사를 하세요!!");
		return;
	} else if (document.getElementById("pass").value == "") {
		alert("비밀번호 입력!!");
		return;
	} else if (document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("비밀번호 확인!!");
		return;
	} else {
		document.getElementById("memberform").action = "<%=root%>/user"; // 값지정
		document.getElementById("memberform").submit(); // 보내기
	}
}
</script>
<body>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>회원가입</h2>
		<form id="memberform" method="post" action="">
			<input type="hidden" name="act" value="register">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="이름입력">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="4자이상 16자 이하" onkeyup="javascript:idcheck();">
				<div id="idresult"></div>
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="passcheck" name="passcheck" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="emailid" name="emailid" placeholder="" size="25"> @
				<select class="form-control" id="emaildomain" name="emaildomain">
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label>
				<div id="tel" class="custom-control-inline">
				<select class="form-control" id="tel1" name="tel1">
					<option value="010">010</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="041">041</option>
					<option value="051">051</option>
					<option value="061">061</option>
				</select> _
				<input type="text" class="form-control" id="tel2" name="tel2" placeholder="1234"> _
				<input type="text" class="form-control" id="tel3" name="tel3" placeholder="5678">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="">주소</label><br>
				<div id="addressdiv" class="custom-control-inline">
					<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" size="7" maxlength="5" readonly="readonly">
					<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
				</div>
				<input type="text" class="form-control" id="address" name="address" placeholder="" readonly="readonly">
				<input type="text" class="form-control" id="address_detail" name="address_detail" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn" onclick="javascript:register();">회원가입</button>
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/user/member/zipsearch.jsp" %>

<%@ include file="/template/footer.jsp" %>