<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.main div{
		width: 1000px;
		border: 2px solid;
	}
	.header {
	}
	.menu {
		float: left;
	}
	.content {
		float: right;
	}
	.footer {
		clear: both; 
	}
</style>
</head>
<body>
	<div align="center">
		<div class="main">
			<div class="header">
			로고가나와요
			</div>
			<div class="menu">
				<a href="/includetest/board/board.jsp">게시판1</a>
				<a href="/includetest/board/album.jsp">사진게시판2</a>
			</div>
			<div class="content">
