package 팀과제4;

import java.util.Scanner;

// 실행
public class EX_메소드 {
	public static void main(String[] args) {
		
		// 1. 다른 클래스에 있는 메소드를 호출하기 위한 객체 생성
		고객 신동엽 = new 고객("신동엽");	
		고객 유재석 = new 고객("유재석");
		
		계좌 통장1 = new 계좌(); // 임의 통장 만들었어.
		통장1.계좌주 = 신동엽; // 임의 통장에 신동엽 객체를 넣었으니 이 통장은 이제 신동엽꺼야.
		
		System.out.println( 통장1.계좌주.name ); // 통장을 통해서 계좌주를 확인하고 이름을 보니 신동엽
		
		통장1.입금(); // 신동엽통장 에만 입금 행동~~
		
		계좌 통장2 = new 계좌(); // 임의 통장 만들었어.
	
	} // main e
	
}// class e

/*


Scanner sc = new Scanner(System.in);
while(true) {
	System.out.println("1.회원가입 2.입출금");
	System.out.println(">>>>선택 : ");int ch = sc.nextInt();
	if( ch == 1 ) {
		System.out.println("이름을 입력하세요 : " +name); String name = sc.next();
		System.out.println("아이디를 입력하세요 : "); String id = sc.next();
		System.out.println("비밀번호를 입력하세요 : "); String pw = sc.next();
	}
	else if( ch == 2) {
		
	}
}
*/