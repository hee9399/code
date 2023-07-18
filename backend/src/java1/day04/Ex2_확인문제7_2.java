package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7_2 { // class s
	public static void main(String[] args) { // main s
		
		 
		// step2 : 중복된 출력을 반복문으로 출력하자 [코드 효율성 증가] 
		// step3 : Scanner 클래스를 이용한 입력된 데이터로 [1,2,3,4]기능 제공 
			// 입력
			// 1. 입력객체
		Scanner scanner = new Scanner(System.in); 
			// 2. 입력객체를 이용한 next~~~() 메소드로 입력객체내 입력받은 데이터 형변환 해서 호출 
			// 1. int 예금액 = 0; // main 실행될때 // main함수 실행할때마다  // 1번 [ o ] 
			int 예금액 = 0;
			while (true) { // 무한루프 // 종료할때까지 4입력할때까지 프로그램 실행 계속 되어야한다 = 무한루프 // 종료조건 : 4입력시
				
				// 서로 같은 내용 출력
				System.out.println("\n----------------------------");
				System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료"); // 경우의 수 4가지
				System.out.println("----------------------------");
				System.out.print("선택> ");
				// 2. 무한입력
				int ch = scanner.nextInt(); // 입력받고 변수에 저장 필수 !!! 입력받은 값으로 추후 행동 하기 위해서
				// step5 : 각 기능별 구현 => 공통 변수 생각 => 예금액
					// 1:예금액 : 입력받아 예금액 변수에 저장
					// 2:출금액 : 출금할 금액 입력받아 예금액 
		// 3. 입력에 따른 서로 다른 코드 실행 // 예금되있는걸 출금하는것이때문에(돈을저장하는) 예금을 해야 출금이 가능해진다는거죠
			if(ch == 1) {
				// 3. int 예금액 = 0; // 1 입력했을때 / 1 입력할때마다 [x]
				System.out.println("예금액>");
				예금액 += scanner.nextInt(); // 입력받은 정수를 예금액 변수에 누적 더하기
			}
			
			else if(ch == 2) {
				System.out.println("출금액>");
				예금액 -= scanner.nextInt(); // 입력받은 정수를 예금액 변수에서 누적 빼기
			}
			else if(ch == 3) {System.out.println("잔고>" +예금액);
			
			} // 예금액 변수 호출해서 출력
			
			else if(ch == 4) {
				System.out.println("\n프로그램 종료");
				break; // 가장 가까운 while 탈출
			}
		}
		
		/*
		System.out.println("선택> 1");
		System.out.println("예금액> 10000");
		
	
		System.out.println("선택> 2");
		System.out.println("출금액> 10000");
		
		
		System.out.println("선택> 3");
		System.out.println("예금액> 10000");
		
		
		System.out.println("선택> 4");
		System.out.println("예금액> 10000");
		*/
		
	} // main e
} // class e
