package model.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.MpointDto;
import model.dto.ProductDto;

public class ProductDao extends Dao {

	// 0. 싱글톤 
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {};
	public static ProductDao getInstance() {return productDao;}
	
	// 1. 쓰기 / 제품 등록
	public boolean register( ProductDto dto  ) {
		
		try {
			
			String sql = "insert \r\n"
					+ "		into product( pcno , pname , pcontent , pprice , plat , plng , mno )\r\n"
					+ "        values( ? , ? , ? , ? , ? , ? , ? )";
			// * sql insert 후 자동생성된 pk번호를 반환하는 방법 
				// .prepareStatement(sql , Statement.RETURN_GENERATED_KEYS ); // 생성된 식별키를 반환한다.
						// 
				// rs = ps.getGeneratedKeys();		:  
			ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS ); // pk번호를 리컨시킨다.
			
			ps.setInt( 1 , dto.getPcno() );
			ps.setString( 2 , dto.getPname() );
			ps.setString( 3 , dto.getPcontent() );
			ps.setInt( 4 , dto.getPprice() );
			ps.setString( 5 , dto.getPlat() );
			ps.setString( 6 , dto.getPlng() );
			ps.setInt( 7 , dto.getMno() );
			
			int count = ps.executeUpdate(); // 제품 등록 
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk -> pno] 반환해서 resultset[ps] 에 대입 
			
			// 반환된 식별기능 중에서 다음으로 이동 [ 하나의 제품 식별키 필요 ]
			rs.next();  // resultset  null --- next() --> 결과레코드1 -- next() --> 결과레코드2
			
			if(count == 1) { // 만약에 제품등록 1개 등록했으면 
				
				// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지등록]
					// 1. dto 에 저장된 이미지 개수만큼 
						// Map<Integer , String>		: map객체명.keySet() : map객체내 모든 키 호출 
						// Map<Integer , String>		: 
				
				for( String img : dto.getImgList().values() ) {
					
					sql = "insert into productimg( pimg , pno ) values( ? , ? ) ";
					ps = conn.prepareStatement(sql);
					ps.setString( 1, img );
					ps.setInt( 2 , rs.getInt( 1 ) );  // ???????? 위에서 인설트 된 제품 
					// 실행 
					ps.executeUpdate();
				}
				
			}
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 호출 / 제품 전체 출력
	
