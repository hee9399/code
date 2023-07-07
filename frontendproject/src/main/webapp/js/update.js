console.log( 'write.js 실행' )

// 1. 썸머노트 실행할때 사용되는 코드 
$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성' 
  });
});

// 2. 수정할 게시물 = 클릭된 게시물 = 현재 보고있는 게시물 [게시물 번호가 세션에 저장되있어요]
	// 클릭을했으니까 보는거고 보고있으니까 수정하는거죠
let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList') );  

onView( )

// 2. 수정할 게시물을 출력해야한다
function onView( ){
	// 1. 어디에
	 let title = document.querySelector('.title') 
	 let content = document.querySelector('#summernote')
	 
	// 2. 무엇을 [클릭된 게시물의 정보 1개]
	 for(let i = 0; i<boardList.length ; i++){
		 let b = boardList[i]  
		 if(b.no == no){
			 // 3. 출력/대입 
			 title.value = b.title 
			 content.value = b.content
			 break;
		 }
	 }
	// 3. 출력/대입 할껀지
} // f end

// 1. 수정 함수 [실행조건 : 등록 버튼을 클릭했을때] 
function onUpdate( ){ console.log('실행됨')
	
}



























