console.log('1_AJAX통신.js Open');

// 1. 예제1
function 예제1(){console.log('예제1() Open')
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax( { } )
	$.ajax({
		url : "http://192.168.17.21/jspweb/Test02",
		success : function 함수명(result){console.log(result);}
		
	});
} // function e

// 1. 예제2
function 예제2(){console.log('예제2() Open')
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax( { } )
	$.ajax({
		url : "http://192.168.17.21/jspweb/Test03",
		success : function 함수명(result){console.log(result);}
		
	});	
	
} // function e

// 1. 예제3
function 예제3(){console.log('예제3() Open')
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax( { } )
	$.ajax({
		url : "http://192.168.17.21/jspweb/Test04",
		success : function 함수명(result){
			console.log(result);
			console.log(result.title);
			console.log(result.content);
			}
		
	});	
	
} // function e

// 1. 예제4
function 예제4(){console.log('예제4() Open')
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajax( { } )
	$.ajax({
		url : "http://192.168.17.21/jspweb/Test05",
		success : function 함수명(result){
			console.log(result);
			console.log(result.title);
			console.log(result.content);
			}
		
	});	
	
} // function e

/*
	스크립트와 자바는 언어가 다르기때문에 return이 불가능하다 따라서 스크립트와 자바가 서로 
	통신 하려면 ajax(아작트)를 사용한다.
	
	$.ajax({
		url : "통신할경로/서블릿주소" ,
		method : "통신방법:get,post,put,delete 선택" ,
		success : function 함수명( 통신반환변수 ) { 통신성공했을때 실행코드 } ,
		error : function 함수명( 통신반환변수 ) { 통신성공했을때 실행코드 } 
		
	});

  - 1. success 속성에서 변환함수 작성시
  		1. success : function 함수명(통신반환변수) {통신성공했을때 실행코드}
 		2. success : function (통신반환변수) {통신성공했을때 실행코드}
 		3. success : function (통신반환변수) => {통신성공했을때 실행코드}
 
 
 	----------------------------------------------------------------------
 	HTTP는 JSON에게 전송한다 하지만 DTO ArrayList에게는 전송 불가능하다.
 		
 	
 	----------------------------------------------------------------------
 	
 	서블릿
 		- request : 요청 객체 
 		- response : 응답 객체
 			- response.getwriter 			: 데이터 응답
 				- 웹 출력=응답 데이터
 			- response.setContentType("전송할데이터의타입명;인코딩타입") 	: 출력할 데이터의 타입 혹은 인코딩
 				- 1. 문자전송[default]
 					- response.setContentType("text/html;charset=UTF-8");
 				- 2. JSON전송 
 					- response.setContentType("application/json;charset=UTF-8");
 	-------------------------------------------------------------------------------------------------------
 	JACKSON : JAVA객체를 JSON 형식에 대한 다양한 클래스 제공 라이브러리
		jackson-annotations-2.14.2 , jackson-core-2.14.2 , jackson-databind-2.14.2
		1. ObjectMapper 클래스 : JAVA객체를 JSON형식으로 변환해주는 함수들을 제공하는 클래스  
			1. .writeValueAsString( JAVA객체 ) : 해당객체를 JSON형식의 문자열로 반환 
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
*/