		// 0. 제품의 해당하는 이미지 출력하는 함수
			// Map을 쓰는이유는? pk값을 가져오기위해서 
	public Map<Integer, String> getProductImg( int pno ){
		
		try {
			
			Map<Integer, String> imglist = new HashMap<>(); // 제품별 여러개 이미지
			// * 이미지테이블에서 현재 레코드의 제품 번호에 해당하는 (여러개) 이미지 출력해서 map객체 담기 
			String sql = "select * from productimg where pno = "+pno;
				// * 위에서 먼저 사용중인 rs 인터페이스  객체 가 사용중 이므로 [ while ] 중복 사용불가능
				// 해결방안 새로운 rs 만들기 ( PreparableStatement , Resultset
					// rs는 힙에 저장되는 객체 이고 공유해서 쓴다.
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next() ) {imglist.put(rs.getInt("pimgno"), rs.getString("pimg") );}
			
			System.out.println("imglist도착"+imglist);
			
			return imglist;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 1. 선택된 제품번호에 해당하는 제품 출력 함수  
		public ProductDto findByPno(int pno) {
			try {
				String sql = "select * from product p natural join pcategory pc natural join member m where p.pno= "+pno;
				// 2번 Dao 함수 에서 pno를 부르기때문에 
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(); 
				if(rs.next() ) {
					
					ProductDto productDto = new ProductDto(
							rs.getInt("pcno"), rs.getString("pcname") , 
							rs.getInt("pno"), rs.getString("pname") , 
							rs.getString("pcontent") , rs.getInt("pprice") , 
							rs.getInt("pstate"), rs.getString("pdate") , 
							rs.getString("plat") , rs.getString("plng") , 
							rs.getInt("mno") , getProductImg(rs.getInt("pno") ) , 
							rs.getString("mid") );
					return productDto;				
				}
				
			} catch (Exception e) {System.out.println(e);}
			return null;
		}
	
		// 2. N개 제품들을 최신순으로 출력 함수 
	public List<ProductDto> findByTop( int count ){
		
		List<ProductDto> list = new ArrayList<>();
		try {
			String sql = "select * from product order by pdate desc limit "+count;
			// sql 실행 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// product 제품들을 list에 담아줘야한다.
				// findByPno가 반환해주는 제품번호에 list로 담아서 출력한다.
			while( rs.next() ) { list.add( findByPno( rs.getInt("pno") ) ); }
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		return null; 
	}	
	
		// 3. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수
	public List<ProductDto> findByLatLng( String east , String west , String south , String north ){
		try { // 제품의 경도가 '동쪽' 보다 작고 경도가 '서쪽' 보다 크고 / 제품의 위도가 '남쪽' 보다 크고 '북쪽' 보다 크다.
			List<ProductDto> list = new ArrayList<>();
				// 동쪽 경도 보다 크거나 같고 서쪽경도보다 작거나 같고 남쪽 위도 보다 크거나같고 북쪽 위도보가 작거나 같다.
			String sql = "select pno from product where ? >= plng and ? <= plng and ? >= plat and ? <= plat order by pdate desc ";
			
			ps = conn.prepareStatement(sql); 
			ps.setString( 1 , east); ps.setString( 2 , west); ps.setString( 4 , south); ps.setString( 3 , north);
			rs = ps.executeQuery();
			while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ); 	} return list;
			
		} catch (Exception e) {System.out.println(e);}
		return null; 	
	}
		
		// 4. 모든 제품들을 출력하는 함수 
	public List<ProductDto> findByAll(){ 
		try {
			List<ProductDto> list = new ArrayList<>();
			String sql = "select * from product ";
			ps = conn.prepareStatement(sql); rs = ps.executeQuery();
			while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ); 	} return list;
			
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 5. 제품 찜하기 등록( 기존에 찜하기가 안되어있을때 등록함 = 조건에따른 레코드가 없을때 ) , 취소( 찜하기 상태일때 취소한다. = 조건에따른 레코드가 있을때 ) 
	public boolean setWish( int mno , int pno ) {
		
		try {	
			// 찜하기가 있으면 없으면 - 삼항연산자
			String sql = getWish(mno, pno) ? "delete from pwishlist where mno = ? and pno = ?" 
					: "insert into pwishlist values( ? , ? ) ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setInt(2, pno);
			int count = ps.executeUpdate();
			if( count == 1 ) {return true;}
			
		} catch (Exception e) {System.out.println("setWish"+e);}
		
		return false;
	}
	
