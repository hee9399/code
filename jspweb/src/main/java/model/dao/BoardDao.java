package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {

	// 0. 싱글톤 
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {} 
	public static BoardDao getInstance() {return boardDao;};
			
			
	// 1. 글쓰기
	public boolean bwriter(BoardDto boardDto) {
		
		try {
			// sql작성
			String sql = "insert into board( btitle , bcontent , bfile , mno , bcno )values( ? , ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );	ps.setString( 2 , boardDto.getBcontent() ); 
			ps.setString( 3 , boardDto.getBfile() );	ps.setInt( 4 , boardDto.getMno() );	
			ps.setInt( 5 , boardDto.getBcno() );
			int count = ps.executeUpdate(); if( count == 1 )return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2-2. 게시물 수 출력 
	public int getTotalSize( int bcno , String key , String keyword ) {
		
		try {
			String sql = " select count(*) from board b natural join member m ";
			// 만약에 전체보기 가 아니면 [ 카테고리별 개수 ]
			if( bcno != 0 ) { sql += " where b.bcno = "+bcno; }
			
			// - 만약에 전체보기 가 아니면 [ 카테고리별 개수 ]
			if( !key.isEmpty() && !keyword.isEmpty() ) {
				if(bcno != 0 ) sql += " and";
				else sql += " where ";
				// * 메소드 소괄호 안에있는 매개변수를 입력받을때는 큰따옴표안에 ++를 넣는다 "+매개변수+"
				sql += " "+key+" like '%"+keyword+"%' ";
			}
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() )return rs.getInt(1);
			
		} catch (Exception e) {System.out.println(e);}
		
		return 0;
	}
	
	// 2. 모든 글 출력 , 여러개의 개시물 - ArrayList
	public ArrayList<BoardDto> getList( int bcno , int listsize , int startrow ,
			String key , String keyword ){
		

		System.out.println("key도착"+key);
		System.out.println("keyword도착"+keyword);
		// * 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트 
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {
			// 앞부분 공통 sql
			String sql = "select b.* , m.mid , m.mimg , bc.bcname "
					+ "	from board b "
					+ "    natural join bcategory bc "
					+ "    natural join member m ";
			// 만약에 카테고리를 선택했으면 [ 전체보기 가 아니면 
				// 카테고리가 있을때  where가있고 검색이 있을때 where이 있으면 안된다 
			if( bcno != 0 ) { sql += " where b.bcno = "+bcno;}
			System.out.println("bcno != 0 도착"+bcno);
				
				// - 만약에 검색이 있다 vs 없다. [ key 와 keyword 모두 빈문자열이 아니면 ]
					// 문자열.isEmpty() : 문자열이 비어 있으면 [ '' ] null vs '' 다름 
				// !key.isEmpty() - key의 값이 비어있지 않으면 
			if( !key.isEmpty() &&  !keyword.isEmpty() ) {
				
				// - 만약에 카테고리내 검색이면 [ 이미 where 구문이 존재하기 때문에 and 조건 추가 ]
				if( bcno != 0 ) sql += "and";
				else sql += " where ";
				// * 메소드 소괄호 안에있는 매개변수를 입력받을때는 큰따옴표안에 ++를 넣는다 "+매개변수+"
				sql += " "+key+" like '%"+keyword+"%' ";
				System.out.println("key , keyword 도착"+sql);
				
			}
			
			// 뒤부분 공통 sql
			sql += " order by b.bdate desc limit ? , ?";
				
			
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , startrow ); 
			ps.setInt( 2 , listsize ); System.out.println(ps);
			rs = ps.executeQuery();
			while( rs.next() ) { // 여러개의 레코드 조회 
				
				BoardDto boardDto = new BoardDto(
						rs.getInt("bno"), 
						rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getString("bfile"), rs.getString("bdate"), 
						rs.getInt("bview"), rs.getInt("mno"), 
						rs.getInt("bcno"), rs.getString("mid"), 
						rs.getString("bcname"), rs.getString("mimg") 
						);
				list.add(boardDto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	// 3. 개별 글 출력 , 내가 클릭한 번호 - bno
	public BoardDto getBoard( int bno ) { 
		System.out.println("dao bno"+bno);
		try {
			String sql = "select b.* , m.mid , m.mimg , bc.bcname\r\n"
					+ "	from board b \r\n"
					+ "    natural join member m\r\n"
					+ "    natural join bcategory bc\r\n"
					+ "    where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if( rs.next() ) { // 여러 레코드 조회  whiles
				System.out.println("11");
				BoardDto boardDto = new BoardDto(
						rs.getInt("bno"), 
						rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getString("bfile"), rs.getString("bdate"), 
						rs.getInt("bview"), rs.getInt("mno"), 
						rs.getInt("bcno"), rs.getString("mid"), 
						rs.getString("bcname"), rs.getString("mimg") 
				);
				System.out.println("dao boarddto"+boardDto);
				return boardDto;
			}
			
		} catch (Exception e) {System.out.println(e);}
		System.out.println("22");
		return null;
	}
	
	// 4. 게시물 수정 
	public boolean onUpdate( BoardDto dto ){
		
		try {
			String sql = "update board set btitle = ? , bcontent = ? ,  bcno = ? , bfile = ? where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1 , dto.getBtitle() );
			ps.setString(2 , dto.getBcontent() );
			ps.setInt(3 , dto.getBcno() );
			ps.setString(4 , dto.getBfile() );
			ps.setInt(5 , dto.getBno() );
			int count = ps.executeUpdate();
			if(count == 1)return true;
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 5. 게시물 삭제 
	public boolean ondelete(int bno) {
		
		try {
			
			String sql = "delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count == 1)return true;
			
		} catch (Exception e) {System.out.println();}
		
		return false;
	}
	
	// 6. 조회수 증가 
	public boolean viewIncre( int bno ) {
		
		try {
			// sql 작성
			String sql = "update board set bview = bview+1 where bno = ?";
			// sql 실행
			ps = conn.prepareStatement(sql);
			// 무엇을 입력받는지 
			ps.setInt(1, bno); 
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		} catch (Exception e) {System.out.println(e);}	
		return false;
	}
	
	
	
}
