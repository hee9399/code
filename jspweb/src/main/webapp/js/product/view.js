console.log('js실행 됩니다.');

// * 게시판상세페이지 , 제품상세페이지 에서는 클릭된 식별자[제품번호] 

// 스크립트는 휘발성이라 페이지가 바뀌면 다 사라진다.  
	// 왜? html 을 종속 받기 때문에 
	
// URL(인터넷 주소) 에서 매개변수(쿼리스트링) 가져오기 
	// 쿼리스트링(http주소상에있는)에있는 pno
let pno = new URL( location.href ).searchParams.get("pno");
// new URL(location.href).searchParams.get("키");
// <a href="/jspweb/product/view.jsp?키=값&키=값&=값">

// 1. pno에 해당하는 제품1개 호출 
findByPno(pno);
function findByPno(pno){
	
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByPno" , pno : pno },      
      method : "get" ,   
      success : jsonObject => {
		  console.log(jsonObject); 
		  
		  // ---------- 캐러셀에 이미지 여러개 대입 ----------------------- //
		  let imgbox = document.querySelector('.imgbox');
		  
		  let html = ``;
		  
		  Object.values( jsonObject.imgList ).forEach( (img,i) => {
			  
			  // 첫번째 이미지에만 active클래스 삽입 , active : 현재화면을 보여주는태그[부트스트랩에서 가져옴]
			  html += `<div class="carousel-item ${i==0 ? 'active' : ''} "> 
					      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
					    </div>`;
					  
		  });
		  imgbox.innerHTML = html;
		  
		  // ---------------- 각 위리에 데이터 넣어주기 ------------------------ // 
		  document.querySelector('.mid').innerHTML = `판매자 : ${jsonObject.mid}`;
		  document.querySelector('.pcname').innerHTML = `카테고리 : ${jsonObject.pcname}`;
		  document.querySelector('.pdate').innerHTML = `등록일 : ${jsonObject.pdate}`;
		  document.querySelector('.pname').innerHTML = `${jsonObject.pname}`;
		  document.querySelector('.pprice').innerHTML = `${jsonObject.pprice.toLocaleString()}원`;
		  document.querySelector('.pcontent').innerHTML = `${jsonObject.pcontent}`;
		  
		  } ,    
		     
      error : e => {} ,         
   });
	
}//  f  e


// 2. 찜하기 등록 [ 비회원제 : ip주소 / 디바이스식별번호 , 회원제 : header.js에 회원식별번호가 존재한다. ]
function setWish(){
	
	// 1. 회원제 유효성검사.  header.js에 회원식별번호가 존재한다.(전역변수 가져오기)
	if( loginState == false ){ alert('로그인후 가능한 기능입니다.') }
	
	// 2. ajax 요청 
		 $.ajax({
	      url : "/jspweb/PwishListController",      
	      async : false , // 동기화 
	      data : {pno : pno},      
	      method : "post",   
	      success : r => {
			  console.log(r);
			  if(r){ getWish(); }
			  else{  }
			  } ,       
	      error : e => {} ,         
	   });
	
}// f   e

// 3. 찜하기 상태 호출
getWish(); 
function getWish(){

	let wish = document.querySelector('.wish'); // 하트 구역 가져오기 

	// 1. 비회원이면
	if( loginState == false ){ wish.innerHTML = '♡'; }
	
	// 2. ajax 요청 
		 $.ajax({
	      url : "/jspweb/PwishListController",      
	      data : { type : "finByWish" , pno : pno},      
	      method : "get",   
	      success : r => {
			  console.log(r);
			  if(r){wish.innerHTML = '♥'; }
			  else{wish.innerHTML = '♡';}
			  
			  } ,       
	      error : e => {} ,         
	   }); 
	
		
	
}//f e
























