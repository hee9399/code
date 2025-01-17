package java1.day10.Ex1;

import java.util.Scanner;

// p. 233~234
public class Ex1_메소드선언호출 {
	// 실행목적
	public static void main(String[] args) { // main s
	// powerOn(); // 호출할 메소드가 다른클래스(객체)에 존재하므로 호출 불가능
		
	// 1. 메소드 호출 하기 위한 객체 생성
		Calcutalor myCalc = new Calcutalor();
	
	// 2. 객체 통한 메소드 호출 / 매개변수 전달 x / 리턴x
	myCalc.powerOn();
		
	// 3. 객체 통한 메소드 호출 / 매개변수 전달 = 2개 / 리턴o -> 변수 달아주기/저장
	int result = myCalc.plusInt(5 ,6);
	System.out.println("result : " +result);
	// 4. 객체 통한 메소드 호출 / 매개변수 전달 = 2개 변수 담아주기
	
	int x = 10;
	int y = 4;
	
	double result2 = myCalc.divide(x , y);
	System.out.println("result2 : " +result2);
	
	myCalc.powerOff();
	
	} // main e
	
} // class e
