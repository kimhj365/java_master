package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	public static void main(String[] args) {
		
		
		Board[] boards = new Board[100];
		boards[0] = new Board(1,"자바게시판 입니다", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다.", "2023-11-28");
		boards[1] = new Board(2,"공부합시다\t", "user02", "자바를 공부합시다.", "2023-11-28");
		boards[2] = new Board(3,"SQL이 기대됩니다", "user03", "정 말 기 대 됩 니 다 ", "2023-11-28");
		Board board = new Board();
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("| 1.게시물 등록  2.목록  3.상세조회  4.종료 |");
			System.out.println("---------------------------------------------");
			System.out.print("동작을 입력하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			//1. 게시물 등록
			case 1: 
				System.out.println("< 게시물 등록 >");
				System.out.print("게시글 번호 >> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("제목 >> ");
				String title = scn.nextLine();
				System.out.print("작성자 >> ");
				String writer = scn.nextLine();
				System.out.println("내용 >> ");
				String content = scn.nextLine();
				System.out.print("일시 >> ");
				String date = scn.nextLine();
				Board brd = new Board(num, title, writer, content, date);
				
				if(board.addArticle(boards, brd)) {
					System.out.println("게시물 등록이 완료되었습니다");
				}
				else {
					System.out.println("게시물 등록에 실패했습니다");
				}
				break;
			// 목록 조회
			case 2:
				System.out.println("< 목록 조회 >");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null) {
						boards[i].showList();
					}
				}
				break;
			// 상세조회
			case 3:
				System.out.println("< 상세 조회 >");
				System.out.print("조회할 게시글 번호를 입력하세요 >> ");
				int input = Integer.parseInt(scn.nextLine());
				board.showContent(boards, input);
				break;
			case 4:
				System.out.println("< 프로그램 종료 >");
				scn.close();
				run = false;
			}	// end of switch
		
		}	// end of while
		scn.close();
		System.out.println("end of program");
	}	// end of main()

}
