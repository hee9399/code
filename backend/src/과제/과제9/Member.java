package 과제.과제9;
// 목적 : 설계도(class) , 객체의 모델(멤버3개사용) 설계는 객체가 아니다 객체의데이터를 설계하는것이다
public class Member {
	// 1. 필드 : 객체의 데이터를 저장하는곳
	String id;	// 초기값/처음에대입 이 없을때 기본값[ 정수0실수0.0붙false참조null ]
	String password;
	String name;
	String phone;
	int age;
	
	// 클래스 빈 공간 클릭
		// 오른쪽 클릭 -> 
	
	
	// 2. 생성자
	public Member(String id , String password , String name , String phone , int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
		
	}	// 1. 매개변수 5개 정의한 생성자
	public Member(String id , String password , String name , String phone ) {}		// 매개변수 4개 정의한 생성자
	public Member(String id , String password , String name ) {}  // 매개변수 3개 정의한 생성자
	public Member(String id , String password ) {}  // 매개변수 2개 정의한 생성자
	public Member(String id) {}  // 매개변수 1개 정의한 생성자
	// public Member(String password) {}
	public Member(int age) {}	 // 매개변수 1개 정의한 생성자
	
	// 3. 메소드
}
