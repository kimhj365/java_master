package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	
	public static void main(String[] args) {
		
		Board[] board;
		Board
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
				System.out.println("일시 >> ");
				String date = scn.nextLine();
				Board brd = new Board(num, title, writer, content, date);
				addWriting(brd);
				
			
			}	// end of switch
		
		}	// end of while
	}	// end of main()

}
