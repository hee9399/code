package java2.day23.Ex4_제네릭메소드;

public class Box<T> {

		// 제네릭 <T>
	// 필드
	private T t; // t라는 필드를 사용하겠다 

	// get and set
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
	
}
