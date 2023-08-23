<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  -->
	<!--  CRUD 기반의 가계부 만들기 -->
	<div class="accountwrap"> <!-- 전체 구역-->
		
		<div class="accountname"> <!-- 가계부 제목 -->
			<h2>가계부</h2>
		</div> <!-- 가계부 제목 e -->
		
		<div class = "account_Top"> <!-- 쓰기 구역 -->
		
			<div class="account_Input"> <!-- 입력구역 -->
				<!-- 내용입력  -->
				<input class = "awriter" type="text" placeholder="항목내용">
				<!-- 금액입력 -->
				<input class = "amoney" type="text" placeholder="금액을 입력해주세요">
				<!-- 날짜입력 -->
				<input class = "adate" type="date" >
			</div> <!-- 입력구역 e -->
			
				<!-- 등록버튼 -->
				<button onclick="awriter()">등록</button>
		
		</div> <!-- 쓰기 구역 e -->
		
		<div class="account_Bottom"> <!-- 출력 구역 --> 
			<div class="accountbox"> <!-- 가계부 1개의 표시구역 -->
				<div class="accountbox_top">
					<div>적금</div>
				</div>
				<div>10000원</div>
				<div> <!-- 버튼 구역 -->
					<button onclick="aupdate()" type="button">수정</button>
					<button onclick="adelete()" type="button">삭제</button>
				</div> <!-- 버튼 구역 e -->
			</div> <!-- 가계부 1개의 표시구역 e-->
		</div> <!-- 출력 구역 e --> 
		
		
	
	</div> <!-- 전체 구역 e-->
	
	
	
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 스크립트 호출 -->
	<script src = "accountbook.js" type="text/javascript"></script>

</body>
</html>