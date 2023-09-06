
/*

	view.jsp 만 키면안되고 list.jsp 에서 클릭하고 들어가야한다. 

 */

// 1. list.jsp에서 클릭된 제목의 bno를 전달받아 게시물 1개 가져오기 
getBoard();
function getBoard(){
	
	// 1. URL 에 있는 매개변수(쿼리스트링) 가져오기 
		// 1. 현재 주소(url)상 매개변수 가져오기 
	let urlParams = new URL(location.href).searchParams
		console.log( urlParams );
	let bno = urlParams.get("bno");// rul주소에서 bno의 데이터 가져오기 
		// new URL(location.href).searchParams("매개변수명")
	console.log( bno );
	
	
	// 2. ajax 이용한 bno 전달해서 게시물의 상세 정보 모두 가져오기 
	 $.ajax({
      url : "/jspweb/BoardController",      
      data : { type : 2  , bno : bno }, // 2면 개별조회  
      method : "get",   
      success : r =>{
		  console.log(r);
      	// 1. 
      	let boardBox = document.querySelector('.boardBox');
      
      	// 2. html 구성 
      	let html = `부가정보 : <div> ${r.bcname} , ${r.bview} , ${r.bdate} </div>
		부가정보2 : <div> ${r.mid} , <img src="/jspweb/member/img/${r.mimg}" width="50px" </div>
		제목 : <div> ${r.btitle} </div>
		내용 : <div> ${r.bcontent} </div>
		첨부파일 : <div> <a href="/jspweb/FileDownLoad?fileDownLoad?filename${r.bfile}"${r.bfile} </a> </div>`
			
			/* <a href=" get 메소드방식 "> </a> */ 
      
      	html += `<a href="list.jsp"> <button type="button"> 목록보기 </button> </a>`
      	// 3. 만약에 본인글 인지 제어 [ 본인글이면 수정/삭제 표시함 / 아니면 표시안함 ]
      	if( r.ishost ){// 클릭된 게시물 번호 삭제 
			  html += `<button onclick="ondelete(${r.bno})" type="button"> 삭제 </button>
						<button onclick="onUpdate(${r.bno})" type="button"> 수정 </button>`
		  }
      // 3. 
      boardBox.innerHTML = html;
      
      } ,       
      error : e => {console.log(e);} ,         
   });
		
}// f e

// 2. 게시물 삭제 -> 레코드 삭제 -> 레코드 식별 -> Pk
function ondelete(bno){
	
	// 
	 $.ajax({
      url : "/jspweb/BoardController",      
      data : {bno : bno},      
      method : "delete",   
      success : r => {console.log(r)
   		 if(r){   
      		alert('삭제성공');
      		location.href="/jspweb/board/list.jsp";
      		}else{alert('삭제 실패'); }
      } ,       
      error : e => {} ,         
   });
	
}//  f e

// 3. 게시물 수정 페이지로 이동 
function onUpdate(bno){
	
	// 1. 수정페이지로 이동 
	location.href=`/jspweb/board/update.jsp?bno=${bno}`
	// 수정버튼을 눌렀을때 기존페이지가 나와야 한다.
	
}//  f e





















