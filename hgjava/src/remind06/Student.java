package remind06;

public class Student {
	// 필드
	private String stuNum;
	private String stuName;
	private int engScore;
	private int mathScore;
	
	// 생성자
	public Student(){}
	
	public Student(String stuNum, String stuName, int engScore, int mathScore) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// 메소드
	void showInfo() {
		System.out.println("번호 : " + stuNum + "\t이름 : " + this.stuName + "\t영어점수 : " + this.engScore + "\t수학점수 : " + mathScore);
	}
	

	// getter / setter
	public String getStuNum() {
		return stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public int getEngScore() {
		return engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	
}
