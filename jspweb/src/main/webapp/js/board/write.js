console.log('writejs open');

/*  섬머노트 실행  */ 
$(document).ready(function() {
	
	// $('#summernote').summernote();
	let option = { // 섬머노트 옵션관련 객체 만들기 
		
		lang : 'ko-kr' , // 한글속성 적용
		height : 500 , // 높이 
		placeholder : '여기에 내용작성'
		
	}
	
  $('#summernote').summernote( option );
});


// 글쓰기 등록함수 
function bwrite(){
	console.log('onwrite() open')
	
	// 1. form 가져오기 
		// form 전체를 배열타입으로 갖고오기때문에 인덱스0 을 추가해준다 
	let form = document.querySelectorAll('.writeFrom')[0];
	console.log(form);
	// 2. form 객체화 
	let formdata = new FormData(form);
	console.log(formdata);
	
	// 3. ajax 로 form 전송하기 
	           $.ajax({
               url : "/jspweb/BoardController" , // 서블릿 어떤 주소와 통신할껀지
               method: "post" ,  // 서블릿 누구랑 통신할껀지 
               data : formdata , // 어떤 객체를 갖고 올껀지 
               contentType : false ,
               processData : false ,
               success : r => { 
				   console.log(r); 
				   		
				   		if( r ){
						alert('글등록 성공');
						location.href = '/jspweb/board/list.jsp';
					}
				   
				   } ,
               error : e => { console.log(e) } ,
            })
	
}// f e

