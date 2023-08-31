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
	
	<div class="webcontainer"> <!-- 회원가입전체구역 --> 
		<form class="signupForm"> <!-- 폼 전송시 각 input에 name속성을 활용해야한다. -->
			
			<h2> 이젠 개발자 커뮤니티 회원가입 </h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다. </p>
			
			<div class="intitle"> 아이디 </div>
			
			<input maxlength="30" onkeyup="idcheck()" name="mid" class="mid" type="text"/>
			<span class="idcheckbox"> </span>
			
			<div class="intitle"> 비밀번호 </div>
			<input maxlength="20" onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" />
			
			<div class="intitle"> 비밀번호 확인 </div>
			<input maxlength="20" onkeyup="pwcheck()" class="mpwdconfirm" type="password" />
			<span class="pwcheckbox"></span>
			<br/>
																		
			<div class="intitle"> 이메일 </div>									
			<div class="emailbox">			
				<input onkeyup="emailcheck()" name="memall" class="memall" type="text" />
				<!-- disabled : 버튼사용불가능 -->
				<button class="authReqBtn" onclick="authReq()" disabled type="button">인증요청</button><br/>
			</div>
			<div class="authbox"><!-- 인증버튼 클릭시 보이는구역 --></div>
			
			<!--  <span class="timebox">02:00</span> -->
			<!--  이메일 인증코드 : <input class="ecode" type="text" /> <button type="button">인증</button><br/> -->
			
			<span class="emailcheckbox"></span>
			<br/>
			
			<div class="intitle"> 프로필 </div>
			<input onchange="preimg(this)"  name="mimg" class="mimg" type="file" accept="jpeg/*"/>
				<!-- <태그명 이벤트명="함수명( this )"> -->
			<img class="preimg" alt="" src="img/default.webp" /> <!-- 등록 사진을 미리보기 할 사진 태그 -->
			
			<button class="signupbtn" onclick="signup()" type="button" >회원가입</button>
		</form>
	</div>

	<script src="../js/signup.js" type="text/javascript"></script>

</body>
</html>