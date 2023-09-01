
let 헤더변수 = "헤더변수데이터";
let loginState = false; /* 로그인 상태 true:로그인중 false 비로그인 */ 

// 1. 현재 로그인된 회원정보 요쳥 

getMemberInfo();

function getMemberInfo(){
	
	           $.ajax({
               url : "/jspweb/MemberController" , 
               method: "get" ,
               data : {type : "info"} ,
               success : r => { console.log(r) 
               	// r 은 키 : 값 을 받은 상태이다. r은 객체이다 
               	
               	// 로그인 상태에 따른 서로다른 html 구성 
               	let submenu = document.querySelector('.submenu');
               	let html = ``;
               	
               	
               	
               	if( r == null ){// 비로그인 , 로그인이 안된상태
               		loginState = false;
						   html += `<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a> </li>
				<li><a href="/jspweb/member/login.jsp"> 로그인 </a></li>`
				   }else{// 로그인 된상태 
					   	   loginState = true;
					  
					   html += ` <li> ${ r.mid } 님 </li>
						<li> <img class="hmimg" src="/jspweb/member/img/${ r.mimg }" /> </li>
						<li> <a href="/jspweb/member/info.jsp">마이페이지</a> </li>
						<li> <a onclick="logout()" href="#">로그아웃</a> </li> `
					   
					if( r.mid = "admin" ){}// 로그인 관리자 메뉴 
				   }
				   // 구성된 html 대입 
               submenu.innerHTML = html;
               
               } ,
               error : e => { console.log(e) } ,
            })
	
}// f e

// 2. 로그아웃 함수 
function logout(){
	
	   $.ajax({
      url : "/jspweb/MemberController",      
      data : {type : "logout"},      
      method : "get",   
      success :  r => {
		  alert('로그아웃 되었습니다.');
		  location.href="/jspweb/index.jsp";} ,       
      error :  e => {} ,         
   });
	
}// f e




































