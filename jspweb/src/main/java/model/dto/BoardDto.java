package model.dto;

public class BoardDto {

	// 필드 
	private int bno; 
	private String btitle; 
	private String bcontent ;
	private String bfile ;
    private int bview; 
    private int mno; 
    private int bcno; 
    
    // - 게시물에 추가적으로 표시할 필드명 
    private String mid; // 작성자 회원아이디 [ 사용자는 게시물 조회시 작성자회원번호 보단 작성자아이디 원하는 경우 다수  ]
    private String bcname; // 카테고리명 [ 사용자는 게시물의 카테고리번호 보단 카테고리 ]
    
    // 생성자 
    public BoardDto() {}
    // 풀 
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int bview, int mno, int bcno, String mid,
			String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
	}
	
	
	// 메소드
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getBcno() {
		return bcno;
	}
	public void setBcno(int bcno) {
		this.bcno = bcno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bview=" + bview + ", mno=" + mno + ", bcno=" + bcno + ", mid=" + mid + ", bcname=" + bcname + "]";
	}
    
    
}
