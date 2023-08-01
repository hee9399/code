package java1.day14.Ex2.Ex_오버라이딩;

public class Ex2_실행 {
	public static void main(String[] args) {
		
		int r = 10;
		
		Calculator claculator = new Calculator();
		System.out.println("원 면적 : "+Calculator.areaCircle);
		
		
		// 3. 자식객체 생성
		Computer computer = new Computer();
		
		// 4. 자식객체가 부모클래스 멤버 메소드 호출
		System.out.println("원 면적 : "+Calculator.areaCircle);
		
		
		
	} // main e
} // class e
