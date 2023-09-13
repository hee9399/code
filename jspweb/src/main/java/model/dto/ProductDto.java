package model.dto;

import java.util.HashMap;
import java.util.Map;

public class ProductDto {

	// 1. 필드
	int pcno; 		 // 카테고리번호 
    String pcname; 	 // 카테고리명
    int pno; 	 		// 제품번호 
	String pname;		// 제품명 
	String pcontent; 
    int pprice;		// signed(기본값:음수사용 +-21억) / unsigned ( 음수사용x - 음수만큼의메모리를 양수로 사용 0~40억정도 : 음수 사용여부 )
    int pstate;						// [ 0 : 판매중(기본값) , 1 : 거래중 , 2 : 판매대기 , 3 : 판매완료 ]
    String pdate;	
    String plat;	
    String plng;	
    int mno;
    Map<Integer, String> imgList = new HashMap<>(); // 여러개 이미지 넣기 위해서 제품의 이미지는 여러개 이기때문에 
    String mid; // * 제품 등록한 회원 아이디 
	
	// 2. 생성자 
	public ProductDto() {}
	// 풀
	public ProductDto(int pcno, String pcname, int pno, String pname, String pcontent, int pprice, int pstate,
			String pdate, String plat, String plng, int mno, Map<Integer, String> imgList, String mid) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
		this.mid = mid;
	}
	// 제품 등록시 생성자 
	public ProductDto(int pcno, String pname, String pcontent, int pprice, String plat, String plng, int mno,
			Map<Integer, String> imgList) {
		super();
		this.pcno = pcno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
	}
	// 3. 메소드
	public int getPcno() {
		return pcno;
	}
	public void setPcno(int pcno) {
		this.pcno = pcno;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public String getPlng() {
		return plng;
	}
	public void setPlng(String plng) {
		this.plng = plng;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public Map<Integer, String> getImgList() {
		return imgList;
	}
	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "ProductDto [pcno=" + pcno + ", pcname=" + pcname + ", pno=" + pno + ", pname=" + pname + ", pcontent="
				+ pcontent + ", pprice=" + pprice + ", pstate=" + pstate + ", pdate=" + pdate + ", plat=" + plat
				+ ", plng=" + plng + ", mno=" + mno + ", imgList=" + imgList + ", mid=" + mid + "]";
	}
	
	
}// class e
