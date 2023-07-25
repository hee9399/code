package 연습_1;


import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class 연습2 {
	   public static void main(String[] args) {// main s

		   Scanner ch1 = new Scanner(System.in);
			
			int 콜라재고 = 10;		int 환타재고 = 10;		int 사이다재고 = 10; 
			int 콜라바구니 = 0;		int 환타바구니 = 0;		int 사이다바구니 = 0;
			int 콜라가격 = 300;	int 환타가격 = 200;	int 사이다가격 = 100;

		   while(true) {
			   System.out.println("메뉴");
			   System.out.println("1.콜라 2.환타 3.사이다 4.결제");
			   System.out.println("---------------------------");
			   
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
					   환타바구니++;
				   }else {
					   System.out.println("사이다재고없음");
				   }
			   }
			   if(ch2 == 4) {
				   System.out.println("-----------------");
				   System.out.println("제품명 |  수량  |         가격 |");
				   
				   if(콜라바구니 != 0) {
					   System.out.println("콜라\t"+콜라바구니+""+콜라가격);
				   }
				   if(환타바구닌 != 0) {
					   System.out.println("환타\t"+환타바구니+""+환타가격);
				   }
				   if(사이다바구닌 != 0) {
					   System.out.println("사이다\t"+사이다바구니+""+사이다가격);
				   }
				   int 총가격 = (사이다바구니*사이다가격)+(콜라바구니*콜라가격)+(환타바구니*환타가격);
				   System.out.println("총가격 : "+총가격);
				   
				   int sum = (콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타가격)
				   
			   }
			   
		   } // while e
			
	   }	// main e
	   
} // class e

