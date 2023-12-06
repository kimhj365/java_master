package todo.p20231205;

import lombok.Data;

@Data

public class Emp {
	//사원정보 : 사번 / 이름 / 전화번호 / 입사일자(오늘날짜) / 급여
	private String num;
	private String name;
	private String tel;
	private String joinDate;
	private int salary;
	
	Emp(){}

	public Emp(String num, String name, String tel, String joinDate, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	
	void showInfo() {
		System.out.printf("%s %s %s %s %d\n", num, name, tel, joinDate, salary);
	}
	
}
