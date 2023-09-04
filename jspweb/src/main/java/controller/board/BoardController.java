package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;


/**
 * Servlet implementation class BoardController
 */
// 서블릿은 요청코드가 없으면 켜지는데 요청코드가 존재하면 실행되지 않는다.
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardController() {}
       
    
    // type : 1. 전체조회 2. 개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 
		ObjectMapper objectMapper = new ObjectMapper();
		String type = request.getParameter("type");
		
		String json = ""; // if 안에서 공통으로 사용하기때문에 jsonArray 을 밖으로 뺀다.
		
		if(type.equals("1") ) { // 1이면 전체 조회 로직 
			
			// 3. DAO
			ArrayList<BoardDto> result = BoardDao.getInstance().getList();
			System.out.println(result);
			// 가공 ArrayList 를 json형태/객체 로 바꾼다
			
			 json = objectMapper.writeValueAsString(result);
			
			
		}else if( type.equals("2") ) {// 2면 개별 조회 로직 
			// 1. 매개변수 요청 
			int bno = Integer.parseInt(request.getParameter("bno") );
			// 2. DAO 처리 
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			
				// 3. 만약에 ( 로그인 혹은 비로그인 ) 요청한 한사람과 게시물작성한사람과 동일하면
			Object object = request.getSession().getAttribute("loginDto");
			
			if( object == null ) { // 비로그인 
				result.setIshost(false); // 남이 쓴 글 
			}else { // 로그인 했을때 
				MemberDto login = (MemberDto)object;
				// 내가 쓴 글 
				if( login.getMno() == result.getMno() ) {result.setIshost(true);}
				
			}
			json = objectMapper.writeValueAsString(result);
		}
		// 공통 로직 
			// 1. 전체조회 , 개별조회 하던 응답 로직 공통 
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print( json );
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
		// MemberDto 에 있는 loginDto를 가져온다.
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		int  bcno = Integer.parseInt( multi.getParameter("bcno") );
		
		// 2. 유효성검사/객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); System.out.println("boardDto도착"+boardDto);
		
		// 3. Dao 처리 
		boolean result = BoardDao.getInstance().bwriter(boardDto);
		
		// 4. (Dao 결과) js에게 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
		
	}
	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 수정할 첨부파일 업로드 
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/board/upload") ,
				1024 * 1024 * 1024 ,
				"UTF-8" ,
				new DefaultFileRenamePolicy() 
				);
		
		// 2. 수정할 데이터 요청 
		int bcno = Integer.parseInt( multi.getParameter("bcno") );
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String oldfile = multi.getFilesystemName("oldfile"); // 파일명 호출 !! [ getFilesystemName ]
		// 2* 수정할 게시물 식별키 / 누구를 수정할껀지 
		int bno = Integer.parseInt( multi.getParameter("bno") );
		// js onUpdate() 에서 bno를 보내야한다 
		BoardDto updateDto = new BoardDto(bno, btitle, bcontent, oldfile, bcno);
			System.out.println("수정dto : " +updateDto);
		
		// * 만약에 새로운 첨부파일이 없으면 기존 첨부파일 그대로 사용 
			// 마냐게boardDto 가 null 이면
		if( updateDto.getBfile() == null ) {
			// 기존 첨부파일  .getBoard(bno)는 수정할게시물의 번호를 보여주는 코드이다 
			 updateDto.setBfile( BoardDao.getInstance().getBoard(bno).getBfile() );
			
		}// if e
		
		// 3. DAO 
		boolean result = BoardDao.getInstance().onUpdate(updateDto);
		// 3. 응답 
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 bno 는 정수값(int)으로 받기때문에 integer 로 형변환 해주어야한다 
				int bno = Integer.parseInt( request.getParameter("bno") ); 
				// 2. DAO
				boolean result = BoardDao.getInstance().ondelete(bno);
				// 3. 응답 
				response.setContentType("application/json;charset=UTF-8");
		    	response.getWriter().print(result);
	}

}
