package 복습.folder;

import java.util.Scanner;

public class part1 {
	public static void main(String[] args) {
		
		Scanner ch1 = new Scanner(System.in);
		
		int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	    int 콜라바구니 = 0; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	    int 콜라가격 = 300; int 환타가격 = 200 ; int 사이다가격 = 100;
		
	    while(true) {
	    	
	    	System.out.println("----------------------------");
	    	System.out.println("1.콜라 2.사이다 3.환타 4.결제");
	    	
	    	int ch2 = ch1.nextInt();
	    	
	    	if(ch2 == 1) {
	    		if(콜라재고 > 0) {
	    			콜라재고--;
	    			콜라바구니++;
	    		}else {
	    			System.out.println("콜라재고없음");
	    		}
	    	}
	    	if(ch2 == 2) {
	    		if(환타재고 > 0) {
	    			환타재고--;
	    			환타바구니++;
	    		}else {
	    			System.out.println("환타재고없음");
	    		}
	    	}
	    	if(ch2 == 3) {
	    		if(사이다재고 > 0) {
	    			사이다재고--;
	    			사이다바구니++;
	    		}else {
	    			System.out.println("사이다재고없음");
	    		}
	    	}
	    		
	    	if(ch2 == 4) {
	    		System.out.println("제품명 | 수량 | 가격 |");
	    		
	    		if(콜라바구니 > 0) {
	    			System.out.println(+콜라바구니+"    "+콜라가격);
	    		}
	    		if(환타바구니 > 0) {
	    			System.out.println(+환타바구니+"    "+환타가격);
	    		}
	    		if(사이다바구니 > 0) {
	    			System.out.println(+사이다바구니+"    "+사이다가격);
	    		}
	    		int 총가격 = ch1.nextInt();
	    		총가격 = (콜라바구니*콜라가격)+(환타바구니*환타가격)+(사이다바구니*사이다가격);
	    		
	    		
	    		
	    		
	    		
	    	} // if(4) end
	    	
	    } // while e
		
	} // main e
} // class e
