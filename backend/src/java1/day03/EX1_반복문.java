package java1.day03;

import java.util.Scanner;

public class EX1_반복문 { // class s
	public static void main(String[] args) {// main s
		// [p.124] 1부터 10까지 누적합계 (for 없이)
		int sum = 0; 
		sum = sum+1; sum+=2; sum+=3; sum+=4; sum+=5; sum+=6; sum+=7; sum+=8; sum+=9; sum+=10;
		
		// 1부터 10까지 누적합계 (for 이용) 
		int sum2 = 0; 
		for(int i = 1; i<=10 ; i++) { sum2 += i;}
			// i는 1부터 10까지 1씩 증가 반복 
		
		// [p.124] 1부터 10까지 출력 
		// 1. for문을 안쓰면 1부터10까지 수작업으로 해야해요 잘못된건아닌데 효율성이 떨어지는 거죠 
		// 2. for 이용 
		for(int i = 1; i<=10; i+=1) {System.out.println(i + " ");}
		
		// [p.126] 초기값 변수는 for에서 선언시 지역변수이다. 
		int sum3 = 0; 
		for(int 반복변수 = 0; 반복변수<=10; 반복변수++) {sum3 += 반복변수;} 
		// System.out.println(반복변수);// x= for ()에서 선언된 변수는 for{}밖에서 사용불가 
		
		int sum4 = 0; int i;
		for(i=1; i<=100; i++) {sum4 += i;} 
		System.out.println("1~" + (i-1)+"합 : " +sum4); 
		
		// [p.127] 실수 // 소수점뒤에 f 사용이유 : (직접 작성한)리터럴 소수점 = double 이기때문에 
		for(float x = 0.1f; x <= 0.1f ; x+=0.1f ) {System.out.print(x + " ");} 
		// float 아니고 double이면? 
		for(double x = 0.1; x <= 1.0 ; x+=0.1) {System.out.print(x + " ");} 
		
		System.out.println("\n---------------------");
		// [p.128] 구구단 
			// 1. 2단 구구단 for이용 
		for(int 곱 = 1; 곱<=9 ; 곱++) {System.out.print(2 * 곱 + " ");} 
			// 1. 2단 ~ 9단 for 
		for(int 단 = 2 ; 단<=9; 단++) {System.out.println(단);}
			// 2. 1곱 ~ 9곱 for 
		for(int 곱 = 1; 곱<=9 ; 곱++) {System.out.println(곱);} 
			// 3. 1,2 합치기 [단 마다 곱 실행(o) vs 곱 마다 단 실행(x) ] 
		for(int 단 = 2; 단<=9; 단++) {// 행 // 단 // 8
			for(int 곱 = 1 ; 곱<=9 ; 곱++) {// 열 // 곱 // 9
				System.out.printf(" ");
				
			}
			
		}
		
 	
	
	// [p.129 vs 124] 1~10 출력 
	for(int g = 1; g<=10 ; g+=1) {System.out.println(g+ " ");}
	
	int a = 1;
	while(a<=10) {System.out.println(a+" "); a++;}
	
	// [.130 vs 126] 1~100 누적합계 
	
	// [126] 
	// int sum3 = 0; 
	// for(int 반복변수 = ㅑ; 반복변수<=100; 반복변수++){녀ㅡ3 += 반복변수;}
	
	int sum5 = 0;
	int b = 1;
	while(b<=100) {sum5 += b; b++;}
	
	// [p.131] 무한루프 // 무한루프를사용할때는 while문을 사용한다 
	//while(true) {System.out.println("무한반복");} 
	//for( ; ;) {System.out.println("무한반복"); 
	
	Scanner scanner = new Scanner(System.in);
	boolean run = true ; // while문 true/false 저장하는 변수 , on/off 역할 
	int speed = 0; // 현재 속도 저장하는 변수 
	
	// while(run){System.out.println("무한반복");} 
	while(run) {// while s
		System.out.println("-----------------------------------");
		System.out.println("1.증속 | 2.감속 | 3.중지"); // 입력의 경우의수 3가지  에 서로 다른 코드 실행
		System.out.println("-----------------------------------"); 
		System.out.println("선택 : "); 
		// --------- 무한입력 
		String strNum = scanner.nextLine();
		// --------- 입력에 따른 서로 다른 실행문 처리 [조건에 따른 실행] 
		if(strNum.equals("1")) { // 만약에 입력이 1이면 
			speed++;	// 스피드 증가 
			System.out.println("현재 속도 = " + speed);
		}else if(strNum.equals("2") ) {// 만약에 입력이 2이면
			speed--; //스피드 감소 
			System.out.println("현재 속도 = " + speed);
		}else if(strNum.equals("3") ) {// 만약에 입력이 3이면
			run = false; 	// 1 : 조건반복변수 false 대입해서 조건식을 false 만든다. // 위치1 
			// break;		// 2 : 가장 가까운 반복문 탈출  // 위치1 
			// return;		// 3 : 현재 함수 강제 변환/종료 // 위치2
		}
		
			
	} // while e
	// 위치1
	
	// [p.135] 
		//1. for문에 식별이름 정의 : for이름 정의 : for이름 : for() {}
	
		//2. break; 
			// : 가장 가까운 반복문 탈출 
		//2. break for이름; 
			// : 해당 for 탈출
		//3. continue;
			// : 가장 가까운 반복문 증감식/조건식 으로 이동; 
		//3. continue for이름; 
			// : 해당 for 반복문 증감식/조건식 으로 이동; 
		// 공통점 : break; continue; 아래 코드는 실행x 
	
 대분자for : for(char upper = 'A'; upper <= 'Z' ; upper++) {
		System.out.println(upper+" ");
		
		소문자for : for(char lower = 'a'; lower <= 'z'; lower++) {
			
			System.out.print("\t "+lower); 
			// * 가장 가까운 반복문 탈출 
			// if(lower == 'g') break;
			// * 특정 for break; 
			if(lower == 'g') break; //대문자for; 
			
		} // for 2 end
		System.out.println();
		
	} // for 1 end
	
	// [p.137]
	
	숫자for : for(int j = 1 ; j<=10 ; j++) {
		if(j % 2 != 0) { // 홀수 찾기 == 1 
			// continue ; // for으로 이동 // 아래에 있는 코드는 실행x // 홀수 출력x
			continue 숫자for;
			
		} // if end 
		System.out.println(j + " "); // 짝수 만 출력
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	} // main e 
	// 위치2
}// class e
	
/*
 	for문 
 		for(1.초기값 ; 2.조건식 ; 4.증감식;){
 				3.실행문; 
 				
 		}
 		1. 초기값이 실행된다. 
 		2. 조건식 판단해서 true이면ㄴ { } 들어감 , false { } 건너뜀/종료 
 		3. true 이면 실행문 실행 
 		4. 초기값이 들어있는 변수에 증감식
 		5. 조건식 판단해서 ~~~ 2,3,4,2,3,4 반복
 		
 	while문 
 		1. *초기값
 		while(2.조건식) {3.실행문 4.*증감식}
 		-초기값과 증감식은 필수x 
 		1.조건식 판단해서 true이면 {} 들어감 , false{} 건너뜀/종료 
 		2.true이면 실행문 실행
 		
 	-- 일반적으로 패턴이 있는경우 for문 사용
 	-- 무한루프 
 
 
 
 
 
 
 
*/