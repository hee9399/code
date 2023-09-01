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