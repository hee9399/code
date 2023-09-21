package controller.product;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.MpointDto;


// 링크: http://localhost/jspweb/PointController
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PointController() {}

    // 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mpno = UUID.randomUUID().toString(); // 포인트내역 식별번호 구성 [ UUID ]
			// UUID.randomUUID() : (s) : UUID 고유성을 보장하는 ID[식별자] 만들기 위한 표준규약
			System.out.println( mpno );
		
		// 2. 로그인된[ 세션에저장된 ] 회원정보에서 회원번호만 출력 
			// getSession 는 object속성(객체,슈퍼클래스)이다 눈에 보이지않는다 class파일은 슈퍼클래스에서 생성되고 모든 클래스에 상속가능하다.
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		System.out.println("mno: "+mno);
		
		// 3. 포인트 수량 / 지급내역 는 js에서 전달받음 
		long mpamount = Long.parseLong( request.getParameter("mpamount") ); 
		String mpcomment = request.getParameter("mpcomment");
		
		// Dto
		MpointDto mpointDto = new MpointDto(mpno, mno, mpamount, mpcomment, null);
		
		// Dao
		boolean result = ProductDao.getInstance().setPoint(mpointDto); System.out.println("result: "+result);
		
		// 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	}
    
	// 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서로 다른 함수/기능 을 실행 하기 위한 분류 
		String type = request.getParameter("type");
		
		// 
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 분류 
		if( type.equals("1") ) { // 1: 현재 포인트 출력 
			long result = ProductDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(json);
			
		}else if( type.equals("2") ) {
			List<MpointDto> result = ProductDao.getInstance().getPointList(mno);
			json  = mapper.writeValueAsString(result);
			
		}
		// 3.응답
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(json);
	}

	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
