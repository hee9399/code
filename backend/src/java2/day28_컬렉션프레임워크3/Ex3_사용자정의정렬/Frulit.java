package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

public class Frulit {

	// 필드 
	public String name;
	public int price;
	
	// 생성자
	public Frulit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Frulit [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
