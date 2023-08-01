package java1.day14.Ex3_부모메소드호출;

public class Airplane {

		// 1. 필드
		public String color = "red";
		// 2. 생성자
		public Airplane() {
			super();
		}
		
		
		// 3. 메소드
	public void Iand() {
		System.out.println("찰륙합니다.");
	}
	
	public void fly() {
		System.out.println("일반 비행합니다.");
	}
	public void takeOff() {
		System.out.println("이륙합니다.");
	}
	
	
}
