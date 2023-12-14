package remind06;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		StudentExe exe = new StudentExe();
		StudentDAO dao = new StudentDAO();	// 오라클 DB 연동 => DB에 정보 저장
		
		while(run) {	
			String numInput;
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.등록 ┃ 2.목록 조회 ┃ 3.단건 조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("번호를 입력하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			
			//학생 등록
			case 1: 
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

				// 추가함수 실행 => DB 저장.
				if(dao.addStudent(std)) {
					System.out.println("저장되었습니다\n");
				}
				else {
					System.out.println("저장 실패하였습니다\n");
				}
				break;
				
			// 목록 조회.
			case 2:
				System.out.println("< 전체 목록 조회 >");
				
				// 목록 조회 함수 실행.
				Student[] stdAry = dao.getStudentList();
				for(Student stdnt : stdAry) {	//Student[] 배열타입.
					if(stdnt != null) {
						stdnt.showInfo();
					}
				}	
				System.out.println();
				break;
				
			// 단건 조회.
			case 3:
				System.out.println("< 단건 조회 >");
				System.out.print("조회할 학생 번호를 입력하세요 >> ");
				numInput = scn.nextLine();
				
				// 단건조회 함수 실행.
				Student stdnt = dao.getStudent(numInput);
				if(stdnt != null) {
					stdnt.showInfo();
					System.out.println();
				}
				else {
					System.out.println("조회 실패하였습니다\n");
				}
				break;
				
			// 정보 수정.
			case 4:
				System.out.println("< 학생 정보 수정 >");
				System.out.print("수정하려는 학생 번호 입력 >> ");
				numInput = scn.nextLine();
				System.out.print("영어 점수 수정 >> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수 수정 >> ");
				math = Integer.parseInt(scn.nextLine());
				
				// 정보 수정 함수 실행.
				if(dao.modifyStudent(numInput, eng, math)) {
					System.out.println("학생 정보가 수정되었습니다\n");
				}
				else {
					System.out.println("수정 실패하였습니다\n");
				}
				break;

			// 정보 삭제.
			case 5:
				System.out.println("< 학생 정보 삭제 > ");
				System.out.print("삭제하려는 학생 이름 입력 >> ");
				numInput = scn.nextLine();
				
				// 정보 삭제 함수 실행.
				if(dao.removeStudent(numInput)) {
					System.out.println("학생 정보가 삭제되었습니다\n");
				}
				else {
					System.out.println("삭제 실패하였습니다\n");
				}
				break;
			
			// 프로그램 종료
			case 6:
				System.out.println("프로그램을 종료합니다");
				scn.close();
				run = false;
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
