console.log('js실행됩니다');

// 제품등록은 회원제 이므로 비로그인시 접근 제한
if( loginState == false ){
	alert('로그인후 사용가능한 페이지'); location.href="/jspweb/";
}


// 6. ------------------------------------- 카카오 지도 표시 ---------------------------------------------------------------------

	// 1. 현재 접속한 사용자의 클라이언트[브라우저] 의 위치 좌표 구하기 
navigator.geolocation.getCurrentPosition( e => { // 내위치를 갖고오는 함수 
	
	console.log( e ); // 남의꺼의 객체를 사용할때 콘솔 무조건 찍어보기 
	console.log( e.coords );
	console.log( e.coords.latitude );   // 위도 
	console.log( e.coords.longitude );  // 경도
	let currentlat = e.coords.latitude;
	let currentlng = e.coords.longitude;

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div , 카카오지도를 표시해줄 역할
	    mapOption = { 
	        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	    plat = latlng.getLat(); 	// 위도와 경도를 전역변수로 이동후 제품등록시 사용.
	    plng = latlng.getLng(); 	//  
	    
	});


} );// getCurrentPosition  end

let plat = 0; 	// 위도 , 현재 카카오지도에서 선택한 좌표. 초기값은 0;
let plng = 0;	// 경도 


// ---------------------------------------------------------------------------------------------------------------------- //
// 1. 제품 등록
function onRegister(){
	
	// 1. from dom객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0]; 
	console.log('registerForm도착'+registerForm);
	
	// 2. formData 객체생성 [ ajax 전송타입 : multipart/form-data ]
	let formData = new FormData(registerForm);
	console.log(formData);
	
		// *** 카카오지도에서 선택된 좌표 사용했을때.
		if( plng == 0 || plat == 0 ){alert('제품위치를 선택해주세요.'); return; }
		formData.set( 'plat' , plat ); 
		formData.set( 'plng' , plng );
	
		// *** 드랍앤드랍을 사용했을때. 
			// 현재 드랍된 파일들을 form 같이 추가하기 [ 왜? 드랍된 파일은 input태그 드랍된 파일이 아니므로 ]
				// 반복문 사용해서 담아준다. 
		if( fileList.length >= 1 ){ // 만약에 드랍된 파일이 존재하면. , 드랍된파일이 1개 이상이면
			
			fileList.forEach( f =>{ 
				//  폼데이터객체에 데이터를 추가하는방법. ,
				// 폼데이터객체.set( '키/필드명/속성명' , 값 );  : 만약에 기존의 동일한 키 가 있으면 덮어쓰기 되므로 기존 사라짐
				// 폼데이터객체.append( '키/필드명/속성명' , 값 ); : 만약에 기존의 동일한 키 가 있으면 해당 키에 데이터 추가
				// FormData.set( 'file1List' , f ); 
				formData.append( 'file1List' , f );
				
			})
			
		}
	
	
	// 3. 
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : formData ,      
      method : "post",   
      // 1. text/html , 2. application/json , 3. multipart / form-data
      contentType : false , // form은 multipart속성이기때문에 json타입을 사용하지않는다. 
      processData : false ,
      success : r => {
		  console.log(r);
		  
		  if( r == true ){
			  alert('제품등록성공');
			  location.href="/jspweb/index.jsp";
		  }else{
			  alert('제품등록실패');
		  }
		  
	  } ,       
      error : e => {
		  console.log(e);
	  } ,         
   });
	
}//f  e


// 2. 드래그 앤 드랍 [이미지를 드래그해서 넣는다.]
	// 1. 드래그 앤 드랍할 구역 dom객체 호출 
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom객체에 구역내 드래그가 들어왔을때 
fileDropBox.addEventListener( "dragenter" , (e) => {
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트를 우선 할당하겠다.
	console.log('드래그가 들어왔어.');
	
	
} );

	// 3. 해당 dom객체에 구역내 드래그가 올라왔을때.
fileDropBox.addEventListener( "dragover" , (e) => { 
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트를 우선 할당하겠다.
	console.log('현재구역에 드래그가 위치중이야.');
	// 해당 fileDropBox는 div속성이기 때문에 js안에서도 style속성 가능하다.
	fileDropBox.style.backgroundColor = 'e8e8e8';
});

	// 4.  해당 dom객체에 구역내 드래그가 나갔을때.
fileDropBox.addEventListener( "dragleave" , (e) => { // 
		e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트를 우선 할당하겠다.
		console.log('드래그가 나갔을때');
		fileDropBox.style.backgroundColor = 'ffffff';
		
} );

	// 5.  해당 dom객체에 구역내 드래그가 드랍했을때.(마우스를 놓았을때)
