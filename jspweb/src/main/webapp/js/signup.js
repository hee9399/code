console.log('js실행됩니다'); 

// onchange : 포커스(커서) 변경할때 
// onkeyup : 키보드에서 키를 누르고 때었을때 
// onkeydown : 키보드에서 키를 눌렀을때 


/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어 
		패턴 문법
			/^ : 정규표현식 시작 알림.
			$/ : 정규표현식 끝 알림.
			[a-z] : 소문자 a~z 패턴 검색 
			[A-Z] : 대문자 A~Z 패턴 검색 
			[0-9] : 숫자 0~9 패턴 검색 
			[가-힣] : 한글 패턴 
			[ 최소길이 , 최대길이 ] : 문자열 길이 패턴 
			+ : 앞에 있는 패턴 1개 이상을 반복할때 
			? : 앞 에 있는 패턴 0개 혹은 1개 이상 반복한다 
			* : 앞 에 있는 패턴 0개 반복한다.
			
			예시] 
				1. [ a - z ] : 소문자 a~z 검색 
				2. [ a-z A-Z ] : 영문(대,소) 검색 
				3. [a-z A-Z 0-9 ] : 영문+숫자 조합 패턴 
				4. [a-zA-Z  0-9 가-힣 ] : 영문 + 숫자 + 한글 조합 패턴 
				5. [ac]				: a와c 패턴 
				6. (?=.*[패턴문자])	: 해당 패턴문자가 한개 이상 포함 패턴 , 필수일때 
					(?=.*[a-z]) 	: 소문자 한개 이상 필수 
					(?=.*[A-Z]) 	: 대문자 한개 이상 필수 
					(?=.*[0-9]) 	: 숫자 한개 이상 필수 
					(?=.*[\n]) 		: 숫자 한개 이상 필수 
					(?=.*[!@#$%^&*]) 	: 패턴문자내 특수문자 한개 이상 필수 
					
				/^[A-Za-z0-9]$/	
				영대소문자 + 숫자 조합의 5~20글자 사이 
				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])$/
				- 영대문자1개 + 영소문자1개 + 슛저 1개 + 특수문자 1개 이상 필수로 갖는 5~20글자 사이 
			
				1. /^[a~z0~9]{5,30}$/	: 영문(소) + 숫자 조합 5~30글자패턴
				2. /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/  : 영대소문자(1개필수) + 숫자(1개필수) 조합 5~20글자 사이 
				  	/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
				  	
			3.  /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/	: 패턴@패턴.패턴
				
				
			패턴 검사 
				"패턴".text(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
			
*/ 



// 1. 아이디 유효성검사. 
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
   				      data : { type : "mid" , data : mid },      
    				  method : "get",   // get으로 가라 
      				  success : r => {console.log('통신성공')
      				  console.log(r);
      				  // true - 사용가능한 
      				  	if(r == true){idcheckbox.innerHTML = '사용불가능한 입니다.'; checkList[0] = false; }
      				  	else{idcheckbox.innerHTML = '사용가능한 아이디입니다.'; checkList[0] = true; }
      				  } ,       
     				  error :r => {} ,         
 		  });
		}else{// 입력한값이 일치하지 않으면 
			idcheckbox.innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능합니다.'; checkList[0] = false;
		}
		 
	
	// 3. 결과 출력 
	
}// f e

