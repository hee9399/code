console.log('js실행됩니다');

// C 저장/등록(create) 가계부 등록 함수명 : awriter
function awriter(){console.log('등록함수실행됩니다')
	
	// 1. html에 있는 input객체 호출하자 document.querySelector를 사용해서 
	// 무엇을? 항목내용 , 금액 , 날짜를 등록하자
	
	let awriterInput = document.querySelector('.awriter'); console.log('awriterInput'+awriterInput);
	let amoneyInput = document.querySelector('.amoney');   console.log('amoneyInput'+amoneyInput);
	let adateInput = document.querySelector('.adate');     console.log('adateInput'+adateInput);
	
	// 2. 객체화 [  타입 변수명 = {속성명 : 데이터}
	// 무엇을 객채화함? 항목내용 , 금액 , 날짜
	let info = {
		
		awriter : awriterInput.value ,
		amoney : amoneyInput.value ,
		adate : adateInput.value ,
		
	};console.log('객체실행됩니다');
	
	// 2. AJAX 
	   $.ajax({
      url : "/jspweb/AccountbookConrtoller",  // 누구랑 통신할껀지
      data : info, // 어떤객체를 갖고올껀지
      method : "post", // 서블릿에 doPost로 가라   
      success : function 함수(r){console.log('doPost통신성공'); vread();
      
      // vread(); 글을썻을때 최신화 시켜준다 
      // 자바에서 문자 true로 보냈기때문에 따옴표는 사용하지 않는다.
      if(r == true){
		  alert('등록성공');
		  // 등록 성공시 HTML에서 작성한 input 내용을 공백으로 초기화 한다.
		  // 입력값이 성공했기때문에 초기화 시켜주는거다. 또는 원상복구를 해주는것이다.
		  awriterInput.value = ''; amoneyInput.value = ''; adateInput.value = '';
	  }
      
      } ,  // 성공했을때     
      error : function 함수(r){} ,    // 실패했을때      
   });
	
}// function e
 
// R 호출(read) 가계부 호출 함수명 : aread
vread();	// js 실행될때 1번 실행 
function vread(){console.log('호출함수 실행됩니다');
	   $.ajax({
      url : "/jspweb/AccountbookConrtoller",     // 누구랑 통신할껀지  
      data : {},      
      method : "get",  // 서플릿에 doGet 으로 가라   
      success : function 함수(r){console.log(r);
      
      	// 응답 받은 객체를 HTML에 출력
      	// 1. [어디에] 출력할 구역의 객체 호출 
      	let output = document.querySelector('.account_Bottom');
      	
      	// 2. [무엇을] 반복문 이용한 데이터를 HTML형식으로 만든다
      	// 왜 반복문을 만드는가? 가계부 출력을 여러개 받기 위해서
      	let html = ``;
      		// 리스트내 모든 객체의 데이터를 html 형식으로 만들기 
      		for(let i = 0; i<r.length; i++){
				  // 객체를 html형식으로 누적 더하기
			html += `<div class="accountbox"> 
				<div class="accountbox_top">
					<div>${r[i].awriter}</div>
				</div>
				<div>${r[i].adate}</div>
				<div> 
					<button onclick="aupdate( ${r[i].ano} )" type="button">수정</button>
					<button onclick="adelete( ${r[i].ano} )" type="button">삭제</button>
				</div> 
			</div>`
				  
			  }// for e
			  
		// 3. [대입] 출력객체 HTML형식에 대입 
		output.innerHTML = html;
      
      } ,  // 성공했을때     
      error : function 함수(r){} ,    // 실패했을때     
   });
}// function e


// U 수정(update) 가계부 수정 함수명 : aupdate
	// 누구를? (클릭한가계부번호) 
	function aupdate(ano){console.log('수정함수실행됩니다');
		
		// 1. 수정할 내용 입력
		let acontent = prompt('수정할 가계부내용: ')
		
	 	  $.ajax({
     	 url : "/jspweb/AccountbookConrtoller",      
     	 data : {},      
     	 method : "put",   
     	 success : function 함수(r){} ,       
     	 error : function 함수(r){} ,         
   });
}// function e


// D 삭제(delete) 가계부 삭제 함수명 : adelete
function adelete(){
	   $.ajax({
      url : "",      
      data : {},      
      method : "",   
      success : function 함수(r){} ,       
      error : function 함수(r){} ,         
   });
}// function e
























