package test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test07
 */
@WebServlet("/Test07")
public class Test07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Test07() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age") );
			// Integer.parseInt() : 문자열타입 => 정수형타입 변환
			// request.getParameter() : 무조건 값을 문자열로 반환
			System.out.printf("[JS] AJAX 가 보내는 테이터 : %s %d \n" , name , age);
		
			// 2. Dao 처리 / 비지니스로직 [ 처리 ]
		
		// 3. 응답
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
