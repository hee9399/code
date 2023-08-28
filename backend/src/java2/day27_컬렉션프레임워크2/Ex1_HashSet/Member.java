package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	// 필드
	public String name;
	public int age;
	
	// 생성자
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//if(obj instanceof Member target) { // javaSE-16 이상 
				if(obj instanceof Member target) { // javaSe-16 이하라면 강제형변환 필요
					// 만약에 해당 객체가 이름과 나이가 일치하면 [ 중복 ]
					return target.name.equals(name) && (target.age==age);
				} else {
					return false;
				}
	}
	
}
