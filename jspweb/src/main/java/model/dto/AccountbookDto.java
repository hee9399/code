package model.dto;

public class AccountbookDto {
	// 필드
	private int ano;
	private String awriter;
	private String amoney;
	private String adate;
	
	// 생성자 
	// 기본생성자
	public AccountbookDto() {}
	
	// 풀생성자 
	public AccountbookDto(int ano, String awriter, String amoney, String adate) {
		super();
		this.ano = ano;
		this.awriter = awriter;
		this.amoney = amoney;
		this.adate = adate;
	}

	// 선택
	public AccountbookDto(String awriter, String amoney, String adate) {
		super();
		this.awriter = awriter;
		this.amoney = amoney;
		this.adate = adate;
	}
	
	// get and set
	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAwriter() {
		return awriter;
	}

	public void setAwriter(String awriter) {
		this.awriter = awriter;
	}

	public String getAmoney() {
		return amoney;
	}

	public void setAmoney(String amoney) {
		this.amoney = amoney;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	// to String
	@Override
	public String toString() {
		return "AccountbookDto [ano=" + ano + ", awriter=" + awriter + ", amoney=" + amoney + ", adate=" + adate + "]";
	}
	
	
	
	
	

}
