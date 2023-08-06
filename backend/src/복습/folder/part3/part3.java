package 복습.folder.part3;

import java.util.Scanner;

public class part3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		int sum = 0;
		
		while (true) {
			System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
			int ch = scanner.nextInt();
			
			if ( ch==1||ch==2||ch==3) {
				
				String 제품 = 재고관리[ch-1];
				int 재고 = Integer.parseInt(제품.split(",")[0]);
				int 바구니 = Integer.parseInt(제품.split(",")[1]);
				int 가격 = Integer.parseInt(제품.split(",")[2]);
				String 이름 = 제품.split(",")[3];
				
				if (재고>0) {
					재고--;
					바구니++;
					System.out.println(이름+"담았습니다");
				} else {
					System.out.println(이름+"재고부족");
				}
				재고관리[ch-1]= 재고+","+바구니+","+가격+","+이름;
				
			} else if (ch==4) {
				System.out.println("결제");
				System.out.printf("%5s %5s %10s \n" ,"제품명","수량","가격");
				for (int i =0; i<재고관리.length; i++) {
					int 재고 = Integer.parseInt(재고관리[i].split(",")[0]);
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String 이름 = 재고관리[i].split(",")[3];
					if (바구니>0) {
						System.out.printf("%5s %5d %10d \n", 이름 , 바구니 , 바구니*가격);
						sum += 바구니*가격;
					} // if e
				} // for e
				System.out.println("총합계 : "+sum);
			} // if e
		} // while e
		
	} // main e
} // class e
