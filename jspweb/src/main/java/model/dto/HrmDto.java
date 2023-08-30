package model.dto;

public class HrmDto {

	// 필드
	private String hnumber;
	private String hname; // 직원이름 
    private String hphone;  // 전화번호 
    private String hrank;  // 직급 
    private String himg;  // 회원 사진 
    private String hdate;  // 등록일 , 현재등록일(자동)
	
	// 생성자 
	public HrmDto() {}
	// 풀생성자 
	public HrmDto(String hnumber, String hname, String hphone, String hrank, String himg, String hdate) {
		super();
		this.hnumber = hnumber;
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.himg = himg;
		this.hdate = hdate;
	}
	
	// 메소드

	public String getHnumber() {
		return hnumber;
	}

	


	public void setHnumber(String hnumber) {
		this.hnumber = hnumber;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHrank() {
		return hrank;
	}

	public void setHrank(String hrank) {
		this.hrank = hrank;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	@Override
	public String toString() {
		return "HrmDto [hnumber=" + hnumber + ", hname=" + hname + ", hphone=" + hphone + ", hrank=" + hrank + ", himg="
				+ himg + ", hdate=" + hdate + "]";
	}

	
	
	
	
	
}
