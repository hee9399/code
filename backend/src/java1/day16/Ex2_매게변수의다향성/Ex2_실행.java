package java1.day16.Ex2_매게변수의다향성;

public class Ex2_실행 {

	public static void main(String[] args) {
		
		// 0.
		Driver driver = new Driver();
		
		// 1. 부모객체 
		Vehicle vehicle = new Vehicle();
			driver.drive(3, vehicle);  // 객체의 타입[Vehicle] 매개변수 타입[Vehicle]  타입의 일치해서 가능
		
		// 2. 자식객체
		Bus bus = new Bus();
			driver.drive(5, bus);
			
		Taxi taxi = new Taxi();
			// driver.drive("안녕" , taxi); // 매개변수의 타입 불일치 불가능
			driver.drive(3 , taxi); // 매개변수의 타입 불일치 불가능
		
		
	} // main e
} // class e
