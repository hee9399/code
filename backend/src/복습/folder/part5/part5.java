package 복습.folder.part5;

import java.util.Arrays;
import java.util.Scanner;

public class part5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] 재고관리 = { "10,0,300,콜라" , "10,0,200,환타" , "10,0,100,사이다"};
		
		while(true) {
			System.out.println("\n\n ------------------- 메뉴 ---------------------");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.println(">>>>>>> 선택 : ");
			int ch = sc.nextInt();
			
			String product = 재고관리[ch-1];
				System.out.println(ch+1+"번 제품");
			
		}
			
	
		
		
		
	} // main e
} // class e
