package 과제.과제9;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행
public class MemberSys {
	public static void main(String[] args) {
		
		// 0. 여러개 Member객체 100개=100명 회원 를 저장 예정인 배열 선언
		Member[] memberList = new Member[100];
		// 배열 선언 : 타입명[] 배열명 = new 타입명[길이];
				// 타입 : 기본타입(int,float 등),참조( String,직접만든클래스=Member 등)타입
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println( Arrays.toString( memberList ) ); // 배열 상태 확인용
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); // 1. 무한 출력
			System.out.print("1.회원가입 2.로그인    선택> ");
			int ch = sc.nextInt(); // 2. 무한 입력
			
			// 3. 입력/선택 경우의수 
			if( ch == 1 ) {
				System.out.println("--------- 회원가입 ---------");
				// 1. 각 입력받아 저장 
				System.out.print("아이디 : "); 	String inputId = sc.next();
				System.out.print("비밀번호 : "); 	String inputPw = sc.next();
				System.out.print("이름 : "); 		String inputName = sc.next();
				System.out.print("전화번호 : "); 	String inputPhone = sc.next();
				System.out.print("나이 : "); 		int inputAge = sc.nextInt();
				// 2. 
					// 1. 기본생성자[과제8] vs 정의한생성자[과제9] 
					Member member = new Member(inputId, inputPw, inputName, inputPhone, inputAge);
				// 3. 
				for( int i = 0 ; i<memberList.length; i++ ) {
					// 만약에 i번째 인덱스에 null 이면 해당 i번재 인덱스에 입력받아서 만든 객체 대입 
					if( memberList[i] == null ) { memberList[i] = member; break; }
				} // for end
				
			} // if end 
			else if( ch == 2 ) {
				System.out.println("--------- 로그인 ---------");
				// 1. 입력받기
				System.out.print("아이디 : "); 	String inputId = sc.next();
				System.out.print("비밀번호 : "); 	String inputPw = sc.next();
				
				// 2. 입력받은 데이터를 배열내 찾기 
				int login = -1;	// 로그인 여부를 저장하는 변수 -1: 못찾았다 0이상이면 찾고 찾은 인덱스번호 저장 = 로그인성공 기록
				for( int i = 0 ; i<memberList.length ; i++) {
					// 만약에 i번째 객체의id필드와 입력받은 아이디와 같고 i번째 객체의pw필드와 입력받은 비밀번호와 같으면
					if( memberList[i] != null && // 비어 있는 인덱스는 검사할 필요가 없다!!!! // i번째 인덱스가 비어있지 않고
							memberList[i].id.equals(inputId) && 
								memberList[i].password .equals(inputPw) ) {
						login = i; // 로그인 성공후 변수에 성공한 인덱스 저장 = 추후에 로그인 상태 활용 
						break;
					}
				}// for end 
				
				// 3. 로그인 성공여부 변수에 따른 흐름 제어
				//로그인 실패 [ 모든 배열 검사후에 성공 못하면 실패 ]
				if( login >= 0 ) { System.out.println("안내) 로그인 성공"); } // 추후에 로그인시 새로운 메뉴 메소드호출 
				else { System.out.println("안내) 로그인 실패"); }
				
				
			} // if end
		} // w e 
		
	} // main e
} // class e


/*
	주제 : 회원제 시스템 
		0. 저장 
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
			* 5가지(서로다른타입) 필드/변수/데이터 를 하나의 묶음방법
			--> 문자열 이용 : "아이디,비밀번호,이름,전화번호,나이"	: ,쉼표 이용한 필드 구분
			--> 클래스(필드) 이용 : 
				1. 클래스 설계	= 새로운 클래스.java 파일 생성
				2. 클래스 멤버 구성 : 필드 , 생성자 , 메소드
		* 하나로 묶인 (기준동일=타입동일) 여러개 저장???????????
		--> 문자열 배열 : String[] 문자열배열 = new String[100];
		--> 클래스 배열 : Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 
			
		2. 조건 기능 
			1. 회원가입
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패 
					
					
					
					
					// 1안 
				Member member = new Member(inputId, inputPw, inputName, inputPhone, inputAge);
				// 2안
				Member member2 = new Member(inputId, inputPw, inputName, inputPhone);
				if( inputAge >= 19 ) member2.age = inputAge;
				// 3안
				Member member3 = new Member(inputId, inputPw, inputName);
				member3.phone = inputPhone;	member3.age = inputAge;
				// 4안 2개	5안 1개
				
					
				
		
*/



