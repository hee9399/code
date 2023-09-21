<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/view.css" rel="stylesheet" />
	
	<!-- 부트스트랩 css 호출 -->
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	

</head>
<body>
	
	<%@include file ="../header.jsp" %>
	
	<div class="webcontent">
	
		<div class="productBox">
		
			<!-- 캐러셀 start -->
			<div id="carouselExample" class="carousel slide"> <!-- 캐러셀 : 이미지슬라이드 -->
			
			  <div class="imgbox carousel-inner"> <!-- carousel-inner : 캐러셀 안에 넣을 이미지 목록 구역 -->
			    <!-- carousel-item : 이미지 1개당 / active : 현재 보고있는 이미지 -->
			  </div>
			  <!-- 왼쪽 이동 버튼 -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			   <!-- 오른쪽 이동 버튼 -->
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
			<!-- 캐러셀 end -->
			
			<div class="mid">판매자 : 정희락</div>
			<div class="categorydate">
				카테고리 <div class="pcname"> 옷 </div>
				등록일 : <div class="pdate"> 2023-09-19 11:47</div> 
			</div>
			<div class="pname">옷 팝니다.</div>
			<div class="pprice">667,000원</div>
			<div class="pcontent">옷 팝니다.<br>옷 팝니다. 옷 팝니다.</div>
			<div class="etcbtnbox">
				<button onclick="setWish()" type="button"> 찜하기<span class="wish">♡</span> </button>
				<button type="button"> 바로구매 </button>
			</div>
			
			<!-- 탭스 start -->	
				<!-- 탭 목록 -->
			<ul class="mt-5 nav nav-tabs nav-pills nav-fill" id="myTab" role="tablist">
			  	<!-- 리스트 1개당 탭 1개 data-bs-target : 탭버튼을 클릭했을때 활성화됨 -->
			  <li class="nav-item" role="presentation">
			    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#navTap1" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">
			    	제품위치
			    </button>
			  </li>
			  <!-- 리스트 1개당 탭 1개 -->
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#navTap2" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">
			    	제품후기
			    </button>
			  </li>
			  <!-- 리스트 1개당 탭 1개 -->
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#navTap3" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">
			    	QnA
			    </button>
			  </li>
			  <!-- 리스트 1개당 탭 1개 -->
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="disabled-tab" data-bs-toggle="tab" data-bs-target="#navTap4" type="button" role="tab" aria-controls="disabled-tab-pane" aria-selected="false" >
			     	구매 유의사항
			    </button>
			  </li>
			  
			</ul>
				<!-- 탭 내용 -->
			<div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="navTap1" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
			  	제품위치 출력되는 구역
			  </div>
			  <div class="tab-pane fade" id="navTap2" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			  	제품후기 출력되는 구역
			  </div>
			  <div class="tab-pane fade" id="navTap3" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">
			 	QnA 출력되는 구역
			  </div>
			  <div class="tab-pane fade" id="navTap4" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">
			  	구매 유의사항 출력되는 구역
			  </div>
			</div>
			<!-- 탭스 end -->
			
		</div>
	
	</div>
	
	<!-- 부트스트랩 js 호출 -->
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<!-- 카카오개발자api --> <!-- 발급받은키? : 카카오개발자 로그인후 내애플리케이션들어가서 내가발급받은 키 복붙하기 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e25da2ed3ee631d5d760e3887f3da1b8&libraries=clusterer"></script>

	<!-- js -->
	<script src="/jspweb/js/product/view.js" type="text/javascript"></script>

</body>
</html>


<!-- 

	찜하기 기능 하기위한 코드 순서도 
		
		- 1. HTML 에서 setWish() 버튼을 클릭한다. 
		- 2. 버튼 클릭했을때 JS 이벤트 함수 정의 한다. 
		- 3. 
		- 4. 
		- 5. 
		- 6. 
		- 7. 

 -->






















