package remind07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 저장공간 : ArrayList
// 추가/수정/삭제/목록/단건 조회
public class StudentExe {
	
	// 필드
	private List<Student> students = new ArrayList<>();
	Scanner scn = new Scanner(System.in);
	
	//생성자
	StudentExe(){
		students.add(new Student("23-001", "김현준", 88, 77));
		students.add(new Student("23-002", "박지웅", 91, 86));
		students.add(new Student("23-003", "전상진", 91, 97));
	}

	// 기능 함수 구현
	// 0. 시작
	int progStart() {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
		System.out.println("┃ 1.학생 등록 ┃ 2.목록 조회 ┃ 3.단건 조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
		System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
		System.out.print("동작을 입력하세요 \n>> ");
		
		int menu = 0;
		try {
		menu= Integer.parseInt(scn.nextLine());
		} catch(Exception e) {
			return 0;
		}
		return menu;
	}
	// 0-1. 자동 번호 매기기
	String autoNumbering() {
		String[] inAry = students.get(students.size()-1).getStuNum().split("-");
		int inNum = Integer.parseInt(inAry[1]);
		String inStr ="23-"+ String.format("%03d", inNum + 1);
		return inStr;
	}
	
	// 1. 추가
	void addStudent(String num) {
		System.out.println("< 학생 등록 >");
		System.out.print("학생이름 영어점수 수학점수 순으로 입력 \n>> ");
	
		String input = scn.nextLine();
		String[] inAry;
//		String num;
		String name;
		int eng;
		int math;
		
		try {
			inAry = input.split(" ");
//		num = inAry[0];
		name = inAry[0];
		eng = Integer.parseInt(inAry[1]);
		math = Integer.parseInt(inAry[2]);
		} catch(Exception e) {
			System.out.println("올바른 학생 정보를 입력하세요");
			return;
		}
		
		Student std = new Student(num, name, eng, math);
		students.add(std);
		System.out.println(name + " 학생 정보가 등록되었습니다");
		}
	
	// 2. 전체 목록 조회.
	void showStudentList() {
		System.out.println("< 전체 목록 조회 >");
		System.out.printf("%6s %10s %9s %5s\n","번호", "이름", "영어점수", "수학점수");
		System.out.println("===============================================");
		for(int i = 0; i < students.size(); i++) {
			students.get(i).showInfo();
			}	
	}
	
	// 3. 단건 조회.
	void showStudent() {
		System.out.println("< 단건 조회 >");
		System.out.print("조회할 학생 번호를 입력하세요 \n>> ");
		String input = scn.nextLine();
		boolean chk = false;
		System.out.printf("%6s %10s %9s %5s\n","번호", "이름", "영어점수", "수학점수");
		System.out.println("===============================================");
		for(Student stdnt : students) {
			if(stdnt.getStuNum().equals(input)) {
				stdnt.showInfo();
				chk = true;
			}
		}
		if(!chk) System.out.println("조회 실패하였습니다\n");
	}
	
	// 4. 학생 정보 수정.
	void modifyStudent() {
		
		System.out.println("< 학생 정보 수정 >");
		System.out.print("수정하려는 학생 번호 입력 \n>> ");
		String numInput = scn.nextLine();
		System.out.print("영어점수 수학점수 순으로 수정할 값을 입력하세요 \n>> ");
		String scoreInput = scn.nextLine();
		
		String[] inAry = scoreInput.split(" ");
		int eng = 0;
		int math = 0;
		
		try {
		eng = Integer.parseInt(inAry[0]);
		math = Integer.parseInt(inAry[1]);
		} catch(Exception e) {
			System.out.println("올바른 값을 입력하세요");
			return;
		}
		boolean chk = false;
		
		for(Student stdnt : students) {
			if(stdnt.getStuNum().equals(numInput)) {
				stdnt.setEngScore(eng);
				stdnt.setMathScore(math);
				chk = true;
			}
		}
		if(chk)		
			System.out.println("학생 정보가 수정되었습니다\n");
		else 
			System.out.println("수정 실패하였습니다\n");
	}
	
	// 5. 학생 정보 삭제.
	void removeStudent() {
		System.out.println("< 학생 정보 삭제 > ");
		System.out.print("삭제하려는 학생 번호 입력 \n>> ");
		String input = scn.nextLine();
		boolean chk = false;
		
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStuNum().equals(input)) {
				students.remove(i);
				chk = true;
			}
		}
		if(chk) 
			System.out.println("학생 정보가 삭제되었습니다\n");
		else 
			System.out.println("삭제 실패하였습니다\n");
		
		
	}
	
}
