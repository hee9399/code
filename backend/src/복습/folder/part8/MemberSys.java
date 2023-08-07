package 복습.folder.part8;

import java.util.Scanner;
import java.util.Arrays;

public class MemberSys {
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	static int loginIndex = -1;
	
	public static void main(String[] args) {
		
		while(true) {
		
		System.out.println("\n\n --------------- 회원 시스템 ---------------");
		System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
		int ch = sc.nextInt();
		
		if(ch == 1) {MemberSys.회원가입();}
		if(ch == 2) {MemberSys.로그인();}
		if(ch == 3) {MemberSys.아이디찾기();}
		if(ch == 4) {MemberSys.비밀번호찾기();회원가입();}
		
		}
		
	}// main e
	static void 회원가입() {
		System.out.println("---------------- 회원가입 ----------------");
		System.out.println("아이디: "); String id = sc.next();
		System.out.println("비밀번호: "); String pw = sc.next();
		System.out.println("이름: "); String name = sc.next();
		System.out.println("전화번호: "); String phone = sc.next();
		System.out.println("나이 : "); int age = sc.nextInt();
		
		Member m = new Member( id , pw , name , phone , age);
		
		for(int i = 0; i<memberList.length; i++) {
			
			if(memberList[i] == null) {memberList[i]=m;System.out.println("회원가입 성공"); break;}
			
		}// for e
 		
	}
	
	static void 로그인() {
		System.out.println(" ------------------ 로그인 -------------------------");
		System.out.println("아이디: "); String id = sc.next();
		System.out.println("비밀번호: "); String pw = sc.next();
		
		for(int i = 0; i<memberList.length; i++) {
			
			if(memberList[i] != null &&
					memberList[i].id.equals(id) && 
						memberList[i].pw.equals(pw)) {
				loginIndex = i;
				break;
			}
			
		}// for e
		if(loginIndex > 0) {System.out.println("로그인 성공");}
		else {System.out.println("로그인 실패");}
	}
	
	static void 아이디찾기() {
		System.out.println("---- 아이디찾기 ---------");
		System.out.println("이름: "); String name = sc.next();
		System.out.println("전화번호: "); String phone = sc.next();
		
		for(int i = 0; i<memberList.length; i++) {
		
			if(memberList[i] != null && 
					memberList[i].name.equals(name) &&
						memberList[i].phone.equals(phone) ) {
				System.out.println("회원님의 아이디 : ");
				return;
			}
			
		}
		System.out.println("회원님의 이름이나 전화번호가 일치하지않습니다");
	}
	
	static void 비밀번호찾기() {
		System.out.println("---- 비밀번호 찾기 ---------");
		System.out.println("아이디: "); String id = sc.next();
		System.out.println("전화번호: "); String phone = sc.next();
		
		for(int i = 0; i<memberList.length; i++) {
		
		if(memberList[i] != null && 
				memberList[i].id.equals(id) &&
					memberList[i].phone.equals(phone) ) {
			System.out.println("회원님의 비밀번호 : ");
			return;
		  }
		
		}
		System.out.println("회원님의 이름이나 전화번호가 일치하지 않습니다");
	}
	
	
}// class e
