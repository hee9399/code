console.log('visitlog.js 열림');

// 1. Create (저장) : 방문록 등록 함수 = vwriter
function vwriter(){
	
	// 1. HTML input에있는 태그 객체 호출
		// document.querySelector 를 사용해서 html에있는 객체를 가져온다 
		// document.querySelector('.vwriter')
	let vwriterInput = document.querySelector('.vwriter');   console.log('vwriterInput:'+vwriterInput);
	let vpwdInput = document.querySelector('.vpwd');		 console.log('vwriterInput:'+vpwdInput); 
	let vcontentInput = document.querySelector('.vcontent'); console.log('vwriterInput:'+vcontentInput);
	 
	// 2. 객체화
		// let 변수명 = {속성명 : 데이터 , 속성명 : 데이터}
	let info = {
		vwriter : vwriterInput.value ,
		vpwd : vpwdInput.value ,
	    vcontent : vcontentInput.value ,
	};console.log(info);
	
	// 3. 유호성검사
	
	
	// 4. AJAX ()
	   $.ajax({
      url : "/jspweb/VisitlogController",      
      data : info,      
      method : "post", // 서블릿 doPost 로 가라  
      success : function 함수(r){console.log("통신성공"); vread();
      // 자바에서 문자 true로 보냈기때문에 따옴표는 사용하지않는다.
      	if(r == true){ // 마냐게 입력값이 true면 ? 입력값 원상복구 또는 초기화 왜? 입력값이 true/성공 했기 때문에 
			  alert('등록성공');
			  // 등록 성공시 HTML에서 작성한 input 내용을 공백으로 초기화 한다.
			  // 입력값이 성공했기때문에 초기화 시켜주는거다. 또는 원상복구를 해주는것이다.
			  vwriterInput.value = ''; vpwdInput.value = ''; vcontentInput.value = '';
			  
		  } // if e
      
      } ,  // 성공했을때     
      error : function 함수(r){} ,    // 실패했을때      
   });
	
	
	// 5. 결과에 따른 코드 
	
	
}// f e



// 2. Read (호출) : 방문록 호출 함수 : vread
vread(); // js 실행될때 1번 실행 
function vread(){ // 실행조건 : js 실행때 1번 실행 . 등록 , 수정 , 삭제시 최신화해야한다 왜? 성공했기때문에 
	   $.ajax({
      url : "/jspweb/VisitlogController",  // 누구랑 통신할꺼냐     
      data : {},      
      method : "get",   
      success : function 함수(r){console.log(r);
     
      	// - 응답 받은 객체를 HTML에 출력	
      	// 1. [어디에] 출력할 구역의 객체 호출 
      	let output = document.querySelector('.visit_Bottom');
      	
      	// 2. [무엇을]  반복문 이용한 데이터를 HTML 형식으로 만들기
      	let html = ``; // `백틱 
     		// 리스트내 모든 객체의 데이터를 html 형식으로 만들기
     		for(let i = 0; i<r.length; i++){
				 // 객체를 html형식으로 누적 더하기 
			html +=	 `<div class="visitbox">
				<div class="visitbox_top">
					<div>${r[i].vwriter}</div>
					<div class="visidate">${r[i].vdate}</div>
				</div>
				<div class="visitbox_center">${r[i].vcontent}</div>
				<div class="visitbox_bottom">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>` 
			
			 }// for e 
      	 
      	// 3. [대입] 출력객체 HTML형식에 대입 
      	output.innerHTML = html;
      
      } , // 성공했을때       
      error : function 함수(r){} ,  // 실패했을때        
   });
	
	
}// f e

// 3. update (수정) : 방문록 수정 함수 : vupdate
function vupdate(){
	
	
}// f e

// 4. delete (삭제) : 방문록 삭제 함수 : vdelete
function vdelete(){
	
	
}// f e