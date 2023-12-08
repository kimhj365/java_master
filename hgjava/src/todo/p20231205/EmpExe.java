package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class EmpExe {
	
	List<Emp> empList = new ArrayList<>();
	
	EmpExe(){
		empList.add(new Emp("1", "ȫ�浿", "010-1111-1111", "2022-01-24", 400));
		empList.add(new Emp("2", "�ȿ���", "010-2222-2222", "2023-05-10", 300));
		empList.add(new Emp("3", "��׷�", "010-3333-3333", "2023-10-09", 200));
	}
	
	// 1. ��� ���.
	boolean addEmp(String num, String name, String tel, String date, int salary) {
		empList.add(new Emp(num, name, tel, date, salary));
		return true;
	}
	
	// 2. ��ü ��� ��ȸ.
	void getEmplist() {
		for(Emp emp : empList) {
			emp.showInfo();
		}
	}
	
	// 3. �ܰ� ��ȸ(�Ի���).
	void getEmp(String input) {
		for(Emp emp : empList) {
			if(emp.getJoinDate().indexOf(input) != -1) {
				emp.showInfo();
			}
		}
	}
	
	// 4. �޿� ����.
	boolean modifySalary(String input, int salary) {
		for(Emp emp : empList) {
			if(emp.getNum().equals(input)) {
				emp.setSalary(salary);
				return true;
			}
		}
		return false;
	}
	
	// 5. ��� ���� ����.
	boolean removeEmp(String input) {
		for(int i = 0; i < empList.size(); i++) {
			if(empList.get(i).getNum().equals(input)) {
				empList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
}