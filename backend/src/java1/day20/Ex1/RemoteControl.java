package java1.day20.Ex1;

public interface RemoteControl { // 인터페이스 선언
	// 인터페이스 : 두 장치를(객체) 연결하는 접속키
	// 구성멤버 
		// 1. public 상수 필드			[ 상수의 기본값 : public static final 생략가능  ] 상수 : 전역에서 사용되는 변하지않는값
		int MAX_VOLUME = 10; 
		public static final int MIN_VOLUME = 0;
		
		// 2. * public 추상 메소드		[ public abstract 생략가능  ] 추상 : 선언만하고 구현을 안함
		void turnOn();
		public abstract void turnOff(); // 구현 받아야하기때문에 public 사용
		public abstract void setVolume(int volume);
		
		// 3. public 디폴트 메소드 		[ public default 생략가능  ] : 선언부 + 실행부 * 디폴트는 선언과 실행을 한다 
			//  public 생략 가능  public default void setMute( boolean mute ){}
					//    =
		default void setMute( boolean mute ) {
			if(mute) {System.out.println("무음 처리합니다."); setVolume(MIN_VOLUME); } 
			else {System.out.println("무음 해제합니다 ");}
		}
		
		// 4. public 정적 메소드(객체없이 인터페이스로만 사용 가능) [ public 생략가능 ] static : 선언부 + 실행부 => 구현객체 x 
		static void changeBattery() {System.out.println("리모콘 건전지를 교환합니다.");}
		public static void  chackBattery() {System.out.println("건전지 확인합니다.");}
		
		// ---> java9 이상 지원 가능 
		// 5. private 메소드		: 
			// 사용하는이유 :  내부 안에서 코드를줄일때 구현받을 메소드로 사용하는게 아니라 디폴트메소드 안에서만 호출이 가능하다 
		private void defaultConmmon() {System.out.println("디폴트 메소드");}
			
		// 6. private 정적메소드	: 디폴트메소드 뿐만아니라 정적메소드 에서도 호출이 가능하다 
		private static void staticConmmon() {System.out.println("정적 메소드");}
		

}

/*
  	인스턴스멤버	: 객체 생성시 메모리 할당되는 필드 , 메소드 	[ static 없는 ]

  	정적멤버		: 객체가 없어도 메모리 우선할당된 필드 , 메소드  [ static 있는 ]
  		- 정적멤버는 인스턴스 멤버에 접근할수 없다. [ p.249 ]
  
 * */














