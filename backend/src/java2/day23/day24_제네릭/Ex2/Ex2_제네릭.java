package java2.day23.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
	

		// 1. Prouduct 객체 만드는데 tv 객체를 가지고 
			// 1. proudct 객체 만들때. 필드에 사용할 타입을 구체적으로 대입해야한다.
		Product<Tv , String> product1 = new Product<>();
			// 2. prouduct 객체 [ Tv kind = null ; String model = null; ] * 필드의 초기값 = 정수0 상수0.0boolean false 클래스null
		product1.setKind(new Tv() );
		product1.setModel("스마트Tv");
			// 3.product 객체 [ Tv kind = new Tv(); String model = "스마트Tv";  ]
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		// 2. Proudct 객체 만드는데 Car 객체를 가지고
			// 1. product 객체 만들때 필드에 사용할 타입 구체적으로 대입 
		Product<Car, String>
	
	}
}
