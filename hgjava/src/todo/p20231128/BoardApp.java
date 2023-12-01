package todo.p20231128;

import java.util.Scanner;

// MVC(Model: 데이터 모아둠 / View: 화면 / Control: 처리, 실행).
public class BoardApp {

//	static BoardExe BoardExe = new BoardExe();	// main함수 밖에서 선언 => static.
//	데이터마다 다른 정보를 담을 필요가 없는 클래스는 static 멤버 선언.
	
	// 필드.
	private Scanner scn = new Scanner(System.in);
	private String id = null;
	private static BoardApp instance = new BoardApp(); // 정적 필드 생성 => 자기 클래스 안에서 인스턴스 생성(싱글톤)
	
	// 생성자.
	private BoardApp() {}	// 싱글톤 => 생성자 호출 막음
	
	// 메서드.
	public static BoardApp getInstance() {	// 자기 클래스에서 생성한 인스턴스 반환.
		return instance;					// => 외부에서 인스턴스 참조 못하기 때문에 static 선언.
	}
	
	private void boardAdd(){
		System.out.println("< 게시물 등록 >");
//		System.out.print("게시글 번호 >> ");
//		int num = Integer.parseInt(scn.nextLine());
		System.out.print("제목 \n>> ");
		String title = scn.nextLine();
//		System.out.print("작성자 >> ");
//		String writer = scn.nextLine();
		System.out.print("내용 \n>> ");
		String content = scn.nextLine();
//		System.out.print("일시 >> ");
//		String date = scn.nextLine();

		Board board = new Board(BoardExe.getSequence(), title, id, content);

		if (BoardExe.addArticle(board)) {
			System.out.println("게시물 등록이 완료되었습니다!");
		} else {
			System.out.println("게시물 등록에 실패했습니다");
		}
	}
	
	private void boardList() {
		Board[] boardAry = BoardExe.showList();
		paging(boardAry, 1);
		// 페이징 처리
//		Board[] pageAry = exe.pageList(boardAry, 1);
//		
//		System.out.println("< 목록 조회 >");
//		System.out.println("글번호\t\t 제목\t\t 작성자\t\t 작성일자");
//		System.out.println("==================================================================");
//		for(Board brd : pageAry) {
//			if(brd != null) {
//				brd.showInfo();
//			}
//		}
//		System.out.println("==================================================================");
//		
//		// 전체 페이지 계산하고 출력.
//		int count = BoardExe.getBoardCount();
//		int totalPage = (int)Math.ceil(count/5.0);
//		for (int i = 1; i <= totalPage; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println("\n페이지를 선택하세요 \n>>");
		while (true) {
			int page = Integer.parseInt(scn.nextLine());
			if (page == 0) {
				break;
			}
			paging(boardAry, page); // main함수 밖에서 메소드 선언.
		}
	}
	
	private void getBoard() {
		System.out.println("< 상세 조회 >");
		int num = 0;
		while(true) {
			System.out.print("조회할 게시글 번호를 입력하세요 \n>> ");
			try {
				num = Integer.parseInt(scn.nextLine());
				break;
			} catch(NumberFormatException e) {
				System.out.println("정확한 번호를 입력하세요");
			}
		}
		Board result = BoardExe.showContent(num);
		if (result != null) {
			System.out.println("------------------------------------------------------------------");
			System.out.println(result.showDetailInfo());
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("게시물 조회에 실패했습니다");
		}
	}
	
	private void boardEdit() {
		System.out.println("< 게시글 수정 >");
		System.out.print("수정할 게시글 번호를 입력하세요 \n>> ");
		int num = Integer.parseInt(scn.nextLine());
		System.out.print("제목 수정 \n>> ");
		String title = scn.nextLine();
		System.out.print("내용 수정 \n>> ");
		String content = scn.nextLine();

		if (!BoardExe.checkResponsibility(id, num)) {
			System.out.println("수정 권한이 없습니다");
//			continue;
			return;
		}
		if (BoardExe.modifyContent(num, title, content)) {
			System.out.println("게시물 수정이 완료되었습니다!");
		} else {
			System.out.println("게시물 수정에 실패했습니다.");
		}
	}
	
	private void boardDel() {
		System.out.println("< 게시글 삭제 >");
		System.out.print("삭제할 게시글 번호를 입력하세요 \n>> ");
		int num = Integer.parseInt(scn.nextLine());

		if (!BoardExe.checkResponsibility(id, num)) {
			System.out.println("삭제 권한이 없습니다");
//			continue;
			return;
		}

		if (BoardExe.removeContent(num)) {
			System.out.println("게시물 삭제가 완료되었습니다!");
		} else {
			System.out.println("게시물 삭제에 실패했습니다.");
		}
	}
	
	private void paging(Board[] boardAry, int page) {
		// 페이징 처리
		Board[] pageAry = BoardExe.pageList(boardAry, page);

		System.out.println("< 목록 조회 >");
		System.out.println("글번호\t\t 제목\t\t 작성자\t\t 작성일자");
		System.out.println("==================================================================");
		for (Board brd : pageAry) {
			if (brd != null) {
				brd.showInfo();
			}
		}
		System.out.println("==================================================================");

		// 전체 페이지 계산하고 출력.
		int count = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(count / 5.0);
		System.out.printf("[현재 페이지: %d]  ", page);
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n페이지를 선택하세요(종료 : 0 입력) \n>>");
	}
	
	public void start() {
		boolean run = true;
		UserExe uexe = new UserExe(); // UserExe 클래스 가져옴.
//		BoardExe exe = new BoardExe();	// BoardExe 클래스 가져옴.

		BoardExe.initData();

		while (true) {
			System.out.print("아이디를 입력하세요\n>> ");
			id = scn.nextLine();
			System.out.print("비밀번호를 입력하세요\n>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다!!");
				break;
			} else {
				System.out.println("아이디와 비밀번호를 확인하세요");
			}
		}

		while (run) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.게시물 등록 ┃ 2.목록 ┃ 3.상세조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			
			
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("정확한 메뉴를 선택하세요");
				continue;
			}

			switch (menu) {
			// 1. 게시물 등록
			case 1:
				boardAdd();
				break;

			// 2. 목록 조회
			case 2:
				boardList();
				break;

			// 3. 상세조회
			case 3:
				getBoard();
				break;

			// 4. 수정
			case 4:
				boardEdit();
				break;
			// 5. 삭제
			case 5:
				boardDel();
				break;
			// 6. 종료
			case 6:
				System.out.println("< 프로그램 종료 >");
				scn.close();
				run = false;
			default:
				System.out.println("정확한 메뉴를 선택하세요");
				break;
			} // end of switch

		} // end of while
		scn.close();
		System.out.println("end of program");
	} // end of start()
}
