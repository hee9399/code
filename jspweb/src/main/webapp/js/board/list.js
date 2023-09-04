console.log('list.js open');

/* 모든게시판은 글쓰기를 눌렀을때 글을 먼저 보여주지 글을먼저쓰고 글을 보여주지 않으니까 
	list에서 write로 이동을 해야한다 .
*/
// 1. 글쓰기 버튼을 클릭하면 
function onwrite(){// - 만약에 비 로그인이면 로그인 페이지로 이동 
	if( loginState ){
		// location - url 정보를 가져오는 객채이다. 
		location.href="/jspweb/board/write.jsp"
	}else{	// - 로그인이면 쓰기 페이지로 이동 
		alert('로그인후 글쓰기 가능합니다.');
		location.href="/jspweb/member/login.jsp";
		
	}
	
	
}// f e

// 2. 모든 글 조회 [ js 열렸을때 1회 자동실행 ]
getList();
function getList(){
	// ajax 의 실행은 스크립트가 실행한다.
	   $.ajax({
      url : "/jspweb/BoardController",      
      data : { type : 1 },      
      method : "get",   
      success : r => {
		  console.log(r);
		  
		  // 1. 출력할 위치 
		  let boardTable = document.querySelector('.boardTable');
		  
		  // 2. 출력할 내용 구성 
		  let html = `	<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>`
			// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html  구성 
				// 배열명.forEach // java -> , js => 
				// forEach - 함수를 반복시킨다 r객체를 반복한다. 
				// forEach( 반복변수명 => { 실행코드 } )
				//  / <img src="/jspweb/member/img${b.mimg}">
				r.forEach( b => {
					console.log(b);
					html += `<tr>
				<th>${ b.bno }</th>
				<th>${ b.bcname }</th>
				<th>  <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle} </a> </th>
				<th>${ b.mid }</th>
				<th>${ b.bview }</th>
				<th>${ b.bdate }</th>
			</tr>`
					
				} ); // for e
			boardTable.innerHTML = html;
		  
	  } ,       
      error : e => {} ,         
   });
	
}// f e

/* 

		HTTP URL에 매개변수(파라미터) 전달 ( 쿼리[질의] 스트링 방식 )
			- 형태 
			- 정의 : 페이지 전환시 매개변수(pk,식별)를 전달할때 
				URL?변수명=데이터 
				URL?변수명=데이터$변수명=데이터
				http://localhost:80/jspweb/board/view.jsp?bno=3${ b.bno }
				url뒤에 ? 를쓰면 매개변수를 전달이된다. , ?를 사용해서 키 , 값을 보낸다
				내가클릭한 변수를 전달하는 방식이다.
			
			- URL에서 매개변수 호출 
				new URL(location.href).searchParams.get("변수명") 
		
*/





























