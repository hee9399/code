<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css 통신 -->
	<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet">
	
	<!-- 부트스트랩 css -->
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

	<!-- 폰트어썸 : 웹에서 아이콘(이미지) -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

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
				<textarea onkeyup="onEnterKey()" class="msg">  </textarea>
				<button onclick="onSend()" type="button"> 전송 </button>
			</div>
			
			<!-- 이모티콘 , 첨부파일 등등 구역 -->
			<div class="dropdown">
			  <button class="emobtn" type="button" data-bs-toggle="dropdown" >
			  	<i class="far fa-grin-squint"></i> <!-- 폰트어썸의 아이콘 -->
			  </button>
			  <ul class="dropdown-menu emolistbox">
			    <img src="/jspweb/img/imoji/emo1.gif" />
			    <img src="/jspweb/img/imoji/emo2.gif" />
			    <img src="/jspweb/img/imoji/emo3.gif" />
			    <img src="/jspweb/img/imoji/emo4.gif" />
			    <img src="/jspweb/img/imoji/emo5.gif" />
			  </ul>
			</div>
			
		</div>
	
	</div>

	<!-- 부트스트랩 js -->
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

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
			
				알림 메시지 
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



