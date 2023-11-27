package chap05;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("학생 정보 입력 >> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.printf("[%d]번 학생 이름 입력 >> ", i);
			student.name = scn.nextLine();
			System.out.printf("[%d]번 학생 점수 입력 >> ", i);
			student.score = Integer.parseInt(scn.nextLine());
			System.out.printf("[%d]번 학생 성별 입력 >> ", i);
			student.gender = scn.nextLine();
			students[i] = student;
		}
	} // end of addStudent()
	
	public static void analysis() {
		System.out.println("분석 >> ");
		int sumOfMen = 0, countOfMen = 0;
		int sumOfWomen = 0, countOfWomen = 0;
		
		for(Student stdnt : students) {
			if(stdnt.gender.equals("남")) {
				sumOfMen += stdnt.score;
				countOfMen++;
			}
			else if(stdnt.gender.equals("여")) {
				sumOfWomen += stdnt.score;
				countOfWomen++;
			}
		}
		System.out.println("남학생의 평균 : " + (double)sumOfMen / countOfMen);
		System.out.println("여학생의 평균 : " + (double)sumOfWomen / countOfWomen);
	} // end of analysis()
	
	public static void searchStudent() {
		System.out.print("학생 조회 >> ");
		String name = scn.nextLine();
		boolean exist = false;
		for(Student stdnt : students) {
			if(name.equals(stdnt.name)) {
				System.out.printf("이름은 %s, 점수는 %d, 성별은 %s\n", stdnt.name, stdnt.score, stdnt.gender);
				exist = true;
			}
		}				
		if(!exist) System.out.println("찾는 이름이 없습니다.");
	} // end of searchStudent()
	
	public static void modify() {
		//이름 입력 - 있으면 변경 점수 입력
		System.out.print("조회할 이름 입력 >> ");
		String name = scn.nextLine();
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if(name.equals(students[i].name)) {
				System.out.print("변경 점수 입력 >> ");
				students[i].score = Integer.parseInt(scn.nextLine());
				exist = true;
			}
		}
		if(!exist) System.out.println("찾는 이름이 없습니다.");
	} // end of modify()

	public static void main(String[] args) {

		boolean run = true;
		
		int studentNum = 0;
		
		while(run) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("| 1.학생 수 | 2.학생 정보 입력 | 3.조회 | 4.분석 | 5.수정 | 6. 종료 |");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("숫자를 입력하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());	// 3 enter
			
			switch(menu) {
			case 1:
				System.out.print("학생 수 입력 >> ");
				studentNum = Integer.parseInt(scn.nextLine());	// "3" (문자열) => 3 (int) 형 변환
				students = new Student[studentNum];
				break;
			case 2:
				addStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				analysis();
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("종료 >> ");
				run = false;
				break;				
			}	// end of switch
		}	// end of while
		scn.close();
	}

}
