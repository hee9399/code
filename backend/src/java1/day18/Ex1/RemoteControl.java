package java1.day18.Ex1;

/*
 		JSM 실행 메모리 
 		
 				1. 메소드영역 		2. 스택영역 			3. 힙영역
 				- 클래스정보		- 지역변수(힘스{}내)		- 객체(인스턴스)
 				- 메소드			- 						- 필드
 				- static정적		
 				- 인터페이스정보							= 익명구현객체
 		
 		class 사람{				사람 유재석 = 102번지;	유재석객체( 나이 = 30 )		유재석.밥먹기() => 30
 				int 나이;			사람 강호동 = 103번지;	강호동객체( 나이 = 40 )		강호동.밥먹기() => 40
 				void 밥먹기(){
 					print( this.나이 )
 				}	
 		}
 		
  */


// 인터페이스 선언 
public interface RemoteControl {
	// 대표 멤버 구성
		// 1. 상수 [public static final] 필드 : 프로그램내 수정 불가능한 데이터
			// int MAX_VOLUME;
	public static int  MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
		// 2. 추상메소드 : 선언부만 하고  구현{ }은 안하는 함수[ 구현은 각 클래스가 구현한다 ]
			// [ public static final ] int MAX_VOLUME ;
	
	// 1. 선언만하는 전원기기 함수
	public abstract void turnOn();
	// 2. 선언만하는 전원끄기 함수 
	void turnOff();
	// 3. 선언만하는 볼륨조절 함수
	void setVolume(int volume);
	
} // interface e
