package 복습.folder.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class part4 {
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String filePath = "./src/복습/part4/part4.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath , true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] inByteArray = new byte[ (int)file.length() ];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] 재고관리 = fileInfo.split("\n");
			
			System.out.println("\n ----------------- 메뉴 ------------------");
			System.out.println("-1:제품정보 0:결제");
			
			for(int i = 0; i<재고관리.length; i++) {
				String name = 재고관리[i].split(",")[0];
				int stock = Integer.parseInt(재고관리[i].split(",")[1]);
				int price = Integer.parseInt(재고관리[i].split(",")[2]);
				int basket = Integer.parseInt(재고관리[i].split(",")[3]);
				if(stock > 0) {System.out.println( (i+1)+name+"[재고없음]" );}
				else {System.out.println( (i+1)+name+"["+price+"]" );}
			}// for e
			System.out.println("\n>>>>>>>> 선택 : "); 
			int ch = sc.nextInt();
			
			if(ch == -1) {
				
				System.out.println("제품명 : "); String name = sc.next();
				System.out.println("초기제고 : "); int stock = sc.nextInt();
				System.out.println("가격 : ");	int price = sc.nextInt();
												int basket = sc.nextInt();
												
				String outStr = name+","+price+","+price+","+basket+"\n";
				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품을 등록했습니다");
				
			}// if e
			else if(ch > 0 && ch <= 재고관리.length) {
				
				String name = 재고관리[ch-1].split(",")[0];
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]);
				if(stock > 0) {stock--; basket++; System.out.println(name+"제품을 담았습니다");}
				else {System.out.println(name+"제품의 제고가 부족합니다");}
				
				재고관리[ch-1] = name+","+stock+","+price+","+basket+"\n";
				
				String outStr = "";
				
				for(int i = 0 ; i<재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+","
							+재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n";
					
					
				}// for e
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
			}// if e
			else if(ch == 0) {
				
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for(int i = 0; i<재고관리.length; i++) {
					
					int price = Integer.parseInt(재고관리[i].split(",")[3]);
					int basket = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[0];
					
					if(basket > 0) {
						System.out.printf("%10s %10s %10s \n" , name , basket , basket*price);
					}
					
				}// for e
				
				
				
			}//  if e
			
			
		}// while e
	} // main e
}	// class e




















