console.log('writejs open');

// 글쓰기 등록함수 
function onwrite(){
	console.log('onwrite() open')
	
	// 1. form 가져오기 
	let form = document.querySelectorAll('.writeFrom');
	console.log(form);
	// 2. form 객체화 
	let formdata = new FormData(form);
	console.log(formdata);
	
	// 3. ajax 로 form 전송하기 
	           $.ajax({
               url : "/jspweb/BoardController" , // 서블릿 누구랑 통신할껀지
               method: "post" ,
               data : "" ,
               contentType : "" ,
               processData : "" ,
               success : r => { console.log(r) } ,
               error : e => { console.log(e) } ,
            })
	
}// f e