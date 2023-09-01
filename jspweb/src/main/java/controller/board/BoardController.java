package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardController() {}
       
    
    // 1. 전체조회 2. 개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 1. 쓰기 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤러post도착");
		
		// 0. 첨부파일 업로드 [  cos.jar(외부라이브러리가필요함) -> 
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				request.getServletContext().getRealPath("/board/upload"), // 저장경로 (워크스페이스 - 메타데이터 - 서버코어 - 캠프 - 웹앱 - 프로젝트명 - 보더 - 업로드)
				1024*1024*1024, // 업로드허용용량[바이트] 1GB
				"UTF-8", // 인코딩타입 
				new DefaultFileRenamePolicy()
				);
		// * 업로드가 잘 되었는지 확인하기 위한 업로드 서버경로 확인
		System.out.println(request.getServletContext().getRealPath("/board/upload"));
		
		// 1. 첨부파일 업로드 (입력받은 매개변수) 요청 
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getParameter("bfile");
			// - 작성자( mno )는 입력x / mno는 세션에 저장 되어있는 상태 
		int mno = ( (BoardDto)request.getSession().getAttribute("loginDto") ).getMno();
		String bcno = multi.getParameter("bcno");
		
		// 2. 유효성검사/객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, mno); System.out.println("boardDto도착"+boardDto);
		
		// 3. Dao 처리 
		boolean result = BoardDao.getInstance().bwriter(boardDto);
		
		// 4. (Dao 결과) js에게 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
