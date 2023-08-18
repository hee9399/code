console.log('1_AJAX통신.js Open');

// 1. 예제1

function 예제1(){ // 
	
	$.ajax({
      url : "http://localhost/jspweb/Test06",      
      data : { 'value1' : '안녕하세요'},      
      method : "get",   
      success : function 함수(result){
		  console.log('서블릿 응답한 내용:'+result)
	  }        
             
   });

	
}// function e

function 예제2(){
	
	// 1. 입력받은 데이터 가져온다
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	
	// 2. 객체화
	let info = {
		
		name : nameData ,
		age : ageData
		
	}// let e
	
	   $.ajax({
      url : "http://localhost/jspweb/Test07",      
      data : info ,      
      method : "get",   
      success : function 함수(result){} ,       
      error : function 함수(result){} ,         
   });
	
}// function e




/*
	$.ajax(); 	매개변수에 객체{} 타입의 속성 대입
	
	객체({
		누구와
		url : "",			-- 통신할 HTTP 주소
		무엇을
		date : {},		-- 보내는 데이터 
		어떻게?
		method :"" ,		-- POST , GET , PUT , DELETE
		통신할껀지
		success : function 함수(result){} , 	-- 통신 성공 했을때 result 로 응답 매개변수 받기 
		error : , function 함수(result){} ,	-- 통신 실패 했을때 result 로 실패사유를 매개변수 받기 
		
	});
	
	   $.ajax({
      url : "",      
      data : {},      
      method : "",   
      success : function 함수(result){} ,       
      error : function 함수(result){} ,         
   });


*/