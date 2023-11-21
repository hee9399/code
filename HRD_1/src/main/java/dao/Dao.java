package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	//생성자에 연동 코드 넣기 
	public Dao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println("연동실패");
			 e.printStackTrace();
		
		}

		
	}
	
	//1. join 메소드 생성
	public boolean onJoin(String custno, String custname, String phone, String address,String joindate, String grade, String city) {
		try {
			String sql="insert into member_tbl_02 values (?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, custno);
			ps.setString(2, custname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, joindate);
			ps.setString(6, grade);
			ps.setString(7, city);
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("실행실패");}
		return true;
	}
	
	//2. 마지막 번호+1
	public int lastNo() {
		try { //순차적이기 때문에 가장 큰 값을 찾으면 됨
			String sql="select max(custno) from member_tbl_02";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return rs.getInt(1)+1;} //가장큰번호(마지막번호)+1
			
		} catch (Exception e) {System.out.println(e+"실패");}
		
		return 0;
	}
	
	//3. 회원목록 조회
	public List<Map<String,String>>list(){
		
		List<Map<String, String>> list=new ArrayList();
		
		try {
			String sql="select*from member_tbl_02";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap();
				map.put("custno", rs.getString("custno"));
				map.put("custname", rs.getString("custname"));
				map.put("phone", rs.getString("phone"));
				map.put("address", rs.getString("address"));
				map.put("joindate", rs.getString("joindate"));
				map.put("grade", rs.getString("grade"));
				map.put("city", rs.getString("city"));
				list.add(map);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	//4. 매출조회
	public List<Map<String,String>> getMoney(){
		List<Map<String, String>> list = new ArrayList<>();
		try {
			String sql = "select m.custno as 회원번호, m.custname as 회원성명, m.grade as 고객등급,sum(mo.price)as 매출 from money_tbl_02 mo inner join member_tbl_02 m on mo.custno=m.custno group by (m.custno,m.custname,m.grade) order by sum(mo.price) desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Map<String,String> map= new HashMap<>();
				map.put("custno", rs.getString("회원번호"));
				map.put("custname", rs.getString("회원성명"));
				map.put("grade", rs.getString("고객등급"));
				map.put("sum", rs.getString("매출"));
				list.add(map);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	//5. 개별조회
	public Map<String,String> getMember(int custno){
		try {
			String sql ="select*from member_tbl_02 where custno= ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, custno);
			rs=ps.executeQuery();
			if(rs.next()) {
				Map<String, String> map= new HashMap<>();
				map.put("custno", rs.getString("custno"));
				map.put("custname", rs.getString("custname"));
				map.put("phone", rs.getString("phone"));
				map.put("address", rs.getString("address"));
				map.put("joindate", rs.getString("joindate"));
				map.put("grade", rs.getString("grade"));
				map.put("city", rs.getString("city"));
				return map;
				
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	} 
	
	//6. 수정
	public boolean update(String custno, String custname, String phone, String address,String joindate, String grade, String city) {
		try {
			String sql="update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?";
			System.out.println("sql> "+sql);
			ps=conn.prepareStatement(sql);
			ps.setString(7, custno);
			ps.setString(1, custname);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, joindate);
			ps.setString(5, grade);
			ps.setString(6, city);
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("실행실패");}
		return true;
	}
}
