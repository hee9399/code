package 복습.folder.part8;

public class Member {
	
	// 1. 필드
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	// 2. 생성자
	public Member() {} 
	
	public Member(String id , String pw , String name , String phone , int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
		
	}

	// 3. 메소드 
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	
	
	
	
	

	


	
	
	
	
	
}// class e
