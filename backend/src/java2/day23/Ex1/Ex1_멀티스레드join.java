package java2.day23.Ex1;

public class Ex1_멀티스레드join {
	
	public static void main(String[] args) {
		
		// main스레드가 main함수 호출
			// main함수는 mainThread 가 실행시킨다 하지만 눈에 보이지않는다
				// Thread는 우리가 생성하면 보이지만 main함수를 실행시키는 mainThread는 눈에 보이지않는다.
		
		
		System.out.println("현재 스레드 : "+Thread.currentThread().getName());
		
		// 1. [main스레드가실행시킨다 작업스레드를]작업 스레드객체 생성 [ main 외 추가적으로 작업스레드 생성 ]
		SumThread sumThread = new SumThread();
		
		// 2. [main스레드가실행시킨다 작업스레드를] 작업 스레드 실행 => 대기상태 => CPU스케줄링 => 실행 => 대기상태 => 대기 => 실행
		sumThread.start();
		
		// 3. [main스레드가실행시킨다 작업스레드를]작업 스레드 객체 의 필드 확인
		// - 작업스레드가 1~100까지 계산의 끝나기전에 main스레드가
		 System.out.println("[ JOIN 하기전 ]1~ 100 함"+sumThread.getSum());
		
		try {
			sumThread.join(); // 합친다.. [ 작업스레드를 호출한 스레드는 일시정지 상태 ]
			// 누가호출했는가? main스레드가 sumThread스레드의 join 메소드를 호출했기 때문에 main스레드가 일시정지 된다.
			// 누가종료됬는가? sumThread스레드가 종료되면 main스레드 일시정지 풀림.
		}catch (Exception e) {}
		System.out.println("[ JOIN 했을때 ]1~ 100 함"+sumThread.getSum());
	}// main e
	
}// class e
