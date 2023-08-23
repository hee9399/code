<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<!-- css import -->
	<link href="visitlog.css" rel="stylesheet" />


</head>
<body>
	<!-- CRUD 기반의 비회원 게시판/방문록 구현 -->
	<div class="visitwrap"> <!-- 전체구역 -->
		<!-- placeholder - 무엇을입력할지에대한 가이드라인 -->
		<div class="visit_Top"> <!-- 쓰기 구역 -->
		
			<div class="visit_Inputs">
				<input class="vwriter" type="text" placeholder="작성자">
				<input class="vpwd" type="text" placeholder="비밀번호">
			</div>
		
				<textarea class="vcontent"></textarea>
				<button onclick="vwriter()" type="button">등록</button>
			
		</div> <!-- 쓰기 구역 e -->
		
		<div class="visit_Bottom"> <!-- 출력 구역 -->
			<div class="visitbox"> <!-- 방문록 1개의 표시구역 -->
				<div class="visitbox_top">
					<div>유재석</div>
					<div class="visidate">2023-08-22 13:30:50</div>
				</div>
				<div class="visitbox_center">안녕하세요.안녕하세요.</div>
				<div class="visitbox_bottom">
					<button onclick="vupdate()" type="button">수정</button>
					<button onclick="vdelete()" type="button">삭제</button>
				</div>
			</div> <!-- 방문록 1개의 표시구역 e -->
			
		</div> <!-- 출력 구역 e -->
		
	</div> <!-- 전체구역 e -->

	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script src="visitlog.js" type="text/javascript"></script>

</body>
</html>