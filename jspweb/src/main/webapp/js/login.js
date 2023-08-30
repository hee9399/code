

// 1. 로그인 함수 
function login(){
	console.log('로그인 함수 실행됩니다.');
	
	// 1. 입력받은 아이디 , 비밀번호 가져온다.
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2. ajax에게 전달해서 회원이 존재하는지 반환 받는다.
		// 2-1 : 로그인성공시 index.jsp 이동 
		// 		: 로그인 실패시 'logincheckbox' 실패 알림 
	   $.ajax({
     		 url : "/jspweb/MemberFindController",      
     		 data : {mid : mid , mpwd : mpwd },      
     		  // get메소드는 전송하는 data노출함(보안취약) 
     		 method : "post",  
      		 success : r =>{
				   
				   if(r){ location.href="/jspweb/index.jsp" ;}
				   else{
					   document.querySelector('.logincheckbox')
					   		.innerHTML = '동일한 회원정보가 없습니다.';
				   }
				   
			   } ,       
      		 error :r =>{} ,         
   });
}// f e 

/*

	get vs post 차이점

		GET : http://localhost/jspweb/MemberFindController?mid=asdas&mpwd=asdas
			- 캐시( 기록O )
			- 추후에 다시 전송시 속도 빠륾
			- 보안 불가능 
			- 매개변수 노출함
			- 개인정보 없는 데이터 정보 일때(권장한다.)
		
		POST : http://localhost/jspweb/MemberFindController
			- 캐시 ( 기록X )
			- 보안 가능
			- 매개변수 노출안됨
			- 로그인 , 회원가입 (권장) , 개인정보를 노출하지 않을때 권장한다.


*/