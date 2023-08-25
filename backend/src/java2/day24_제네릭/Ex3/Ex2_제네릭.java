package java2.day24_제네릭.Ex3;

public class Ex2_제네릭 {

	public static void main(String[] args) {
		
		// 1. 홈 렌탈 대리점 객체 생성 [ 안산지점 집렌탈대리점 ]
		HomeAgency 홈렌탈안산지점 = new HomeAgency();
		// 2. 안산 대리점에서 렌탈을 한다
		// 유재석집에 불을 킨다 
		Home 유재석집 = 홈렌탈안산지점.rent();
		// 3. 렌탈한 home객체(유재석집)해서 메소드 실행  
		유재석집.turnOnLight();
		
		// 2. 안산 대리점에서 렌탈을 한다
		// 강호동집에 불을 킨다 
		Home 강호동집 = 홈렌탈안산지점.rent();
		// 3. 렌탈한 home객체(강호동집)해서 메소드 실행  
		강호동집.turnOnLight();
		
		// 1-2. 홈 렌탈 대리점 객체 생성 [ 수원지점 집렌탈대리점 ]
		HomeAgency 홈렌탈수원지점 = new HomeAgency();
		// 2. 수원 대리점에서 렌탈을 한다
		// 신동엽집에 불을 킨다 
		Home 신동엽집 = 홈렌탈수원지점.rent();
		// 3. 렌탈한 home객체(신동엽집)해서 메소드 실행  
		신동엽집.turnOnLight();			
		// 2. 수원 대리점에서 렌탈을 한다
		// 하하집에 불을 킨다 
		Home 하하집 = 홈렌탈수원지점.rent();
		// 3. 렌탈한 home객체(하하집)해서 메소드 실행  
		하하집.turnOnLight();
		
		
	}// main e
}// class e
