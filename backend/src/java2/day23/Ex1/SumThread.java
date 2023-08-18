package java2.day23.Ex1;

/*
	멀티스레드 구현하는 방법
		1. Thread 클래스로부터 extends/상속 한다
			- 많은필드를 물려받을꺼면 상속사용 
			
		2. * Runnable 인터페이스로부터 implements
			인터페이스사용 왜? run이라는메소드만 사용할꺼니까 / 메소드만사용할꺼면 인터페이스사용
			
		- Thread 상태
			1. new 이용한 스레드 객체 생성[ 스레드 생성 ]
			2. start() 메소드 이용한 run() 작업코드 실행
				- start() 한다고해서 바로 실행되는것이아니다
				
				실행대기(Runnable) : 실행 대기표 받고 기다리는 중 ( 운영체제(윈도우)가 하드웨어[cpu]를 사용할수 있는 권한 줄때까지 ) = cpu스케줄링
				
					반복 
				
				
				실행(Running) : 실행상태가왔음/해당 스레드 순서가 되면 cpu사용할수 있는 권한[ 명령어 전달 실행 ]
				
				일시정지 : 스레드가 실행대기 가 아닌 잠시 정지됨 상태.
				
				종료(Terminated) : 스레드 종료
					- main메소드 , run메소드 종료
				
		- 병렬(여러단위 흐름 ex) 다차선도로) 처리 vs 직렬(하나단위 흐름 ex) 1차선도로) 처리
			직렬은 유효성검사할때 편함 
			병렬은 코드적인 흐름은 좋겠지만 유효성검사에서 복잡할수있다 
			
			- 단일(직렬) 스레드 : main 함수만 있는 경우
			- 멀티(병렬) 스레드 : main 함수만 있는 경우
			
			- 컴퓨터의 병렬 처리 방법
				- 소프트웨어[손에안잡히는논리적인것 , 자바]는 직접적인 하드웨어[손에잡히는물리적인것 , cpu]
	
*/

public class SumThread extends Thread {

	
	// 필드
	private long sum;
	
	// 생성자

	
	// 메소드
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {// 1부터 100 이하까지 1씩증가하면서 누적합계를 구한다 
		for(int i = 1; i<=100; i++) {sum+=i;}
	}
	
	
	
	
}
