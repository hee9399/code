package test.day01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  		Default constructor.
 
 * */

@WebServlet("/Test01") // 헤당 클래스의 http웹 URL 주소 // 해당 클래스를 호출하고 싶으면  http://localhost/jspweb/Test01
public class Test01 extends HttpServlet { // !!!!! : HttpServlet 서블릿클래스 상속
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test01() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> js input");
		response.getWriter().append(">>> js output : Hello Servlet ");
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
