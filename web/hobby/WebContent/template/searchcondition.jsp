<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="../admincss/datepicker.min.css">
<link rel="stylesheet" href="../admincss/searchcondition.css">
<hr>
<div class="hobby-admin-search">
		<div class="form-group">
		
			<span style="margin-left: 10px; margin-right: 5px;">기간  설정</span><br>
			<input type="text"
				class="form-control form-control-1 input-sm monthFrom"
				placeholder="CheckIn" style="width: 150px; display: inline-block; ">
				 ~ 
				<input type="text"
				class="form-control form-control-1 input-sm monthFrom"
				placeholder="CheckIn" style="width: 150px; display: inline-block;"><br>
				<button type="button" class="btn btn-outline-dark">일</button>
				<button type="button" class="btn btn-outline-dark">월</button>
				<button type="button" class="btn btn-outline-dark">년</button>
		</div>
		
		<div class="form-group">
			<span style="margin-left: 10px; margin-right: 5px;">카테고리 선택</span><br>
		      <select class="form-control" id="sel1" name="sellist1">
		        <option>스포츠</option>
		        <option>운동·헬스</option>
		        <option>외국어</option>
		        <option>컴퓨터</option>
		        <option>마케팅</option>
		        <option>음악·악기</option>
		        <option>영상·사진</option>
		      </select>
		</div>
			<button type="button" class="btn btn-outline-primary">검색</button>
</div>
<hr>