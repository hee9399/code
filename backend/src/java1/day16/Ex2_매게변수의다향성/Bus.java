package java1.day16.Ex2_매게변수의다향성;

public class Bus extends Vehicle {
	// 버스는 택시가 될수없다 // 형변환 불가능하다
	// 버스에서 Vehicle 가능
	
	@Override
	public void run() {System.out.println("버스가 달립니다.");}

	
}
