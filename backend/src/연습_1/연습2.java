package 연습_1;

import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class 연습2 {
	public static void main(String[] args) {
		System.out.print("파일에 저장할 내용 : "); 
		Scanner scanner = new Scanner(System.in); 
		String instr = scanner.naxtLine(); 
		
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/da07/Ex2_테스트.txt" , true); 
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/da07/Ex2_테스트.txt" , true)
		
		byte[] instrArray = instr.getBytes(); 
		fileOutputStream.write(instrArray);
				
		byte[] outstrArray = 
		
		
	} // main e 
}	// class e
