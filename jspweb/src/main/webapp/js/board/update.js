


// 2. 쿼리스트링(url주소상의변수) 의 변수 가져오기 
		// 쿼리스트링 : URL?변수명=값&변수명=값$변수명=값
		// new URL(location.href).searchParms.get("변수명");
		// /jspweb/board/update.jsp?bno = 주소값의변수명을 호출 한다. 
	let bno = new URL(location.href).searchParams.get("bno");
		console.log(bno);
	// getBoard() , onUpdate() 두함수에서  bcno를 같이 사용할것이기때문에 전역변수로 빼서 사용한다.

// 1. 수정할 게시물의 기존 정보를 보여주기 
getBoard();
function getBoard(){
	
		
	// 3. ajax에게 bno 전달해서 게시물정보 가져오기 
	 $.ajax({
      url : "/jspweb/BoardController",      
      data : {type : 2 , bno : bno},   // 게시물수정은 여러개가 아니고 하나의 게시물을 수정하기때문에 타입 2 를get으로 보낸다.
      method : "get",   
      success : r => {
		  console.log(r);
		  // 응답 결과 html 대입 
		  // value 를 쓰는 이유는 입력값이 input 으로 입력받기때문에 value를 사용한다 
		  document.querySelector('.bcno').value = `${r.bcno}`
		  document.querySelector('.btitle').value = `${r.btitle}`
		  document.querySelector('.bcontent').innerHTML = `${r.bcontent}`
		  document.querySelector('.oldfile').value = `${r.oldfile}`
		  
		  /*  섬머노트 실행  */ 
			$(document).ready(function() {
				
				// $('#summernote').summernote();
				let option = { // 섬머노트 옵션관련 객체 만들기 
					
					lang : 'ko-kr' , // 한글속성 적용
					height : 500 , // 높이 
					placeholder : '여기에 내용작성'
					
				}// option end
				
			  $('#summernote').summernote( option );
			});// summernote end
		  
	  } ,       
      error : e => {} ,         
   });
	
}// f e 

// 수정하기 
function onUpdate(){ 
	/* 
		update에 bno가 필요하다 그래서 전역변수로 선언한 bno를 사용한다.
		bno는 게시물을 식별하는 변수명이다. 
	
	*/
	// 1. 입력된(수정된) from  정보 한번에 가져오기 
		// 1. form 가져오기 
	let form = document.querySelectorAll('.updateFrom')[0]
	
	
	// 2. from 객체화 
	let formdata = new FormData(form);
	console.log(formdata);
	// 3. 응답 결과를 html 대입  
		// .set( 속성명 , 값 ); // form에 데이터 속성 추가 
	formdata.set( "bno" , bno );
	
	// 3. ajax 로 form 전송하기 
		           $.ajax({
               url : "/jspweb/BoardController" , 
               method: "put" ,
               data : formdata ,
               contentType : false ,
               processData : false ,
               success : r => { console.log(r) 
               
               		if(r){ alert('수정성공'); 
               			location.href=`/jspweb/board/view.jsp?bno=${ bno }`;
               		}else{alert('수정실패');}
               } ,
               error : e => { console.log(e) } ,
            })
	
	
}// f e








