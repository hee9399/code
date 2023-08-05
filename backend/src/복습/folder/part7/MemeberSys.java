package 복습.folder.part7;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행 
public class MemeberSys {
	public static void main(String[] args) {
		
//  객체       객체명 			새로운객체 생성     
	Member[] memberList = new Member[100]; // [100] 배열의 길이 100개까지 생성 가능
	
	Scanner sc = new Scanner(System.in);
	
		while(true) {
			System.out.println(Arrays.toString(memberList));
			System.out.println("\n\n ---------- 회원제 정보 -------------");
			System.out.println("1.회원가입 2.로그인");
			int ch = sc.nextInt();
			
			// 선택한게 1번이면
			if(ch == 1) {
				
				System.out.println("------------ 회원가입 ------------");
				System.out.println("아이디 : "); String inputId = sc.next();
				System.out.println("비밀번호 : "); String inputPw = sc.next();
				System.out.println("이름 : "); String inputName = sc.next();
				System.out.println("전화번호 : "); String inputPhone = sc.next();
				System.out.println("나이 : ");	int inputAge = sc.nextInt();
				
				// 해당 값을 객체에 담는다
				Member member = new Member(inputId , inputPw , inputName , inputPhone , inputAge);
				
				// 찾는다
				for(int i = 0; i<memberList.length; i++) {
					
					if(memberList[i] == null) {memberList[i] = member; break;}
					
				}// for e
						
			} // if e
			// 가입후 2번을 골랐을때 
			else if(ch == 2) {
				System.out.println(" ------------- 로그인 ---------------- ");
				System.out.println("아이디 : "); String inputId = sc.next();
				System.out.println("비밀번호 : "); String inputPw = sc.next();
				
				int login = -1;
				for(int i = 0; i<memberList.length; i++) {
					
					if(memberList[i] != null && 
							memberList[i].id.equals(inputId)  &&
								memberList[i].pw.equals(inputPw)) {
						login = i;
						break; // 찾았으면 멈춤		
					}
					
				}// for e
				// login이 0보다 크거나 작으면 실행 아니면 실패
				if(login >= 0) {System.out.println("로그인성공");}
				else {System.out.println("로그인실패");}
			}
			
			
		}// while e
			
			
		
		
		
	} // main e
} // class e
