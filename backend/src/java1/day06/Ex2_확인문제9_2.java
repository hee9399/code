package java1.day06;

import java.util.Scanner;

public class Ex2_확인문제9_2 {	
	public static void main(String[] args) { // main s
		
		 /*
		   9번 문제 
		   	- nextLine()메소드를 사용하라 그럼 String(클래스)을 사용한다
		   	  배열선언을 해줘야한다 왜? 여러명의 학생수를 효율적이게 저장하기위해
		   	  서랍장에 옷을 종류별로 저장하듯이
		   	  
		   	  
		  	1. 학생수 
		  		학생수(숫자로)를입력한다 , 입력했으면 학생수를 출력한다
		  			- 입력 , 출력하는 프로그램을 만든다
		  		학생수를입력하는거지  몇명의학생이라는 정확한 기준은없다
		  		
		  			  		
		  	2. 점수입력
		  		학생수를 입력한뒤에 점수를입력한다 
		  			- 입력 , 출력하는 프로그램을 만든다
		  		  
		  		
		  	3.점수리스트
		  		
		  	
		  	
		  	4.분석
		  	
		  	5.종료
		  	
		  	
		 */
		
		Scanner scanner = new Scanner(System.in); 		
			// 변수선언 
			// while문 밖에 변수선언하는 이유는? 학생수를 누적시키기위해 while문 안에 선언하면 입력받은값을 누적시킬수없다 
			// 누적시켜서 학생수를 리스트하고 분석 해야하기 때문에 
		
		 	int 학생수 = 0 ;	 	// 입력받을 학생수
		 	int 점수 = 0 ;
		 	// int라는 타입에 학생수2라는변수는 새로운 정수타입에 학생수만큼 배열에 들어온다 빈칸으로 들어온다
		 	int[] 학생수2 = new int[학생수] ; 
		 	
		 	// int 학생수2[] = { 12 , 66, 90, 44 , 6 };
		// [p.199] 확인문제9
		while(true) { // while s	// 무한루프
			System.out.println("---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("---------------------------------------------");
			System.out.println("선택> ");
			
			
			
			// 입력받는 변수
			int ch = scanner.nextInt();
			// int ch1= scanner.nextInt();
		
			if( ch == 1 ){ // 입력받을 학생수 s  
				System.out.println("학생수 : ");
				// 입력을받을것 
				학생수 = scanner.nextInt();
				
				
				
			} // 입력받을 학생수 e
			
			if(ch == 2){
				System.out.println("점수입력 : ");
				// 입력받을것 
				점수 = scanner.nextInt();
				
			} // 입력받을 점수
			
			if(ch == 3){
				
				
			} // 점수리스트
			
			if(ch == 4){} // 분석
			
			if(ch == 5){} // 종료
			
			
			
		} // while e
		
		
		
		
	}	// main e
}	// class  e


/*
 	step4 
 	설계 조건
 		- 학생수를 입력받아 입력받은 학생수 만큼 점수를 입력받아 저장
 		- 현재 점수 출력 / 통계 
 		
 		1. 학생수 
 			- 학생수를 입력받아 '학생수' 변수에 저장한다. 
 			- 그 학생수 만큼 배열 선언한다. [ 메모리 할당 ] : 타입[] 변수명 = new 타입[길이]
 		2. 점수입력
 			- 몇개 점수 입력????? 정해져 있지 않는 상태 --> 변수로만 처리 비효율적으로 --> 배열 효율적
 			- 1번 기능에서 할당된 배열만큼 점수를 입력받아 각 인덱스에 저장한다.
 				[ 만일 학생수를 입력받지 않고 점수입력을 하면 요류 발생!!! ]
 		3. 점수리스트
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터 호출 한다.
 		4. 분석
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 모두 더한다 = sum
 			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 호출해서 최고점수 찾는다 = max
 		
 		5. 종료
 			무한루프 종료해서 출력그만!! break;
 	
 		// .nextLine() 사용시 주의할점 
 		 * nextLine 사용시 다른 next~~() 앞뒤로 존재 했을때 하나로 인식 [ 오류 처럼 보일수 있다 ]
 		 1. 해결 방안1
 		 	Integer.parseInt(scanner.nextLine() );
 		 2.
 */

/*
	공통 출력 
		System.out.println("-----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
		System.out.println("-----------------------------------------------");
		System.out.println("선택> 1");
	
	개별 출력 
	// 1.
	System.out.println("학생수> 3");
	// 2.
	System.out.println("scores[0]> 85");
	System.out.println("scores[1]> 95");
	System.out.println("scores[2]> 93");
	// 3.
	System.out.println("scores[0]: 85");
	System.out.println("scores[1]: 95");
	System.out.println("scores[2]: 93");
	// 4.
	System.out.println("최고 점수: 95");
	System.out.println("평균 점수: 91.0");
	// 5.
	System.out.println("프로그램 종료");
	
*/






























