<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href = "/jspweb/css/splice.css" rel="stylesheet" />
	
	
	<!-- wavesurfer js라이브러리 불러오기 -->
	<script src="https://unpkg.com/wavesurfer.js"></script>
	
</head> 
<body>
	<div class="mainwarp"> <!-- 메인페이지 전체 -->
	
		<header> <!-- 헤더 -->
			<div class="headercontainer">
				<div class="mainlogo1"><a href="#"><img class="mainlogo2" src="/jspweb/splice/img/mainlogo.png" ></a> </div>
				<div class="menu1"> <a href="#"> Sounds </a> </div>  
			</div> 
		</header>
	
		<div class="sampleList">
		
		    <div class="sampleCard">
		    
		        <img src="/jspweb/splice/img/voximg.png" alt="Sample 1">
		        <h3> PMND_Vocal_Chop_110BPM_03_Bm.wav </h3>
		       	<div class="wavefile" id="waveform"> </div>
				<button class="file1" onclick="playstop()"> play/stop </button>     
		      
		        <div id="waveform"></div>
		   
		    </div>
		    
		</div> 
	</div> <!-- 메인페이지 전체 e -->
	
	
	<!--  <script src="http://code.jquery.com/jquery-latest.min.js"> </script> -->
	<script src="splice.js" type="text/javascript"></script>
	
</body>
</html>

