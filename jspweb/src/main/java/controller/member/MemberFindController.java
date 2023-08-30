package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import model.dao.MemberDao;

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
		String mid = request.getParameter("mid");	System.out.println("mid : "+mid);
		String mpwd = request.getParameter("mpwd");	System.out.println("mpwd : "+mpwd);
		
		
		// 2. ( 객체화/유효성검사 )
		
		// 3. DAO 에게 전달후 결과 받기 
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
