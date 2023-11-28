package chap06;
// 회원관리 앱
// 회원번호, 이름, 연락처, 성별
// public <-> private

public class Member {
	// 속성(필드)
	private int memberNo;	// 두 단어 이상의 조합 : CamelCase
	private String memberName;
	private String phone;
	private String gender;	// Men or Women
	
	// 생성자 : 필드의 초기값을 지정
	// 기본생성자 컴파일러가 생성
	Member() {
		
	}
	
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
		
	public Member(int memberNo, String memberName, String phone, String gender) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	
	//기능 (메소드)
	void showInfo() {
		System.out.printf("이름은 %s이고 연락처는 %s 입니다.\n", memberName, phone);
	}
	
	String showAllInfo() {
		String result = "이름은 " + memberName + "이고 번호는 " + memberNo +//
				"이고 연락처는 " + phone + "이고 성별은 " + gender + "입니다.";
		return result;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}
	
}