// 2. 비밀번호 유효성검사 [ 1. 정규표현식 검사. 2. 비밀번호 와 비밀번호 확인 일치여부 ]
function pwcheck(){console.log('패스워드 입력중');
	
	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	// 1. 입력 값 호출 
	let mpwd = document.querySelector('.mpwd').value; console.log('mpwd'+mpwd);
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	
	// 2. 유효성 검사 
		// 1. 정규표현식 만들기 [ 영대소문자(1개필수) + 숫자(1개필수) 조합 5~20글자 사이 ]
		// ( ) 소괄호 안에있는건 필수이다. 
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
	
	if(mpwdj.test(mpwd)){ // 1. 비밀번호 정규표현식 검사 
		
		// 2. 비밀번호 확인 정규표현식 검사 
		if(mpwdj.test(mpwdconfirm) ){
			
			// 3. 비밀번호 와 비밀번호 확인 일치여부 
			// 처음에 입력한 비밀번호 mpwd
			// 비빌번호 확인 mpwdconfirm
			if(mpwd == mpwdconfirm){
				pwcheckbox.innerHTML = '사용가능한 비밀번호'; checkList[1] = true;
			}else{
				pwcheckbox.innerHTML = '비밀번호가 일치하지 않습니다.'; checkList[1] = false;
			}
			
		}else{
			pwcheckbox.innerHTML = ' 영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력해주세요.'; checkList[1] = false;
		}
		
	}else{
		pwcheckbox.innerHTML = ' 영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력해주세요.'; checkList[1] = false;
	}
	
	
	
	
}// f e

// 3. 이메일 유효성검사 ( 1. 정규표현식 2. 중복검사 )
function emailcheck(){
	
	 let emailcheckbox = document.querySelector('.emailcheckbox');
	 let authReqBtn = document.querySelector('.authReqBtn');
	
	// 1. 입력된 값 호출 
	let memall = document.querySelector('.memall').value
	
	// 2. 이메일 정규표현식 [ 영대소문자,문자,숫자,_- @ ]
		// ex) clffp99@naver.com
		// 1. clffp99 : 이메일 아이디부분 은 영대소문자 , 숫자 , _-패턴 
		// 2. @ 	: +@  @ 앞에 패턴이 1개이상 필수 
		// 3. 도메인	
			// 회사명 	: @ 뒤에 그리고 , 앞에 패턴은 a-zA-Z0-9_-
			// .		: +\. : .앞에 패턴이 1개이상 필수로 들어간다.
			// 도메인 	: . 두에 패턴은 a-zA-Z
		 
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	
	if(memailj.test(memall)){
		
		$.ajax({
      url : "/jspweb/MemberFindController",      // 누구랑 통신할건지 
      data : {type : "memall" , data : memall}, //      
      method : "get", // doGet으로 가라    
      success : r => {
     		if(r){
				 emailcheckbox.innerHTML = '사용중인 이메일입니다.';
				authReqBtn.disabled = true; // 해당 버튼의 disabled 속성 작용
				checkList[2] = false;
			 }else{
				 emailcheckbox.innerHTML = '사용가능한 이메일입니다.';
				 authReqBtn.disabled = false; // 해당 버튼의 disabled 속성 작용
			 }
      
      } ,       
      error : r => {console.log(r);} ,         
   });
		
	}else{
		 emailcheckbox.innerHTML = '이메일형식에 맞게 입력해주세요.';
		 authReqBtn.disabled = true; // 해당 버튼의 disabled 속성 작용 
		 checkList[2] = false;
	}
	
}// f e


// 4. 인증요청 버튼을 눌렸을때.
function authReq(){console.log('인증요청');

	// ------------------------- 테스트용 ---------------- //
	let authbox = document.querySelector('.authbox');
	
	// 2. auth html 구성 
	let html = `<span class="timebox">02:00</span>
			   <input class="ecode" type="text" /> 
			   <button onclick="auth()" type="button">인증</button>`

	// 3. auth  html 대입 
	authbox.innerHTML = html;

	// 4. 타이머 실행 
	// Controller에서 전달한 난수생성6자리가 r에게 전달한다.
	authcode = '1234'; // 인증 코드 '1234' [ Controller(서블릿) 전달받음 ]
	
	timer = 120;	   // 인증 제한시간 120초 테스트용
	settimer();        // 타이머 실행

/*
	// -------------------------- 이메일 인증 보냈을때 ------------------------------ // 

	// -- 인증요청시 서빌릿 과통신[ 무엇을? 인증코드 생성 , 이메일전송 ]
	   $.ajax({
      url : "/jspweb/AuthSendEmailController",      
      data : { memail : document.querySelector('.memail').value } ,      
      method : "get",   
      success : r => {console.log(r)};
      
      	// 1. 'authbox' div 호출 
	let authbox = document.querySelector('.authbox');
	
	// 2. auth html 구성 
	let html = `<span class="timebox">02:00</span>
			   <input class="ecode" type="text" /> 
			   <button onclick="auth()" type="button">인증</button><br/>`
	
	// 3. auth  html 대입 
	authbox.innerHTML = html;
	
	// 4. 타이머 실행 
	// Controller에서 전달한 난수생성6자리가 r에게 전달한다.
	authcode = r; // 인증 코드 '1234' [ Controller(서블릿) 전달받음 ]
	
	timer = 120;	   // 인증 제한시간 120초 테스트용
	settimer();        // 타이머 실행
      
      
      } ,       
      error : e => {e} ,         
   });
	
*/

}// f e 

