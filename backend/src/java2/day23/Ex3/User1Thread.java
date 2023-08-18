package java2.day23.Ex3;

public class User1Thread extends Thread {

	// 필드
	private Calculator calculator; 
	
	// 생성자
	public User1Thread() {setName("User1");}


	public  void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}// [setter] e
	
	@Override
	public void run() {calculator.setMomory1(100);}
	
	
	
	
}// class e