	// 6. 제품 찜하기 상태 출력 
	public boolean getWish( int mno , int pno ) {
	
		try {
			
			String sql = "select * from pwishlist where mno = ? and pno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setInt(2, pno);
			rs = ps.executeQuery();
			if(rs.next() ) {return true;}
			
		} catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 7. 현재 로그인된 회원의 찜한 제품 정보를 출력한다(가져온다.) , 찜한 제품은 여러개 이기때문에 List/ArrayList 사용해서 가져온다.
	public List<ProductDto> getWishProductList( int mno ) {
		
		
		List<ProductDto> list = new ArrayList<>();
		try {
			// 현재 회원이 찜한 제품번호 찾기 
			String sql = "select pno from pwishlist where mno = "+mno; // 현재 회원의 찜하기 제품번호 목록 찾기 
		
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			
			// 현재 회원이 찜한 제품번호의 레코드 반환  ,  1번함수에 선택된 제품번호에 해당하는 제품 출력 함수 에 있는 dao를 가져온다. 
				// 찾은 제품번호 하나씩 findByPno() 함수에게 전달해서 제품정보를 list 담기 
			while( rs.next() ) { list.add( findByPno( rs.getInt("pno") ) ); }
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	// 8. 포인트 지급/사용[증갑/차감] 함수 [ 인수: mpno식별번호 , mno회원번호 , mpamount포인트수 , mpcomment지급내역 vs mpointDto ]
		// 내 포인트가 어떻게 됬는지? 차감됬는지 
	public boolean setPoint( MpointDto dto ) {
		System.out.println("dto:"+dto);
		try {
			String sql = "insert into mpoint( mpno , mno , mpamount , mpcomment ) values( ? , ? , ? , ? ) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1 , dto.getMpno() ); 		ps.setInt(2 , dto.getMno() );
			ps.setLong(3 , dto.getMpamount() );		ps.setString(4, dto.getMpcomment() ); 
			int count = ps.executeUpdate();
			System.out.println("setPoint: "+ps);
			if( count == 1 ) { return true; }		
			
		} catch (Exception e) {e.getStackTrace();}
		
		return false;
	}
	// 10. 내 포인트 확인 [ 로그인한 사람의 현재 포인트 합계 ] [ 인수: mno회원번호 ] , 하나출력 - 찾는다. 
	public long getPoint( int mno ) {
		
		try {
			// mpamount 에 대한 포인트 합계를 구하겠다.
				// sum( 필드명 ) : 총합계를 계산할 필드명 인수로 대입 // avg // count
			String sql = "select sum(mpamount) from mpoint where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , mno);
			rs = ps.executeQuery();
			if( rs.next() ) {return rs.getInt( 1 );}
			
		} catch (Exception e) {e.getStackTrace();}
		
		return 0;
	}
	
	// 11. 내 표인트 사용 내역 전체 출력하는 함수 [ 인수: mno회원번호 ] 내포인트 전체 내역
	public List<MpointDto> getPointList( int mno ){
		
		List<MpointDto> list = new ArrayList<>();
		try {
			String sql = "select*from mpoint where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1 , mno);
			rs = ps.executeQuery();
			while( rs.next() ) {  
				
				MpointDto dto = new MpointDto(
					rs.getString(1) , rs.getInt(2) , rs.getLong(3) ,
					rs.getString(4) , rs.getString(5) );
				
				list.add(dto);
			}
			
		} catch (Exception e) {e.getStackTrace();}
		
		return null;
	}
	
	
}// class e

/*
 	Map<Integer, String>		: map객체명.keySet() : map객체내 모든 키 호출 
 	Map<Integer, String>		: map객체명.values() : map객체내 모든 값 호출 
 	
 	// ------ get( 인덱스 )  : List 컬렉션은 인덱스 사용한다.
 	// ------ get( 인덱스 )  : SET컬렉션 MAP 컬렉션은 인덱스가 없으므로 키 값으로 호출한다.
 	
 */

/*
 
 	jdbc : java 와 db 간의 연동 라이브러리 [ mysql-connector-j-8.1.0.jar ]
 		1. Connection
 		2. PreparedStatement
 		3. ResultSet
 		- DriverManager.getConnection( 연동할 DB주소 )
 	
 		
 JAVA
 		1. 연동
 				연동은언제 되나요? new MmeberDao(); 싱글톤 생성했을때 
 					싱글톤은 언제 사라지나요? java가 꺼지면 사라진다.
 				
 			자바와 외부(소프트웨어)와 통신하는 데이터가 다니는 통로 이다. ( 바이트(Byte)단위로다닌다. )					
 							JAVA																				DB서버
 						DriverManager.getConnection														localhost:3306
 JAVA						
 		2. 연동 결과 			
 					연동은언제하나요?	JAVA가 객체를 생성했을때 
 JAVA
 
 		3. 연동 결과 [ SQL 대입해서 PreparedStatement ]
 				PreparedStatement - SQL에 대한 서명을 준비한다.
 				
  JAVA
 
 		4. Sql 조작/준비
 		
 		
 */
















