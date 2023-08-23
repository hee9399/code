package java2.day23.Ex4_제네릭메소드;

public class Ex4_제네릭 {
	
	// 제네릭메소드 선언 
		// 목적 : 함수 매개변수 받을때, 정해져 있지않는 타입 받고 싶을때 ( int를 받을껀지 string을 받을껀지등등 )
			// public boolean 메소드(int value){}
			// public boolean 메소드(String value){}
			// ---> 통합	// public <T> boolean 메소드(T value){}
	
		// 제네릭메소드 선언할때 <제네릭타입> : 함수내에서도 제네릭타입을 사용할수있다.
	//			  선언부 				매개변수
	public static <T>  Box<T> boxing(T t){ // boxing(T t) = 포장(행동)하는 함수 
								// 매개변수 제네릭타입 사용하기위한 <T> 선언부에 정의하면 사용가능하다.
								// T t = 100 T라는 타입에 100이 들어간다 object
		// Integer t = 100
		Box<T> box = new Box<>();
		box.setT(t);	// box객체[t = 100] box객체 내에 100이 들어간다.
						// String t = "홍길동"
		return box;
	}
	
	public static void main(String[] args) {
		
		// 1. Box 객체 t필드를 Integer 타입으로 선정
			// 타입 파라미터에 값 넣으면 (자동으로) 값의 타입으로 Integer로 대체\
		Box<Integer> box1 = boxing(100); // 100은 위에선언한 boxing매개변수t에 들어간다.
			// box1 [ Integer t ]
		int intkvalue = box1.getT();
		System.out.println(intkvalue);
		
		// 2. 
		// Box라는 곳에 String을 넣을꺼에요
		Box<String> box2 = boxing("홍길동"); // 타입파라미터에 값 넣으면 (자동으로) 값의 타입으로 String 대체 
		String strvalue = box2.getT();
		System.out.println(strvalue);
		
		// ArrayList : 누군가가 미리 만든 클래스[라이브러리]
			// 라이브러리[클래스] < API[ 인터페이스포함] <  프로그램제공[ 프레임워크 ]
		
		
	}// m e
}// c e
