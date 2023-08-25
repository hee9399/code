package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	// 싱글톤 
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance() {return memberDao;}
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
		
		try {
			
			String sql = "insert into member( mid , mpwd , memail , mimg ) values( ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemall());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if(row == 1)return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 로그인
	
	// 3. 아이디찾기 
	
	// 4. 비밀번호찾기
	
	// 5. 내정보 호출
	
	// 6. 아이디 중복검사
	public boolean findId(String mid) {
		try {
			String sql = "select*from member where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// 아이디 하나만확인하기때문에 if 문 여러개라면? while문
			// true - 중복이있는아이디다.
			if((rs.next() ) ) return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 7. 회원수정
	
	// 8. 회원탈퇴 
	
}