package todo.p20231214;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
//		BookExe exe = new BookExe();
		BookDAO dao = new BookDAO();
		boolean run = true;
		
		while(run) {

			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.도서 등록 ┃ 2.목록 조회 ┃ 3.단건 조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			switch(menu) {
			// 1.도서 등록.
			case 1:
				System.out.println("< 도서 등록 >");
				System.out.print("도서 코드를 입력하세요 \n>> ");
				String bookCode = scn.nextLine();
				System.out.print("도서명을 입력하세요 \n>> ");
				String bookName = scn.nextLine();
				System.out.print("저자를 입력하세요 \n>> ");
				String author = scn.nextLine();
				System.out.print("출판사를 입력하세요 \n>> ");
				String publisher = scn.nextLine();
				System.out.print("가격을 입력하세요 \n>> ");
				int bookCost = 0;
				
				try {
					bookCost = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					System.out.println("올바른 도서 정보를 입력하세요");
				}
				Book book = new Book(bookCode, bookName, author, publisher, bookCost);
				
				if(dao.addBook(book)) {
					System.out.println("도서 정보가 등록되었습니다");
				}
				else {
					System.out.println("도서 정보 등록에 실패했습니다");
				}
				break;
				
			// 2.목록 조회.
			case 2:
				System.out.println("< 도서 목록 조회 >");
				System.out.printf("%7s %10s %10s %11s %10s\n", "도서코드", "도서명", "저자", "출판사", "가격");
				System.out.println("======================================================================");
				
				List<Book> books = new ArrayList<>();
				books =	dao.getBookList();
				
				for (int i = 0; i < books.size(); i++) {
					books.get(i).showInfo();
				}
				break;
				
			// 3.단건 조회.
			case 3:
				System.out.println("< 도서 단건 조회 >");
				System.out.print("도서 코드를 입력하세요 \n>> ");
				bookCode = scn.nextLine();
				System.out.printf("%7s %10s %10s %11s %10s\n", "도서코드", "도서명", "저자", "출판사", "가격");
				System.out.println("======================================================================");
				
				Book bk = dao.getBook(bookCode);
				bk.showInfo();
				break;
					
			// 3.가격 수정.	
			case 4:
				System.out.println("< 도서 정보 수정 >");
				System.out.print("수정할 도서 코드를 입력하세요 \n>> ");
				bookCode = scn.nextLine();
				System.out.print("가격을 입력하세요 \n>> ");
				bookCost = 0;
				try {
					bookCost = Integer.parseInt(scn.nextLine());
				} catch (Exception e) {
					System.out.println("올바른 도서 정보를 입력하세요");
					return;
				}if (dao.modifyBook(bookCode, bookCost))
					System.out.println("도서 정보가 수정되었습니다");
				else
					System.out.println("찾는 도서 정보가 없습니다");
				break;
				
			// 4.도서 삭제.
			case 5:
				System.out.println("< 도서 정보 수정 >");
				System.out.print("삭제할 도서 코드를 입력하세요 \n>> ");
				bookCode = scn.nextLine();
				System.out.print("정말로 삭제하시겠습니까? (Y/N) \n>> ");
				String yesNo = scn.nextLine();
				
				if (yesNo.equals("Y") || yesNo.equals("y")) {
					if(dao.removeBook(bookCode)) {
					System.out.println("도서 정보가 삭제되었습니다");
					} 
					else {
					System.out.println("찾는 도서 정보가 없습니다");
					}
				} 
				else {
					System.out.println("도서 정보 삭제가 취소되었습니다");
				}
				
				
				break;
				
			// 5.종료.
			case 6:
				System.out.println("프로그램을 종료합니다.");
				scn.close();
				run = false;
				break;
				
			default:
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch.
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.

}
