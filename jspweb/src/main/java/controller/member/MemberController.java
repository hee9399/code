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
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberController() { }

    // 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX 통신받은 data객체의 '속성명' 요청한다. [ request ]
    	String mid = request.getParameter("mid");	System.out.println("mid"+mid);
    	String mpwd = request.getParameter("mpwd");	System.out.println("mpwd"+mpwd);
    	String memail = request.getParameter("memail"); System.out.println("memail"+memail);
    	String mimg = request.getParameter("mimg");	System.out.println("mimg"+mimg);
    	
    	// 2. 객체화
    	MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
    	
    	// 3. DAO 객체 전달후 결과 응답받고 
    	boolean result = MemberDao.getInstance().signup(memberDto);
    	
    	// 4. 결과를 AJAX에게 응답한다.
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}
    
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
