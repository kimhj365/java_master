package chap06;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		StudentExe exe = new StudentExe();
//		Student[] students = new Student[100];
		
		while(run) {	
			String numInput;
//			boolean exist = false;
			
			System.out.println("-------------------------------------------------------");
			System.out.println("| 1.등록  2.목록  3.단건 조회  4.수정  5.삭제  6.종료 |");
			System.out.println("-------------------------------------------------------");
			System.out.print("번호를 입력하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: 
//				Student student = new Student();
//				System.out.println("학생 등록 >> ");
//				System.out.print("학생 번호 입력 >> ");
//				student.setStuNum(scn.nextLine());
//				System.out.print("학생 이름 입력 >> ");
//				student.setStuName(scn.nextLine());
//				System.out.print("영어 점수 입력 >> ");
//				student.setEngScore(Integer.parseInt(scn.nextLine()));
//				System.out.print("수학 점수 입력 >> ");
//				student.setMathScore(Integer.parseInt(scn.nextLine()));
//				int count = 0;
//				students[count] = student;
//				count++;
				
				System.out.println("< 학생 등록 >");
				System.out.print("학생 번호 입력 >> ");
				String num = scn.nextLine();
				System.out.print("학생 이름 입력 >> ");
				String name = scn.nextLine();
				System.out.print("영어 점수 입력 >> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수 입력 >> ");
				int math = Integer.parseInt(scn.nextLine());
				Student std = new Student(num, name, eng, math);
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] == null) {
//						students[i] = std;
//						break;
//					}
//				}
				if(exe.addStudent(std)) {
					System.out.println("저장되었습니다\n");
				}
				else {
					System.out.println("저장 실패하였습니다\n");
				}
				break;
			case 2:
				System.out.println("< 전체 목록 조회 >");
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null)
//						students[i].showInfo();
//				}
				for(Student stdnt : exe.showStudentList()) {	//Student[] 배열타입
					if(stdnt != null) {
						stdnt.showInfo();
					}
				}	
				System.out.println();
				break;
			case 3:
				System.out.println("< 단건 조회 >");
				System.out.print("조회할 학생 번호를 입력하세요 >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(nameInput)) {
//							students[i].showInfo();
//							exist = true;
//					}
//				}
//				if(!exist) System.out.println("찾는 이름이 없습니다");
				Student stdnt = exe.showStudent(numInput);
				if(stdnt != null) {
					stdnt.showInfo();
					System.out.println();
				}
				else {
					System.out.println("조회 실패하였습니다\n");
				}
				break;
			case 4:
				System.out.println("< 학생 정보 수정 >");
				System.out.print("수정하려는 학생 번호 입력 >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(numInput)) {
//						System.out.print("학생 번호 입력 >> ");
//						num = scn.nextLine();
//						System.out.print("학생 이름 입력 >> ");
//						name = scn.nextLine();
//						System.out.print("영어 점수 수정 >> ");
//						eng = Integer.parseInt(scn.nextLine());
//						students[i].setEngScore(eng);
//						System.out.print("수학 점수 수정 >> ");
//						math = Integer.parseInt(scn.nextLine());
//						students[i].setMathScore(math);
//						exist = true;
//						System.out.println("학생 정보가 수정되었습니다");
//					}
//				}
//				if(!exist) System.out.println("찾는 이름이 없습니다");
				System.out.print("영어 점수 수정 >> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수 수정 >> ");
				math = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(numInput, eng, math)) {
					System.out.println("학생 정보가 수정되었습니다\n");
				}
				else {
					System.out.println("수정 실패하였습니다\n");
				}
				break;

			case 5:
				System.out.println("< 학생 정보 삭제 > ");
				System.out.print("삭제하려는 학생 번호 입력 >> ");
				numInput = scn.nextLine();
//				exist = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuName().equals(numInput)) {
//						students[i] = null;
//						exist = true;
//						System.out.println("학생 정보가 삭제되었습니다");
//					}	// 바깥쪽 if
//				}	// end of for
//				if(!exist) System.out.println("찾는 이름이 없습니다");
//				System.out.println();
				if(exe.removeStudent(numInput)) {
					System.out.println("학생 정보가 삭제되었습니다\n");
				}
				else {
					System.out.println("삭제 실패하였습니다\n");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				scn.close();
				run = false;
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
