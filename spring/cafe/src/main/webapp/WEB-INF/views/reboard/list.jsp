<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/commons/template/top.jsp" %>
<%@ include file="/WEB-INF/views/commons/board_common.jsp" %>
<script>
	$(document).ready(function() {
		$(".moveWriteBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val("1");
			$("#key").val("");
			$("#word").val("");
			$("#seq").val("");
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/write").submit();
		});
		
		$(".moveReplyBtn").click(function() {
			
		});
		
		$(".viewBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val("${pg}");
			$("#key").val("${key}");
			$("#word").val("${word}");
			$("#seq").val($(this).attr("data-seq"));
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/view").submit();
			return false;
		});
		
		$(".firstListBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val("1");
			$("#key").val("");
			$("#word").val("");
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/list").submit();
		});
		
		$(".moveListBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val($(this).attr("data-pg"));
			$("#key").val("${key}");
			$("#word").val("${word}");
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/list").submit();
		});
		
		$("#searchBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val("1");
			$("#key").val($("#skey").val());
			$("#word").val($("#sword").val());
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/list").submit();
		});
		
		$("#myListBtn").click(function() {
			$("#bcode").val("${bcode}");
			$("#pg").val("1");
			$("#key").val("id");
			$("#word").val("${userInfo.id}");
			$("#commonForm").attr("method", "GET").attr("action", "${root}/reboard/list").submit();
		});
	});
</script>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="${root}/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
		<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운 글을
		올리는 공간입니다<br>
		</td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>
<!-- title end -->

<!-- bbs start -->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr valign="bottom">
		<td nowrap>
			<img src="${root}/img/board/btn_write_01.gif" width="64" height="22" class="moveWriteBtn"
			border="0" align="absmiddle" alt="글쓰기"></td>

		<td width="100%" style="padding-left: 6px" valign="bottom">새글 <b><font
			class="text_acc_02">${requestScope.navigator.newArticleCount}</font></b> / 전체 <font
			class="text_acc_02">${requestScope.navigator.totalArticleCount}</font></td>
		<td width="300" nowrap>
		<div align="right"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="5" style="padding: 0px"></td>
	</tr>
</table>

<form name="listForm" method="post" style="margin: 0px">
<table width="100%" cellpadding="5" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="2" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr class="bg_board_title" align="center" height="28">
		<td nowrap><b>번호</b></td>
		<td nowrap class="board_bar" style="padding: 0px">|</td>
		<td></td>
		<td width="100%"><b>제목</b></td>
		<td nowrap class="board_bar" style="padding: 0px">|</td>
		<td width="120" nowrap><b>글쓴이</b></td>
		<td nowrap class="board_bar" style="padding: 0px">|</td>
		<td nowrap><b>조회</b></td>
		<td nowrap class="board_bar" style="padding: 0px">|</td>
		<td width="45" nowrap><b>날짜</b></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>

	<!-- 공지기능 적용시 -->


	<!-- 공지기능 적용끝  -->
	<c:forEach var="article" items="${requestScope.articleList}">
	<tr>
		<td align="center" class="text_gray">${article.seq}</td>
		<td></td>
		<td nowrap class="onetext" style="padding-right: 5px"></td>
		<!--td>
     
     </td-->
		<td style="word-break: break-all;">
			<img src="${root}/img/board/blank.gif" width="${article.lev * 15}" height="1" />
			<a href="" class="link_board_03 viewBtn" data-seq="${article.seq}">${article.subject.replace('<', '&lt')}&nbsp;&nbsp;&nbsp;</a></td>
		<td></td>
		<td style="word-break: break-all;"><a href="javascript:;"
			onClick="showSideView();" class="link_board_04">${article.name}</a></td>
		<td></td>
		<td align="center" class="text_gray">${article.hit}</td>
		<td></td>
		<td align="center" class="text_gray">${article.logtime}</td>
	</tr>

	<tr>
		<td bgcolor="#ededed" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	</c:forEach>

	<tr>
		<td class="bg_board_title_02" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>
</form>
<!-- bbs end -->

<!-- 하단 페이징 -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="5"></td>
	</tr>
	<tr valign="top">
		<td nowrap>
			<img src="${root}/img/board/btn_write_01.gif" width="64" height="22" class="moveWriteBtn"
			border="0" align="absmiddle" alt="글쓰기"></td>
		<td width="100%" align="center"><!--PAGE-->${requestScope.navigator.navigator}</td>
		<td nowrap class="stext"><b>${requestScope.navigator.pageNo}</b> / ${requestScope.navigator.totalPageCount}
		pages</td>
	</tr>
</table>
<br>
<!-- 하단 페이징 -->

<!-- 검색 영역-->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="10"></td>
	</tr>
	<tr>
		<td width="50%"></td>
		<td nowrap>
		<select id="skey" name="key" class="inp">
			<option value="subject">글제목
			<option value="name">글쓴이
			<option value="seq">글번호
		</select> 
		<span id="sear1"> 
		<input type="text" id="sword" size="22" class="inp" style="margin-top: -19px;"> 
		</span> 
			<img src="${root}/img/board/sbtn_s.gif" width="32" height="18" id="searchBtn"
			border="0" align="absmiddle" alt="검색"> 
			
			<c:if test="${sessionScope.userInfo != null}">
			<img src="${root}/img/board/sbtn_mytext.gif" width="82" height="20" id="myListBtn"
			align="absmiddle" alt="내가 쓴 글 보기">
			</c:if><br>
		</td>
		<td width="50%" align="right"><a href="#"><img
			src="${root}/img/board/sbtn_top.gif" width="24" height="11"
			align="absmiddle" alt="TOP"></a><br>
		</td>
	</tr>
</table>
<%@ include file="/WEB-INF/views/commons/template/bottom.jsp" %>

