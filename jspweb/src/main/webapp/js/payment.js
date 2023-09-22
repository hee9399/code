
// 1. 테스트 
// setPoint( 1000 , "회원가입축하" );

// 포인트 사용시 테스트 
// setPoint( -500 , "이모티콘구매");
// getPoint();
// getPointList();


// 1. 포인트 사용 함수 [ mno는 서블릿이 (로그인 세션)알고있다. ]
function setPoint( mpamount , mpcomment ){
	
	if( loginState == false ){ return; }
	
	let returnData = false; 
	
		   $.ajax({
		      url : "/jspweb/PointController" ,  
		      async: false , /* ajax가 응답이 올때까지 대기상태 = 동기식 */    
		      data : { mpamount : mpamount , mpcomment : mpcomment },      
		      method : "post",   
		      success : r => { console.log(r);
		      
		      // 포인트 사용 함수 만 기능처리 할꺼기때문에 
		      	returnData = r;
		      
		      } ,       
		      error : e => {} ,         
		   });
		   
		   return returnData; /* ajax 결과를 리턴하는 방식 */
	
}//f e

// 2. 내 프린트 확인 함수 
function getPoint(){
	
	if( loginState == false ){ return; }

			$.ajax({
		      url : "/jspweb/PointController",      
		      data : { type : 1 },      
		      method : "get",   
		      success : r => { console.log(r);
		      
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
		      success : r => { console.log(r);
		      
		      } ,       
		      error : e => {} ,         
		   });
	
	
}// f  e


// ----------------------------- 아임포트 ---------------------------------- //

// 1. 아임포트 관리자 식별키 
IMP.init('imp14264585') // 예: 'imp00000000a'

// 2. 결제 함수 [  ]
function requestPay() {
	
	// 2-1. : 만약에 결제방식을 선택을 안했으면 
	if( pay_method == '' ){ alert('결제방식을 선택해주세요'); return; }
	if( pay_method == amount ){ alert('결제방식을 선택해주세요'); return; }
	
	// 2-2. : 주문번호 만들기 
		// * 주문번호는 고유성이있는것을해야한다 왜? 중복이 있으면안되기때문에 
		// 1. 날짜(밀리초) + 상품코드(제품의pk) + 회원번호 조합해서 설계 
		// 2. 회사 전화번호 + 사업자번호 조합해서 설계
			// --- 등등 
		let now = new Date(); 			console.log( now );  // 현재날짜 ,
		let time = now.getTime();		console.log( time );  // 현재시간[ 밀리초로 가져옴 ] ,
		let merchant_uid = "p"+time+"-"+loginMid; console.log(merchant_uid);
		
	
    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method: pay_method , // onPayMethod() 함수에 전달 
      merchant_uid: "ORD20180131-0000011",   // 주문번호[]
      name: "포인트결제" ,
      amount: amount ,  // onAmount() 함수에게 전달 
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "경기도 안산시 상록구",
      buyer_postcode: "12345"
    }, function (rsp) { // callback
    	console.log( rsp );
    	if( rsp.success ){ // 결제 성공 
			
			
		}else{ // 결제 실패 [ 테스트: 실패가 성공이라는 가정 ]
			alert( '결제성공' );
			
			// 1. 포인트 적립 기능처리 
			let result = setPoint( amount , '포인트결제' ); 
			
			// 2. 결제내역 테이블 기능처리 [ 구현x ]
			
			/* 
				f12 개발자도구에 저장됨 
				
				error_msg: "사용자가 결제를 취소하셨습니다"
				imp_uid: "imp_797532967651"
				merchant_uid: "ORD20180131-0000011"
				pay_method: "card"
				pg_provider: "html5_in.icis"
				pg_type: "payment"
				success: false
			
			*/
			
		}
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
    });
  }

// 3. 결제 방식 선택 함수 
let pay_method = ''; // 결제방식 
function onPayMethod( method ){ pay_method = method; }


// 4. 결제 금액 선택 함수 
let amount = 0; // 결제금액
function onAmount( value ){ amount = value; }















