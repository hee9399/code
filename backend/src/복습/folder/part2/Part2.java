package 복습.folder.part2;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int sum=0;
		String 재고관리 ="콜라,300,0,10-사이다,400,0,10-환타,500,0,10";
		
		String 콜라 = 재고관리.split("-")[0];
		String 사이다 = 재고관리.split("-")[1];
		String 환타 = 재고관리.split("-")[2];
		
		int 콜라가격 = Integer.parseInt(콜라.split(",")[1]);
		int 사이다가격 = Integer.parseInt(사이다.split(",")[1]);
		int 환타가격 = Integer.parseInt(환타.split(",")[1]);
		
		int 콜라바구니 = Integer.parseInt(콜라.split(",")[2]);
		int 사이다바구니 = Integer.parseInt(사이다.split(",")[2]);
		int 환타바구니 = Integer.parseInt(환타.split(",")[2]);
		
		int 콜라재고 = Integer.parseInt(콜라.split(",")[3]);
		int 사이다재고 = Integer.parseInt(사이다.split(",")[3]);
		int 환타재고 = Integer.parseInt(환타.split(",")[3]);
		
		
		while(true) {
			System.out.println("1.콜라 2.사이다 3.환타 4.결제");
			int ch1 = scanner.nextInt();
			if(ch1==4) {
				System.out.printf("%3s %3s %5s","품목", "수량", "금액");
				if (콜라바구니>0) {
					System.out.printf("%3s %3d %5d",콜라.split(",")[0],콜라바구니,콜라가격*콜라바구니);
				}
				if (사이다바구니>0) {
					System.out.printf("%3s %3d %5d",사이다.split(",")[0],사이다바구니,사이다가격*사이다바구니);
				}
				if (환타바구니>0) {
					System.out.printf("%3s %3d %5d",환타.split(",")[0],환타바구니,환타가격*환타바구니);
				}
				sum = 콜라가격*콜라바구니+사이다가격*사이다바구니+환타가격*환타바구니;
				
				System.out.println("총금액 : "+sum);
				System.out.println("1.결제 2.취소");
				int ch2=scanner.nextInt();
				
				while(true) {
					if (ch2==1) {
						System.out.println("금액투입");
						int pay=scanner.nextInt();
						if (pay>=sum) {
							System.out.println("거스름돈 : "+(pay-sum));
							콜라바구니=0;
							사이다바구니=0;
							환타바구니=0;
							break;
						} else {
							System.out.println("금액이부족합니다");
						}
					}else {
						System.out.println("결제 취소");
						콜라재고 += 콜라바구니;
						사이다재고 += 사이다바구니;
						환타재고 += 환타바구니;
						콜라바구니=0;
						사이다바구니=0;
						환타바구니=0;
						break;
					}
					
				} //while end
			} else if(ch1==1) {
				if (콜라바구니>0) {
					콜라바구니++;
					콜라재고--;
					System.out.println("콜라담았습니다");
				}
				System.out.println();
			} else if(ch1==2) {
				if (사이다바구니>0) {
					사이다바구니++;
					사이다재고--;
					System.out.println("사이다담았습니다");
				}
			} else if(ch1==3) {
				if (환타바구니>0) {
					환타바구니++;
					환타재고--;
					System.out.println("환타담았습니다");
				}
			} 
		}//while e
		
	}
}
