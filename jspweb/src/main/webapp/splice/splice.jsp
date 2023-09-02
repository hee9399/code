<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/splice.css" rel="stylesheet" />
	
	<!-- wavesurfer js라이브러리 다운 -->
	<!--  <script src="//cdnjs.cloudflare.com/ajax/libs/wavesurfer.js/1.4.0/wavesurfer.min.js"></script> -->
	
	<script src="https://unpkg.com/wavesurfer.js"></script>
	
</head>
<body>
	<div class="mainwarp"> <!-- 메인페이지 전체 -->
	
	
		<header>
			<div class="headercontainer">
				<div class="mainlogo1"><a href="#"><img class="mainlogo2" src="/jspweb/splice/img/mainlogo.png" ></a> </div>
				<div class="menu1"> <a href="#"> Sounds </a> </div>  
			</div> 
		</header>
		
				
		
	
		<div class="sample-list">
		    <div class="sample-card">
		        <img src="/jspweb/splice/img/samplelogo1.jpg" alt="Sample 1">
		        <h3>DBM_CK_KICK_18</h3>
		       	<div id="waveform"></div>
				<button onclick="playstop()">play/stop</button>     
		      
		       	
		        <div id="waveform"></div>
		   
		    </div>
		    <div class="sample-card">
		        <img src="" alt="Sample 2">
		        <h3>Sample 2</h3>
		        <div id="waveform2"></div>
				<button onclick="playstop2()">play/stop</button> 
		        
		    </div>
		    <div class="sample-card">
		        <img src="" alt="Sample 3">
		        <h3>Sample 3</h3>
		        
				
		    </div>
		    <!-- 실제 샘플 카드는 Splice Sounds에서 가져온 데이터를 반영해야 합니다. -->
		</div> 
	</div> <!-- 메인페이지 전체 e -->
	
	
	<!--  <script src="http://code.jquery.com/jquery-latest.min.js"> </script> -->
	
	
	
	<script src="splice.js" type="text/javascript"></script>
	
</body>
</html>