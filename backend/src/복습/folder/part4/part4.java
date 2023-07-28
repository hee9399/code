package 복습.folder.part4;

import java.util.Arrays;
import java.util.Scanner;

public class part4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		System.out.println(재고관리);
		
		System.out.println(Arrays.toString(재고관리.split("\n") ) );
		System.out.println("1조각 : " +재고관리.split("\n")[0] );
		System.out.println("2조각 : " +재고관리.split("\n")[1] );
		System.out.println("3조각 : " +재고관리.split("\n")[2] );
		
		
		while(true) {
			System.out.println("\n\n --------------- 메뉴 ------------------");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제 ");
			System.out.println(">>>>>>>>> 선택 : ");
			int ch = sc.nextInt();
			
			String 콜라정보 = 재고관리.split("\n")[0];
			String 환타정보 = 재고관리.split("\n")[1];
			String 사이다정보 = 재고관리.split("\n")[2];
			
			int 콜라재고 = Integer.parseInt(콜라정보.split(",")[0] ) ;
			int 콜라바구니 = Integer.parseInt(콜라정보.split(",")[1] ) ;
			int 콜라가격 = Integer.parseInt(콜라정보.split(",")[2] ) ;
			
			int 환타재고 = Integer.parseInt(환타정보.split(",")[0] ) ;
			int 환타바구니 = Integer.parseInt(환타정보.split(",")[1] ) ;
			int 환타가격 = Integer.parseInt(환타정보.split(",")[2] ) ;
			
			int 사이다재고 = Integer.parseInt(사이다정보.split(",")[0] ) ;
			int 사이다바구니 = Integer.parseInt(사이다정보.split(",")[1] ) ;
			int 사이다가격 = Integer.parseInt(사이다정보.split(",")[2] ) ;
			
			재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"
					+환타재고+","+환타바구니+","+환타가격+"\n"
					+사이다재고+","+사이다바구니+","+사이다가격+"\n";
					
		}
		
		
		
	} // main e
}	// class e
