console.log('js실행됩니다');

// 1. 제품 등록
function onRegister(){
	
	// 1. from dom객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0]; 
	console.log('registerForm도착'+registerForm);
	
	// 2. formData 객체생성 [ ajax 전송타입 : multipart/form-data ]
	let fromData = new FormData(registerForm);
	console.log(fromData);
	
	// 3. 
	$.ajax({
      url : "/jspweb/ProductInfoController",      
      data : fromData ,      
      method : "post",   
      // 1. text/html , 2. application/json , 3. multipart / form-data
      contentType : false , // form은 multipart속성이기때문에 json타입을 사용하지않는다. 
      processData : false ,
      success : r => {
		  console.log(r);
		  
	  } ,       
      error : e => {
		  console.log(e);
	  } ,         
   });
	
}//f  e
































/*  
// 1. form 사용하지 않았을때
function register1(){
	
	   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : {
		  pname1 : document.querySelector('.pname1').value ,
		  pcontent1 : document.querySelector('.pcontent1').value
		  
	  },      
      method : "post",   
      success : r => {
		  console.log(r);
	  } ,       
      error : e => {} ,         
   });
	
}// f  e

// 2. form 사용시
function register2(){
	
	let registerForm1 = document.querySelectorAll('.registerForm1')[0];
	let formData = new FormData(registerForm1);
	// formData 에는 multipart속성이 있기때문에 multipart타입을 사용한다.
	
		   $.ajax({
      url : "/jspweb/ProductInfoController",      
      data : formData ,      
      method : "post",   
      // 1. text/html , 2. application/json , 3. multipart / form-data
      contentType : false , // form은 multipart속성이기때문에 json타입을 사용하지않는다. 
      processData : false ,
      success : r => {
		  console.log(r);
	  } ,       
      error : e => {} ,         
   });
	
}//  f  e
*/