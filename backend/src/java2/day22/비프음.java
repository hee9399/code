package java2.day22;

import java.awt.Toolkit;

public class 비프음 implements Runnable {
			// implements : 구현하다
			// 무엇을 구현하냐? 추상을 구현한다 
			// 필드를연장할때 사용
	@Override
	public void run() { // Runnable인터페이스 추상메소드 구현 
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for( int i = 0 ; i<5 ; i++ ) {
			toolkit.beep();
			try { Thread.sleep(500);} catch (Exception e) {System.out.println(e);}
		}
	} // 추상메소드 구현 end 	
	
	
}
