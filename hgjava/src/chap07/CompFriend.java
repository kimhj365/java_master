package chap07;

public class CompFriend extends Friend{
	// 필드.
	private String comp;
	private String dept;
	
	// 생성자.
	public CompFriend(String name, String phone, String comp, String dept){
		super(name, phone);	// 부모 클래스의 생성자.
		this.comp = comp;
		this.dept = dept;
	}
	
	// 메소드.
	
	@Override
	public String showInfo() {
		return "이름은 " + getName() + ", 연락처는 " + getPhone() + ", 회사는 " + comp + ", 부서는 " + dept;
	}
	
	String getCompany() {
		return comp;
	}

	String getDept() {
		return dept;
	}
	
	void setCompany(String comp) {
		this.comp = comp;
	}
	
	void setDept(String dept) {
		this.dept = dept;
	}
}
