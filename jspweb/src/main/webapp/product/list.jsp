<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/list.css" rel="stylesheet" />
	
	<!-- 부트스트랩 css 호출 -->
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>

	<%@include file ="../header.jsp" %>
	
	<div class="mapcontent"> <!-- 지도와 사이드바 포함/전체구역 -->
	
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map"></div>
	
		<!-- 사이드바 구역 -->
		<div class="sidebar">
		
			<!-- 카드 start -->
			 <!-- mb-3 : m : margin , b : bottom -->
			  <!-- row : flex역할 하위 요소를 가로배치 / g-0 : 여백제거 , 기본간격제거 -->
			     <!-- col : 구역마다 12그리드(12개의 col이 존재한다.) -->
			  
			<!-- 카드 end -->
			
		</div>
	
	</div> <!-- 지도와 사이드바 포함/전체구역 e -->
	
	
	 <!-- 부트스트랩 js 호출 -->
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<!-- 카카오개발자api --> <!-- 발급받은키? : 카카오개발자 로그인후 내애플리케이션들어가서 내가발급받은 키 복붙하기 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e25da2ed3ee631d5d760e3887f3da1b8&libraries=clusterer"></script>

	<!-- js -->
	<script src="/jspweb/js/product/list.js" type="text/javascript"></script>

</body>
</html>

<!-- 

	<div class="card mb-3" style="max-width: 540px;"> 
			  <div class="row g-0">  
			    <div class="col-md-4"> 
			      <img src="..." class="img-fluid rounded-start" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Card title</h5>
			        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
			      </div>
			    </div>
			  </div>
			</div> 


 -->