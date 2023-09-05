<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/board/list.css" rel="stylesheet"/>

</head>
<body>

	<%@include file = "../header.jsp" %>

	<div class="webcontainer"> <!-- 전체구역 -->
		<div class="boardtop">
			<h2> 게시판 </h2>
			<p> 다양한 사람들과 정보를 공유 하세요. </p>
		</div>
		
		<!-- 2. 싱딘 부가 버튼 -->
		<div class="boardtopetc">
			
			<div>
				
				<select class="bbtn listsize" onclick="onListSize()"> <!-- 하나의 페이지에 표시할 최대 게시물수 -->
				
					<option> 10 </option>
					<option> 15 </option>
					<option> 20 </option>
				
				</select>
				<span class="boardcount"> 게시물수 : 13 </span> <!-- 전체 게시물 수 -->
			</div>
		<button class="bbtn" onclick="onwrite()" type="button">글쓰기</button>
		
		</div>
		<!--  3. 카테고리 구역 -->
		<div class="boardcategorybox">
			<button onclick="onCategory(0)" class="bbtn" type="button"> 전체보기 </button>
			<button onclick="onCategory(1)" class="bbtn" type="button"> 공지사항 </button>
			<button onclick="onCategory(2)" class="bbtn" type="button"> 자유게시판 </button>
			<button onclick="onCategory(3)" class="bbtn" type="button"> 노하우 </button>
		</div>
		
		<!-- 4. 테이블  구역-->
		<table class="boardTable"> </table>
		
		<div class="boardbottom">
		
			<!-- 5. 페이징 처리  구역-->
			<div class="pagebox">
				
				
				<button type="button"> > </button> <!-- 다음 버튼 -->
			</div> <!-- 페이지 버튼 구역 e -->
			
			<!-- 6. 검색 구역 -->
			<select class="bbtn"> <!-- 검색 할 필드명 -->
			
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			
			</select>
			<input class="keyword" type="text"> <!-- 검색 내용 -->
			<button class="bbtn" type="button">검색</button>
			
		</div>
		
	</div><!-- 전체구역 e -->
	
	
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>

</body>
</html>