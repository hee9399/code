package java2.day22.Ex3;

public class 타이머기능 implements Runnable{
	// 타이머
	@Override
	public void run() {
		while(true) {
			int second = 0;
			
			try {
				Thread.sleep(1000); // 1초 일시정지	
			} catch (Exception e) {System.out.println(e);}
			second++;
			System.out.println("타이머 : "+second+"초");
		}// w e
		
	}// run e
	
}// class e
