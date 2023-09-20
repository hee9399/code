



// 0. 카카오맵 옵션 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

 // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });
    
    
    
    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
    
// 1. 현재 보고 있는 지도의 동서남북 좌표 얻기 
getInfo();    
function getInfo() {

    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds(); // getBounds 안에 남 , 서 , 북 , 동 순서로 저장되어 있다.
    console.log( bounds );
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); // 남서쪽
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); // 북동쪽
    
    // lat : 위도[ +-90 ] , lng : 경도 [ +-180 ]
    let 북 = neLatLng.getLat(); 
    let 남 = swLatLng.getLat(); 
    let 서 = swLatLng.getLng(); 
    let 동 = neLatLng.getLng(); 
	
	
    findByLatLng( 동 , 서 , 남 , 북 ); // 2번 함수 실행 , 2번 함수가 동 , 서 , 남 , 북 을 받는다. 
    
}
    
    
// 2. 해당 동서남북 좌표에 범위내 제품만 출력하기 , 아작트를 이용해서 컨트롤러에게 전달해야한다. 
function findByLatLng( east , west , south , north  ){
	
	clusterer.clear(); // * 클러스터내 모든 마커를 초기화 한다. 
	 
	$.ajax({
      url : "/jspweb/ProductInfoController",  
      async : false  , /* 
      							ajax통신은 기본적으로 비동기(결과를 기다리지않는다) 통신이므로 false값을 넣어주면 동기화를 해준다는의미이다. 
      							비동기(  async : true )
      						*/     
      data : { type : "findByLatLng" , east : east , west : west , south : south , north : north  },      
      method : "get" ,   
      success : jsonArray => {console.log(jsonArray); 
      
      	// 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = jsonArray.map( (p) => {
			console.log( p );
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng)
            });
        });
      		// 클러스터러에 마커들을 추가합니다
        	clusterer.addMarkers(markers); // 마커들을 클러스터에 저장한다.
        	
        	// --------------------------- 2. 사이드바에 제품 출력 ------------------------------------------- // 
        	
        	let sidebar = document.querySelector('.sidebar');
        	let html = ``;
        	
        	jsonArray.forEach( (p) => {
				
				html += `<div class="card mb-3" style="max-width: 540px;"> 
						  <div class="row g-0">  
						    <div class="col-md-5"> 
						      <a href="/jspweb/product/view.jsp?pno=${p.pno}">
						      <img src="/jspweb/product/img/${ Object.values(p.imgList)[0] }" class="img-fluid rounded-start" alt="...">
						      </a>
						    </div>
						    <div class="col-md-8">
						      <div class="card-body">
						        <h5 class="card-title">${p.pname}</h5>
						        <p class="card-text">
						        	<div> ${p.pcontent} </div>
						        	<div> ${p.pprice.toLocaleString() }원 </div>
						        </p>
						      </div>
						    </div>
						  </div>
						</div> `;
				
			});
        	sidebar.innerHTML = html; 
      } ,       
      error : e => {} ,         
   });
	
}// f  e
    
// 3. 카카오 지도에서 드래그를 하고 끝났을때 1번함수 재실행 
kakao.maps.event.addListener( map, 'dragend' , function() { 
	 getInfo( ); // 1번 함수 실행 
	
 });
   
    
/*

		$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByAll" },      
      method : "get" ,   
      success : jsonArray => {console.log(jsonArray); 
      
      	// 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = jsonArray.map( (p) => {
			console.log( p );
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng)
            });
        });
      		// 클러스터러에 마커들을 추가합니다
        	clusterer.addMarkers(markers);
      } ,       
      error : e => {} ,         
   });

*/     
    
    
    
    
    
    
    
    
    
    
    
    
    
























