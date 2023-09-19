package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

// 링크 : http://localhost/jspweb/ProductInfoController
@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductInfoController() {}

    // 1. 제품 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 컨트롤러도착");
		
		// * commons.jar 이용한 업로드 구현 
		// 1. commons-io.jar , commons-fileupload.jar 필드 필요하다.
		
		// 1. 저장경로 [ 첨부파일이 저장될 폴더 위치 ]
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		// 2. 업로드할 파일아이템저장소 객체 : 업로드할 옵션 [ import org.apache.commons.fileupload.disk.DiskFileItemFactory; ]
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository( new File(uploadPath) ); // 2. 저장위치 // 파일을 전송해주기때문에 File 타입으로 묶어서 전달한다.
		itemFactory.setSizeThreshold( 1024*1024*1024 );	// 3. 용량 
		itemFactory.setDefaultCharset("UTF-8");		// 4. 한글인코딩 
		
		
		// 3. 파일 업로드 객체 [ import org.apache.commons.fileupload.servlet.ServletFileUpload; ]
		ServletFileUpload fileUpload = new ServletFileUpload( itemFactory );
		
		// 4. 파일 업로드 요청 [ 요청방식 : request ]
		try {
			
			Map< Integer , String > imgList = new HashMap<>(); // 업로드한 파일명 들을 저장하기 위한 map컬렉션 
			// Map 컬렉션은 키 와 값 으로 구성된 엔트리 이다 , [ * 키는 중복이 불가능하다. ]
			
			// form전송시 input/select/textarea 태그의 모든 데이터 한번에 요청 해서 List 반환
			List<FileItem> fileList = fileUpload.parseRequest( request );
			// FileItem : 각 요청한 데이터 
			
			// 5. 업로드 실행
			int i = 0;
			for( FileItem item : fileList  ) { // 읽어온 input 들의 데이터를 반복문으로 하나씩 꺼내기 
				
				// 1. 일반 필드 [ item.isFormField() : 마냐게 일반폼필드이면 true / 아니고 첨부파일필드이면 false ]
				if( item.isFormField() ) {  
					System.out.println( item.getString() ); // .getString() : 해당 요청 input의 value 호출 , 파일 값 호출 
					
				}
				else { // 2. file 필드 
					// 만약에 파일 필드이면 업로드 진행 
					System.out.println("업로드할 파일명 : "+item.getName() ); // getName() : 파일이름 호출함
					// 6. 업로드 경로 + 파일명 [ 조합 ]
					
						// 파일명에 중복이 있을때 식별 생성 
						 UUID uuid =  UUID.randomUUID();
							// UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약 [ - 하이픈 4개 구역 ]
						String filename = uuid+"-"+item.getName().replaceAll("-", "_");
														// 만약에 파일명에 - 하이픈 존재하면 _ 언더바로 변경
														// 왜? 파일명과 UUID 간의 식별하기 위해 구분 - 하이픈 사용하기 때문에 
														// 추후에 파일명만 추출시 사용자가 파일명에 - 이 있으면 파일명 추출시 쪼개기가 힘들다.
						// UUID[ - - - ] - 파일명 : 추후에 파일명만 추출시 -하이픈 기준으로 쪼개기 
						
						// 하이픈 이란?  붙임표또는 하이픈은 문장 부호이다. 낱말을 합치거나 음절을 나눌 때 쓰인다. 
					
					File fileUploadPath = new File(uploadPath + "/"+filename ) ;
					
					System.out.println("업로드경로와 파일명이 조합된 경로 : " + fileUploadPath);
					
					item.write( fileUploadPath ); // .write("저장할경로[파일명포함]")  파일 업로드할 경로를 file타입으로 제공 
					// 7. 업로드 된 파일이름 Map에 저장 [ -DB에 저장할려고 ]
					i++;
					imgList.put( i , filename ); // 저장시 에는 이미지번호가 필요 없음
					// Map 컬렉션은 키 와 값 으로 구성된 엔트리 이다 , [ * 키는 중복이 불가능하다. ]
					
				}// else e
			}//for e	
			
			// 회원번호 
			Object object = request.getSession().getAttribute("loginDto");
			MemberDto memberDto = (MemberDto)object;
			int mno = memberDto.getMno();
			
			ProductDto productDto = new ProductDto( 
					 /* 이미지는 여러개이기때문에 인덱스로 가져올수없고 List 로 사진갯수만큼 가져온다  
					   
					     1. fileList.get(0) : input의  pcno 값 호출
					  	 2. fileList.get(1) : naem 의 pname 값 호출
					  	 3. fileList.get(2) : pcontent 값 호출 
					  	 4. fileList.get(3) : pprice 값 호출 
					  	 5. fileList.get(4).getString() : 위도 
					  	 6. fileList.get(5).getString() : 경도 
					  	 
					  */
					Integer.parseInt( fileList.get(0).getString() ) , 
					 fileList.get(1).getString() ,
					 fileList.get(2).getString() ,
					 Integer.parseInt( fileList.get(3).getString() ) ,
					 fileList.get(4).getString() ,  
					 fileList.get(5).getString() ,
					 mno , // 회원번호 호출  
					 // 여러개 이미지는 위에서 리스트로 구성후 대입 
					 // 업로드한 파일명의 개수만큼 MAP 리스트 
					 imgList );
			 System.out.println( productDto );
			 System.out.println("dto도착");
			 
			// Dto 를 Dao 처리 
				boolean result = ProductDao.getInstance().register( productDto );
				
			// 응답 
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
				
		} catch (Exception e) {  }; 
		
		
		
		
		// 옵션 :  1. 요청방식 2. 저장위치 3. 용량 4. 한글인코딩  5. 파일명중복일때 , 5가지 사용해서 구현하기 
		
		
	}
    
	// 2. 제품 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		if( type.equals("findByTop") ) {
			/* 
			   1. js에서 보낸 조회객체를 요청한다.  
			   2. dao처리한다.
			   3. js에게 응답한다. 
				
			*/
			int count = Integer.parseInt( request.getParameter("count") );
			List<ProductDto> result = ProductDao.getInstance().findByTop(count);
			json = mapper.writeValueAsString(result);
			
		}
		else if( type.equals("findByLatLng") ) {
			String east = request.getParameter("east");
			String west = request.getParameter("west");
			String south = request.getParameter("south");
			String north = request.getParameter("north");
			List<ProductDto> result = ProductDao.getInstance().findByLatLng(east, west, south, north);
			json = mapper.writeValueAsString(result);
			
		}
		else if( type.equals("findByPno") ) {
			int pno = Integer.parseInt( request.getParameter("pno") );
			ProductDto result = ProductDao.getInstance().findByPno(pno);
			json = mapper.writeValueAsString(result);
		}
		else if( type.equals("findByAll") ) {
			List<ProductDto> result = ProductDao.getInstance().findByAll();
			json = mapper.writeValueAsString(result);
		}
		// 응답 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 제품 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
