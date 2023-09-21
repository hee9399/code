package model.dto;

public class MpointDto {// 포인트 지급 dto

	// 필드 
	 String mpno; 		// 포인트 내역 식별번호 [ UUID ]
	 int mno;  			// 누가? 사용자/회원 번호 [ 회원번호 fk ]
	 long mpamount; 	  	// 무엇을? 포인트 [대략 43억]
	 String mpcomment;   // 어떻게? 지급내역  
	 String mpdate;      // 언제? 날짜 
	
	// 생성자 
	public MpointDto() {}
	// 풀
	public MpointDto(String mpno, int mno, long mpamount, String mpcomment, String mpdate) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
		this.mpdate = mpdate;
	}
	
	// 메소드
	public String getMpno() {
		return mpno;
	}

	public void setMpno(String mpno) {
		this.mpno = mpno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public long getMpamount() {
		return mpamount;
	}
	public void setMpamount(long mpamount) {
		this.mpamount = mpamount;
	}
	public String getMpcomment() {
		return mpcomment;
	}
	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}
	public String getMpdate() {
		return mpdate;
	}
	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}
	@Override
	public String toString() {
		return "mpontDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdate=" + mpdate + "]";
	}
	
	
}// class e
