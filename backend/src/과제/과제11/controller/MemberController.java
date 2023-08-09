package 과제.과제11.controller;


import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	
	// 1. 회원가입 처리
	// 반환타입이 int타입이면 int
	public int signupLogic(String id , String password , String name , String phone  ){
		System.out.println("--- singupLogic 컨트롤 도착");
		System.out.println(id + password + name + phone);
			// 1. 아이디중복체크
			if(MemberDao.getInstance().infoCheck("mid", id)) return 3;
			// 2. 전화번호 중복 체크
			if(MemberDao.getInstance().infoCheck("mphone", phone)) return 4;
		
		// 1. 객체화 : 5개 변수들이 이동 할때마다 매개변수의 코드 길어지니까.. 패키지로 이동
		 MemberDto dto = new MemberDto(0 , id , password , name , phone);
		 
		 boolean result = MemberDao.getInstance().signupSQL(dto); 
		 
		 // 3. 결과를 view 에게 전달
		 if(result) return 1;
		 else return 2;

	}
	
	// 0. 로그인된(PK식별용) 회원의번호를 저장하는 필드 = 웹세션 
	private int loginSession = 0; // 0 : 로그인 안한상태 : 1이상 : 로그인된 회원의 번호 
	
	public int getLoginSession() {return loginSession;}

	// 2. 로그인 처리
	public boolean loginLogic(String id , String password ) {
		System.out.println("--- loginLogic컨트롤 도착");
		System.out.println(id + password);
		MemberDao.getInstance().loginSQL(id, password);
		
		// Dao 에서 로그인 타입이 int 로 반환해줬기 때문에 int를 가져온다.
		 int result = MemberDao.getInstance().loginSQL(id, password);
		 // 로그인 성공했을때 기록 하기 [ - 로그인 이후 로그인된정보로 활동 ]
		 // int 가 1보다 크면 성공 아니면 실패
		 if(result >= 1) {this.loginSession = result; return true;}
		 else {return false;}
		
	}
	
	// 3-2 로그아웃 처리
	public void logOut() {this.loginSession = 0;}
	
	
	
	
	
	
	// 컨트롤 과 dao 와 주고받는다 dao -> controller(중간제어 , 유효성검사 역할) -> Mainpage
	// 파란색 리턴 빨간색 매개변수
	
	// 4. 아이디 찾기 
		public String findById(String name , String phone) {
			// 텍스트.view 전달받은 매개변수 확인
			System.out.println("view value : "+name+phone);
			
			// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기 
			
			String result 
						= MemberController.getInstance().findById( name ,phone );
			
			
			return result; // null(실패)인 이유 String은 기본값이 null이다 그래서 null을 넣어주지않으면 빨간줄이뜬다
			
		}
	
	// 5. 비밀번호 찾기
		public String findByPw(String id , String phone) {
			// 텍스트.view 전달받은 매개변수 확인
			System.out.println("view value : "+id+phone);
						
			// Dao에게 매개변수 전달하고 찾은 비빌번호 반환 받기 			
					
			String result 
					= MemberController.getInstance().findByPw( id ,phone );
			
			return MemberDao.getInstance().findByPw(id, phone); // 실패
			
		}
	
	// 6. 
		// dao에게 mno 전달해야한다
		public MemberDto info() {
			// 현재 로그인된 회원번호[loginSession]는 view에서 전달 받지않고 컨트롤안에 저장되어 있으므로 바로전달
			// 현재 로그인된 회원번호로 회원정보 요청하기 
			return MemberDao.getInstance().info(this.loginSession);
			
		}
		
	// 7.
		// 새로운 패스워드 매계변수를 받아야함 
		public boolean infoUpdate(String newPw) {
			
			return MemberDao.getInstance().infoUpdate(newPw, loginSession) ;
			
		}
	// 8. 	
		public boolean infoDelete() {
			
			return MemberDao.getInstance().infoDelete(loginSession) ;
			
		}	
		
		
} // class e















