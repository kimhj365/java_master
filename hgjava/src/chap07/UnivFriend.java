package chap07;

// 자식: UnivFriend / 부모: Friend
public class UnivFriend extends Friend{	// extends: 상속관계
	// 필드.
	private String univ;	// 학교.
	private String major;	// 전공.
	
	// 생성자.
	public UnivFriend() {}
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);	// 부모 클래스의 생성자 호출.
		this.univ = univ;
		this.major = major;		
	}
	
	// 메소드.
	@Override
	public String showInfo() {
		return "이름은 " + getName() + ", 연락처는 " + getPhone() + ", 학교는 " + univ + ", 전공은 " + major;
	}

	public String getUniv() {
		return univ;
	}

	public String getMajor() {
		return major;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