// 4번,5번,6번 함수에서 공통적으로 사용할 변수[전역변수]
let authcode = '';
let timer = 0; // 인증 시간(초) 변수 
let timerInter; // setInterval 을 가지고있는 함수 

// 5. 타이머 함수 만들기 
function settimer(){
	// setInterval( 함수명 , 실행간격[밀리초] ) : 특정시간마다 함수를 실행시키는 함수 
	// 1초에 한번씩 안녕을 출력
	// setInterval( () => {console.log('안녕');} , 1000 );
	
 timerInter = setInterval( () => {
		// 시간 형식 만들기 
			// 1. 분 만들기 [ 초 / 60 ] => 분 / [ 초 % 60 ] => 나머지 초 
		let m = parseInt(timer/60); // 분 계산 [ 몫 ]
		let s = parseInt(timer % 60); // 초 계산 [ 나머지 ]
			// 2. 두자리수 맞춤 3 -> 03
		m = m < 10 ? "0"+m : m; // 만약에 분 이 10보다 작으면 한지리수 이므로 0 붙이고 아니면 
		s = s < 10 ? "0"+s : s; 
	
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증 시간(초) HTML 대입
		timer --; // 1씩 차감 	
		
		// 만약에 타이머가 0 보다 작으면 [ 시간 끝 ]
		if(timer < 0){
			
			// 1. setInteval 종료 [ 누구를 종료할껀지 실별자.. 변수 선언 = timerInter ]
			clearInterval( timerInter );
			
			// 2. 인증 실패 알림 
			document.querySelector('.emailcheckbox').innerHTML = '인증실패' ;
			
			// 3. authbox 구역 다시 초기화 
			document.querySelector('.authbox').innerHTML = '';
			checkList[2] = false;
			
		}//  if e
				
	},1000 ); // 1초에 한번씩 실행되는 함수 
		// 무엇이실행되나? html의 형식을 
		// 그다음에 무엇을? 타이머 실행함수를 실행시킨다 
	
}// f e

// 6. 인증요청후 인증코드를 입력하고 인증하는 함수
function auth(){console.log('auth open');
	
	// 1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	
	// 2. 비교[ 인증코드 와 입력받은 인증코드 ]
	if(authcode == ecode){
		
		// 1. setInterval 종료 
		clearInterval(timerInter);
		
		// 2. 인증성공 알림 
		document.querySelector('.emailcheckbox').innerHTML = '인증성공'; checkList[2] = true;
		
		// 3. authbox 구역 HTML 초기화 
		document.querySelector('.authbox').innerHTML = ``; checkList[2] = true;
		
	}else{
		
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML =`인증코드 불일치`; checkList[2] = false;
	}
	
}// f e

/*
	setInterval() : 특정시간마다 함수를 실행 함수 
		1. 
			setInterval( function 함수명(){} , 밀리초 )
			setInterval( function (){} , 밀리초 )
			setInterval( 함수명() , 밀리초 )

*/ 

// setInterval( 함수명 , 실행간격[밀리초] ) : 특정시간마다 함수를 실행시키는 함수 
	// 1초에 한번씩 안녕을 출력
	// setInterval( () => {console.log('안녕');} , 1000 );

