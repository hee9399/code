package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MemberFindController() {}

    
    // 하나의 메소드의 여러개 ajax 와 통신할때는 type 데이터 전송한다( 숫자가 1:아이디중복검사 2:이메일중복검사 vs 필드명 : mid : 아이디중복검사 memail : 이메일중복검사 )
    // doGet 메소드에 아이디 유효성검사 메소드에 ajax와 이메일중복검사 메소드의 ajax 가 들어올껀데 type을 1과2로 나눈다는것이다 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다 
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		// 2. 객체화/유효성검사 
		
		// 3. DAO 요청 결과 
		boolean result = MemberDao.getInstance().findIdorEmail(type, data);
		// 4. 결과 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	// 로그인 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 매개변수 요청 
		 	// js필드명과 똑같이 맞춘다 
			// request
		String mid = request.getParameter("mid");	System.out.println("mid : "+mid);
		String mpwd = request.getParameter("mpwd");	System.out.println("mpwd : "+mpwd);
		
		
		// 2. ( 객체화/유효성검사 )
		
		// 3. DAO 에게 전달후 결과 받기 
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// - 만약에 로그인 성공하면 세션에 로그인한 정보를 담기 
		if(result == true ) {
			
			// 1. 세션에 저장할 데이터를 만든다.
			MemberDto loginDto = MemberDao.getInstance().info(mid); System.out.println("다오결과"+loginDto);
			
			// 2. 세션에 저장한다.
			request.getSession().setAttribute("loginDto",loginDto); 
			// * 새션 상태 확인 
				// 강제 타입변환 
				MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
				System.out.println( "세션 상태 : "+dto );
				
		}// if e
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		
		
	}

}

/*
 	- 저장소 
 		우리가 설계를할때 누구를 어디다 저장해야하지? 
 		1. java/js 일반 변수들 , 메모리 
 			- 휘발성( 스크립트끄거가 자바가종류되거나 실행되거나 페이지전환되거나  새로고침되거나 타서 날라간다/사라진다/초기화 , 이동객체  )
 			- DTO 이동객체 , 로직에 필요한 변수들 ( 생성조건에 따라 사용범위가 다르다. )
 			
 			세션객체(  static 으로된 전역변수  )  : 모든 곳에서 동일한 메모리 사용
 				장점 : 모든 곳에서 동일한 메로리 사용 가능하다. , 동일한주소값 사용
 				단점 : 프로그램 혹은 서버가 종료될때까지 유지/메모리 가 많이 소비된다.
 				
 				- 주로 로그인정보 : 왜? 페이지가 전환되더라도 로그인 상태는 유지를 해야하기 때문에 
 			
 		2. DB 메모리
 			- 영구 저장 [ 논리구조(관계형/표) 저장 ]
 			- 회원정보 , 게시판정보 , 제품정보 등등 
 			- 실제 데이터
 			
 		3. 파일처리
 			- 영구 저장 [ 문자열 저장 ]
 			- 로그/기록 ( 예외처리 오류 정보 , 접속수 , 최상위 보안 자료 )
 			- 실제 데이터
 			
 		4. 세션
 			- 
 
   		로그인 했다는 증거 => 인증 [  인증서 -> 세션에 저장  ]
  			js : sessionStorage		: 모든 js에서 사용가능한 메모리 공간 [ 문자열 타입 ]
  				- 스크립트에서 섹션에 데이터 추가
  				세션저장 : sessionStroage.setItem( 키 , 데이터 );
  				세션호출 : sessionStorage.getItem( 키 );
  			
  			java(서블릿) : request.getSession() : 모든 서블릿 에서 사용가능한 메모리 공간 [ Object ]
  				세션타입 : Object [ 필수 ]
  				세션저장 : request.getSession().setAttribute("속성명",값);
  				세션호출 : request.getSeesion().getAttribute( "속성명" );
  				세션
  				
  	서블릿
  		내장객체 
  			request - 요청객체 ( 서블릿에서 요청할때 누구한테? js한테 )
  				request.getParameter();		:  ajax으로 부터 전달된 데이터 요청 
  			
 			response - 응답객체 ( js에게 응답한다. )
  				response.getWriter().print() 	: ajax에게 전달할 데이터 응답  		
  			    response.setContentType("application/json;charset=UTF-8");  :  [ 데이터 타입 설정 ] , 제이슨에게 보낼꺼야
 					- jackson이라는 라이브러리로통해 js와 통신한다
 					- 
 					
 		오버로딩 :	동일한 메소드나 생성자에 인자값의 타입이 다르면 다른함수로 인식한다 , 인자의 타입으로 오버로딩을 하는것이다 , 오버로딩은 인자로판단하는것이 아니고 타이븡로판단한다
 		
 	    오버라이드 : 상속받은것을 정의한다
 					
 		set - 저장
 					
 		get - 꺼내기 set에서 저장한것을 get으로 꺼낸다.	
 */































