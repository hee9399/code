<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css 통신 -->
	<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	
	
	<div class="webcontainer">
	
		<!-- 채팅전체구역 -->
		<div class="chatbox">
		
			<div class="chatcont"> 
			
				<!-- js html 대입되는 자리 -->
			
			</div>	
			<!-- 채팅입력창 , 전송버튼 -->
			<div class="chatbottom"> 
				<textarea class="msg">  </textarea>
				<button onclick="onSend()" type="button"> 전송 </button>
			</div>
		</div>
	
	</div>



	<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>

</body>
</html>

<!-- 


				<div class="rcont">  
					<div class="subcont">
						<div class="date"> 오전 10:02 </div>
						<div class="content"> 안녕하세요. ㅋㅋㅋ </div>
					</div>
				</div>
			
				<div class="alarm"> 강호동님이 입장하셨습니다. </div>
				
		
				
				<div class="lcont">  
			
					<img class="pimg" src="/jspweb/member/img/default.webp" />
					<div class="tocont">
						<div class="name"> 강호동 </div> 
						<div class="subcont">
							<div class="content"> 그래 안녕~~~ </div> 
							<div class="date"> 오전 10:10 </div> 
						</div>
					</div>
				</div>




 -->



