console.log('datago.js open');

/*
		공공데이터 포털 
	https://www.data.go.kr/
		- 공공데이터 데이터 선택 -> 활용신청 -> Request URL 확인 
		
	$.ajax({
		url : "신청한공공데이터 Request URL" ,
		method : "GET" , 
		data: {} ,
		success : r => {} , 
		error : e => {} 
	})
*/

// 1. 안산시 착한가격업소 API 호출 
apil();
function apil(){
	
	   $.ajax({
      url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=10&serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D",      
      data : {},      
      method : "get",   
      success : response => {
		  console.log( response );
		  let data = response.data; console.log(data);
		  console.log( data[0] );
		  console.log( data[0].업소명 );
		  
		  // 1. 출력할 dom객체 
		  let apiTable1 = document.querySelector('.apiTable1');
		  
		  // 2. HTML 구성 
		  let html = ``;   
		  	// 2-2 
		  	// 배열명.forEach( ( 반복변수명 ) => { 반복코드 } )
		  	// 배열명.forEach( ( 반복변수명 , 인덱스 ) => { 반복코드 } )
		  data.forEach( ( d , i ) =>{
			  html += `<tr>
			 		<td>${ i+1 }</td>
					<td>${ d.업소명 }</td>
					<td>${ d.소재지도로명주소 }</td>
					<td>${ d.연락처 }</td>
					<td>${ d.품목1 } / ${ d.가격1 }</td>
					<td>${ d.품목2 } / ${ d.가격2 }</td>
					<td>${ d.품목3 } / ${ d.가격3 }</td>
				</tr>`
			  
		  });
	
		  // 3. 출력할 위치에 HTML 대입 
		  apiTable1.innerHTML = html;
	  } ,       
      error : e => {} ,         
   });
	
}// f  e

/*

	카카오 개발자 센터 
		https://developers.kakao.com
		1. 애플리케이션 추가 
		2. 플랫폼 사이트 도메인 등록
		
		http://apis.map.kakao.com

*/

 
// ------------------------------- 1. 카카오 지도를 출력하는 객체 ------------------------ //
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    enter : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
    level : 14 // 지도의 확대 레벨 
});

// ----------------------------------- 마커 이미지 설정 -------------------------------- //
// 마커 이미지의 주소
var markerImageUrl = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png', 
	markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
	markerImageOptions = { 
	offset : new kakao.maps.Point(25, 22)// 마커 좌표에 일치시킬 이미지 안의 좌표
};

// -------------------------------- 마커 이미지를 생성하는 객체 --------------------------------- //
var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);


// ------------------------------- 2. 마커 클러스터를 생성합니다. ------------------------ //
// 마커 클러스터러를 생성합니다 , 맵을 clusterer에 담는다. 
var clusterer = new kakao.maps.MarkerClusterer({
	map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 7 // 클러스터 할 최소 지도 레벨 // clusterer 를 적용되는 레벨 
});


// --------------------------------3. 마커 클러스터러에 추가할 여러개 마커 를 생성합니다  ---------------------- //
// 데이터를 가져오기 위해 jQuery를 사용합니다
  // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다  												  페이지번호 
$.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=10&serviceKey=N9u8cpxn1pSHN82TA1627ljRCp2%2FgiT8cnr44fCjiE%2FyK04B0apbzF6B8CZSvV%2F2wg6kFKmVtpiblGHrXZb0JQ%3D%3D", 
		function(response) { // response 안에 data가 있다.
			console.log(response);
		// response : 공공데이터 응답 객체 
		// response.data : 응답객체내 검색된 전기차중전소 목록/배열/인덱스 
 
var markers = $(data.positions).map(function(i, position) { 
	// 1. map에는 94개의 데이터를 저장시키고있다.
	
	console.log(i); // 반복 인덱스 
	console.log(position); //   
	
	// 개별 마커 생성후 
	// let marker = new kakao.maps.Marker({  })
	let marker = new kakao.maps.Marker({  
		position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)']) ,
		image : markerImage, // 마커의 이미지
	});
// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
kakao.maps.event.addListener(marker, 'click', function() {
	
	let html = ``;
	
	html += `<div> 충전소명 : ${ position.충전소명 } </div>`;
	html += `<div> 충전소명 : ${ position.충전기타입명 } </div>`;
	html += `<div> 충전소명 : ${ position.운영기관명 } </div>`;
	html += `<div> 충전소명 : ${ position.소재지도로명주소 } </div>`;
	
	document.querySelector('.datailbox').innerHTML = html;
	
});
	
	// 생성된 마커 리턴 
    return marker;
});

// 클러스터러에 마커들을 추가합니다 , markers를 clusterer에 저장한다.
clusterer.addMarkers(markers);
});
/*
	$.ajax({ url:"" , method:"" , data:{} , success:()=>{} });
	$.method()
	
	객체내 속성명호출할때는 
		객채명.속성명   이 일반적이다
		근대 객채명['속성명'] 이렇게도 사용하는데 주로 속성명에 
		
	for문을쓰면 배열과 많이 사용하는데 for(let i = 0; i<)
	
	for 문 
		- 배열명 : arrayList
		
		1. 배열의 길이만큼 인덱스 0부터 배열의 길이만큼 반복 
			for(let i = 0; i<arrayList.length; i++){}
		
		2. 배열의 젓번째 인덱스부터 마지막인덱스까지 반복
			for( let 반복변수 in arrayList ){}
		
		3. 배열의 첫번째 데이터 부터 마지막 데이터까지 반복 
			for( let 반복변수 of arrayList ){}
		
		4. 배열의 첫번째 데이터 부터 마지막 데이터까지 반복 [ 리턴값을 줄수없다 ]
			arrayList.forEach( (반복변수)=>{ } )
			arrayList.forEach( (반복변수,인덱스변수)=>{ } )
			arrayList.forEach( (반복변수,인덱스변수,배열)=>{ } )
		
		5. 배열의 반복변수orㅁ인덱스를 첫번째부터 마지막 반복한다 [ 리턴값을준다 ] => 새로운 배열에 저장할수 있다. 
		
		let returnArrays = arrayList.map( (반복변수 , 인덱스변수)=>{return} )
	
*/ 

let arrayList = [ 'a' , 'b' , 'c' , 'd' ]
console.log("-----------------");
for(let i = 0; i<arrayList.length; i++){}

console.log("-----------------");
for(let data1 in arrayList ){ console.log(data1) }

console.log("-----------------");
for(let data2 in arrayList ){ console.log(data2) }

console.log("-----------------");
for(let data3 in arrayList ){ console.log(data3) }

console.log("-----------------");
arrayList.forEach(  );

/*
// 1. 접속한 브라우저의 GPS 좌표 얻기 [ geolocation ]
navigator.geolocation.getCurrentPosition( pos => { 
	console.log( pos ); 
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	// 내가 접속한위치에 카카오지도에다가 안에 넣어줘야한다 	
	
	// 카카오 지도 출력 
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng( lat, lng ), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng( lat, lng ); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);
	
}); // f e

*/ 

/*

// 카카오 지도 출력 
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

*/















































