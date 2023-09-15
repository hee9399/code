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

/* 게시물 조회 조건 객체 */ 
let pageOject = {
	type : 1 , bcno : 0 , 
	listsize : 10 , 
	page : 1 , key : '' , keyword : ''
}

	// 여기서 type은 : 1:전체조회 , 2:개별조회  
	// bcno : 조회할 카테고리 번호 [ 기본값은 전체보기 ]
	// listsize : 하나의 페이지에 최대 표시할 게시물수 [ 기본값은 10개 ]
	// page : 조회할 페이지 번호 
	// key : 검색할 기준 필드명 
	// keyword : 검색할 데이터 
	
// 5. 검색 버튼을 클릭했을때.
function onSearch(){
	console.log('onSearch() opne');
	// 입력받은 key 값을 게시물 조회 조건객체에 담는다.
	pageOject.key = document.querySelector('.key').value; // 검색할 기준 필드명 
		
		// 입력받은 keyword 값을 게시물 조회 조건객체에 담는다.
	pageOject.keyword = document.querySelector('.keyword').value; // 검색할 데이터 
		
	getList(1);
	
}// f  e
	
	
// 3. 카테고리 버튼을 클릭했을때.
function onCategory( bcno ){
	console.log('클릭된 카테고리 : '+bcno); 
	pageOject.bcno = bcno; // 조회 조건객체내 카테고리로 변경 
	pageOject.key = ''; pageOject.keyword = ''; // 검색 해제
	getList(1); // 조건이 변경되었기 때문에 다시 출력[ 재렌더링/새로고침 ]
		
}//  f  e

// 4. 한페이지 최대 표시할 개수를 변경했을때.
function onListSize(){
	
	pageOject.listsize = document.querySelector('.listsize').value;
	// 조건이 변경되었기 때문에 다시 출력[ 재렌더링/새로고침 ]  , 처음에는 1페이지 부터 시작
	getList(1); 
	
}// f   e

// 2. 모든 글 조회 [ js 열렸을때 1회 자동실행 ] // 페이지 번호 클릭
getList(1); // 첫페이지는 1페이지로 시작
// page 는 2. 페이지번호 출력 에서 실행되는 변수이다.
function getList( page ){ // page : 조회할 페이지번호 클릭 
	// 전달할 페이지 객체 생성 
	pageOject.page = page;
	// 클릭된 페이지번호 를 조건객체에 대입  

	// ajax 의 실행은 스크립트가 실행한다.
	   $.ajax({
      url : "/jspweb/BoardController",      
      data : pageOject ,      
      method : "get",   
      success : pageDto => {
		  console.log(pageDto);
		  
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
				pageDto.boardList.forEach( b => {
					console.log(b);
					html += `<tr>
				<td>${ b.bno }</td>
				<td>${ b.bcname }</td>
				<td>  <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle} </a> </td>
				<td>
					${ b.mid }
					<img src-"/jspweb/member/img${ b.mimg }/"/>
				</td>
				<td>${ b.bview }</td>
				<td>${ b.bdate }</td>
			</tr>`
					
				} ); // for e
			boardTable.innerHTML = html;
			
			// ----------------------- 2. 페이지번호 출력 ----------------- //
			html = ``;
			
			// 페이지 개수만큼 페이징번호 구성 
			// 이전 버튼 
			html += `<button  onclick="getList( ${ page <= 1 ? page : page-1 } )" type="button"> < </button>`;
			
			// 페이지번호 버튼
			for(let i = 1 ; i<=pageDto.totalpage; i++){
				// class=" ${ page == i ? 'selectpage' : '' } "
				// 만약에 현재페이지(page)와 i번째 페이지와 일치하면 class="selectpage"
				html += `<button class="${ page == i ? 'selectpage' : '' }" onclick="getList( ${i} )" type="button"> ${i} </button>`;
				}
				// 다음 버튼 [ page >= pageDto.totalpage ? page : page+1 만약에 현재페이지가 마지막페이지이면 고정 아니면 1증가 ] 
							// 		
				html +=	`<button onclick="getList(${ page + 1} )" type="button"> > </button>`;
			
			document.querySelector('.pagebox').innerHTML = html;
		  
		  // ------------------ 3. 게시물 수 출력 ------------------------- //
		  let boardcount = document.querySelector('.boardcount');
		  
		  	// 1. 검색이 없을때 
		  	if( pageOject.key == '' && pageOject.keyword == '' ){
				 boardcount.innerHTML = `총 게시물 수 : ${ pageDto.totalsize }`
			  }else{ // 2. 검색이 있을때  
				  boardcount.innerHTML = `검색된 게시물 수 : ${ pageDto.totalsize }`
			  }
		  	// 2. 없을때 
		  
		  
		  
		  
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





























