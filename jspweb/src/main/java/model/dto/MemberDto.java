package model.dto;

public class MemberDto {
	private int mno; 
	private String mid ;
	private String mpwd ;
	private String memall;
	private String mimg ;
	
	// DB 없는 필드 
	// 로그인 시간
	private String loginDatetime;
	
	// get and set
	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	
	// 로그인 객체를 만들 생성자 [ 패스워드 제외 ] : 오버로딩 하기위해 매개변수 타입 순서를 변경한다.
	public MemberDto(  String loginDatetime , int mno, String mid, String memall, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memall = memall;
		this.mimg = mimg;
		this.loginDatetime = loginDatetime;
	}
	
	// ------------------------------------------------ // 
	
	// 생성자 
	public MemberDto() {}


	public String getLoginDatetime() {
		return loginDatetime;
	}
	
	// 풀
	public MemberDto(int mno, String mid, String mpwd, String memall, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memall = memall;
		this.mimg = mimg;
	}
	// 번호뺀거 
	public MemberDto(String mid, String mpwd, String memall, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memall = memall;
		this.mimg = mimg;
	}
	
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
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMemall() {
		return memall;
	}
	public void setMemall(String memall) {
		this.memall = memall;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memall=" + memall + ", mimg=" + mimg
				+ "]";
	}
 
	
	
	
}
