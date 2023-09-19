package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	
	// 3. 선택된 제품번호에 해당하는 제품 출력 함수  
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
	
		// 1. N개 제품들을 최신순으로 출력 함수 
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
	
		// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수
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
	
	// 3. 제품 개별 조회/출력
	
	
	// 4. 수정 / 재품 수정
	
	
	// 5. 삭제 / 제품 삭제 
	
	
	
}// class e
