package 연습_1;

import java.util.Scanner;

public class 연습3 { // class	 s
	
	public static void main(String[] args) {	//	main e
		
		Scanner ch1 = new Scanner(System.in);
		
		int 콜라재고 = 10;		int 환타재고 = 10;		int 사이다재고 = 10; 
		int 콜라바구니 = 0;		int 환타바구니 = 0;		int 사이다바구니 = 0;
		int 콜라가격 = 300;		int 환타가격 = 200;		int 사이다가격 = 100; 
		
	while(true) { // 제고 선택결제를 위한 무한루프
		System.out.println("메뉴");
		System.out.println("1.콜라 | 2.환타 | 3.사이다 | 4,결제 |");
		System.out.println("-------------------------------");
		
		int ch2 = ch1.nextInt();
		
		// 1번메뉴 선택했을때
		if(ch2 == 1) {
			if(콜라재고 > 0) { // 콜라재고가 0보다 크면 바구니에 담고 콜라재고는 바구니에 담기니까 감소
				콜라재고--;
				콜라바구니++;
			}else {
				System.out.println("콜라재고없음");
			}
		}
		// 2번메뉴 선택했을때
		if(ch2 == 2) {
			if(환타재고 > 0) {
				환타재고--; 
				환타바구니++;
			}else {
				System.out.println("환타재고없음");
			}
		}
		// 3번메뉴 선택했을때
		if(ch2 == 3) {
			if(사이다재고 > 0) {
				사이다재고--;
				사이다바구니++;
			}else {
				System.out.println("사이다재고없음");
			}
		}
		// 4번메뉴 선택했을때
		if(ch2 == 4) { // 각메뉴의 수량과 가격이 주문할때마다 떠야하고 주문한 총가격이 출력되야함
			System.out.println("-----------------------");
			System.out.println("제품명 |   수량 |      가격 |");		// 본횟수 1번
			
			if(콜라바구니 != 0) {
				System.out.println("콜라\t"+콜라바구니+"     "+콜라가격);
			}
			if(환타바구니 != 0) {
				System.out.println("환타\t"+환타바구니+"     "+환타가격);
			}
			if(사이다바구니 != 0) {
				System.out.println("사이다\t"+사이다바구니+"     "+사이다가격);
			}
			int 총가격 = (사이다바구니*사이다가격) + (콜라바구니*콜라가격) + (환타바구니*환타가격);
			System.out.println("총가격 : "+총가격);
			 
			int sum = (콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격); 
			System.out.println("총가격 : " +sum);
		}
		 
			
		
		
	} // while e
			
		
			
		
		
		
		
		
		
		
		
	}	// main e
	
}	//	class e
