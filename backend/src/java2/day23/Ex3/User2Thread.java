package java2.day23.Ex3;

public class User2Thread extends Thread {

	// 필드
	private Calculator calculator; 
	
	// 생성자
	public User2Thread() {setName("User2");}


	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}// [setter] e
	
	@Override
	public void run() {calculator.setMomory1(50);}
	
	
	
}// class e
