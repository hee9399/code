package java1.day18.Ex1;

public class Ex1_실행 {

	public static void main(String[] args) {
	
		// 1. 인터페이스타입의 변수 선언 
		RemoteControl rc;
			// * 인터페이스 만으로 객체 생성 불가능 [ 객체 생성할려면 추상메소드를 구현후 가능 ]
		// rc.turnOn(); // 추상메소드 객체없이 실행불가능하다
		
		// 2. 인터페이스 변수에 텔리비전 객체의 대입[주소대입]
		rc = new Television(); // 구현객체 : 해당 추상메소드가 존재한 인터페잇를 구현해준 클래스로 객체 생성
		
		// 3. 인터페이스로 메소드 실행
		rc.turnOn();
		
		
		// 4. 리모컨을 오디오로 변경
		rc = new Audio();
		
		rc.turnOn();
		
		// 5. 리모콘의 상수필드 호출
		System.out.println("리모콘의 최대 볼륨 : "+rc.MAX_VOLUME);
		System.out.println("리모콘의 최대 볼륨 : "+rc.MIN_VOLUME);
		
		// 6. 메소드 실행 
		rc.setVolume(100);
		
		// 7. 리모콘 교체
		rc = new Television();
		rc.setVolume(-10);
		
		/*
		 		인터페이스    vs       상속
		 		interface 	       extends
		 		구현한다		       연장한다
		 		*여러개 구현		   * 1개 상속
		 		추상메소드 		       메소드
		 		*버전[다양메소드제공]  
		    목적: 메소드의 통합          빠른 개발 / 묘듈화(쪼개서 개발함) 유지보수가 편하기때문에
		 	ex) 게임패드,키보드         등급제 , 직급별(사원이라는슈퍼클래스로 팀장객체를 따로만듬) 
		 	    
		 	
		 * */
	}
}
