package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

public class Person implements Comparable<Person>{

	// 메소드 [ 정렬 기준 만들기 ]
		// 1. Comparable 구현
		// 2. compareTo 메소드 구현 (오버라이드해야함)
	
	@Override
	public int compareTo(Person o) {
		// 나이 기준으로 오름차순
		if( age < o.age ) return -1; //  -1 을넣으면 오름차순이된다
		else if( age == o.age ) return 0;
		else return 1;
	}
	/*
	 	문자로 오름차순으로 하고싶다면 바이트를 사용해야한다.
	  	
	  */
	
	// 필드 
	public String name;
	public int age;
	
	// 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	 
	
	
}
