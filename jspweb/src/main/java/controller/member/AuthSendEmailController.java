package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmailService;


@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AuthSendEmailController() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청하기 
		String memail = request.getParameter("memail"); System.out.println("memail : "+memail);
		
		// 2. 인증번호 생성 [ 난수 6자리 ]
		String auth = "";
		for(int i = 0; i<6; i++) {
			
			Random random = new Random(); 	// 랜덤 객체
			auth += random.nextInt(10);		// 0~9 random.nextInt(끝수); : 0~끝수 범위내 난수생성	
			
		}System.out.println("생성자 6자리난수 : "+auth);
		
		
			
		// 3. 인증번호를 해당 이메일에게 전송 [ 전송할때는 라이브러리가 필요하다 SMTP가 필요함 ]
			// SMTP : 간이 우편 전송 프로토콜 
			// 이메일 기능 도메인 : 네이버 , 다음 , 구글 
		// 메일 서비스 객체 선언 
		EmailService emailService = new EmailService();
		
		//
		emailService.authsend(memail, auth);	
		
		// 4. 인증번호 반환 
		response.getWriter().print(auth); // 아작트에게 보낸다 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}


























