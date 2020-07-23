package co.micol.ex02.vo;

public class CommonVo {
	//변수병은 테이블 column명과 같게 만들어라
	private int rno;
	private String id; 
	private String password;
	private String name;
	private String tel;
	private String title;
	private String contents;
	
	public CommonVo(String id, String password) {  // 로그인 체크시 사용하려고 만든 생성자 
		this.id = id;
		this.password = password;
	}
	
	public CommonVo() { //default 생성자
		
	}

	public CommonVo(String id, String password, String name, String tel) {
		this.id = id;			//Memeber Table에 데이터 입력시 사용할 생성자
		this.password = password;
		this.name = name;
		this.tel = tel;
	}
	
	public CommonVo(int rno, String id, String title, String contents) {
		this.rno = rno;  		//Board Table Insert용
		this.id = id;
		this.title = title;
		this.contents = contents;
	}
	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