// 7. 첨부파일에 등록된 사진 등록시 등록 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능 >
function preimg(object){console.log('사진 선택 변경됨');

	console.log(object); // 이벤트를 발생시킨 태그의 DOM객체를 인수로 받음 
			//  vs 
	// console.log(document.querySelector('.mimg'));\
	// 1. input태그의 속성 [ type,class,onchange,name 등등 ]
	
	// ------- 해당 파일을 바이트코드로 변환 
	// 2. input태그 이면서 type="file" 이면 추가적인 속성 
		// .file : input type="file" 이면 추가적인 속성 
	console.log(object.files);
	console.log(object.files[0]); // 리스트중에서 하나의(0번째) 파일만 가져오기 
	
	
	// --- 해당 파일을 바이트코드 변환 
	// 2. JS 파일클래스 선언 
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기객체 선언 
	
	
	// 3. 파일 읽어오기 함수 제공 
		// 내가선택한파일 object.files[0] 를 읽어온다 
	file.readAsDataURL( object.files[0] ); // input 에 등록된 파일리스트(  object.files )중 1개를 파일객체로 읽어온다.
	console.log( file );
	
	
	// 4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => { // onload() : 라는 함수를 이용해서 파일을 출력해준다. , 읽어온 파일의 바이트코드를 불러온 함수 구현 
	
	console.log( e ); // e : 이벤트 정보 
	console.log( e.target); // onload() 실행한 FileReader 객체 
	console.log( e.target.result ); // 읽어온 파일을 바이트코드로 읽는다.
	document.querySelector('.preimg').src = e.target.result; // img src속성에 대입
	
	}
	
}// f e

let checkList = [false , false , false ]//  인덱스 [0] : 아이디통과여부 , [1] : 패스워드통과여부 , [2] : 이메일통과여부 

// 8. 회원가입 메소드
function signup(){ 
	// 1. 아이디 / 비밀번호 / 이메일 유효성검사 토오가 여부 체크 
		console.log( checkList );
	if(checkList[0] && checkList[1] && checkList[2] ){// checkList 에 저장된 논리가 모두 true 이면 
		console.log('회원가입 진행가능'); 
		// 2. 입력받은 데이터를 한번에 가져오기 form 태그 이용 
			// <form> 각종 input/button </form>
			// 1. form 객체 호출   querySelectorAll(from태그 식별자)
		 	let signupForm = document.querySelectorAll('.signupForm' )[0];
				console.log(signupForm);
			// 2. form 데이터 객체화 
				// 일반객체로 첨부파일을 전송할수없다 formData라는 객치로 이요해서 첨부파일 전송 기능을 한다.
			let signupData = new FormData( signupForm ); // 첨부파일시[ 대용량 ] 필수
				console.log( signupData );
				
			// 3. AJAX 에게 첨부파일[대용량] 전송 하기. 
		 /*	
			// 1. 첨부파일 없을때
			   $.ajax({
    			   url : "",      
    			   data : {},      
   				   method : "",   
   				   success : r => {console.log(r);} ,       
   				   error :  e => {console.log(e);} ,         
   });
   */
		// 2. 첨부파일 있을때  , [ 기존 json형식의 전송x form객체 전송 타입으로 변환한다. ]
			           $.ajax({
               url : "/jspweb/MemberController" , 
               method: "post" ,
               data : signupData ,
               contentType : false , // FormData 객체를 전송한다. 
               processData : false , // 
               success : r => { console.log(r) 
               
               		if( r ){// 회원가입성공 [ 1.알린다 2.페이지전환 ]
						   alert('회원가입 성공');
						   location.href = '/jspweb/member/login.jsp';
					}else{// 회원가입 실패 
						alert('회원가입 실패[ 관리자문의 ]');
					}
               
               } ,
               error : e => { console.log(e) } ,
            })
			
	}else{ 
		console.log('회원가입 진행불가능');
	}
	
	
	
}// f e


/*

// 1.유효성 검사가없는 회원가입 메소드 
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

*/