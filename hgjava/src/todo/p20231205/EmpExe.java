package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class EmpExe {
	
	List<Emp> empList = new ArrayList<>();
	
	boolean addEmp(String num, String name, String tel, String date, int salary) {
		empList.add(new Emp(num, name, tel, date, salary));
		return true;
	}
	
	void getEmplist() {
		for(Emp emp : empList) {
			emp.showInfo();
		}
	}
	
	
	
}
