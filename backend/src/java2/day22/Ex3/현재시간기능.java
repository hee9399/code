package java2.day22.Ex3;

import java.time.LocalTime;

public class 현재시간기능 implements Runnable{
	
	@Override
	public void run() {
		// 현재시간 출력 해주는애
		while(true) {
			// LocalTime.now() : 현재시간 반환 함수
			System.out.println(LocalTime.now() );
			try {
				Thread.sleep(1000); // 1초 일시정지
				
			} catch (Exception e) {System.out.println(e);}
			
		}// w e
		
	}// run E

}
