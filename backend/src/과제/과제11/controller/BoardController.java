
package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.view.LoginPage;

public class BoardController {

	// 0. 싱글톤
		private static BoardController boardController = new BoardController();
		public static BoardController getInstance() {return boardController;}
		private BoardController() {}
	
	// 9. boardWrite			: 게시물쓰기 페이지
		public boolean boardWrite(String title , String content) {// 글쓰기에 필요한것 : 제목 , 내용 , 작성자/회원번호(식별) 
			// 1. 유효성검사 
			if( title.length() == 0 || title.length() > 50  ) { return false; }
			// 2. Dto [ 입력받은제목 , 입력받은내용 , 로그인된회원번호= MemberController 의 loginSession  ]
			BoardDto boardDto = new BoardDto( title , content , MemberController.getInstance().getLoginSession() );
			// 2. 글쓰기전용 생성자가 없을때
			// BoardDto boardDto2 = new BoardDto( 0, title, content, null , 0, MemberController.getInstance().getLoginSession(), null);
			// 3. DAO에게 전달후 결과 받아서 받은 결과 바로 반환
			return BoardDao.getInstance().boardWrite(boardDto);
		}
		
		// 10. boardPrint		: 모든 게시물 출력
		public ArrayList<BoardDto> boardPrint() {
			return BoardDao.getInstance().boardPrint();
		}
		
		// 11-1. boardView		: 개별 게시물 출력
		public BoardDto boardView(int bno) {
			return BoardDao.getInstance().boardView(bno);
		}
		
		// 11-2. 조회수 증가
		public boolean viewAdd(int bno) {
				return BoardDao.getInstance().viewAdd(bno);
		}
		// 12. boardUpdate		: 게시물 수정[ 준비물 : bno = 수정할 게시물의 식별[ 누구를 수정할껀지 ] / mno = 작성요청한 회원과 게시물의 작성자 가 일치한 경우에만[유효성검사] / title : 수정할값 , content
		public int boardUpdate(int bno , int mno ,String title , String content) {
			// 1. 유효성검사
				// 2. 게시물의 작성자회원번호 와 로그인된 회원번호가 일치 하지 않으면 
			if(mno == MemberController.getInstance().getLoginSession()) {return 3;}
				//1. 제목 글자 수 검사
			if(title.length() < 1 || title.length() > 50) {return 4;}
			// 2.
			boolean result = BoardDao.getInstance().boardUpdate(new BoardDto( mno , title , content) );
			
			return 2;
			
		}
		
		// 13. boardDelete		: 게시물 삭제 [ 준비물 : bno = 삭제할 게시물의 식별[누구를 삭제할껀지] / mno(게시물의 작성자) 삭제요청한 회원과 게시무르이 작성자가 일치된 경우에만 [유효성검사] ]  
		public int boardDelete(int bno , int mno) {
			// 1. 유호성검사 
			if(mno != MemberController.getInstance().getLoginSession()) {return 3;}
			//2
			boolean result = BoardDao.getInstance().boardDelete(bno);
			if(result) return 1;
			
			return 2;
		}
		
		// 14. 쪽지보내기 
		public void noteSend() {}	
		
		// 15. 쪽지확인 페이지  // + 쪽지답장 
		
		// 16. 쪽지답장 보내기 페이지 
		
		
	
}

/*
	테이블
		레코드/행/가로	-> DTO 1개
		레코드/행/가로	-> DTO 1개	여러개 DTO 하나의 객체로 담기 => 리스트 혹은 배열 
		레코드/행/가로	-> DTO 1개
		
	1	안녕하세요.	안녕		2023-08-10 11:01:58	0	7	-> boardDTO	
	2	제목에 띄어	하하하	2023-08-10 11:02:53	0	7	-> boardDTO		ArrayList<boardDTO> vs BoardDto[]
	3	테스트1		테스트2	2023-08-10 11:09:11	0	7	-> boardDTO
	
	
예)
	로그인한 회원정보1개 조회 = DTO.
	관리자가 모든회원정보 여러개 조회 = ArrayList<DTO>

	개별 게시물 1개 출력 = DTO 
	모든 게시물 여러개 출력 = ArrayList<DTO>
	
	
	----
			System.out.println( rs );
			System.out.println();
			// 필드순서에 따른 필드 값 호출 : rs.get타입(필드순서번호)
			System.out.print( rs.getString(1) +"\t" ); // bno
			System.out.print( rs.getString(2) +"\t"); // btitle
			System.out.print( rs.getString(3) +"\t"); // bcontent
			System.out.print( rs.getString(4) +"\t"); // bdate 
			System.out.print( rs.getString(5) +"\t"); // bview 
			System.out.print( rs.getString(6) +"\t"); // mno
			System.out.println();
			

*/
