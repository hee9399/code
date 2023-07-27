package java1.day11.Ex1.Ex1;

import java1.day11.Ex1.Ex3.Member;

public class B {
	public static void main(String[] args) {
		
	
	A a = new A(); // A와 B클래스는 같은 패키지
	
	public B() {}; // B클래스 생성자
	
	// 3.오류 : C클래스는 호출이 가능하지만 생성자(private)는 호출 불가능
		// 오류 : 생성자를 private 되어 있는 클래스는 외부에서 객체생성
	// C c = new Member();
	
	// [ 두 객체는 다르다 ]
	// Memeber member3 = new Memeber();
	// Memeber member4 = new Memeber();
	
	
	// 2. Member 객체 호출 [ 두 객체는 같다. ]
	member member1 = Member.getInstance();
	member member2 = Member.getInstance();
	
	System.out.println();
	
	
	} // main e
} // class e
