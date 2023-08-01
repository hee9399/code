package 복습.folder.part6;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;

public interface part6 {
	public static void main(String[] args) {
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt"; 
			FileOutputStream filleOutputStream = new FileOutputStream( filePath , true );
			FileOutputStream filleOutputStream = new FileInputStream( filePath );
			File file = new File(filePath); 
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] 재고관리 = fileInfo.split("\n");
			
			System.out.println("\n\n -------------------- 메뉴 ----------------------- ");
			System.out.println("-1 : 제품등록 0 : 결제 ");
			
			for(int i = 0; i<재고관리.length; i++) {
				if(!재고관리[i].equals("") ) {
					String name = 재고관리[i].split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					if(stock == 0) {System.out.print((i+1)+":"+name+"[재고없음]");}
					else {System.out.print( (i+1)+":"+name+" [ "+price+" ] " );}
					
				}
			}
			System.out.println("\n>>>>>> 선택 : ");
			int ch = sc.nextInt();
			
			if(ch == -1) {
				System.out.println("제품명 : ");			String name = sc.next();
				System.out.println("초기제고 : ");			int stock = sc.nextInt();
				System.out.println("가겨 : ");			int price = sc.nextInt();
														int basket = 0; 
														
				String outStr = name+","+stock+","+price+","+basket+"\n";
				
				FileOutputStream.write(outStr.getbytes() );
				System.out.println("안내) 제품 등록이 되었습니다");
				
			}
			else if(ch > 0 && ch <= 재고관리.length) {
				String name = 재고관리[ch-1].split(",")[0];
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]);
				
				if(stock > 0) {stock--; basket++; System.out.println(name+"재고 담았습니다");}
				else {System.out.println(name+"제품의 재고가 부족합니다");}
				
				재고관리[ch-1] = name+","+stock+","+price+","+basket;
				
				String outStr = ""; 
				for(int i = 0; i<재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+
							","+재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n"; 
					
				} // for e
				
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write( outStr.getBytes() );
				
			}
			
			else if(ch == 0) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for(int i = 0; i<재고관리.length; i++) {
					int basket = Integer.parseInt(ㅈ)
				}
				
			}
			
		} // while e
			
			
		
		
		
	} // main e
}	// class e
