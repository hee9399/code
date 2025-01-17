package java1.day16.Ex2_매게변수의다향성;

public class Driver {

	// 매게변수의 다형성 예제의 메소드 선언 [ 매개변수의 타입이 부모클래스 타입 ]
					//  Vehicle vehicle 받는이유는 Vehicle 속성을 bus와taxi를 갖고있기때문에 
	public void drive(int value , Vehicle vehicle) { // Vehicle vehicle 자동타입변환(버스 , 택시에서 들어온것)
		// 부모객체의 다양한 자식객체들이 자동타입변환해서 매개변수 들어온 상태
			// * 타입 확인 : 객체명 instanceof 클래스명 : 해당 객체가 해당 클래스의 타입이면 true / fasle
		System.out.println("vehicle 타입확인 : " + (vehicle instanceof Bus) ); // true
		System.out.println("vehicle 타입확인 : " + (vehicle instanceof Taxi) ); // fasle
			// * 강제타입변환 : 1. 태생 자식객체(자동타입변환 으로 부모객체된 객체) 2. 캐스팅
		
			if(vehicle instanceof Bus) {System.out.println("버스전진"); Bus bus = (Bus)vehicle; }
			if(vehicle instanceof Taxi) {System.out.println("택시전진"); Taxi taxi = (Taxi)vehicle; }
		
		// 매개변수에 부모객체의 다양한 자식객체들이 자동타입변환해서 매개변수 들어온 상태 
		// 다향성을 보여주기위해 bus와taxi를 한번에 실행시킨다
		vehicle.run();
		
	}
}
