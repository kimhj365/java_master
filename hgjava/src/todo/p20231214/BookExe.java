package todo.p20231214;

import java.util.ArrayList;
import java.util.List;

public class BookExe {

	private List<Book> books;
	

	BookExe() {
		books = new ArrayList<>();
		books.add(new Book("B001", "이것이 자바다", "신용권", "한빛미디어", 25000));
		books.add(new Book("C003", "자바 기초", "김재원", "이지스퍼블리싱", 20000));
		books.add(new Book("D001", "자바마스터", "박재민", "도서출판홍릉", 15000));
	}

	// 1. 도서 등록.
	boolean addBook(Book book) {
		books.add(book);
		return true;		
	}

	// 2. 도서 목록 조회.
	void getBookList() {
		for (Book book : books) {
			book.showInfo();
		}
	}

	// 3. 도서 단건 조회
	boolean showBook(String bookCode) {
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.showInfo();
				return true;
			}
		}
		return false;
	}

	// 4. 도서 정보 수정.
	boolean modifyBook(String bookCode, int bookCost) {
		
		for (Book book : books) {
			if (book.getBookCode().equals(bookCode)) {
				book.setBookCost(bookCost);
				return true;
			}
		}
		return false;
	}

	// 5. 도서 정보 삭제
	boolean removeBook(String bookCode) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookCode().equals(bookCode)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
}
