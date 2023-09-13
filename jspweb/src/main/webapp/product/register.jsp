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
	<!--  -->
	<div class="webcontainer">  <!-- 제품등록 전체구역 -->
	
		<form class="registerForm">
			카테고리 : <select name="pcno">
						<option value="1"> 노트북 </option>
						<option value="2"> 테블릿 </option>
						<option value="3"> 냉장고 </option>
					</select> <br/>
			제품명 :  <input name="pname" type="text" /> <br/>
			제품설정 : <textarea name="pcontent"></textarea> <br/>
			제품가경 : <input name="pprice" type="number" /> <br/>
			
			<!-- 1. 제품파일 1개일때. -->
			<!--  제품이미지 : <input name="pimg" type="file" /> <br/> -->
			
			<!-- 2. 제품파일 여러개일때. input 속성에 multiple 추가 -->
			제품이미지 : <input name="pimg" type="file" multiple="multiple" /> <br/>
			<!-- multiple="multiple" 속성 사용시 cos.jar에서는 여러개 파일명 호출이 불가능하다. -->
			<!-- 해결방안 : 1. multiple="multiple" 사용하지않고 input 여러개 사용한다 -->
			<!-- 해결방안 : 2. multiple="multiple" 사용하고 cos.jar 대신 commons.jar 사용한다. -->
			
			<button onclick="onRegister()" type="button"> 등록 </button>
		</form>
	
	</div> <!-- 제품등록 전체구역 e -->


	<!-- js -->
	<script src="/jspweb/js/product/register.js" type="text/javascript"></script>

</body>
</html>
<!--
		<h3> 제품 등록 페이지 [ form 태그 없이 전송하는경우 ] </h3>
		<div>
			제품명 : <input class="pname1" type="text" /> <br>
			제품설명 : <textarea class="pcontent1"></textarea> <br>
			<button onclick="register1()"> 등록1 </button>
		</div>
		
		<h3> 제품 등록 페이지 [ form 태그 이용해서 전송하는경우 2 ] </h3>
		<form class="registerForm1">
			
			<div>
				제품명 : <input name="pname1" type="text" /> <br>
				제품설명 : <textarea name="pcontent1"></textarea> <br>
				<button onclick="register2()"> 등록1 </button>
			</div>
		
		</form>
		 -->