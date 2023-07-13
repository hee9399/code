// 자바 한줄 주석 
/* 여러줄 주석 */

package java1.day01; // 패키지/폴더 경로

public class Hello {// class start // 클래스 선언 // 'Hello' 클래스명 = 숫자시작X , 공백X , 첫글자대문자
	// 1. JAVA 코드 가장 단위 = 클래스 = 모든 코드는 클래스{ } 중괄호 안에서 작성
	// 2. 모든 실행코드는 main함수 안에서 작성 [스데드=코드읽은흐름]
	// 스레드 = 어떤 흐름의 단위
	
	// { } 마다 tap 1번 적용
	public static void main(String[] args) { // m start / 메소드=함수 선언
		// console.log() vs System.out.println()
		// syso + 컨트롤 + 스페이스바 엔터!! 
		System.out.println("Hello java"); 
		// 실행 : ctrl+F11 , 해당 오른쪽클릭 -> RUN , 상단메뉴 RUN
	} // m end
	
	// 실행 코드는 main함수 밖에서 작성이 불가능하다
	// System.out.println("Hello java"); 
	
} // class end

// 클래스 밖에서 코드작성 X
// System.out.println("Hello java"); 
