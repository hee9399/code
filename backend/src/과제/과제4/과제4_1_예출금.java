package 과제.과제4;

import java.util.Scanner;

public class 과제4_1_예출금 { 
	public static void main(String[] args) { 
		
		// 입력객체
		Scanner scanner = new Scanner(System.in);
			
		  
		int balance = 0; String account = "123-1234"; short password = 1234;  
		
		while( true ) { // 무한루프 [ 종료조건 : 4 입력시 break; ] 
			System.out.println("\n\n--------------------");
			System.out.println("1.예금 2.출금 3.잔액 4.종료 : ");
			System.out.println("--------------------");
			System.out.print(">> 선택 : ");
			// 무한 입력
			int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			// else if 와 if의 차이점 은 else if는 통으로 묶고 if는 각각의 실행이다 
			//  step2 : 입력받은 메뉴 번호에 따른 서로 다른 코드/행동 실행 
			if( ch == 1 ) { // 예금기능 구현 
				System.out.print("계좌번호 : ");	String inputAccount = scanner.next();
				// 일치하면 / 일치하지 않으면 => 경우의수 2개 => if 
				// 같다 / 다르다.  equals()
				if(inputAccount.equals(account) ) {
					// 입력받은 계좌변호와 기존의 계좌번호와 일치하면
					// 3. 예금액을 입력받아 
					System.out.println("예금액 : "); int inputBalance = scanner.nextInt();
					// 4. 예금액 변수에 누적 더 해준후 [예금 성공] 출력
					balance += inputBalance;	System.out.println("예금 성공");
				}else{// 일치하지 않으면 
					System.out.println("계좌번호 불일치");
				}
			 //   balance += scanner.nextInt(); // int는 선언키워드 이기때문에 키워드와 키워드명을 붙이면 선언이되고 키워드명을빼고 키워드명만넣으면 호출이된다
				
			}
		 	else if( ch == 2  ) {
				// step2 : 경우의수 true 기능 구현 
				System.out.print("계좌번호:"); 		String inputAccount = scanner.next();
				if( inputAccount.equals( account ) ) {
					System.out.print("비밀번호:"); 		Short inputPassword = scanner.nextShort();
					// 1. 비밀번호 일치 경우의수 
					if( inputPassword == password  ) { // 입력받은 비밀번호 와 기존의 비밀번호와 일치하면
						// 2. 출금액 받고
						System.out.print("출금액:"); 		int inputBalance = scanner.nextInt();
						// 3. 예금액보다 출금액이 더 크면
						if( inputBalance > balance ) { // 입렫받은 출금액이 현재 예금된 금액보다 크면 
							System.out.println("잔액 부족");
						}else {
							balance -= inputBalance; System.out.println("출금 성공");
						}
					}else {
						System.out.println("비밀번호 불일치");
					}
				}else {
					System.out.println("계좌번호 불일치");
				}
			}
			else if( ch == 3  ) { System.out.println("예금액 : " + balance ); }
			else if( ch == 4  ) {  System.out.println("안녕히 가세요");  break;  }
			/* ----------- */
			
		
		} 
	} 
} 

/*
 
 // 1번문제는 예금액 과 계좌번호 와 패스워드를 출력 , 입력 하는 코드작성 
			System.out.print("예금액 : ");  int balance = scanner.nextInt(); 
			System.out.print("계좌번호 : "); String account = scanner.next();
			System.out.print("패스워드 : "); short password = scanner.nextShort();
				// 계좌번호 가 123-1234 이다
				System.out.println(account.equals("123-1234") );
				
 
 
  
 */

/*
	주제 : 예출금 시스템
		변수 조건 
			1. balance , account , password 1명의 임의 예금액 과 계좌번호 , 패스워드 입니다. 변경불가능 
			
		입력 조건 
			1. 사용할 기능을 입력받는다. [1 이면 예금기능 2 이면 출금기능 3이면 잔액확인기능 4이면 종료 ]
			
		실행 조건 
			1. 만약에 예금 기능 
				1. 계좌번호를 입력받아 일치하면 예금액을 입력받아 예금액 변수에 누적 더 해준후 [ 예금 성공 ]출력 
								일치하지 않으면 '계좌번호 미일치' 라는 안내출력후 다시 메뉴로 이동 
			2. 만약에 출금 기능 
				1. 계좌번호를 입력받아 일치하면 비밀번호를 입력받고 출금액 받고 예금액에서 누적 차감 해준다.  [ 출금 성공 ]출력 
								계좌번호를 일치하지 않으면 '계좌번호 미일치' 라는 안내출력후 다시 메뉴로 이동 
								비밀번호를 일치하지 않으면 '비밀번호 미일치' 라는 안내출력후 다시 메뉴로 이동 	
								예금액보다 출금액이 더 크면 '잔액 부족' 라는 안내출력후 다시 메뉴로 이동
								
			3. 만약에 잔액 기능 
				1. 현재 예금된 금액을 출력해준다. [ 예금액 : 3000 ]출력
				  
			4. 만약에 종료 기능 
				1. 시스템이 종료된다. [ 안녕히 가세요. ]출력
*/










