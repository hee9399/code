package 과제.과제11.model.dao;


import javax.print.DocFlavor.STRING;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {
	private static MemberDao memberDao= new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	// 2. 회원가입SQL
	public boolean signupSQL(MemberDto dto) {
		
		try { // 
			
			// 3. 대입된 SQL 조작하기 위해 반환된 prepareStatement를 ps 대입
			ps = conn.prepareStatement("insert into member(mid , mpw , mname , mphone) values(?,?,?,?)"); 
			// conn , 필드는 Dao 부모클래스에게 물려받음[ .setString(?순서번호 , 값)
			ps.setString(1 , dto.getMid());
			ps.setString(2 , dto.getMpw());
			ps.setString(3 , dto.getMname());
			ps.setString(4, dto.getMphone()); 
			
			// 5. SQL 실행						[ps.ps.executeUpdate();  :  SQL 실행 ]
			ps.executeUpdate(); 
			return true;
		}catch(Exception e) {System.out.println("경로) 회원가입실패 사유 : "+e);}
		return false;
	}
	
	// 3. 로그인SQL
	public boolean loginSQL(String id , String password) {
		
		try {
			// 1단계 : SQL 작성한다. [ 추천 : MYSQL 워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select * from member where mid = ? and mpw = ?" ;
			// 2단계 : SQL 조작할수 있는 객체 필요함으로 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql); 
			// 3단계 : SQL 조작 [ SQL 안에 있는 매개변수[?]에 값 대입 ] 
			ps.setString(1, id );
			ps.setString(2, password );
			// 4단계 : SQL 실행해서 그 결과 객체를 rs객체에 대입 [ *ps는 결과를 조작할수 없다. ]
				// [ insert/update/delete : ps.executeUpdate(); / select : ps.executeQuery(); ]
			rs = ps.executeQuery(); 
			// 5단계 : SQL 실행 결과 조작 [ rs.next() : 결과중에서 다음 레코드객체 호출 ] 
				// 만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1객체 -> 레코드2객체 -> 레코드3객체 ]
				// 											.next  		.next			.next
			if(rs.next() ) { return true; } // 로그인SQL 결과레코드는 1개 또는 0개 이므로 if 사용해서 .next() 1번 호출
											// next() 다음레코드가 존재하면 true / false
				 // 로그인 성공 
		}catch(Exception e) {System.out.println(e);}
		return false; // 로그인 실패
			
	} // p e
	
} // class e

/*
  // 싱글톤 객체
	private static MemberDao memberDao= new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	// 2. 회원가입SQL
	public void signupSQL(MemberDto dto) {
		System.out.println("----- singupSQL 디오 도착");
		System.out.println(dto);
		// 1. 회원가입 필요한 SQL을 문자열에 작성해서 저장
			// 테이블에 레코드 삽입 : insert into 테이블명(필드명 , 필드명 , 필드명 ) values(값,값,값,깂);
			// 변수는 문자처리하면 안된다. 
		try { // 
			String sql = "insert into member(mid , mpw , mname , mphone ,) values(?,?,?,?)";
			
			// 2. 위에서 작성한 SQL를 DB연동객체에 대입 [ conn.prepareStatement(sql)]
			// 3. 대입된 SQL 조작하기 위해 반환된 prepareStatement를 ps 대입
			ps = conn.prepareStatement(sql); // db연동객체.prepareStatement(조작할SQL문자열)
			// conn , 필드는 Dao 부모클래스에게 물려받음[ .setString(?순서번호 , 값)
			ps.setString(1 , dto.getMid());
			ps.setString(2 , dto.getMpw());
			ps.setString(3 , dto.getMname());
			ps.setString(2, dto.getMphone()); 
			
			// 5. SQL 실행						[ps.ps.executeUpdate();  :  SQL 실행 ]
			ps.executeUpdate(); 
		}catch(Exception e) {System.out.println("경로) 회원가입실패 사유 : "+e);}
	}
 * */



