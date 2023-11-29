package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	static BoardExe exe = new BoardExe();	// main함수 밖에서 선언 => static
	
	public static void main(String[] args) {
		
		UserExe uexe = new UserExe();	// UserExe 클래스 가져옴.
//		BoardExe exe = new BoardExe();	// BoardExe 클래스 가져옴.
		
		exe.initData();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String id = null;

		while(true) {
			System.out.print("아이디를 입력하세요\n>> ");
			id = scn.nextLine();
			System.out.print("비밀번호를 입력하세요\n>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "님 환영합니다!!");
				break;
			}
			else {
				System.out.println("아이디와 비밀번호를 확인하세요");
			}
		}
		
		while(run) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.게시물 등록 ┃ 2.목록 ┃ 3.상세조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			// 1. 게시물 등록
			case 1: 
				System.out.println("< 게시물 등록 >");
//				System.out.print("게시글 번호 >> ");
//				int num = Integer.parseInt(scn.nextLine());
				System.out.print("제목 \n>> ");
				String title = scn.nextLine();
//				System.out.print("작성자 >> ");
//				String writer = scn.nextLine();
				System.out.print("내용 \n>> ");
				String content = scn.nextLine();
//				System.out.print("일시 >> ");
//				String date = scn.nextLine();
				
				Board board = new Board(exe.getSequence(), title, id,  content);
				
				if(exe.addArticle(board)) {
					System.out.println("게시물 등록이 완료되었습니다!");
				}
				else {
					System.out.println("게시물 등록에 실패했습니다");
				}
				break;
				
			// 2. 목록 조회
			case 2:
				Board[] boardAry = exe.showList();
				paging(boardAry, 1);
				// 페이징 처리
//				Board[] pageAry = exe.pageList(boardAry, 1);
//				
//				System.out.println("< 목록 조회 >");
//				System.out.println("글번호\t\t 제목\t\t 작성자\t\t 작성일자");
//				System.out.println("==================================================================");
//				for(Board brd : pageAry) {
//					if(brd != null) {
//						brd.showInfo();
//					}
//				}
//				System.out.println("==================================================================");
//				
//				// 전체 페이지 계산하고 출력.
//				int count = exe.getBoardCount();
//				int totalPage = (int)Math.ceil(count/5.0);
//				for (int i = 1; i <= totalPage; i++) {
//					System.out.print(i + " ");
//				}
//				System.out.println("\n페이지를 선택하세요 \n>>");
				while(true) {
					int page = Integer.parseInt(scn.nextLine());
					if(page == 0) {
						break;
					}
					paging(boardAry, page);	// main함수 밖에서 메소드 선언.
				}
				break;
				
			// 3. 상세조회
			case 3:
				System.out.println("< 상세 조회 >");
				System.out.print("조회할 게시글 번호를 입력하세요 \n>> ");
				int num = Integer.parseInt(scn.nextLine());
				Board result = exe.showContent(num);
				if(result != null) {
					System.out.println("------------------------------------------------------------------");
					System.out.println(result.showDetailInfo());
					System.out.println("------------------------------------------------------------------");
				}
				else {
					System.out.println("게시물 조회에 실패했습니다");
				}
				break;
				
			// 4. 수정
			case 4:
				System.out.println("< 게시글 수정 >");
				System.out.print("수정할 게시글 번호를 입력하세요 \n>> ");
				num = Integer.parseInt(scn.nextLine());
				System.out.print("제목 수정 \n>> ");
				title = scn.nextLine();
				System.out.print("내용 수정 \n>> ");
				content = scn.nextLine();
				
				if(!exe.checkResponsibility(id, num)) {
					System.out.println("수정 권한이 없습니다");
					continue;
				}
				if(exe.modifyContent(num, title, content)) {
					System.out.println("게시물 수정이 완료되었습니다!");
				}
				else {
					System.out.println("게시물 수정에 실패했습니다.");
				}
				
				break;
			// 5. 삭제
			case 5:
				System.out.println("< 게시글 삭제 >");
				System.out.print("삭제할 게시글 번호를 입력하세요 \n>> ");
				num = Integer.parseInt(scn.nextLine());
				
				if(!exe.checkResponsibility(id, num)) {
					System.out.println("삭제 권한이 없습니다");
					continue;
				}
				
				if(exe.removeContent(num)) {
					System.out.println("게시물 삭제가 완료되었습니다!");
				}
				else {
					System.out.println("게시물 삭제에 실패했습니다.");
				}
				break;
			// 6. 종료
			case 6:
				System.out.println("< 프로그램 종료 >");
				scn.close();
				run = false;
			}	// end of switch
		
		}	// end of while
		scn.close();
		System.out.println("end of program");
	}	// end of main()

	public static void paging(Board[] boardAry, int page) {
		// 페이징 처리
		Board[] pageAry = exe.pageList(boardAry, page);
		
		System.out.println("< 목록 조회 >");
		System.out.println("글번호\t\t 제목\t\t 작성자\t\t 작성일자");
		System.out.println("==================================================================");
		for(Board brd : pageAry) {
			if(brd != null) {
				brd.showInfo();
			}
		}
		System.out.println("==================================================================");
		
		// 전체 페이지 계산하고 출력.
		int count = exe.getBoardCount();
		int totalPage = (int)Math.ceil(count/5.0);
		System.out.printf("[현재 페이지: %d]  ", page);
		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n페이지를 선택하세요(종료 : 0 입력) \n>>");
	}
}
