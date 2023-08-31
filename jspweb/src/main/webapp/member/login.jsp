<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/jspweb/css/member.css" rel="stylesheet"/> 

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<!-- 1. 헤더에서 로그인메뉴를  -->
	
	<div class="webcontainer"> <!-- 회원가입전체구역 --> 
		<form class="signupForm"> <!-- 폼 전송시 각 input에 name속성을 활용해야한다. -->
			
			<h2> 이젠 개발자 커뮤니티 회원가입 </h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다. </p>
			
			<div class="intitle"> 아이디 </div>
			
			<input maxlength="30"  name="mid" class="mid" type="text"/>
			
			
			<div class="intitle"> 비밀번호 </div>
			<input maxlength="20" name="mpwd" class="mpwd" type="password" />
			
			<!-- 로그인 유효성검사 구역 -->
			<div class="logincheckbox">  </div>
			
			<!-- 아이디/비밀번호 찾기 구역 -->
			<div class="findbtnbox">
				<a href="#">아이디찾기</a>
				<a href="#">비밀번호찾기</a>
			</div>
			
			<button class="signupbtn" onclick="login()" type="button" >로그인</button>
		</form>
	</div>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src="../js/login.js" type="text/javascript"></script>

</body>
</html>