/*
   // ----------------------------------- 업로드 ----------------------------------------------------- // 
 	MultipartRequest multi = new MultipartRequest(
				request ,
				request.getServletContext().getRealPath("/product/img") ,
				1024*1024*10 ,
				"UTF-8" ,
				new DefaultFileRenamePolicy()
				);
		// --------------------------------------------------------------------------------------- //
		String pcno = multi.getParameter("pcno");
		String pname = multi.getParameter("pname");
		String pcontent = multi.getParameter("pcontent");
		String pprice = multi.getParameter("pprice");
		// * 만약에 첨부파일이 2개 이상 했을때. 파일명 여러개 호출 
		Enumeration pimg = multi.getFileNames();
			System.out.println( pimg );
				// .getFilesystemName(" input name ") : 첨부된 한개의 파일만 호출 
				// .getFileNames : 파일타입의 이름을 가져온다. , 첨부된 input 태그들의  name을 호출한다.
 */


/*
// [ form 태그 없는 경우 1 ]
// 1. ajax 전달한 data의 객체 속성명을 이용한 호출 
String pname1 = request.getParameter("pname1");
String pcontent1 = request.getParameter("pcontent1");
		System.out.println(pname1);  System.out.println(pcontent1);
*/
/*
// form 태그 이용하는 경우 2 - 첨부파일 없을때 요청 
MultipartRequest mulit = new MultipartRequest( request , request.getServletContext().getRealPath("") );

String pname2 = request.getParameter("pname2");
String pcontent2 = request.getParameter("pcontent2");
System.out.println(pname2);  System.out.println(pcontent2);
*/