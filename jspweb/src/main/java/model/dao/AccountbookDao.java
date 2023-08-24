package model.dao;

import java.util.ArrayList;

import model.dto.AccountbookDto;

public class AccountbookDao extends Dao {

	// 0. 싱글톤 
		private static AccountbookDao accountbookDao = new AccountbookDao();
		private AccountbookDao() {} 
		public static AccountbookDao getInstance() {return accountbookDao;};
	
		// 1. 저장
		public boolean awriter(AccountbookDto accountbookDto) {
			
			try {
				// SQL 작성
				String sql = "insert into accountbook( awriter , amoney , adate ) values( ? , ? , ? )";
				// sql연결 
				ps = conn.prepareStatement(sql);
				// sql 매개변수 대입 
					// get으로 객체 호출
				ps.setString(1 , accountbookDto.getAwriter() );
				ps.setString(2 , accountbookDto.getAmoney() );
				ps.setString(3 , accountbookDto.getAdate() );
				// 4. SQL 실행 
				ps.executeUpdate();
				// 5. 결과반환
				return true;
				
			} catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
		// 2. 호출
		public ArrayList<AccountbookDto> aread(){
			// 여러개의 dto를 담을 리스트를 생성한다
			// 왜? 여러개의 가계부를 담아올꺼기때문에 그리고 몇개의가계부를 담아올지 모르기때문에 ArrayList 배열 사용 
			ArrayList<AccountbookDto> list = new ArrayList<>();
			
			
			try {
				// 레코드 전체를 출력할때는? select
				String sql = "select * from accountbook order by adate desc";
				ps = conn.prepareStatement(sql);
				// execute - 실행 Query - 요구
				rs = ps.executeQuery();
				
				while(rs.next() ) {
					AccountbookDto accountbookDto = new AccountbookDto(
					rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4)		
					);
					list.add(accountbookDto);
				}// w e
					
			} catch (Exception e) {System.out.println(e);}
			return list; // 리스트 변환 
		}
		
		// 3. 수정
		// 무엇을? 내용과 금액과 날짜를 수정한다. 
		// 어떻게? 식별번호를 입력받아서 
		public boolean aupdate(int ano , String awriter , String amoney) {
			try {
				// sql작성하기 
				String sql = "update accountbook set awriter = ? , amoney = ? where ano = ?";
				ps.setInt(3, ano); ps.setString(1, awriter); ps.setString(2, amoney);
				int row = ps.executeUpdate();
				if(row == 1) return true;
				return false;
			} catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
		
		// 4. 삭제
		public boolean adelete(int ano) {
			try {
				// SQL작성하기 
				String sql = "delete from accountbook where ano = ?";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, ano);
				// 실행 
				int row = ps.executeUpdate();
				if(row == 1) return true;
				return false;
				
			} catch (Exception e) {System.out.println(e);}
			
			return false;
		}
		
}
