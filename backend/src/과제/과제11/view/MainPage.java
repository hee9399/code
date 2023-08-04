package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {

	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	

	
	// 0. 입력객체 
	private Scanner sc = new Scanner(System.in);
	
	
	
	// 1. 메인메뉴
	public void mainView() {
		while(true) {
			System.out.println("\n\n =========== 회원제 커뮤니티 ========");
			System.out.println("1.회원가입 2.로그인 선택 : ");
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchExceptio
				if( ch == 1) {signupView();} 
				if( ch == 2) {loginView();} 
			
			
			}catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
				
			} // eatch e
		}// try e
	} // while e
	
	
	// 2. 회원가입 화면
	public void signupView() {
		// 1. 출력에 따른 입력값 받는다.
		System.out.println("------ 회원가입 --------");
		System.out.println("아이디 : ");   String id = sc.next();
		System.out.println("비밀번호 : ");  String password = sc.next();
		System.out.println("이름 : ");     String name = sc.next();
		System.out.println("전화번호 : ");  String phone = sc.next(); 
		boolean result = 
		MemberController.getInstance().signupLogic(id ,password,name ,phone );	
	}
	
	// 3. 로그인 화면
	public void loginView() {
		System.out.print("아이디 : ");   String id = sc.next();
		System.out.print("비밀번호 : ");  String password = sc.next();
		
		boolean result =
				MemberController.getInstance().loginLogic(id , password);
		if(result) {System.out.println("안내) 로그인성공");}
		else {System.out.println("경고) 로그인실패");}
	}
	
} // class e
