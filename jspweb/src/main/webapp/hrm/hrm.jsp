<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="hrmwrap"> <!-- 인사관리 전체구역 -->
		<form class="hrmForm">	
		
			<div class="hrm_Top"> <!-- 등록 구역 -->
				<h3> 인사관리 시스템 </h3>
				
				<div> 직원번호 </div>
				<input maxlength="30"  name="hnumber" class="hnumber" type="text" placeholder="직원번호" />
				<span class="numbercheckbox"></span>
				
				<div> 이름 </div>
				<input maxlength="30"  name="hname"  class="hname" type="text" placeholder="이름" />
				<span class="namecheckbox"></span>
				
				<div> 전화번호 </div>
				<input maxlength="30"  name="hphone"  class="hphone" type="text" placeholder="전화번호"/>
				<span class="phonecheckbox"></span>
				
				<div> 날짜 </div>
				<input name="hdate" class="hdate" type="date">
				
				<div> 직급 </div>
				<select class="hrank">
				
					<option> 사원 </option>
					<option> 주임 </option>
					<option> 대리 </option>
					<option> 과장 </option>
					<option> 차장 </option>
					<option> 부장 </option>
					<option> 상무 </option>
					<option> 전무 </option>
					<option> 부사장 </option>
					<option> 사장 </option>
				
				</select>
				
				<div> 직원사진 </div>
				<input onchange="hrmimg(this)" name="himg" class="himg" type="file" accept="" />
				<img class="hrmimg" alt="" src="img/기본이미지.webp" />
			
				<button class="hrmbtn" onclick="hwriter()" type="button"> 등록 </button>
			
			</div> <!-- 등록 구역 e -->
			
		</form>		
		
	</div> <!-- 인사관리 전체구역 e -->
	
	
		<div class="hrm_Bottom"> <!-- 출력 구역 -->
			
			<div class="hrmbox"> <!-- 인사관리 1개의 출력구역 -->
				<div> 22 </div>
				<div> 정희락 </div>
				<div> 010-1111-2222 </div>
				<div> 사원 </div>
				<div> 2023-08-30 </div>
				<img src="" />
				
			</div> <!-- 인사관리 1개의 출력구역 e -->
		</div>	
			
			

	<script src="hrm.js" type="text/javascript"></script>

</body>
</html>