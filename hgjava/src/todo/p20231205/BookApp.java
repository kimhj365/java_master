package todo.p20231205;

public class BookApp {

	public static void main(String[] args) {

		BookExe exe = new BookExe();
		boolean run = true;
		
		while(run) {

			// 0. 프로그램 시작
			int menu = exe.progStart();
			
			switch(menu) {
			// 1.도서 등록.
			case 1:
				exe.addBook();
				break;
				
			// 2.목록 조회.
			case 2:
				exe.showBookList();
				break;
				
			// 3.단건 조회.
			case 3:
				exe.showBook();
				break;
					
			// 3.가격 수정.	
			case 4:
				exe.modifyBook();
				break;
				
			// 4.도서 삭제.
			case 5:
				exe.removeBook();
				break;
				
			// 5.종료.
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
				
			default:
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
