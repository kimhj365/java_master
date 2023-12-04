package chap13;

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
	
}