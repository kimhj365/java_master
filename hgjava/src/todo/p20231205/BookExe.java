package todo.p20231205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookExe {

	private List<Book> books;
	Scanner scn = new Scanner(System.in);

	BookExe() {
		books = new ArrayList<>();
		books.add(new Book("B001", "이것이 자바다", "신용권", "한빛미디어", 25000));
		books.add(new Book("C003", "자바 기초", "김재원", "이지스퍼블리싱", 20000));
		books.add(new Book("D001", "자바마스터", "박재민", "도서출판홍릉", 15000));
	}

	// 0. 프로그램 시작
	int progStart() {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
		System.out.println("┃ 1.도서 등록 ┃ 2.목록 조회 ┃ 3.단건 조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
		System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
		System.out.print("동작을 입력하세요 \n>> ");
		int menu = 0;
		try {
			menu = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			return menu;
		}
		return menu;
	}

	// 1. 도서 등록.
	void addBook() {
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
			return;
		}
		books.add(new Book(bookCode, bookName, author, publisher, bookCost));
		System.out.println("도서 정보가 등록되었습니다");
	}

	// 2. 도서 목록 조회.
	void showBookList() {
		System.out.println("< 도서 목록 조회 >");
		System.out.printf("%7s %10s %10s %11s %10s\n", "도서코드", "도서명", "저자", "출판사", "가격");
		System.out.println("======================================================================");
		for (Book book : books) {
			book.showInfo();
		}
	}

	// 3. 도서 단건 조회
	void showBook() {
		System.out.println("< 도서 단건 조회 >");
		System.out.print("도서 코드를 입력하세요 \n>> ");
		String bookCode = scn.nextLine();
		System.out.printf("%7s %10s %10s %11s %10s\n", "도서코드", "도서명", "저자", "출판사", "가격");
		System.out.println("======================================================================");
		boolean chk = false;
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.showInfo();
				chk = true;
			}
		}
		if (!chk)
			System.out.println("찾는 도서가 없습니다");
	}

	// 4. 도서 정보 수정.
	void modifyBook() {
		System.out.println("< 도서 정보 수정 >");
		System.out.print("수정할 도서 코드를 입력하세요 \n>> ");
		String bookCode = scn.nextLine();
		System.out.print("가격을 입력하세요 \n>> ");
		int bookCost = 0;
		try {
			bookCost = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			System.out.println("올바른 도서 정보를 입력하세요");
			return;
		}
		boolean chk = false;
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.setBookCost(bookCost);
				chk = true;
			}
		}
		if (chk)
			System.out.println("도서 정보가 수정되었습니다");
		else
			System.out.println("찾는 도서 정보가 없습니다");
	}

	// 5. 도서 정보 삭제
	void removeBook() {
		System.out.println("< 도서 정보 수정 >");
		System.out.print("삭제할 도서 코드를 입력하세요 \n>> ");
		String bookCode = scn.nextLine();
		System.out.print("정말로 삭제하시겠습니까? (Y/N) \n>> ");
		String yesNo = scn.nextLine();
		boolean chk = false;
		if (yesNo.equals("Y") || yesNo.equals("y")) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getBookCode().equals(bookCode)) {
					books.remove(i);
					chk = true;
				}
			}
		} else {
			System.out.println("도서 정보 삭제가 취소되었습니다");
			return;
		}
		if (chk)
			System.out.println("도서 정보가 삭제되었습니다");
		else
			System.out.println("찾는 도서 정보가 없습니다");
	}

}
