package 과제.과제2;
// java.lang 패키지 : System 클래스 , Math 클래스 , Integer 클래스 등등 import 생략
import java.util.Scanner; // Scanner 클래스를 사용하기 위한 클래스호출

public class 연산20문제 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	/*
		|\_/|
		|q p|   /}
		( 0 )"""\
		|"^"`    |
		||_/=\\__|
	 */
		//------ 문제1 여기에 풀이-------//
			//1행
				System.out.print("|"); System.out.print("\\"); 
				System.out.print("_"); System.out.print("/");    System.out.println("|"); // println 출력후 줄바꿈
			//2행
				System.out.print("|"); System.out.print("q");    System.out.print(" p"); 
				System.out.print("|"); System.out.print("   /"); System.out.println("}");// println 출력후 줄바꿈
			//3행
				System.out.print("(");  System.out.print(" 0 "); System.out.print(")"); 
				System.out.print("\""); System.out.print("\"");  System.out.print("\""); System.out.println("\\"); // println 출력후 줄바꿈 
			//4행
				System.out.print("|");  System.out.print("\""); System.out.print("^"); 
				System.out.print("\""); System.out.print("`"); System.out.println("    |"); //println 출력후 줄바꿈 
			//5행
				System.out.print("|"); System.out.print("|");  System.out.print("_"); System.out.print("/"); 
				System.out.print("="); System.out.print("\\"); System.out.print("\\");System.out.print("_");
				System.out.print("_"); System.out.println("|"); //println 출력후 줄바꿈
			
		/*
				문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	     		[입력변수]
					1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
		 		[출력 예]
					   --------------방문록--------------------
					   | 순번  | 작성자  | 	내용 	| 날짜       |
					   |  1   | 강호동  |안녕하세요  |  09-28    |
					  ----------------------------------------
		 */
		//------ 문제2 여기에 풀이-------//
				
			/*	//1.입력 객체 생성
				Scanner scanner = new Scanner(System.in);
					// System.in = 시스템 입력 = 기보드
				//2. 입력 객체를 이용한 입력값 호출/저장 
					// 1. 입력받은 문자열 가져오기 scanner.next
					// 2. 변수애 저장 
				System.out.print("작성자 : "); String 작성자 = scanner.next();
				System.out.print("내용 : "); String 내용 = scanner.next();
				System.out.print("날짜 : "); String 날짜 = scanner.next();
				// 출력
				System.out.printf("--------------방문록--------------------");
				System.out.printf("|%4s| %4s  |%10s| %4s|\n" ,"순번", "작성자" , "내용" , "날짜"); 
				System.out.printf("|%4s| %4s  |%10s| %4s|\n" ,1 ,작성자 , 내용 , 날짜);
				System.out.printf("--------------------------------------\n") 
		*/
				
				
	/*			
		//------ 문제3 여기에 풀이-------//
			//1. 입력객체 : 상단에 
			//2. 입력값 호출 
		
			System.out.print("기본급 : "); int 기본급 = scanner.nextInt(); 
			System.out.print("수당 : "); int 수당 = scanner.nextInt(); 
			//2. 계산 							  // %퍼센트[x] 나머지 연산자[o]
			long 실수령액 = 기본급 + 수당 - (int)(기본급*0.1); // 10:1000% 1:100% 0.5:50% 0.05:5% 
			// 리터럴(직접입력한)의 기본타입 : int(정수) , double(실수) 
			// int * double 연산시 => 결과 double 
			// double 은 long 에 대입 x => 강제형변환(캐스팅)  
			System.out.println("실수령액 : "+ 실수령액);
												
		//------ 문제4 여기에 풀이-------//
		
		// 1. 입력 
				// 1. 입력객체 : 상단 
				// 2. 입력값 호출 / 저장 
				System.out.println("금액 : "); int 금액 = scanner.nextInt(); 
				// 2. 계산 // 3. 출력 
					// 십만원 
				System.out.println("십만원 : " + (금액/100000) + " 장"); 
				// 만원권 부터는 십만원 제외한 금액에서 만원 계산 
				금액 -= (금액/100000) * 100000; // 원금에서 3십만원을 제외한다 
				System.out.println("만원 : " +(금액/10000) + " 장"); 
				// 천원 : 금액에서 만원을 제외한 금액에서 천원 계산 
				금액 -= (금액/10000) * 10000; // 원금에서 5만원 제외  
				System.out.println("천원 : " + (금액/1000) +" 장"); 
				// 백원 : 금액에서 천원을 제외한 금액에서 백원 계산 
				금액 -= (금액/1000) * 1000; // 원금에서 5만원 제외  
				System.out.println("백원 : " + (금액/100) +" 장"); 
		
		//------ 문제5 여기에 풀이-------//
		// 배수공식 : 값 % 수 = 나머지 	*만약에 나머지가 0 이면 수는 그 값의 배수 
		// 홀짝공식 : 값 % 2 = 1 or 0 	*만약에 나머지가 1 이면 값은 홀수  / 0이면 
			System.out.print("정수5 : "); int 정수5 = scanner.nextInt(); // 입력받은 정수
			char result = (정수5 % 7 == 0 ) ? 'o' : 'x'; 
			System.out.println("문제5 결과 : " + result);
		
		
		//------ 문제6 여기에 풀이-------//
			System.out.print("정수6 : "); int  정수6 = scanner.nextInt();// 입력받은 정수
			System.out.println("문제6 결과 : " + ( (정수6 % 2 == 1) ? "o" : "x") ); 
		
		//------ 문제7 여기에 풀이-------//
			System.out.print("정수7 : "); int 정수7 = scanner.nextInt(); 
			System.out.println("문제7 결과 :"+ (정수7 % 7 == 0 && 정수7 % 2 == 0 ? "o" : "x") );
		
		//------ 문제8 여기에 풀이-------//
			System.out.println("정수8 : "); int 정수8 = scanner.nextInt(); 
			System.out.println();
									*/
		//------ 문제9 여기에 풀이-------// 
				/*
			System.out.print("정수9_1 : "); int 정수9_1 = scanner.nextInt(); 
			System.out.print("정수9_2 : "); int 정수9_2 = scanner.nextInt(); 
			// 삼항연산자 : 조건?참:거짓          // 중첩 : 조건1 ? 참1 : 조건2 ? 참2 : 조건3 ? 참3 : 거짓 // 읽기 어려우면 if문 사용
			System.out.println("더 큰수 : " +(정수9_1 > 정수9_2 ? 정수9_1 : 정수9_1 < 정수9_2 ? 정수9_2 : "같다" ) ); 
			
		//------ 문제10 여기에 풀이-------//
			System.out.print("반지름 : "); double 반지름 = scanner.nextDouble(); 
			System.out.println("원 넓이 :"+ ( 반지름*반지름*3.14 ) );
		
		//------ 문제11 여기에 풀이-------//
			System.out.print("실수1 : "); double 실수1 = scanner.nextDouble();
			System.out.print("실수2 : "); double 실수2 = scanner.nextDouble(); 
			System.out.printf("실수2 에서 실수1 비율 계산 : %.6f %% \n" , ( 실수1/실수2 )*100.0 ); 
					// %f : 실수형식  %.6f : 실수 소수점6자리형식 						// 100 을 왜 곱하는가? 보여주기 편하기 위해서 컴퓨터는 0.64가 64퍼센트로 인식해요 
		
		//------ 문제12 여기에 풀이-------//
			System.out.print("윗변 : "); double 윗변 = scanner.nextDouble();
			System.out.print("밑변 : "); double 밑변 = scanner.nextDouble(); 
			System.out.print("높이 : "); double 높이 = scanner.nextDouble(); 
			System.out.println("사다리꼴 계산 : " + (윗변 + 밑변)*높이 / 2);
			
			*/
		
		//------ 문제13 여기에 풀이-------//
			System.out.println("키2 : "); int 키1 = scanner.nextInt(); 
			System.out.println("표준 체중 : " +(키-100)*0.9); 
			
		
		//------ 문제14 여기에 풀이-------//
			System.out.println("키2 : "); int 키2 = scanner.nextInt(); 
			System.out.println("몸무게 : "); int 몸무게 = scanner.nextInt(); 
			System.out.println("BMI 계산 : " + (몸무게 / ( (키2/100)*(키1/100) ) ) ); 
				// 수정된 계산식 = 체중/ 신장(m) 
		
		//------ 문제15 여기에 풀이-------//
			System.out.print(" inch : "); double 인치 = scanner.nextDouble();
			System.out.println(" inch ---> cm : " + (인치*2.54) + "cm" ); 
			
		//------ 문제16 여기에 풀이-------//
			System.out.print("중간고사 : "); double 중간고사 = scanner.nextDouble();
			System.out.print("기말고사 : "); double 기말고사 = scanner.nextDouble();
			System.out.print("수행평가 : "); double 수행평가 = scanner.nextDouble();
			System.out.printf("점수 : %.2f" , (중간고사*0.3 + 기말고사*0.3 + 수행평가 * 0.4)); 
		
		//------ 문제17 여기에 풀이-------//
			// 1. x에 10을 대입한다. (x=10) 
			// 2. y에 계산식 [연산5개] = -- + + -- [*만약에 우선순위가 동일할경우 왼쪽부터]
				// 계산 순서
				//1.x-- : x에 1차감[후위감소] 가장 마지막처리
					// x = 10
				//2.--x : x에 1차감[선위감소] 가장 먼저처리 
					// [x = 9]
				//3.+ : 10+5	15
				//4.+ : 15+9	24
				//5.= : 24-1
				// x = 8 , y = 23[하나차감하니까]
			int x = 10; 
			int y = x-- + 5 + --x ; 
			//	System.out.println(x--); 	 // 10 
			//	System.out.println(x-- + 5); // 15 
			//	System.out.println(--x); 	 // 9
			System.out.printf("x의 값 : %d , y의값 : %d ",x,y);
		
		//------ 문제18 여기에 풀이-------//
		// 문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
			System.out.print("나이 : "); int 나이 = scanner.nextInt(); 
			// 삼항연산자 
			System.out.println(나이 >= 40 ? "중년" : 나이 >= 20 ? "성인" : 나이 >= 10 ? "학생" : "유아" ); 
		
		//------ 문제19 여기에 풀이-------//
			// 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력 
			System.out.print("국어 : "); int 국어 = scanner.nextInt(); 
			System.out.print("영어 : "); int 영어 = scanner.nextInt();
			System.out.print("수학 : "); int 수학 = scanner.nextInt(); 
			System.out.println(" 총점 : " +(국어+영어+수학)/3.0 ); 
			System.out.printf("평균 : %.2f \n");
			
		
		//------ 문제20 여기에 풀이-------//
			System.out.print("아이디 : ");	String 아이디 = scanner.next(); 
			System.out.print("비밀번호 : ");  String 비밀번호 = scanner.next(); 
			System.out.println(아이디.equals("admin") && 비밀번호.equals("1234") ? "로그인성공" : "로그인실패" );
			// * 비교/산술 연산자는 객체에서 사용 불가능[기본타입vs객체 메모리구조 다름] 
			// 기본타입 데이터 비교시 == 가능 	// 문자열 데이터 비교시 == 불가능 [ .equals() 메소드 사용 ] 
			// 3 == 3 [가능] 			// "안녕".equals("안녕") 
			
		//------ 문제21 여기에 풀이-------//
		System.out.println("정수1 :" ); int 정수1 = scanner.nextInt(); 
		System.out.println("정수2 :" ); int 정수2 = scanner.nextInt();
		System.out.println("정수3 :" ); int 정수3 = scanner.nextInt();
		int max = 정수1; // 임의의 가장 큰수를 저장하는 max변수 [ 첫번째 값을 초기값 대입 ] 
		max = max < 정수2 ? 정수2 : max; // 마약게 max 보다 정수2가 더 크면 정수2 대입
		max = max > 정수3 ? 정수3 : max; // 만약에 max 보다 정수3이 더 크면 정수3 대입
		System.out.println("max : " + max);
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
