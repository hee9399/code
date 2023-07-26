package java1.day10.Ex3;

public class Car {
	
	// 1. 필드
	int gas; // 현재 객체의 gas 데이터를 저장하는 곳
	// 2. 생성자
	// 3. 메소드  // 관례적으로 메소드명은 
					// 1. 필드에 저장하는 용도의 함수는 set필드명
					// 2. 필드에 값을 호출하는 용도의 함수는 get필드명 --> setter/getter
					// 3. 필드에 값을 존재여부(boolean  있다  , 없다) 확인하는 함수 is필드명 
		// 1. 리턴x매개1개 : 매개변수로 부터 전달받은 gas값을 필드gas 저장하는 함수
	void setGas(int gas) {
		this.gas = gas; // this : 현재객체 [ 매개변수와 필드와 이름 동일할때 실별용 ]
	}
	// 2. 리턴o매개변수x : 현개 객체의 gas필드가 0이면 false 리턴 아니면 
	boolean isLeftGas() {
		if(this.gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		}
		System.out.println("gas가 없습니다");
		return true;
	}
		// 3. 리턴x 매개변수x : 필드의 gas가 0일때까지 gas 1씩 차감 하고 0이면 종료  return;
	void run() {
		while(true) {
			if(this.gas > 0) {
				System.out.println("달립니다.가스 잔량 : " +this.gas);
			} // if end
			else {
				System.out.println("멈춥니다,가스 잔량 : " +this.gas);
				return; // 메소드 강제종료 되므로 while 당연히 종료
			}
		} // w end
	} // f end
	
	
	
	
} // c end
