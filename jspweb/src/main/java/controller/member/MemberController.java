package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberController() {}

    // 저장 
    // 1. [c] (첨부파일 있을때 from ) 회원가입 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    // ----------------------------------------------- 파일 업로드 : 서버폴더에 저장 ----------------------------------------------------------------- //
    	
    	// 첨부파일에 저장할 폴더의 절대경로
    	// img 폴더에 설정 들어가서 경로 복붙 
    	// 1. 개발자 pc 경로 업로드 [ 문제발생 : 개발자pc에 업로드하면 업로드파일을 서버로 빌드 ]
    	// String uploadpath = "C:\\Users\\504\\git\\ezen_web_2023_A\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로 
    	// git은 작업된 파일/코드을 올리는것이지 서버를 통째로 올리는 공간은 아니다 
    	// git을 사용하는애들은 workspace를 사용하지 않는다 
    	
    	// 2. 서버 pc 경로 업로드 [ 사용자는 바로 서버pc 업로드  ]
    	// String uploadpath= "이클립스워크스페이스 :  C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps";
    	
    	// 서버는 두가지의 경로가 있다. c드라이브 , http
    	
    	// 3. 서버 pc 경로 ( 상대경로 = 서버경로 찾아주는 함수 )
    		// 서버에 bulld(베포)된 파일/폴더 의 경로 찾기 
    		// request.getSession().getServletContext().getRealPath("프로젝트명이하 경로");
    		// getRealPath : C:\Users\504\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jspweb\member\signup.jsp
    		// Httppath : http://localhost/jspweb/member/signup.jsp
    	String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
    	System.out.println("member 폴더 img 폴더 실체(서버) 경로 : "+uploadpath);
    	
    	
		// 첨부파일 전송 했을때. 
    		// 1. 첨부파일 서버pc에 업로드( COS.jar 라이브러리 )
    			// MultipartRequest : 파일 업로드 클래스 
    	MultipartRequest multi = new MultipartRequest(
    			request , 					  // 1. 요청방식
    			uploadpath  , 				  // 2. 첨부파일을 저장할 폴더 경로 
    			1024*1024*10, 				  // 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB/10메가까지 허용 
    			"UTF-8" ,
    			new DefaultFileRenamePolicy() // 5. [ 파일명중복제거 ] 만약에 서버내 첨부파일의 동일한 이름이 있을때  이름뒤에 숫자를 자동으로 붙이기
    			);
    	
    	
    // ---------------------------------------------- DB처리 : 업로드된 파일에 ---------------------------------------------------------------------- //
    	
    		// 2. from 안에 있는 각 데이터 호출 
    	
    	// 일반input :  multi.getParameter("from객체전송시input name");
    	// 첨부파일input : 
    	
    	// 1. AJAX 통신받은 data객체의 '속성명' 요청한다. [ request ]
    	String mid = multi.getParameter("mid");	System.out.println("mid"+mid);
    	String mpwd = multi.getParameter("mpwd");	System.out.println("mpwd"+mpwd);
    	String memall = multi.getParameter("memall"); System.out.println("memail"+memall);
    	// String mimg = request.getParameter("mimg");	System.out.println("mimg"+mimg);
    	String mimg = multi.getFilesystemName("mimg"); System.out.println("mimg : "+mimg);
    	
    	// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( mimg == null ) {mimg = "default.webp";}
    	
    	// 2. 객체화
    	MemberDto memberDto = new MemberDto(mid, mpwd, memall, mimg);
    	
    	// 3. DAO 객체 전달후 결과 응답받고 
    	boolean result = MemberDao.getInstance().signup(memberDto);
    	
    	// 4. 결과를 AJAX에게 응답한다.
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}
    
    // 호출 2. 회원정보( 세션호출 ) / 로그아웃( 세션초기화 ) 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다. [x]
		String type = request.getParameter("type");
			// * 만약에 type 이 info이면 
		if(type.equals("info") ) {
			// 섹션에 저장된 로그인 객체를 꺼낸다.
			// 1. 세션호출한다. [ 세션타입은 object ]
			Object session = request.getSession().getAttribute("loginDto");
			// 2. 타입변환한다. [ 부모 -> 자식 ( 캐스팅/강제타입변환 ) ]
			MemberDto loginDto = (MemberDto)session;
	
		// DTO는 JS가 이해할수 없는 언어 이므로 JS가 이해할수 있게 JS 언어로 변환 [ jackson 라이브러리 ]
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
	
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);
			
		}else if(type.equals("logout") ) {
			// * 세션에 저장된 로그인 객체를 업애기/초기화/지우기/삭제 
			// 방법1 : 모든 세션 초기화하는 함수 
				// request.getSession().invalidate(); // 로그인 정보 뿐만 아니라 모두 삭제.
			// 방법2 : (세션 특정 속성) 초기화하는 방법 jvm GC(쓰레기수집기 = 해당 객체를 아무도 참조하고 있지 않으면) 
			request.getSession().setAttribute("loginDto", null);
		}
		
		// 2. 유효성/객체화 [x]
		
		// 3. Dao 처리 [x]
		
		// 4. 응답한다.
		
		
		
		
		
	}

	// 수정 3. 회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// multipart/from-data 전송 요청// cos.jar[ MultipartRequest클래스 ]
		
		// 첨부파일 전송 했을때. 
		// 1. 첨부파일 서버pc에 업로드( COS.jar 라이브러리 )
			// MultipartRequest : 파일 업로드 클래스 
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/member/img") ,
				1024*1024*10 ,
			    "UTF-8" ,
			    new DefaultFileRenamePolicy());
			    
		// ------------------------------ DB 업데이트 -------------------------------------- //
		// * from 전송일때는 input의 데이터 호출시 
			// 일반 input : multi.getParameter("input name")
			// 첨부 input : multi.getFilesystemName("input name")
		String mimg = multi.getFilesystemName("mimg");
		
		// Dao [ 로그인된 회원번호 , 수정할 값 ]
		Object object = request.getSession().getAttribute("loginDto"); 
		MemberDto memberDto = (MemberDto)object;
		int loginMno = memberDto.getMno();
		
		// 만약에 수정할 첨부파일 없으면 
		if(mimg == null) {// 기존 이미지 그대로 사용 
			mimg = memberDto.getMimg(); // 세션에 있던 기존 이미지 그대로 대입 
			
		}
		
		boolean result = MemberDao.getInstance().mupdate(loginMno, mimg);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}
	// 삭제 4. 회원삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다
			// 입력받은 패스워드 
		String mpwd = request.getParameter("mpwd"); System.out.println("컨트롤러 입력받은비밀번호"+mpwd);
		
		// 2. 유효성검사/객체화 
		
		
		// 3. DAO 처리 [ 현재로그인된 회원번호[pk] , 입력받은 패스워드[mpwd] ]
			// 1. 현재로그인된 회원정보 => 세션 
		
		// ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		      //               vs
		// 1. 로그인 세션 호출한다 
		Object object = request.getSession().getAttribute("loginDto"); System.out.println("Object 받음");
		// 2. 타입 변환한다
		MemberDto memberDto = (MemberDto)object;
		// 3. 로그인 객체에 회원번호만 호출한다
		int loginMno = memberDto.getMno();
		
		// 2. DAO 전달 해서 결과 받기 
		Boolean result = MemberDao.getInstance().mdelete(loginMno, mpwd); 
		
		// 4. 응답한다. 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}

/*
	용량 단위
		bit : 0 or 1 
		byte: 01010101 -> 1byte
		kb : 1024byte -> 1kb
		mb : 1024kb -> 1mb
*/








