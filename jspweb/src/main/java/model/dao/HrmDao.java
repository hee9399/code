package model.dao;

import java.util.ArrayList;

import model.dto.AccountbookDto;
import model.dto.HrmDto;

public class HrmDao extends Dao {

	// 싱클톤 
	private static HrmDao hrmDao = new HrmDao();
	private HrmDao() {};
	public static HrmDao getInstance() {return hrmDao;}
	
	// 1.  인사관리 등록 
	public boolean hrmRegistered(HrmDto dto) {
		
		try {
			
			String sql = "insert into hrm( hnumber , hname , hphone , hrank , himg , hdate ) values( ? , ? , ? , ?  , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getHnumber()); 
			ps.setString(2, dto.getHname());
			ps.setString(3, dto.getHphone());
			ps.setString(4, dto.getHrank());System.out.println(" dao hrank "+dto.getHrank());
			ps.setString(5, dto.getHimg());
			ps.setString(6, dto.getHdate());
			int row = ps.executeUpdate();
			if(row == 1)return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 인사괸리 출력
	public ArrayList<HrmDto> hread(){
		// 여러개의 dto를 담을 리스트를 생성한다
		// 왜? 여러개의 가계부를 담아올꺼기때문에 그리고 몇개의가계부를 담아올지 모르기때문에 ArrayList 배열 사용 
		ArrayList<HrmDto> list = new ArrayList<>();
		
		
		try {
			// 레코드 전체를 출력할때는? select
			String sql = "select * from hrm order by hnumber asc";
			ps = conn.prepareStatement(sql);
			// execute - 실행 Query - 요구
			rs = ps.executeQuery();
			
			while(rs.next() ) {
				HrmDto hrmDto = new HrmDto(
				rs.getString(1)	,
				rs.getString(2)	,
				rs.getString(3)	,
				rs.getString(4)	,
				rs.getString(5)	,
				rs.getString(6)	
				);
				list.add(hrmDto);
			}// w e
				
		} catch (Exception e) {System.out.println(e);}
		return list; // 리스트 변환 
	}
	
}// class e






















