package controller.accountbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.AccountbookDao;
import model.dto.AccountbookDto;

/**
 * Servlet implementation class AccountbookConrtoller
 */
@WebServlet("/AccountbookConrtoller") // 해당 서블릿 자바 
public class AccountbookConrtoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountbookConrtoller() {}


    // 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. AJAX의 DATA속성에 있는 객체 정보(스크립트 객체의 속성명)를 호출하기 
    	// 무엇을 저장할껀지? 항목내옹 , 금액 , 날짜  
    	// 어떻게? 현재 스크립트/HTTP주소 awriter()함수에서 info객체를 서블릿 doPost에게 보낸값을 얻어야한다.
    	// 어떤코드로 응답해주나? request.getParameter 로 HTTP요청은 파라미터 이기때문에 
    	String awriter = request.getParameter("awriter");	System.out.println("awriter"+awriter);
    	String amoney = request.getParameter("amoney");		System.out.println("amoney"+amoney);
    	String adate = request.getParameter("adate");		System.out.println("adate"+adate);
    	
    	// 2. 객체화
    	AccountbookDto accountbookDto = new AccountbookDto(awriter,amoney,adate); 
    	System.out.println("accountbookDto"+accountbookDto);
    	
    	// 3. DAO 객체 전달후 결과 응답받기 
    	boolean result = AccountbookDao.getInstance().awriter(accountbookDto);
    	// 4. 결과를 AJAX에게 응답한다. 
    	// getWriter() 에게 print로 응답한다.
    	// 문자 true로 보낸다 왜? 타입이 boolean 이니까 
    	// js에게 보내줄껀데 true값을 보낸다 json으로 보낸다 
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
	}
    
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요철 [x[ : 모든 가계부 출력은 조건이없다 전부 출력이기 때문에
		// 2. 전부출력이므로 객체화도 없다 
		
		// 3. DAO
		ArrayList<AccountbookDto> result = AccountbookDao.getInstance().aread();
			// js는 ArrayList타입을 사용할수 없다 ArrayList타입을 JSON배열로 변환해서 전달해야한다
		ObjectMapper objectMapper = new ObjectMapper();
		// JSON타입으로 변환은 불가능하지만 왜? 현재 자바에서 진행중이기때문에 그치만 JSON형식의 문자열로 변환 가능하다. 
		String jsinArray = objectMapper.writeValueAsString(result);
		
		
	}

	
	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
