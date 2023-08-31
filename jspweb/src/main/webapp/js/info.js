

console.log( 헤더변수 );

// 1. 로그인된 회원의정보 호출 
getInfo(); // 함수 호출 
function getInfo(){
	
	   $.ajax({
      url : "/jspweb/MemberController",      
      data : {type : "info"},      
      method : "get",   
      success : r => {
		  
		  if(r == null ){// 로그인 상태 
		  
			  alert('회원전용 페이지입니다.[로그인]페이지로 이동');
			  location.href="/jspweb/member/login.jsp";
			  
		  }else{// 로그인 상태 -> 마이페이지 구역에 정보 넣어주기 
			  
			  document.querySelector('.preimg').src=`img/${r.mimg}`;
			  document.querySelector('.mid').innerHTML = r.mid;
			  document.querySelector('.memall').innerHTML = r.memall;
		  }
		  
	  } ,       
      error : e =>{} ,         
   });
	
}//  f e

// 2. 회원 수정
function mupdate(){
	
	// 1.첨부파일 전송할때 
		// 1. from 가져오기 
	let form =  document.querySelectorAll('.signupForm')[0];
		console.log(form)
		// 2. from 데이터 객체화 하기 
	let formdata = new FormData(form);
		console.log(formdata);
		
		// form 전송 ajax
	
       $.ajax({
               url : "/jspweb/MemberController" , 
               method: "put" ,
               data : formdata ,
               // form 전송타입 : 문자X jsonoX , multipart/form-data
               /*
               		HTTP 전송타입 
               			1. text/html			: 문자타입 [ 기본값 ]
               			2. application/json 	: json타입
               			3. multipart/from-data 	: 대용량 form 전송 타입  
               					 contentType : false , // 전송타입 : form 으로 전송  // true로 전송하면 json문자형 전송이된다 
              					 processData : false ,
               
               */ 
               contentType : false , // 전송타입 : form 으로 전송  // true로 전송하면 json문자형 전송이된다 
               processData : false ,
               success : r => { 
				   
				   if(r){
					   alert('수정 성공');
					   logout();
				   }else{
					   alert('수정 실패');
		
				   }
				   
			    } ,
               error : e => { console.log(e) } ,
            })
	
}// f e


// 3. 회원 탈퇴
function mdelete(){ 
	
	// 1. 탈퇴여부 확인 confirm() 확인/취소 버튼 알림창 
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인 버튼을 눌렀을때.
	if(dconfirm == true){
		let mpwd = prompt('비밀번호확인');
		// ajaxs [ 패스워드 전송해서 로그인 회원번호와 입력받은 패스워드의 일치하면 탈퇴 ]
		   $.ajax({
    		  url : "/jspweb/MemberController",      
    		  data : {mpwd : mpwd},      
    		  method : "delete",   
     		  success : r => {
				 if(r){ alert('회원탈퇴 했습니다.'); logout(); }
				else{ alert('패스워드가 일치하지 않습니다'); } 
				 
				  } ,       
    		  error : e => {} ,         
   });
		
	}
	
	
}// f e 