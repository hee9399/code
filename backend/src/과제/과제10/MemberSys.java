package 과제.과제10;
						 // 현재 클래스에서 캍은 패키지에 있는 클래스 호출 = 생략
						 // java.lang 기본 패키지이므로 생략 (String , System 등)
import java.util.Arrays; // 현재 클래스에서 다른 패키지에 있는 클래스 호출 = import

import java.util.Scanner; // 자동완성 이용한 클래스 작성하면 import 자동
// vs
// import java.util.*;      

public class MemberSys {

	static Member[] memberList = new Member[100];
	
	// 입력객체를 main 함수 밖으로 빼면 모든함수에서 사용 가능한 인스턴스 멤버가 된다 
	// 스태틱을 붙여서 전 구역에서 공유하면서 사용되는 메모리이다
	static Scanner sc = new Scanner(System.in);
	static int loginIndex
	
	public static void main(String[] args) { //  main 함수에 static //메인함수는 정적멤버이다
		
		
		while(true) {
			// * 확인용
			System.out.println("회원배열(리스트) ");
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			
			// 1. 입력객체(Scanner)의 위치를 어디에 둘지 생각해야한다
			
			int ch = sc.nextInt();
			
			if(ch == 1) {MemberSys.회원가입();} // main함수 밖에 있는 다른 함수 호출
			// 1. 인스턴스멤버(static없는) 함수는 객체를 생성하고 호출한다. 
			// 2. 정적멤버 (static있는) 함수는 객체없이 클래스를 통한 호출한다.
			if(ch == 2) {MemberSys.로그인();}
			if(ch == 3) {MemberSys.아이디찾기();}
			if(ch == 4) {MemberSys.비밀번호찾기(); 회원가입();}
			
			
		} // while e 
		
	} // main e
	
	// 1. 회원가입 함수
	static void 회원가입() {
		// 1. 입력받기 -> 각각 5개 입력받기
				System.out.println("--------- 회원가입 ---------");
				System.out.print("아이디 : "); 	String id = sc.next();
				System.out.print("비밀번호 : ");	String pw = sc.next();
				System.out.print("이름 : ");		String name = sc.next();
				System.out.print("전화번호 : ");	String phone = sc.next();
				System.out.print("나이 :");		int age = sc.nextInt();
				// 2. 5개 변수를 하나의 객체로 묶음
				Member m = new Member(id, pw, name, phone, age);	// m변수에는 객체 힙 주소 가지고 있음
				// 3. 회원의 1개의 객체를 배열 저장
					// 1. 배열내 빈공간=null 을 찾는다
				for( int i = 0 ; i<memberList.length ; i++ ) {
					if( memberList[i] == null ) { memberList[i] = m; System.out.println("안내)회원가입 성공"); break; }
				
			} // for end
		} // m end
	
	// 1. 로그인 함수
	static void 로그인() {
		System.out.println("");
	}
	// 1. 아이디찾기 함수
	static void 아이디찾기() {}
	// 1. 비밀번호 함수
	static void 비밀번호찾기() {}
	
} // class e
/*
주제 : 회원제 시스템 
	0. 회원클래스 설계 = Member
		아이디 , 비밀번호 , 이름 , 전화번호 , 나이
	0. Member 객체를 여러개 저장하는 배열 
		Member[] 객체배열 = new Member[100];
	
	1. 초기 메뉴 [ 24시간 ]
		1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
		
	2. 조건 기능 
		1. 회원가입 메소드 
			1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
			2. Member 객체화
			3. 객체를 배열 저장 
			 
		2. 로그인 메소드
			1. 아이디 , 비밀번호 입력받아 저장 
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 로그인 성공 
				- 아니면 실패
				 
		3. 아이디찾기 메소드
			1. 이름 , 전화번호 입력받아 저장
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 찾은 아이디 출력 
				- 아니면 없다.
				 
		4. 비밀번호찾기 메소드 
			1. 아이디 , 전화번호 입력받아 저장
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
				- 아니면 없다.
				
				
					// 1. m = {id = null , pw = null , name = null , age = 0}
		m.id = id ; m.pw = pw; m.phone = phone ;  m.age = age ;
			// 2. m = { id = "입력받은값" , pw = "입력받은값" name = "입력받은값"  , age = 0}
*/