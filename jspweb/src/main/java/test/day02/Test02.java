package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test02") // @ : 어노테아숀 // 해당 클래스의 URL 매핑 : 해당클래스의 위아래 래핑을 연결해주는 어노테이션
public class Test02 extends HttpServlet { 
// HttpSeverlet 클래스부터 상속 받으면 해당 웹 관련 기능 제공 [ 1.멀티 스레드 2.예외처리 3.HTTP get,post,delete ]
	//  * 자바서블릿 HTTP의 기반으로 만들어진 클래스 
	
		// HTTP : Hypertext Transfer Protocol : 문서 교환 규칙/약속/규약/방법
			// HTTP 메소드 get : 호출 / post : 저장 / put : 수정 / delete : 삭제 
			// HTTP Body : 주고받을 데이터 저장소
				// 한글 지원x
	
		// 브라우저[ 크롬,엣지 등 ]에서 주소 입력해서 웹사이트 접속하는 방식
			// 주소창 www.naver.com => get 방식
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 콘솔출력
		System.out.println("Test02 Hello JS");
		// 2. 웹 출력
		response.getWriter().append("Test02 Hello JS");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
