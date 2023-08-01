package java1.day14.Ex3_부모메소드호출;

public class Ex3_실행 {

	public static void main(String[] args) {
		
		// 1. 자식 객체
		 SupersonicAirplane sa = new SupersonicAirplane();
		 
		// 2.
		 sa.takeOff();
		 sa.hashCode();
		 sa.fly();
		 sa.Iand();
		 sa.toString();
		
		 // 자바의 모든 조상은 오브잭트이다  내가만든클래스는 조상코드를 쓸수있다
	}
}
