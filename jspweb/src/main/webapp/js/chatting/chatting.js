
// 1. 클라이언트 소켓 만들기 

	// 1. JS웹소켓 객체 [ webSocket클래스 ]
		//서버소켓에 누구랑 통신할껀지
			// new WebSocket( 'ws//ip주소:포트번호/프로젝트명/서버소켓URL' );
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); 
	// 2. opopen , onclose , send , onmessage

	// 내가 만든 함수를 클라이언소켓 속성에 대입 
	클라이언트소켓.onmessage = ( event ) => onmsg(event);

	// 2. 연결된 서버소켓으로 부터 메세지를 받았을때 
	function msgsend(){
	
	// 1. input 입력된 값 가져오기 
	let msg = document.querySelector('.inputcontent').value; console.log('msg객체 도착'+msg);
	
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send( msg ); // 1. input에서 입력받은 데이터를 보내기 , send를 해주면 자바 @OnMessage에게 전달한다
	console.log('클라이언트소켓에 도착');
	
	// 2. open()
	
	
}//f e

// 3. 연결된 서버소켓에게 메세지 보내기
function onmsg(event){
	console.log(event);
	console.log(event . data);
	
	document.querySelector('.contentbox')
		.innerHTML += `<div> ${event.data} </div>`

}// f  e

/*

	1. AJAX[단방향]
	
		주체자 : 
		JS					JAVA[서블릿]


		 아작트에서 서블릿에보내고 서블릿에서 아작트에게 보낸다
		AJAX
				rest	get
						post
						put
						delete

	2. ( 웹 ) 소켓[양방향]
		소켓 : 통신의 종착점[도착위치]

		WS  :  

		js					JAVA[서버소켓]
		[클라이언트소켓]			[서버소켓]
		websocket	
		1. 서버소켓 접속 		2. 서버소캣 24시간 상시 클라이언트 소켓 명단 저장 [  ]
		3. 데이터 전송 			4. 데이터 받는다.
	
*/

/* 

					클라이언트[사용자]			서버[서비스회사]
	강호동카카오톡
			1. '안녕' 이라고 보낼때 서버한테 보내는것이다 사람에게 보내는것이아니다
	
	유재석카카오톡
											카카오서버[제주도]
											2. '안녕' 메세지 받는다.
				<------------------------------
				3. '안녕' 
				
	신동엽카카오톡
	
	
	하하카카오톡 


*/