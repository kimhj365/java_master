package chap07;

// 부모: 이름, 연락처, showInfo(). 
public class Friend {
	// 필드.
	private String name;
	private String phone;
	
	// 생성자.
	public Friend() {
		super();	// 모든 클래스는 Object 클래스의 상속 받음 (extends Object)
	}
	
	public Friend(String name, String phone){
		this.name = name;
		this.phone = phone;
	}

	// 메소드.
	
	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
	
	public String showInfo() {
		return "이름은 " + name + ", 연락처는 " + phone + " 입니다.";
		
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
