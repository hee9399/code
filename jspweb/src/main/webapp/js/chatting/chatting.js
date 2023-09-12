
// loginState - header.js 에서 가져온 변수 

// * ajax(기본값이 비동기통신이다)가 응답의 결과를 가지교ㅗ 오기전에 아래코드가 실행된다. ,  loginState 변수가 변경되기 전에 실행되므로 문제가발생한다.
// - 해결방안 ajax 동기화 통신 하자..
// 1. 비 로그인시 입장 불가능.. , 회원제 체팅 이기때문에 
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"; }
// 2. JS 클라이언트[유저] 소켓 만들기 
console.log('채팅방에 입장한 아이디 : '+loginMid);
 
// 2. JS 클라이언트[유저] 소켓 만들기 
	// 스크립트 기준으로 소켓이 만들어진다. 
	// new WebSocket 를 하게되면 자바 서버는 @OnOpen로 받는다.
let clientSocket = new WebSocket(`ws://localhost:80/jspweb/serversocket/${loginMid}`); // 서버소켓 [ 서버로 보낸다 ]
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속한다 ----> 서버소켓의 @OnOpen 으로 이동
	// - 서버소켓URL에 매개변수 전달하기[ - 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
	
	// --- 메소드 
		// 커스텀한다 
		// 자동으로 받기위해
		// 이 라이브러리는 커스텀을이용해서 주고 받아야한다. 
		// 1. (자동실행) 클라이언트 소켓이 정상적으로 서버소켓에 접속했을때
	clientSocket.onopen = e => { 
		// 1-2 : 만약에 접속을 성공하면 알림메시지 전송 
		let msg = { type : "alarm" , content : `${loginMid}님이 입장했습니다.`} 
		// clientSocket.send(msg); // 그냥 전송하면 문제발생 : 해당 메시지를 받는 JAVA는 JSON타입을 모른다 그래서 문자열 타입으로 전송해야한다. , JSON.stringify 사용
		// 타입 : 각메모리를 저장한다 
		// 
		clientSocket.send( JSON.stringify(msg) );
		
	}; 
		// 2. (자동실행) 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때 
	clientSocket.onerror = e => { console.log('서버와 오류발생: '+e);  };
		// 3. (자동실행) 클라이언트 소켓이 서버소켓과 연결이 끊겼을때.
	clientSocket.onclose =  e => { console.log('서버와 연결이 끊김: '+e); };
		// 4. (자동실행) 클라이언트소켓이 메시지를 받았을때.
			// onmessage가 발동하면 onMsg함수 실행한다.
	clientSocket.onmessage = e => onMsg(e); 
	// send 보내기는 없음
	
	
// 3. 서버에게 메시지 전송 	
function onSend(){
	// 3-1 textarea 입력값 호출 
	let msaValue = document.querySelector('.msg').value;
	if(msaValue == '' || msaValue == '\n'){ 
		document.querySelector('.msg').value = ``;
		return; 
	}
	
	// 3-2 메시지 전송 
	
	let msg = {type : 'message' , content : msaValue }
	
		// send 를 하게되면 자바서버에서는 onMessage를 받는다.
			// msg - 보낸사람 
	clientSocket.send( JSON.stringify(msg) ); // 클라이언트 소켓과 연결된 서버소켓에게 메시지 전송 ----> 서버소켓의 
	
	// 3-3 메시지 전송 성공시 
	 document.querySelector('.msg').value = ``;
	  
	
}// f  e


// 4. 메세지를 받았을때 추후 행동(메소드) 선언 
function onMsg(e){ // 매개변수는 아무말이나 사용가능 
	console.log(e); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체 
	console.log(e.data); // 메시지를보내면 해당 메시지는 개발자도구함에 data에 담기기때문에.
	
	let msgBox = JSON.parse( e.data ); // e.data : 서버로 부터 전달받은 내용물 e.data 속성에 있는 
	// 객체안에있는 또다른객체ㅐ를 parse 해서 json형태로 전달한다. 
	msgBox.msg = JSON.parse( msgBox.msg );
	
	// 2. msg속성내 content(메시지내용) 속성의 \n 를 <br>로 바꾼다  치환후 결과를 content속성에 대입 
		// - replace() 문자열 교체/치환/바꾸기 함수 , 숫자처리불가능
	msgBox.msg.content.replace( /\n/g , '<br>' );
	
	
	// 1. 어디에 출력할껀지 
	let chatcont = document.querySelector('.chatcont');
	
	// 2. 무엇을 
	let html = ``;
		// 만약에 메시지 타입이 알람 이면 
		if( msgBox.type == 'alarm' ){
			html += `${typeHTML(msgBox.msg)}`;
		}
		// 만약에 메시지 타입이 알람이 아니면 
		// 2-2 만약에 내가 보냈으면.[ 보낸사람아이디와 로그인된사람의 아이디와 같으면 ]
			// 4번 함수에서 치환덴 content 변수를 html에 대입하면 체팅 보낼때 줄바꿈 처리가되어서 보내진다.
		else if( msgBox.frommid == loginMid ){
			html += `<div class="rcont">  
					<div class="subcont">
						<div class="date"> ${msgBox.date} </div>
						${typeHTML(msgBox.msg)}
					</div>
				</div>`;
		}else{// 2-2 내가 보낸 내용이 아니면 
			html += `		<div class="lcont">  
					<img class="pimg" src="/jspweb/member/img/${msg.frommimg}" />
					<div class="tocont">
						<div class="name"> ${msgBox.frommid} </div> 
						<div class="subcont">
							${ typeHTML(msgBox.msg) }
							<div class="date"> ${msgBox.date} </div> 
						</div>
					</div>
				</div>`;
		}
	 
	
	// 3. 누적 대입 [ 기존 채팅목록에 이어서 추가 += ]
	chatcont.innerHTML += html;
	
	// ----------------------- * 만약에 스크롤 최하단으로 내리기 ( 스크롤 이벤트 ) ----------------------------- //
	// 1. 현재 스크롤의 상단 위치 좌표.
	// let topHeight = chatcont.scrollTop; // dom객체.scrollTop : 해당 div의 스크롤 상단위치 
		// console.log(topHeight);
	// 2. 현재 dom객체의 전체 높이 
	// let scrollHeight = chatcont.scrollHeight; // dom객체.scrollHeight : 헤당 div의 전체 높이 
		// console.log(scrollHeight);
	// 3.  전체 높이 값을 현재 스크롤 상단 위치에 대입 
			// chatcont - 채팅창목록 
	chatcont.scrollTop = chatcont.scrollHeight;
	
}// f  e

