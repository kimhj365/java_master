package com.yedam.student.vo;

public class Student {
	// 필드
	private String studentNumber;
	private String studentName;
	private int englishScore;
	private int mathematicsScore;
	
	// 생성자
	public Student(){}
	
	public Student(String studentNumber, String studentName, int englishScore, int mathematicsScore) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathematicsScore = mathematicsScore;
	}

	// 메소드
	void showInfo() {
		System.out.println("학번 : " + studentNumber + "이름 : " + this.studentName + "영어 : " + this.englishScore + "수: " + mathematicsScore);
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathematicsScore() {
		return mathematicsScore;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public void setMathematicsScore(int mathematicsScore) {
		this.mathematicsScore = mathematicsScore;
	}
	
}