package 과제.과제11.controller;


import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	
	// 1. 회원가입 처리
	public boolean signupLogic(String id , String password , String name , String phone  ){
		System.out.println("--- singupLogic 컨트롤 도착");
		System.out.println(id + password + name + phone);
		// 유호성검사 했다치고
		// 1. 객체화 : 5개 변수들이 이동 할때마다 매개변수의 코드 길어지니까.. 패키지로 이동
		 MemberDto dto = new MemberDto(0 , id , password , name , phone);
		 
		 boolean result = MemberDao.getInstance().signupSQL(dto); 
		 return result;

	}
	
	// 2. 로그인 처리
	public boolean loginLogic(String id , String password ) {
		System.out.println("--- loginLogic컨트롤 도착");
		System.out.println(id + password);
		MemberDao.getInstance().loginSQL(id, password);
		
		 boolean result = MemberDao.getInstance().loginSQL(id, password);
		 return result; // -> 
		
	}
	
} // class e
