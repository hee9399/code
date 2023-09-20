
// findByPno( 3 ); // 테스트 
// findByLatLng() // 테스트 불가 
// findByAll(); // 테스트

findByTop( 10 ); // 메인페이지에 최신등록된 제품 10개출력  
// 1. N개 제품들을 최신순으로 출력 함수 
function findByTop( count ){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByTop" , count : count },      
      method : "get",   
      success : jsonArray => { console.log(jsonArray); 
      
      	let productBox = document.querySelector('.productBox');
      	console.log(productBox);
      	
      	let html = ``;
      	
      		jsonArray.forEach( (p) =>{
				 // * 대표 이미지 출력하기 [ 첫번째 이미지 ] / oObject.keys(객체명) : 해당 객체내 모든 속성명 
				 	// 유효성검사 필요함 이미지 1개 이상출력 	 
					
				 let firstImg = Object.values(p.imgList)[0];	 
				   // console.log( Object.values(p.imgList) );	
				   // console.log( Object.values(p.imgList)[0] );
				 
				html = `<div class="col">
						    <div class="card" style="height:450px; border: none;">
						      <a href="/jspweb/product/view.jsp?pno=${p.pno}">
						      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="..." style="height:300px; border-radius: 50px; box-shadow: 0px 0px 5px #e8e8e8;">
						      </a>
						      <div class="card-body">
						        <h5 class="card-title">${p.pname}</h5>
						        <p class="card-text">
						        	<div> ${p.pcontent} </div>
						        	<div> ${p.pprice.toLocaleString() }원 </div>
						        </p>
						      </div>
						    </div>
						 </div>`;
			});
      	productBox.innerHTML = html; 
      
      } ,       
      error : e => {} ,         
   });
	
}// f  e



/*
	자바스크립트 객체 [ 필드 = 속성 = 키 ]
		형태 : let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터 , 속성명 : 데이터 }
			- 데이터란 : 데이터(상수/변수) , 변수 , 함수 ,. 배열/리스트 등등 이 들어간다.
			
			객체(속성명/필드) 추가할때
				삽입 : 객체명.새로운필드명 = 데이터 
			delete 삭제 : 객체명.삭제할속성명 
				객체명.속성명  또는 객체명['속성명']
				* 사용자정의 함수(우리가 만드는함수) 중에 delete 라는 이름으로 선언 불가능하다 
			ex) function delete() 가 불가능하다 js에서 delete라는 속성명을 지원해주기때문애
			
			호출 : 객체명.속성명 또는 객체명[속성명]
				- Object.keys( 객체명 ) : 객체내 모든 키를 배열로 반환한다.
				
				- Object.values( 객체명 ) : 객체내 모든 값를 배열로 반환한다. , forEach 사용 이유는? 배열 , list 에게 사용한다 
						 - 객체를 배열로반환시킨다. 객체명의 values로 반환시킨다.
				
	자바스크립트 배열/리스트 
		형태 : let 변수명 = [  ]
		배열.push( 데이터 ) - 추가 
		배열명.splice( 인덱스 , 개수 ) - 삭제 
		배열명[인덱스]  - 호출
		
				 console.log(p.imgList);	
				 console.log( Object.keys(p.imgList) );	
				 console.log( Object.keys(p.imgList)[0] );	
				 let firstImg = p.imgList[ Object.values( p.imgList )[0] ]; 

*/ 



/*
// 2. 현재 카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수  
function findByLatLng( east , west , south , north ){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByLatLng" , east : east , west : west , south : south , north : north  },      
      method : "get",   
      success : jsonArray => {console.log(jsonArray); } ,       
      error : e => {} ,         
   });
	
}// f  e

// 3. 선택한 제품번호에 해당하는 제품 출력 함수 
function findByPno(pno){
	
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByPno" , pno : pno },      
      method : "get" ,   
      success : jsonObject => {console.log(jsonObject); } ,       
      error : e => {} ,         
   });
	
}//  f  e

// 4. 
function findByAll(){
	
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByAll" },      
      method : "get" ,   
      success : jsonArray => {console.log(jsonArray); } ,       
      error : e => {} ,         
   });
	
}//  f  e

*/



