console.log('js실행됩니다');



// 7. 첨부파일에 등록된 사진 등록시 등록 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능 >
function hrmimg(object){console.log('사진 선택 변경됨');

	console.log(object); // 이벤트를 발생시킨 태그의 DOM객체를 인수로 받음 
			//  vs 
	// console.log(document.querySelector('.mimg'));
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
	document.querySelector('.hrmimg').src = e.target.result; // img src속성에 대입
	
	}
	
}// f e

// 1. C 인사관리 등록 함수
function hwriter(){
	console.log('등록함수 실행됩니다.');
	// from 객체 호출 
	let hrmForm = document.querySelectorAll('.hrmForm')[0];
	let hrank = document.querySelector('.hrank').value;
	// form 데이터 객체화
	let hrmData = new FormData(hrmForm);
	console.log(hrmData);
	hrmData.append("hrank",hrank);
	// 1.  첨부파일이 있을때 
	           $.ajax({ // html 호출한. 
               url : "/jspweb/HrmController" , 
               method: "post" ,
               data : hrmData ,
               contentType : false , // FormData 객체를 전송한다. 
               processData : false , // 
               success : r => { console.log(r) 
               		
               		if( r ){// 등록 성공 [ 1.알린다 2.페이지전환 ]
						   alert('인사관리 등록 성공');
						   location.href = '/jspweb/hrm/hrm.jsp';
					}else{// 등록 실패 
						alert('인사관리 등록 실패');
					}
               
               } ,
               error : e => { console.log(e) } ,
            })
	
	// 2. 객체화 
	
}

// 2. R 인사관리 호출 함수

hread(); // js 실행될때 1번 실행 
function hread(){ // 실행조건 : js 실행때 1번 실행 . 등록 , 수정 , 삭제시 최신화해야한다 왜? 성공했기때문에 
	   $.ajax({
      url : "/jspweb/HrmController",  // 누구랑 통신할꺼냐     
      data : {},      
      method : "get",   
      success : function 함수(r){console.log(r);
     
      	// - 응답 받은 객체를 HTML에 출력	
      	// 1. [어디에] 출력할 구역의 객체 호출 
      	let output = document.querySelector('.hrm_Bottom');
      	
      	// 2. [무엇을]  반복문 이용한 데이터를 HTML 형식으로 만들기
      	let html = ``; // `백틱 
     		// 리스트내 모든 객체의 데이터를 html 형식으로 만들기
     		for(let i = 0; i<r.length; i++){
				 // 객체를 html형식으로 누적 더하기 
			html +=	 `<div class="hrmbox"> 
			
				<div>${r[i].hnumber}</div>
				<div>${r[i].hname}</div>
				<div>${r[i].hphone}</div>
				<div>${r[i].hdate}</div>
				<div>${r[i].hrank}</div>
				<img src="img/${r[i].hrmimg}" />
				
			</div> >` 
			
			 }// for e 
      	 
      	// 3. [대입] 출력객체 HTML형식에 대입 
      	output.innerHTML = html;
      
      } , // 성공했을때       
      error : function 함수(r){} ,  // 실패했을때        
   });
	
	
}// f e


