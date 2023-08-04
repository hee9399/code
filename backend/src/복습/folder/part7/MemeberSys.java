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
		
		System.out.println("\n\n ------ 회원 시스텐 -------");
		System.out.println("1.회원가입 2.로그인  선택>");
		int ch = sc.nextInt();
		
		if(ch == 1) {
			System.out.println("------- 회원가입 ----------------");
			
			System.out.print("아이디 : "); String inputId = sc.next();
			System.out.print("비밀번호 : "); String inputPw = sc.next();
			System.out.print("이름 : "); String inputName = sc.next();
			System.out.print("전화번호 : "); String inputPhone = sc.next();
			System.out.print("나이 : "); int inputAge = sc.nextInt();
			
			Member member = new Member(inputId , inputPw , inputName , inputPhone , inputAge);
			
			for(int i = 0; i<memberList.length; i++) {
				
				if(memberList[i] == null) {memberList[i] = member; break;}
			} // if e 				
		} // if e
		
		else if(ch == 2) {
			System.out.println(" ------------- 로그인 ----------------");
			System.out.println("아이디 : "); String inputId = sc.next();
			System.out.println("비밀번호 : "); String inputPw = sc.next();
			
			int login = -1;
			for(int i = 0; i<memberList.length; i++) {
				
				if(memberList[i] != null &&
						memberList[i].id.equals(inputId) &&
							memberList[i].password.equals(inputPw)) {
					login = i;
					break;
				}
				
			} // for e
			if(login >= 0) {System.out.println("안내) 로그인성공");}
			else {System.out.println("안내) 로그인실패");}
		}
		
	} // while e

		
		
	} // main e
} // class e
