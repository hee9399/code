package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;

/**
 * Servlet implementation class VisitlogController
 */
@WebServlet("/VisitlogController") // 해당 서블릿(자바) / 컨트롤러 클래스를 호출하는 HTTP 매핑주입
public class VisitlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VisitlogController() {super(); }
    
    // 1. 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. AJAX의 DATA속성에 있는 객체 정보(스크립트 객체의 속성명)를 호출하기 
    	// request.getParameter("객체의속성명")
    		// request.getParameter("vwriter"); 스크립트에있는 vwriter 호출한다 
    	String vwriter = request.getParameter("vwriter"); System.out.println("vwriter:"+vwriter);
    	String vpwd = request.getParameter("vpwd"); System.out.println("vpwd:"+vpwd);
    	String vcontent = request.getParameter("vcontent"); System.out.println("vcontent:"+vcontent);
    	
    	// 2. 객체화
    	VisitDto visitDto = new VisitDto(vwriter, vpwd, vcontent); System.out.println("visitDto:"+visitDto);
    	
    	// 3. DAO 객체 전달후 결과 응답받고 
    	boolean result = VisitDao.getInstance().vwriter(visitDto);
    	
    	// 4. 결과를 AJAX에게 응답한다.
    	// getWriter() 에게 print로 응답한다 
    	// 문자 true로 보낸다 
    	response.setContentType("application/json;charset=UTF-8"); // js에게 true를 보낸다 , json은 스크립트 캑체이다 스크립트에게 보낼때 사용한다.
    	response.getWriter().print(result);
    	
	}
    // 1. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [x] : 모든 글 출력은 조건이 없으므로 요청값이 없다. vs 개별 글 출력 : 조건이 출력일 글 번호 
		
		// 2. 객체화 [x]
		
		// 3. DAO
		ArrayList<VisitDto> result = VisitDao.getInstance().vread();
			// JS는 ArrayList타입을 사용할수 없으므로  ArrayList타입을 JSON배열로 변환해서 전달해야한다 [ 라이브러리 : jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		// JSON타입으로 변환은 불가능하지만 왜? 현재 자바에서 진행중이기때문에 그치만 JSON형식의 문자열로 변환 가능하다. 
		String jsonArray = objectMapper.writeValueAsString(result);
		
		// 4. 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}

	 // 1. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	 // 1. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