// 5. textarea 입력창에서 입력할때마다 이벤트 발생 함수 
function onEnterKey(){
	// 2. 만약에 [pc카톡기준] ctrl + enter 이면 줄바꿈처리한다. 
	if( window.event.keyCode == 13 &&  window.event.ctrlKey ){ // 조합키 : 한번에 두개 이상 입력 가능한 키 [ ctrl.shift+alt ]  
		 document.querySelector('.msg').value += `\n`; return;
	}
	// 1. 만약에 입력한 키 가 [엔터] 이면 메시지 전송 
	if( window.event.keyCode == 13 ){onSend(); return;}
	
	
	
}//f  e

// 6. 이모티콘 출력하기 
getEmo(); // 이모티콘 가져오는 함수
function getEmo(){
	
	// - 여기서 i는 해당 이미지의 순서번호 
	for(let i = 1; i<=43 ; i++ ){
		document.querySelector('.emolistbox').innerHTML
			+= `<img 
				onclick="onEmoSend(${i})"
			src="/jspweb/img/imoji/emo${i}.gif" />`;
	}
	
}// f  e

// 7. 클릭한 이모티콘 서버로 보내기/전송하기.
function onEmoSend(i){
	
	// 1. msg 구성 
	let msg = { type : 'emo' , content : i+"" }; // i는 int타입이다 i+"" 큰따옴표를 처리해서 문자열까지 통합해서 사용한다.
		// 여기서 type 은 msg[메시지] , emo[이모티콘] , img[사진] 메시지면 메시지 이모티콘이면 이모티콘
		// content : 내용물 
		
	// 2. 보내기 
	clientSocket.send(JSON.stringify( msg ) );
			// JSON타입을 String타입으로 변환해주는 함수. [ 모양/형식/포멧 : JSON ]
	
}// f  e

// 8. msg 타입에 따른 html 반환 함수 
function typeHTML( msg ){
	
	html = ``;
	
	// 1. 메시지 타입 일때는 <div> 반환 
	if(msg.type == 'message'){
		html += `<div class="content"> ${msg.content} </div>`; // 메시지면 메시지전송
	}
	
	// 2. 이모티콘 타입 일때는 <img> 반환 
	else if(msg.type == 'emo'){
		html += `<img src="/jspweb/img/imoji/emo${msg.content}.gif" />`; // 이모티콘이면 이모티콘 전송 
	}
	// 3. 만약에 알림 타입 일때는 <div> 반환 
	else if( msg.type == 'alarm' ){
		html += `<div class="alarm"> ${msg.content} </div>`;
	}
	return html; 
	
}// f  e


