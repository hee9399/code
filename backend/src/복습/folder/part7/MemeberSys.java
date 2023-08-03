package 복습.folder.part7;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행 
public class MemeberSys {
	public static void main(String[] args) {
		
		Member[] memberList = new Member[100];
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(Arrays.toString(memberList));
			
			System.out.println("\n\n ------------------ 메뉴1 ----------------------------");
			System.out.println("1.회원가입 2.로그인");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				
				System.out.println("아이디 : "); String inputId = sc.next();
				System.out.println("비밀번호 : "); String inputPw = sc.next();
				System.out.println("이름 : "); String inputName = sc.next();
				System.out.println("휴대폰번호 : "); String inputPhone = sc.next();
				System.out.println("나이 : "); int inputAge = sc.nextInt();
				
				Member member = new Member(inputId , inputPw , inputName , inputPhone , inputAge );
				
				for(int i = 0; i<memberList[i]; i++) {
					if(memberList)
				}
				
			} // if e
			
			
		} // while e

		
		
	} // main e
} // class e