fileDropBox.addEventListener( 'drop' , (e) => { // e는 drop에서 실행된 정보를 가져다주는 함수이다.
		console.log('해당 드래그가 드랍했어.');
		// * 브라우저 자체적으로 'drop' 이벤트가 우선적으로 실행되므로 해당 이벤트실행 
		// 해결방안 : 기존 상위(브라우저/크롬) 이벤트를 무시해야한다. 
		e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트를 우선 할당하겠다.
		
		// -------------------------------- 드랍된 파일의 정보?? -------------------------------------- //
			// 1. 드랍된 데이터 정보를 이벤트 겨로가에서 찾기 
				// dataTransfer - 라이브러리에서 지원하는 객체 
					// 객체는 포장지인데 포장지안에있는 순서와 이름을 꺼낸다.
			console.log(e.dataTransfer );
			console.log(e.dataTransfer.files ); 		// 라이브러리자체에서  files 해당파일의 정보를 List로 전달함. 
			console.log(e.dataTransfer.files[0] );		// List는 배열이기때문에 인덱스를 넣어준다.
			console.log(e.dataTransfer.files[0].name ); // .name : 파일의 이름 가져오기 
			
			// 2. 드랍된 파일들을 특정 리스트에 저장
			let files = e.dataTransfer.files;
			
			for( let i = 0; i<files.length ; i++ ){ 
				// 마냐게 files 에값이 null이 아니면서  undefined 값이 아닌상태라면 
				if( files[i] != null && files[i] != undefined ){
					
					// 드랍된 파일의 정보가 존재하면 [ null 그리고 undefined 아닌 상태 ]
					
					fileList.push( files[i] );
					
				}// if e
			}
			// 3. 배경색 초기화 
			fileDropBox.style.backgroundColor = 'ffffff';
			// 4. 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시 
			fileListPrint();
			
} ); // f  e

// 현재 드래그앤 드랍으로 등록된 파일들 
let fileList = []; // html

// 3. 현재 드랍된 파일들의 정보를 구역에서 표시하는 함수 
function fileListPrint(){
	
	// 1. [어디에] fileDropBox 에 [ fileDropBox dom객체가 함수밖에 존재하므로 재호출x ]
	// 2. [ 무엇을 ] HTML구성
	let html = ``;
		fileList.forEach( ( f , i )  => {
			
			let fname = f.name; // 파일의 이름 
			let fsize = (f.size/1024).toFixed(1) // 파일의 용량 [ 바이트 단위 ] kb 변환 
					// .toFixed(소수점단위) : 소수점 자르기 
			
			html += `<div>
			<span> ${fname} </span>
			<span> ${fsize} </span>
			<span> <button onclick="fileListDelete( ${i} )" type="button"> 삭제 </button>  </span>
		</div>`; // fileListDelete( ${i} ) - i번째 파일 삭제한다.
			
		})//  forEach e
		// 3. [대입]
		fileDropBox.innerHTML = html;
			
};//f  e

// 4. 현재 드랍된 파일들 중에 삭제버튼 클릭시 해당 파일 제거 
	// splice( i , 1 ) : i번째 1개 삭제한다. , fileListPrint(); 새로고침한다
function fileListDelete( i ){ fileList.splice( i , 1 ); fileListPrint(); } 


let object 


// 5. 메인페이지에 10개 최신순으로 출력
	

// 6. 카카오에서 현재 보고있는 범위 만큼의 좌표( 동서남북 -> js카카오톡 api 제공 ) 범위내 포함된 제품


// 7. 선택된 제품의 개별출력 [ ex) 아뜨랑스/다방/직방 ]
 
 
// 8. 관리자 입장의 제품 모두 출력 [ 페이징 처리 ] ( ex) 관리입장의 제품 모두 출력해서 관리 )



	/*
	
		// 스크립트는 html에서 의존해서 실행된다 
		// html은 브라우저에서 실행된다. 
		- 브라우저안에 html이 켜지고 html안에 스크립트가 켜진다. , 서블릿은 톰캣내 서블릿과 통신한다 스크립트의 ajax로 통해서
		스크립트는 ajax로 통해서 외부에있는 소켓 과 통신한다. 
		
		// 브라우저/소프트웨어 자체가 drop 이라는 이벤트가 넣어져있다.
	
		dom객체 이벤트 추가하는 방법 2가지. 
			가정 : 특정 구역에서 클릭(onclick) 이벤트 추가 
			1. HTML 속성 이벤트 사용하는 방법 
				<button onclick="" type="button"> </button>
				
			2.	.addEventListener( '이벤트명' , 함수 ) : 사용하는방법 
				let button = document.querySelector('button');
				button.addEventListener( 'onclick' , 함수 );
				
		이벤트
			
			종류: click , keyup , keydown 등등 
			- 정의 : 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트의 결과물을 반환해주는 구조이다. 
			클릭이벤트의 대한 실행을해주는건 js가 해주는것이다 조건이 충족했을때 
			
			ex) <button onclick="함수(e)" type="button"> </button>		
			
					
	 	드래그 앤 드랍 관련 이벤트
	 		1. ondragenter 	: 
	 		2. dragover 	: 
	 		3. dragleave 	: 
	 		4. drop			:
	 		
	 		
	*/












/*  
// 1. form 사용하지 않았을때
function register1(){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : {
		  pname1 : document.querySelector('.pname1').value ,
		  pcontent1 : document.querySelector('.pcontent1').value
		  
	  },      
      method : "post",   
      success : r => {
		  console.log(r);
	  } ,       
      error : e => {} ,         
   });
	
}// f  e

// 2. form 사용시
function register2(){
	
	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData(registerForm1);
	// formData 에는 multipart속성이 있기때문에 multipart타입을 사용한다.
	
		   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : formData ,      
      method : "post",   
      // 1. text/html , 2. application/json , 3. multipart / form-data
      contentType : false , // form은 multipart속성이기때문에 json타입을 사용하지않는다. 
      processData : false ,
      success : r => {
		  console.log(r);
	  } ,       
      error : e => {} ,         
   });
	
}//  f  e
*/