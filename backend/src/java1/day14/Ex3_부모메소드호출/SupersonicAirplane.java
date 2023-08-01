package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirplane extends Airplane {
		// 자식클래명 extends 부모클래스명
		// ! : 자식클래스에서 부모클래스의 구성멤버를 사용할수없다.
		// !! : 단) 부모클래스는 자식클래스의 구성멤버를 사용할수없다. 
	
	
	// 1. 필드
	// public static final : 상수 필드
	public static int NOTMAL = 1;
	public static int SUPERSONIC = 2;
	// 인스턴스 필드
	public int flyMode = NOTMAL;

	// 2. 생성자
		public SupersonicAirplane() {
			super();
		}
	
	
	// 3. 메소드 
		// 부모클래스로부터 오버라이딩 => 컨트롤 + 스페이스바
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		super.fly(); // 부모 생성자 호출 -> Airplane
	}


	@Override
	public void Iand() {
		// TODO Auto-generated method stub
		super.Iand();
	}


	@Override
	public String toString() {
		return "SupersonicAirplane [flyMode=" + flyMode + "]";
	}
	
	
}

/*
  
  			this		vs			super
  			현재클래스					부모클래스
  필드		this.필드명;				super.필드명;
  생성자		this( );				super( )
  메소드		this.메소드명( );			super( ) ;
  
  			오버로딩	:	동일한 메소드명일때 매개변수에 따른 식별 기능
  			오버라이딩 : 	부모클래스로 상속받은 메소드를 재정의 할때
  
 
 */