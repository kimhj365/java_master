package chap13;

import lombok.Data;

@Data

public class Member {
	
	private String memberNo;
	private String memberName;
	private int point;
	
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	public String getMemberNo() {
		return memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public int getPoint() {
		return point;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	// (MapExe2.java) 
	// hashCode, equals 재정의함에 따라, 각각 생성한 객체도 키가 같으면 동일 객체 취급될 수 있음
	// object 클래스의 hashCode() : 물리적 동일성 판단
	// lombok이 재정의한 hashCode() : 논리적 동일성 판단
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
}