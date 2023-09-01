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
	
	
	<div class="webcontainer">
		<h3> 글 쓰기 페이지 </h3>
		<a href="list.jsp"></a>
		
		<form class="writeFrom">  <!-- 쓰기 입력 구역 -->
		
		제목 : <input type="text" name="btitle" class="btitle">
		내용 : <textarea name="bcontent" class="bcontent"></textarea>
		첨부파일 : <input type="file" name="bfile" class="bfile">
		<a href="list">목록보기</a>
		<button type="reset">다시쓰기</button>
		
		</form>
	
	</div>
	
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>

	

</body>
</html>