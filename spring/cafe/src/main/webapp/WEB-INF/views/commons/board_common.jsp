<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="bcode" value="${requestScope.parameter.bcode}" />
<c:set var="pg" value="${requestScope.parameter.pg}" />
<c:set var="key" value="${requestScope.parameter.key}" />
<c:set var="word" value="${requestScope.parameter.word}" />
<c:set var="seq" value="${requestScope.seq}" />
<form id="commonForm">
	<input type="hidden" name="bcode" id="bcode"/>
	<input type="hidden" name="pg" id="pg"/>
	<input type="hidden" name="key" id="key"/>
	<input type="hidden" name="word" id="word"/>
	<input type="hidden" name="seq" id="seq"/>
</form>