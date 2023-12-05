package remind07;

public class StudentApp {

	public static void main(String[] args) {
		
		boolean run = true;
		StudentExe exe = new StudentExe();
		
		while(run) {	
			int menu = exe.progStart();
			
			switch(menu) {
			// 1.학생 추가.
			case 1: 
				exe.addStudent(exe.autoNumbering());
				break;
			// 2.전체 목록 조회
			case 2:
				exe.showStudentList();
				break;
			// 3. 단건 조회
			case 3:
				exe.showStudent();
				break;
			// 4. 학생 정보 수정
			case 4:
				exe.modifyStudent();
				break;
			// 5. 학생 정보 삭제
			case 5:
				exe.removeStudent();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;
			default:
				System.out.println("올바른 동작을 입력하세요");
			}	// end of switch
			
		}	// end of while
		System.out.println("end of program");
	}	// end of main()
}
