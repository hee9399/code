package model.dao;

import java.sql.Statement;
import java.util.List;

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
			
			
			ps.setInt(1, dto.getPcno() );
			ps.setString(2, dto.getPname() );
			ps.setString(3, dto.getPcontent() );
			ps.setInt(4, dto.getPprice() );
			ps.setString(5, dto.getPlat() );
			ps.setString(6, dto.getPlng() );
			ps.setInt(7, dto.getMno() );
			
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
					
				}
				
			}
			return true;
		} catch (Exception e) {System.out.println(e);}
		
		return false;
		
	}
	
	// 2. 호출 / 제품 전체 출력
	public List<ProductDto> findByTop( int count ){return null; }
	public List<ProductDto> findByLatLng( String east , String west , String south , String north ){return null; }
	public ProductDto findByPno(int pno) {return null;}
	public List<ProductDto> findByAll(){ return null;}
	
	// 3. 제품 개별 조회/출력
	
	
	// 4. 수정 / 재품 수정
	
	
	// 5. 삭제 / 제품 삭제 
	
	
	
}// class e