/*

	[JS]스크립트는 HTML파일에 종속된 파일이에요 HTML안에서 실행되는 파일이라는거죠 , HTML이 없으면 실행이 되지않는다.
	그래서 스크립트는 노드JS가 나오기 전까지는 인기가 많은편이였어요. 
	노드JS는 스크립트가 없어도 백엔드로 사용하는거에요.
	HTML두번켰으면 스크립트를 두번 실행한거에요.  , 코드는 하나지만 코드를실행시키는건 여러개라는거에요. 
	
	* 소켓이란. 
		- 통신의 종착점[ 데이터가 전달되는 위치 - 받는사람 - 보낸사람 ]
	
	 * WebSocket 웹소켓 라이브러리 
		* 소켓 관련된 함수들을 제공하는 클래스 
		
		* 클라이언트라는거는 사용자/요청 를 말해요 
			서버 : 데이터 주는 PC [ 데이터를 주는/전달해주는 ]
			1. 웹소켓의 객체를 생성해야한다.
				new WebSocket("ws://IP주소:PORT번호/프로젝트명/서버소켓경로");
			2. 서버는 한번키지만 여러명에게 실행시켜준다. 
			
		* URL[주소] 상의 매개변수 전달하는 방법 
			1. 쿼리스트링 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
			2. 경로매개변수명 : URL/데이터1/데이터2/데이터3

		* 소켓이란?
			- 통신의 종착점[ 데이터가 전달되는 위치 - 받는사람 -보낸사람 ]
			
		예) 
			// 레시피는하나인데 실행되는 거는 두개인거에요. 
				만드는사람과 사용하는사람은 다르다 , 사용자의 입장에서 테스트를 해봐야하기때문에 
			- 강호동이 우체국에 보내고 우체국이 신동엽	집에 보낸다. 
			
			[ 클라이언트소켓 ]				[ 서버소켓 ]
			JS = 강호동의집 					우체국[서버소켓이된다]
				안산시 상록구[소켓]
				
			JS = 신동엽의집 
				상록구 영통구[소켓] 		
				
		* ajax - 아작트는 통신하는 애인데 동기화하고 비동기화라는게 존재해요. , 아작트는 기본값이 비동기 에요. 
		
		동기화[ 첫번째 요청의 결과에 따라 다음 요청이 필요할때 이럴때는 동기화를 사용해야해요 ]
		
			동기화 Client 와 Server 라는게있고 
			동기화는 하나의 아작트로 서버로부터 요청을 보내고 응답을받아요 
			마냐게 요청이 여러개일때  서버는 처리중일때는 한번더보내요 
			동기화는 watting 순서가있어요 순서대로 처리해요 , 흐름이 하나라는거에요 , 대기상태를 만들어요 
			동기화는 요청을 처리중일때는 보낼수가없어요 언제까지? 처리가 끝날때 까지 
			
		비동기화[ 클라이언트가 요청을 보내고 응답의 대한 대기를 하지않는것 ]
		
			비동기화   Client(클라이언트) 와  Server	라는게 있으면 	
			비동기화도 요청을 보내고 응답을 받는데 
			비동기라는거는 watting 순서라는게 없어요 , 흐름이 여러개일수도있다 , 처리중일때 대기상태가 아니라는거에요.
			응답의 순서가 없다는건데 요청1 과 요청2가 있으면 누가먼저 응답처리할지 정해져있는게 아니라는거에요. 
			언제많이쓸까요? 예를들어 아작트가 동영상을 가져오면 가져올때 영상의 체팅 , 댓글 까지 가져와야할때 처리를따로해야하기때문에 비동기화를 사용해요. , 따로따로 가져와야하니까
	
*/ 

// ------------------------------------------- 비회원제 ---------------------------- //
			
/*
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

*/

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

	2. ( 웹 ) 소켓[양방향] : 자바와js가 서로 소켓을 알고있는상태
		소켓 : 통신의 종착점[도착위치]

		WS  :  

		js					JAVA[서버소켓]
		[클라이언트소켓]			[서버소켓]
		websocket	
		1. 서버소켓 접속 		2. 서버소캣 24시간 상시 클라이언트 소켓 명단 저장 [  ]
		3. 데이터 전송 			4. 데이터 받는다.
	
*/

/*

				클라언트[사용자]						서버[서비스회사]
			
		강호동카카오톡		
						'안녕'
				-------------------------------->
				1. 강호동 메시지(안녕) 보낸다.
				
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
				
		유재석카카오톡 
													카카오서버[제주도]
													- 전제조건 : 클라이언트의 정보들 보관
													접속된명단 : [ 강호동,유재석,신동엽,하하 ]
													2. '안녕' 메시지 받는다.
				<--------------------------------		
				3. 서버가 '안녕' 메시지 보낸다.			
		신동엽카카오톡 
		
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		하하카카오톡 
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		
*/

/*
	let msgBox = JSON.parse( e.data ); console.log( msgBox );
		// JSON.parse( ) : 문자열타입의 JSON형식을 JSON타입으로 변환 
		// JSON.stringify() : JSON타입 을 문자열 타입 (JSON형식 유지)
		console.log( msgBox.msg ); // java , js console내 출력시 줄바꿈 \n 맞음 html에서의 줄바꿈해줘야한다 <br>
		
		// 1. 특정 문자열 찾아서 1개 치환/바꾸기/교체 
		let content = msgBox.msg.replace( '\n' , '<br>' ); // replace( '변경할문자열[정규표현식]' , '새로운문자' )
		console.log(content);
		
		// 2. 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체 => java : .replaceAll();  js : 정규표현식 
		content = msgBox.msg.replace( /\n/g , '<br>' );	// \g : 동일한 패턴의 모든 문자 찾기 [전체]
		console.log(content);
	
	msgBox.msg = JSON.parse( content ); // 치환하고 다시객체에 대입한다. 
		console.log(msgBox);

*/


















