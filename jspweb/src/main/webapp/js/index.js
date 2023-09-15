


// 1. N개 제품들을 최신순으로 출력 함수 
function findByTop( count ){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByTop" , count : count },      
      method : "get",   
      success : r => {console.log(r); } ,       
      error : e => {} ,         
   });
	
}// f  e

// 2. 
function findByLatLng( east , west , south , north ){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByLatLng" , east : east , west : west , south : south , north : north  },      
      method : "get",   
      success : r => {console.log(r); } ,       
      error : e => {} ,         
   });
	
}// f  e

// 3. 
function findByPno(pno){
	
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByPno" , pno : pno },      
      method : "get" ,   
      success : r => {console.log(r); } ,       
      error : e => {} ,         
   });
	
}//  f  e

// 4. 
function findByAll(){
	
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : { type : "findByAll" },      
      method : "get" ,   
      success : r => {console.log(r); } ,       
      error : e => {} ,         
   });
	
}//  f  e





