package java2.day23.day24_제네릭.Ex2;

public class Product < K , M >{ 
		// 제네릭 : 클래스 안으로 들어오는 파라미터=변수(변하는수/밖에있는것 = 정해져있지않는 타입 [ 매개타입 ])
		// 제네릭 매개타입 이름 : A ~ Z 대문자 알파벳 권장 
		// 제네릭 타입 여러개 이면 < A~Z , A~Z , A~Z >
	// 제품[Product] 클래스 안에 자동차객체도넣고싶고 전자제품도 넣고싶다 그럴때는 제네릭을 사용해야한다 

	// 필드
	private K kind;
	private M model;
	// 생성자
	
	// 메소드
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	
	
	
	
	
	
}// class e
