package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	// 필드.
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int salary;

	// 생성자.
	Employee() {
	}

	public Employee(String empNo, String empName, String empTel, int salary) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = sdf.format(date);
		this.salary = salary;
	}

	public Employee(String empNo, String empName, String empTel, String empDate, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.salary = salary;
	}

	// 메소드.
	// 목록 조회 메소드
	void showInfoTel() {
		System.out.println(empNo + " " + empName + " " + empTel);
	}
	
	// 입사 날짜 조회 메소드
	void showInfoDate() {
		System.out.println(empNo + " " + empName + " " + empDate);
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpTel() {
		return empTel;
	}

	public String getEmpDate() {
		return empDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}