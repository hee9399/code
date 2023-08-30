package controller.hrm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HrmController() {}

    // 저장 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
		System.out.println("hrm 폴더 img 폴더 서버 경로 : "+uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadpath ,
				1024*1024*10 ,
				"UTF-8" , 
				new DefaultFileRenamePolicy() // 파일중복제거
				);
		String hnumber = multi.getParameter("hnumber"); System.out.println("컨트롤러hnumber"+hnumber);
		String hname =  multi.getParameter("hname"); System.out.println("컨트롤러hname"+hname);
		String hphone = multi.getParameter("hphone"); System.out.println("컨트롤러hphone"+hphone);
		String hrank = multi.getParameter("hrank"); System.out.println("hrank"+hrank);
		String himg = multi.getFilesystemName("himg"); System.out.println("컨트롤러himg"+himg);
		String hdate = multi.getParameter("hdate"); System.out.println("컨트롤러hdate"+hdate);
		
		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( himg == null ) {himg = "기본이미지.webp";}
		
		// 2. 객체화 
		HrmDto hrmDto = new HrmDto(hnumber, hname, hphone, hrank, himg, hdate);
		
		// 3. dao 객체 전달후 결과 응답받기 
		boolean result = HrmDao.getInstance().hrmRegistered(hrmDto);
		
		// js 에게 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
		
	}
    // 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
	}

	



	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
