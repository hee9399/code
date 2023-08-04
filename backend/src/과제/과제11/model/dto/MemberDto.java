package 과제.과제11.model.dto;

public class MemberDto {

	// 1.필드
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	
	/* 
	  dto를 만들때 
	  	1. 필드는 직접작성
	  	2. 생성자는 기본생성자와 풀생성자를 만든다 (자동완성)
	  	3. 메소드는 객터와섹터와 tostring 을 만든다
	 */
	
	// 2. 생성자
		// 1. 기본생성자
	public MemberDto() {}
		// 2. 풀생성자 
	public MemberDto(int mno, String mid, String mpw, String mname, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
	}
	
	// 3. 메소드
	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone
				+ "]";
	}
	
}
