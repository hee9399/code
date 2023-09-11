package model.dto;

public class MsgDto {

	// 필드 
	private String frommid; // 보낸사람 
	private String msg; // 보낸내용 
	
	// 생성자 
	public MsgDto() {}
	// 풀 

	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
	}
	// 메소드 

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + "]";
	}
	
	
	
	
}// class e
