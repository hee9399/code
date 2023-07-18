package 과제.과제3.Level2;

import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		// Scanner 객체 생성 
		Scanner scanner = new Scanner(System.in);
		
		/* -------문제1----- */ 
			// 2. 무엇을 입력받을껀지
			System.out.print("정수1 : "); int 문제1_1 = scanner.nextInt(); // 1.입력값을 int형으로 호출 
			System.out.print("정수2 : "); int 문제1_2 = scanner.nextInt(); 
			
			// 마냐게 문제 1_1 이 문제1_2보다 크면 더큰수를 출력한다 
			// 아니면 문제1_2가 더크면  더큰수가나온다
			// 아니면 동일한수가나온다
			if(문제1_1 > 문제1_2 ) System.out.println("더 큰수 : " +문제1_1); 
			else if(문제1_1 < 문제1_2 ) System.out.println("더 큰수 : " +문제1_2); 
			else System.out.println("동일한 수");
			
		/* -------문제2----- */
			System.out.print("정수1 : "); int 문제2_1 = scanner.nextInt(); 
			System.out.print("정수1 : "); int 문제2_2 = scanner.nextInt();
			System.out.print("정수1 : "); int 문제2_3 = scanner.nextInt(); 
			
			// 1안 max라는 변수를 임시변수로 만들어서 코드를 줄이는 방법
			int max = 문제2_1; 
			if(max < 문제2_2) max = 문제2_2; 
			if(max < 문제2_3) max = 문제2_2; 
			System.out.println("문제2 : " +max); 
			// 2안 
		/*	if(문제2_1 > 문제2_2) { // 첫반째 값이 두번째 값보다 컸을때 
				if(문제2_1 > 문제2_3) {System.out.println("가장큰수 : " + 문제2_1);} 
				else {System.out.println("가장큰수 : " +문제2_3);}
			}else if(문제2_2 > 문제2_3) {
				
			} */
			
			
			
		/* -------문제3----- */ 
			// > : 오름차순 < : 내림차순
			System.out.print("정수1 : "); int 문제3_1 = scanner.nextInt(); 
			System.out.print("정수1 : "); int 문제3_2 = scanner.nextInt();
			System.out.print("정수1 : "); int 문제3_3 = scanner.nextInt();
			if(문제3_1 > 문제3_2); { int temp = 문제2_1; 문제2_1 = 문제2_2; 문제2_2 = temp; } // 만약에 조건이 충족하면 자리 변경 
			if(문제3_1 > 문제3_3); { int temp = 문제2_1; 문제2_1 = 문제2_3; 문제2_3 = temp; } // 만약에 조건이 충족하면 자리 변경
			if(문제3_2 > 문제3_3); { int temp = 문제2_2; 문제2_2 = 문제2_3; 문제2_3 = temp; } // 만약에 조건이 충족하면 자리 변경
			System.out.printf("문제3 : %3d %3d %d \n" , 문제2_1 , 문제2_2 , 문제2_3 );
			
		/* -------문제4----- */
			int 점수 = scanner.nextInt(); 
			if(점수 >= 90 ) {System.out.println("합격");
				// 조건식에 들어갈수 있는 경우: 1. true/false 결과를 갖는 비교/논리
				//						2. true/false 를 저장하고 있는 변수 
				//						3. true/false 리터럴(직접 적은 데이터)
			}else System.out.println("불합격");
		/* -------문제5----- */
			if(점수 >= 90) {System.out.println("합격");}
			else if(점수 >= 80) { System.out.println("A등급");}	
			else if(점수 >= 70) { System.out.println("C등급");} 
			else {System.out.println("재시험");}
			
		/* -------문제6----- */
			System.out.print("국어 : "); int 국어 = scanner.nextInt(); 
			System.out.print("영어 : "); int 영어 = scanner.nextInt();
			System.out.print("수학 : "); int 수학 = scanner.nextInt(); 
			double 평균 = (국어+영어+수학)/3.0; // 값/3 vs 값/3.0 
			if( 평균 >= 90 ) {
				if(국어==100) System.out.println("국어우수");
				if(영어==100) System.out.println("영어우수");
				if(수학==100) System.out.println("수학우수");
			}
			else if(평균 >= 80) {
				if(국어>=90) System.out.println("국어장려"); 
				if(영어>=90) System.out.println("영어장려");
				if(수학>=90) System.out.println("수학장려"); 
			}
			
		/* -------문제7----- */
		
		
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
