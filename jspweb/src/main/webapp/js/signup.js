console.log('js실행됩니다'); 

// onchange : 포커스(커서) 변경할때 
// onkeyup : 키보드에서 키를 누르고 때었을때 
// onkeydown : 키보드에서 키를 눌렀을때 


/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어 
		패턴 문법
			/^ : 정규표현식 시작 알림.
			$/ : 정규표현식 끝 알림.
			[a~z] : 소문자 a~z 패턴 검색 
			[A~Z] : 대문자 A~Z 패턴 검색 
			[0~9] : 숫자 0~9 패턴 검색 
			[가~힣] : 한글 패턴 
			[ 최소길이 , 최대길이 ] : 문자열 길이 패턴 
			
			예시] 
				1. [ a ~ z ] : 소문자 A~Z 검색 
				2. [ a~zA~Z ] : 영문(대,소) 검색 
				3. [a~zA~Z0~9 ] : 영문+숫자 조합 패턴 
				4. [a~zA~Z0~9가~힣 ] : 영문 + 숫자 + 한글 조합 패턴 
				5. [ac]				: a와c 패턴 
				
				1. /^[a~z0~9]{5,30}$/	: 영문(소) + 숫자 조합 5~30글자패턴
				
			패턴 검사 
				"패턴".text(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
			
*/ 



// 아이디 유효성검사. 
function idcheck(){ // 실행조건 : 아이디 입력창에 입력할때마다 실행하게
	console.log('idcheck() open');
	
	// 1. 값 호출
	// 입력상자 혹은 타입을갖고있는html 클래스명을 불러올때는 .value를 넣어준다 
	let mid = document.querySelector('.mid').value;
	let idcheckbox = document.querySelector('.idcheckbox');
	
	// 2. 유효성검사 
		// 마냐게 아이디의(mid) 글자수가 5글자보다 작거나 그리고mid의 글자수가 30보다 크면 
		// 제어문 이용한 검사 if(mid.length < 5 && mid.length >= 30 ){}
		
		// 1. 아이디는 영문(소문자)+숫자 조합의 5~30글자 사이 이면 
			// 1. 정규표현식 작성.
		let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사.
		console.log(midj.test(mid) )
		if(midj.test(mid) ){ // 입력한 값이 패턴과 일치하면
			//	document.querySelector('.idcheckbox').innerHTML = '패턴 합격'
			
			// -- 입력한 아이디가 패턴과 일치하면 아이디중복검사.
			  $.ajax({
  				      url : "/jspweb/MemberFindController",      
   				      data : { mid : mid },      
    				  method : "get",   // get으로 가라 
      				  success : r => {console.log('통신성공')
      				  // true - 사용가능한 
      				  	if(r == true){idcheckbox.innerHTML = '사용불가능한 입니다.'}
      				  	else{idcheckbox.innerHTML = '사용가능한 아이디입니다.'}
      				  } ,       
     				  error :r => {} ,         
 		  });
		}else{// 입력한값이 일치하지 않으면 
			idcheckbox.innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능합니다.'
		}
		 
	
	// 3. 결과 출력 
	
}// f e

// 1. 회원가입 메소드 
function signup(){
	
	// 1. HTML에 가져올 데이터의 tag객체 호출 [ DOM객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid'); console.log('아이디'+midInput);
	let mpwdInput = document.querySelector('.mpwd'); console.log('비밀번호'+midInput);
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm'); 
	let memailInput = document.querySelector('.memail'); console.log('아이디'+memailInput);
	let ecodeInput = document.querySelector('.ecode'); 
	let mimgInput = document.querySelector('.mimg'); console.log('아이디'+mimgInput);
	
	// 2. (객체화) 
	let info = { // 인증코드(유호성검사 위한) , 패스워드 확인(유호성검사 위한) : DB 넣을 필요가 없는데이터
		
		mid : midInput.value ,
		mpwd : mpwdInput.value ,
		memail : memailInput.value ,
		mimg : mimgInput.value 
		
	}// let e
	
	// 
	  $.ajax({
      url : "/jspweb/MemberController",      
      data : info ,      
      method : "post",   
      success : r => {
		  
		  if(r == true){alert('등록성공')
		  
		  midInput.value = ''; mpwdInput.value = '';
		   memailInput.value = ''; mimgInput = '';
		  
		  
		  }
		  else{console.log('등록실패');}
		  
	  } ,       
      error :  r => {console.log('통신실패');} ,         
   });
	
};// f e