package java2.day22.Ex2;

public class 작업스레드1 implements Runnable {

	@Override
	public void run() {
		try {
			int count = 1;
			while(true) {
		System.out.println(Thread.currentThread().getName()+"[작업1 Thread] output : "+ count);
		Thread.sleep(2000); // 2초간 일시정지 [예외처리필수]
		count++;
			}// w e
		}catch (Exception e) {System.out.println(e);}
		
	}
	
}// class e
