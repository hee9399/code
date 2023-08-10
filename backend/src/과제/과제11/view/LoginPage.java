package 과제.과제11.view;


import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	// 0. 싱글톤
	private static LoginPage LoginPage = new LoginPage();
	public static LoginPage getInstance() {return LoginPage;}
	private LoginPage() {}
	
	// 0. 입력객체
	private Scanner sc = new Scanner(System.in);
	
	// 1. loginMenu 		    : 로그인했을때 메뉴 페이지
	public void loginMenu() {
		while(MemberController.getInstance().getLoginSession() != 0) {
			
			boardPrint();
			
			System.out.println("\n\n ----- ---- ---- -----");
			System.out.println("1.로그아웃 2.회원정보 3.글쓰기 4.글조회 선택 : ");
			
			try {
				int ch = sc.nextInt();
				if(ch == 1) {MemberController.getInstance().logOut();}
				if(ch == 2) {info();}
				if(ch == 3) {boardWrite();}
				if(ch == 4) {boardView();}
				
			}catch(Exception e) {
				System.out.println(e);
				sc = new Scanner(System.in);
			}// c e
			
		}// w e
		
	}
	
	// 2. info 					: 로그인된 회원정보 페이지
	// 로그인된 회원정보를 con , dao 에게 전달해야한다
	public void info() {
		
		System.out.println("\n\n ======== info ================== ");
		// 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[DTO] 반환 받기
		MemberDto result = MemberController.getInstance().info();
		// 2. 반환받은 회원정보 객체[MemberDto] 의 각 필드를 출력
		System.out.println(">ID : "+result.getMid());		// 
		System.out.println(">NAME : "+result.getMname());
		System.out.println(">PHONE : "+result.getMphone());
		
		// 2. 서브메뉴
		System.out.println("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택 : ");
		int ch = sc.nextInt();
		
		if(ch == 1) {infoUpdate();}
		if(ch == 2) {infoDelete();}
		if(ch == 3) {return;} // 생략가능
		
	}
	
	// 3. infoUpdate 			: 회원정보 수정 페이지	
	public void infoUpdate() {
		System.out.println("\n\n ======== password Update ===== ");
		System.out.println("새로운 비밀번호 : "); String newPw = sc.next();
		
		boolean result = MemberController.getInstance().infoUpdate(newPw);
		if(result) {
			System.out.println("안내] 비밀번호수정완료:로그아웃됩니다");
			MemberController.getInstance().logOut();
			
		}else {System.out.println("경고] 비밀번호수정실패:관리자에게문의");}
		
		
	}
	
	// 4. infoDelete			: 회원정보 탈퇴 페이지
	public void infoDelete() {
		System.out.println(" ==== member delete =====");
		System.out.println("정말 탈퇴하시겠습니까?? 1.예 2.아니오");
		int ch = sc.nextInt();
		if(ch == 1) {
			
			boolean result = MemberController.getInstance().infoDelete();
			if(result) {
				System.out.println("안내] 회원탈퇴성공 : 로그아웃됩니다");
				MemberController.getInstance().logOut();
			}else {System.out.println("경고] 회원탈퇴실패 : 관리자에게문의");}
		}
		
	}
	
	// 9. boardWrite			: 게시물쓰기 페이지
	public void boardWrite() {
		System.out.println("----- post write -----");
		System.out.println("제목 : "); String title = sc.next();
		System.out.println("내용 : "); String content = sc.next();
		
	boolean result = 	
		BoardController.getInstance().boardWrite(title , content );
	if(result) {System.out.println("안내) 글쓰기 등록");}
	else {System.out.println("안내) 글쓰기 실패 : 제목 1~50 사이로 필수 입력");}
		
	}
	
	// 10. boardPrint			: 모든 게시물 출력
	public void boardPrint() {
		System.out.println(" ----- post LIST ----- ");
		// 1. 여러개의 게시물을 요청해서 반환된 결과 저장 
		ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();
		// 2. 출력 
		System.out.printf("%-3s %-4s %-19s %-10s %s \n" , "no" , "view" , "date" , "mid" , "title");
		for( int i = 0 ; i<result.size(); i++ ) {
			BoardDto dto = result.get(i);	// i번째의 객체를 호출 
			System.out.printf("%-3s %-4s %-19s %-10s %s \n" , 
					dto.getBno() , dto.getBview() , dto.getBdate() , dto.getMid() , dto.getBtitle() );
		}
	}
	
	// 11. boardView		: 개별 게시물 출력
	public void boardView() {
		System.out.println(" ----- post View----- ");
		// 1. 보고자하는 게시물의 게시물번호를 입력받기[ 식별번호 ]
		System.out.println("게시물번호 : "); int bno = sc.nextInt();
		// 2.
		BoardDto result = BoardController.getInstance().boardView(bno);
		// 3. 출력
		System.out.printf("title : %3s view : %3s date : %3s mid : %19s " ,
				result.getBno() , result.getBview() ,
				result.getMid() , result.getBdate() );
		System.out.printf("title : %s \n" , result.getBtitle() );
		System.out.printf("content : %s \n" , result.getBcontent());
		//조회수 증가 메소드
		viewAdd(bno);
		// 4. 추가메뉴 
		System.out.println("1.뒤로가기 2.수정 3.삭제 4.삭제 선택 >");
		int ch = sc.nextInt();
		
		if(ch == 1) {}
		if(ch == 2) {boardUpdate();}
		if(ch == 3) {boardDelete();}
		
	}
	
	// 12. boardUpdate		: 게시물 수정
	public void boardUpdate() {}
	
	// 13. boardDelete		: 게시물 삭제
	public void boardDelete() {}
	
	// 조회수 증가 메소드
	public void viewAdd(int bno) {
		
		boolean result = 
			BoardDao.getInstance().viewAdd(bno);	
		
	}
	
}

/*
	ArrayList<리스트에저장할타입> 리스트 객체명 = new ArrayList<>();
		1. .size()		: 리스트내 객체수 					==유사 result.length
		2. .get( 인덱스 )	: 리스트내 인덱스번째의 객체 호출 		==유사 result[i]
		3. .add( 객체 )	: 리스트내 객체 추가

*/












