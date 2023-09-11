package controller.chatting;

import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;


@ServerEndpoint("/serversocket/{mid}") // chatting.js 와 통신한다.
public class ServerSocket {

	// 0. 접속된 클라이언트소켓들의 저장소. 
		// clienList 는 메세지를 받았을때 저장시키는 객체이다. 
	public static List<ClientDto> clientList = new Vector<>();
	
	// 1. 클라이언트 소켓으로부터 접속을 받았을때  , js 에서  new WebSocket 을했을때 	
	@OnOpen // 매개변수 : 1. 접속된 클라이언소켓(세션) 2. 접속된 회원아이디 
	public void onOpen( Session session , @PathParam("mid") String mid ) { // header.js에 아작트에서 로그인이 성공 됬으면 mid를 가져온다.
		System.out.println("클라이언트 소켓이 입장했습니다."+ session);
		System.out.println("접속한 회원아이디 "+mid);
		// 1-1 : 접속된 클라이언트 소켓을 리스트에 저장하자.
			// 우리가 접속시키는 클라이언트는 dto에 저장했기때문에 dto를 사용한다.
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add( clientDto );
		System.out.println("접속된 클라이언트들 : "+clientDto);
	}
	// 2. 
		// 에러가 났을때 
			// Throwable throwable  - 에러에 추가할 매개변수 해주지않으면 오류가뜬다. 
	 @OnError
	 public void onError( Session session , Throwable throwable ) {
		 
	 }
	
	// 3. 클라이언트 소켓 과 서버소켓이 연결이 끊겼을때.
	@OnClose 
	public void onClose( Session session ) {
		// * 접속목록에서 세션 제거 
		for( ClientDto clientDto : clientList ){// 접속목록에서 연결이 끊긴 세션 찾기 
			if( clientDto.getSession() == session) {
				// 클라이언트소켓이 세션과 연결이 끊긴 세션과 같으면 해당 dto를 제거한다. 
				clientList.remove(clientDto);
				break;
			}// if e
		}// for e 
	}// 
	
	// 4. 
		// @OnMessage 는 js 에서 send를 받는다 
	@OnMessage	// 매개변수 : 1. 메시지를 보낸 클라이언트소켓(세년) 2. 메식지 내용[ 문자열 ]
	public void onMessage(Session session , String msg ) throws Exception {
		System.out.println("보낸 클라이언트소켓[누가] : "+session+" 보낸내용[무엇을] :  "+msg);
		
			// 2-2 메시지를 보낼 내용 구성. [ 보낸사람 , 보낸내용 ] 
			MsgDto msgDto = null;
				// - 보낸사람 찾기 [ 보낸 세션 을 이용한 보낸 mid 찾기 ]
				for( ClientDto clientDto : clientList) {
					if( clientDto.getSession() == session ) {
						// 회원목록중에 보낸세션과 일치하면 
						msgDto = new MsgDto( clientDto.getMid() , msg );
						break;
					}
				}
				// - msgDto를 json 사용할수 있도록 형변환 
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonMsg = objectMapper.writeValueAsString(msgDto);
		
		// 2-1 받은 메시지를 접속된 회원들에게 모두 전송 
			// 접속되있는 회원들은 client소켓에 있다
		for( ClientDto clientDto : clientList ) { // 회원목록에서 하나씩 회원 꺼내기 
			clientDto.getSession().getBasicRemote().sendText(jsonMsg); // 예외처리 필수 
			
		}// for e
	}
	
	
	
}// class e

/*
  
  	* WebSocket 서버 소켓 라이브러리를 제공한다.
  		1. 서버소켓 클래스 생성 
  			- 클래스위에 서버소켓의 URL 만들기 
  			@ServerEndpoint("/ServerSocket")
  			@ServerEndpoint("/Serversocket/{매개변수1}/{매개변수2}") , 매개변수를 넣을때 중괄호처리한다.
  		
  		2. 서버소켓 메소드 제공한다.
  			주의할점 - 메소드 매개변수의 규칙이 존재한다. 매개변수에 Session 을 사용한다.
  			// 메소드를 쓸때 오버라이드로 들어가다보니까 @OnOpen 에 첫번째 매개변수에는  Session을사용한다 , 하나의 공식 이라고 생각하면된다.
  			 	* Session - 클라이언트소켓의 정보를 받아준다. [ - 클라이언트의 ip는 확인이 불가능하다. ]
  			 	
  			 	@는 어노테이션을 말한다 
  			 	
  			1. 클라이언트 소켓이 접속했을때 , 실행되는 메소드 
  			@OnOpen
  				1. 
  				public void onOpen( Session session ) {}

  					Session - 서버소켓의 접속된 클라이언트소켓 정보 
  				
  				2. 클라이언트 소켓과 오류가 발생했을때 , 실행되는 메소드 
  				public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
  					- @PathParam("매개변수명1") 타입 매개변수명 - 서버소켓(url) 경로상의 매개변수를 호출 
  					
			
			3. 클라이언트 소켓과 연결이 끊겼을때 , 실행되는 메소드 
			@OnError
			 public void onError( Session session , Throwable throwable ) {}
			 	- Session : 서버소켓과 오류가 발생한 클라이언트소켓 정보 
			 	- Throwable : 오류 발생한 사유 정보 
			
			4. 클라이언트 소켓으로부터 메시지를 받았을때. 실행되는메소드 
			@OnClose
			public void onClose( Session session ) {}
				- Session : 서버소캣과 연결이 끊긴 클라이언트소켓 정보 
			
			4. 클라이언트 소켓으로부터 메시지를 받았을때. (자동실행)되는 메소드
				@OnMessage
					public void onMessage( Session session , String msg ) { } 
						- Session : 서버소켓에게 메시지를 보낸 클라이언트소켓 정보 
						- String 매개변수 : 클라이언트소켓으로 부터 받은 메시지 [문자열타입]
						
				5. 클라이언트소켓에게 메시지 전송 
					클라이언트소켓.getBasicRemote().sendText("내용");
 
 */















