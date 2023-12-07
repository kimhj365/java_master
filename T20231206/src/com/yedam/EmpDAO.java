package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmpDAO {
	// 필드.
	ArrayList<Employee> employee = new ArrayList<>();

	// 생성자.
	EmpDAO() {

		// 기본 데이터.
		employee.add(new Employee("23-11", "홍길동", "943-1234", "2023-12-01", 400));
		employee.add(new Employee("23-12", "김길동", "943-1244", "2023-12-02", 380));
		employee.add(new Employee("23-13", "박길동", "943-1254", "2023-12-03", 360));
		employee.add(new Employee("23-14", "정길동", "943-1264", "2023-12-03", 350));
		employee.add(new Employee("23-15", "최길동", "943-1274", "2023-12-04", 340));
		employee.add(new Employee("23-16", "고길동", "943-1284", "2023-12-04", 330));
		employee.add(new Employee("23-17", "남길동", "943-1294", "2023-12-05", 320));
		employee.add(new Employee("23-18", "신길동", "943-1204", "2023-12-05", 310));
	}

	// 메소드.
	
	// 1. 추가.
	public boolean addEmployee(String empNo, String empName, String empTel, String empDate, int salary) {
		// 입사일자 공백인 경우 오늘날짜로 자동 생성.
		if (empDate.equals("")) {
			employee.add(new Employee(empNo, empName, empTel, salary));
		} else {
			employee.add(new Employee(empNo, empName, empTel, empDate, salary));
		}
		return true;
	}

	// 2. 목록.
	public void getEmployeeList() {
		for (Employee emp : employee) {
			emp.showInfoTel();
		}
	}

	// 3. 수정(급여).
	public boolean modifyEmploy(String input) {
		// 사번 급여 String을 space 기준으로 분리.
		// 사번: inAry[0] / 급여: inAry[1].
		String[] inAry = input.split(" ");
		for (Employee emp : employee) {
			if (emp.getEmpNo().equals(inAry[0])) {
				int empSalary = 0;
				// parseInt 예외처리
				try {
					empSalary = Integer.parseInt(inAry[1]);
				} catch (NumberFormatException e) {
					return false;
				}
				emp.setSalary(empSalary);
				return true;
			}
		}
		return false;
	}

	// 4. 삭제.
	public boolean removeEmploy(String input) {
		// 사번 input과 동일한 사번가진 사원 삭제.
		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).getEmpNo().equals(input)) {
				employee.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5. 사원 조회(조건: 입사 일자).
	public void getEmployee(String input) {
		// Date 타입 seacrhDate 변수 생성.
		Date searchDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// sdf.parse로 String을 Date타입으로 변환
		try {
			searchDate = sdf.parse(input);
		} catch (Exception e) {
			return;
		}
		for (Employee emp : employee) {
			// 입사일 String => Date 타입 변환
			Date empDate = new Date();
			try {
				empDate = sdf.parse(emp.getEmpDate());
			} catch (ParseException e) {
				return;
			}
			// getTime으로 long 타입으로 변환해서 비교연산자로 대소비교
			// 찾는 날짜 이후에 입사한 사원만 showInfo로 출력
			if(searchDate.getTime() <= empDate.getTime()) {
				emp.showInfoDate();
			}
		}
	}
}
