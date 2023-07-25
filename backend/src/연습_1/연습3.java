package 연습_1;

import java.util.Scanner;

public class 연습3 { // class	 s
	
	public static void main(String[] args) {	//	main e
		
		Scanner sc = new Scanner(System.in);
		
		int 콜라재고 = 10;		int 환타재고 = 10;		int 사이다재고 = 10; 
		int 콜라바구니 = 0;		int 환타바구니 = 0;		int 사이다바구니 = 0;
		int 콜라가격 = 300;	int 환타가격 = 200;	int 사이다가격 = 100; 
		
	while(true) {
		
		System.out.println("1.콜라 2.환타 3.사이다");
		
		int ch1 = sc.nextInt();
		
		if(ch1 == 1) {
			if(콜라재고 > 0) {
				콜라재고--;
				콜라바구니++;
			}else {
				System.out.println("콜라 재고없음");
			}
		}
		if(ch1 == 2) {
			if(환타재고 > 0) {
				환타재고--;
				환타바구니++;
			}else {
				System.out.println("환타 재고없음");
			}
		}
		if(ch1 == 3) {
			if(사이다재고 > 0) {
				사이다재고--;
				사이다바구니++;
			}else {
				System.out.println("사이다 재고없음");
			}
		}
		if(ch1 == 4) {
			System.out.println("제품명    |   수량   |      가격 |");
			
			if(콜라바구니 > 0)System.out.println("콜라\t"+콜라바구니+""+콜라가격);
			if(환타바구니 > 0)System.out.println("콜라\t"+환타바구니+""+환타가격);
			if(사이다바구니 > 0)System.out.println("콜라\t"+사이다바구니+""+사이다가격);
			
			int 총가격 = (콜라바구니*콜라가격)+(환타바구니*환타가격)+(사이다바구니*사이다가격);
			System.out.println("총가격 : " +총가격);
			
			if(총가격 > 1) {
				System.out.println("1.결제 2.취소");
				int ch2 = sc.nextInt();
				
				if(ch2 == 1) {
					int 금액 = sc.nextInt();
					if(총가격<=금액) {
						System.out.println(총가격-금액+"결제성공");
						콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
					}else {
						System.out.println("잔액부족");
						콜라재고 += 콜라바구니;
						환타재고 += 환타바구니;
						사이다재고 += 사이다바구니;
						콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
					}
				}
				if(ch2 == 2) {
					콜라재고 += 콜라바구니;
					환타재고 += 환타바구니;
					사이다재고 += 사이다바구니;
					콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
				}
				
			}
			
		}
		
		
	} // while e
		
		
		
		
	}	// main e
	
}	//	class e
