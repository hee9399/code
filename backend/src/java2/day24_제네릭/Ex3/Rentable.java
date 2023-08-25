package java2.day24_제네릭.Ex3;

public interface Rentable<P> {
	// 추상메소드 : 선언만하고 정의 하지않는 메소드 
		// 추상메소드 기본값 : public abstract / 생략이 가능하다.
		// public abstract P rent();
		P rent();
}
