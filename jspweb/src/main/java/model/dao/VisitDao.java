package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao {
	
	// 0. 싱글톤 
	// 싱글톤이 만들어지면 
	private static VisitDao visitDao = new VisitDao();
	private VisitDao() {} 
	public static VisitDao getInstance() {return visitDao;};
	
	// 인수 : 무엇을줄건지?   리턴 : 무엇을 받을껀지?
	// 여러개를 담을때는 ? ArrayList 를 사용한다 
	// 1. 저장 [ 인수 : 저장할내용이 담긴 DTO , 리턴: 성공/실패 = true/false ]
	public boolean vwriter(VisitDto visitDto) {
		// 0. try{}catch(){} 
		try {
			// 1. SQL 작성 
			String sql = "insert into visitlog( vwriter , vpwd , vcontent) values(? , ? , ?);";
			// 2. SQL 연결 
			ps = conn.prepareStatement(sql);
			// 3. SQL 매개변수 대입
				// get으로 입력할 객체호출 
			ps.setString(1, visitDto.getVwriter() );
			ps.setString(2, visitDto.getVpwd());
			ps.setString(3, visitDto.getVcontent());
			// 4. SQL 실행 
			ps.executeUpdate();
			// 5. 결과 반환
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 호출 [ 인수 : x , 리턴 : 여러개( ArrayList )의 방문록DTO = 개별조회가 아니기때문에 모든 레코드를 가져온다 ]
	public ArrayList<VisitDto> vread() {
		// 여러개의 dto를 담을 리스트를 생성한다 
		// 왜? 여러개의 방문록을 담아올꺼기 때문에 하나의 방문록이아니고 여러개의 방문록 몇개인지 정확하지않으므로 자동길이/가변길이로 설정 
		ArrayList<VisitDto> list = new ArrayList<>();
		
		try {
			String sql = "select*from visitlog";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // s -> q , i/d/u -> u ,
			while(rs.next()) { // rs.next() : select 검색결과중 다음레코드 이동 = 존재하면 true / 존재하지 않으면 false
				// * 하나 레코드/하나 줄/하나 행/ 하나 방분록 / 하나 DTO 
				// 레코드 --> DTO 변환 
				// 필요한건 무엇인가? 레코드마다 각 필드 호출 = rs.get타입(필드순번) 혹은 rs.get타입("필드명") 
				VisitDto visitDto = new VisitDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5)
					);
						// 여러개 dto를 저장할 리스트에 저장 
						list.add(visitDto);
			}	
		} catch (Exception e) {System.out.println(e);}
		
		return list; // 리스트 변환 
	}
	
	// 3. 수정 [ 인수 : 수정할번호(int)/수정할방문록내용(String) , 리턴 : 여러개의 성공/실패 = true/false ]
	public boolean vupdate(int vno) {return false;}
	
	// 4. 삭제 [ 인수 : 삭제할방문록번호(int) , 리턴 : 성공/실패 = true/false  ]
	
}
