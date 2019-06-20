<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
var cnt = 1;	 
	$("#id").keyup(function() {
		var $id = $("#id").val();
		if ($id.length < 5 || $id.length > 16) {
			cnt = 1;
			$("#idresult").css("color", "gray");
			$("#idresult").text("id는 5자이상 16자이하입니다.");
		} else {
			$.ajax({
				type : "GET",
				url : "${root}/user/idcheck.kitri",
				dataType : "json",
				data : {
					"checkid" : $id
				},
				success : function(result) {
					cnt = parseInt(result.idcount);
					if(cnt == 0) {
						$("#idresult").css("color", "blue");
						$("#idresult").html("사용 가능한 아이디입니다");
					} else {
						$("#idresult").css("color", "red");
						$("#idresult").html("이미 사용중인 아이디입니다");
					}
				}
			});
		}
		return false;
	});
	
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
	
	$('#registerBtn').click(function() {
		if($("#id").val().trim().length == 0) {
			alert("아이디 입력!!");
			return;
		} else if(cnt != 0) {
			alert("아이디 중복확인!!");
			return;
		} else if($("#name").val().trim().length == 0) {
			alert("이름 입력!!");
			return;
		} else if($("#pass").val().trim().length == 0) {
			alert("비밀번호 입력!!");
			return;
		} else if($("#pass").val() != $("passcheck").val()) {
			alert("비밀번호 확인!!");
			return;
		}  else {
			$("#memberform").attr("action", "${root}/user/register.kitri").submit();
		}
		return false;
	});
});
</script>
<body>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>회원가입</h2>
		<form id="memberform" method="post" action="">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="이름입력">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="4자이상 16자 이하">
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
				<input type="text" class="form-control" id="address_detail" name="addressDetail" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn">회원가입</button>
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/user/member/zipsearch.jsp" %>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>