package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

// 링크 : http://localhost/jspweb/PwishListController
@WebServlet("/PwishListController")
public class PwishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PwishListController() {}
    
    // 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	// 1. 찜하기로 등록할 제품번호 요청 
    	int pno = Integer.parseInt( request.getParameter("pno") ); System.out.println("pno: "+pno);
    	// 2. 찜하기를 등록한 회원번호 요청x [ 서블릿은 로그인한 정보를 알고있다. -> 서블릿 세션 ]
    	// int mno = request.getSession().getAttribute("loginDto"); 
    			// - 로그인(dto) 가 되고나서 mno를 가져와야 하기때문에 타입변환을 해줘야한다.
    	int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();  System.out.println("mno: "+mno);
    	// 3. dao 전달 
    	boolean result = ProductDao.getInstance().setWish(mno, pno);
    	
    	// 4. js 에게 응답 
    	response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
    	
	}
	
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if( type.equals("finByWish") ) {
		// 1. 요청 
		int pno = Integer.parseInt( request.getParameter("pno") ); System.out.println("pno: "+pno);
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();  System.out.println("mno: "+mno);
		
		// 3. dao 전달 
    	boolean result = ProductDao.getInstance().getWish(mno, pno);
    	
    	// 4. js 에게 응답
    	response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		}else if( type.equals("finByAll") ) {
			int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();  System.out.println("mno: "+mno);
			List<ProductDto> result = ProductDao.getInstance().getWishProductList(mno);
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString( result );
			// 4. js 에게 응답
	    	response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonArray);
			
		}
		
	}
	
	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
