package java2.day23.Ex2;

public class WorkThread extends Thread {

	// 필드
	public boolean work = true;
	// 생성자 
	public WorkThread(String name) {
		super(name); // 스레드의 이름 젼경 
	}
	
	// 메소드
	@Override
	public void run() {
		while(true) {
			if(work) {						// super.getName() : 스레드 이름 호출
				System.out.println(super.getName());
				
			}else {
				Thread.yield(); // 현재 스레드의 양보[대기상태] 만들기 
			}// else e
		}// while e 해당스레드는 무한루프[ 절대 종료되지 않는 스레드 ]
		
	}
	
	
}// class e
