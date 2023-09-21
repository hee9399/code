
// 1. 테스트 
// setPoint( 1000 , "회원가입축하" );

// 포인트 사용시 테스트 
setPoint( -500 , "이모티콘구매");
getPoint();
getPointList();
// 1. 포인트 사용 함수 [ mno는 서블릿이 (로그인 세션)알고있다. ]
function setPoint( mpamount , mpcomment ){
	
	if( loginState == false ){ return; }
	
		   $.ajax({
		      url : "/jspweb/PointController",      
		      data : {mpamount : mpamount , mpcomment : mpcomment},      
		      method : "post",   
		      success : r => {console.log(r);
		      
		      } ,       
		      error : e => {} ,         
		   });
	
	
}//f e

// 2. 내 프린트 확인 함수 
function getPoint(){
	
	if( loginState == false ){ return; }

			$.ajax({
		      url : "/jspweb/PointController",      
		      data : {type : 1},      
		      method : "get",   
		      success : r => {console.log(r);
		      
		      } ,       
		      error : e => {} ,         
		   });
	
	
}// f  e

// 3. 내 포인트 내역 전체 출력 함수 
function getPointList(){
	
	if( loginState == false ){ return; }
	
			$.ajax({
		      url : "/jspweb/PointController",      
		      data : { type : 2 },      
		      method : "get",   
		      success : r => {console.log(r);
		      
		      } ,       
		      error : e => {} ,         
		   });
	
	
}// f  e






















