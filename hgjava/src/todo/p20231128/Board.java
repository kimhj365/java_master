package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	// 필드
	private int num;
	private String title;
	private String writer;
	private String content;
	private String writeDate;
	
	// 생성자
	// 1. 기본 생성자
	public Board(){}

	// 2. 날짜 자동 입력 생성자
	public Board(int num, String title, String writer, String content) {
		Date today = new Date();	//시스템 시간을 기준으로 생성
//		int year = today.getYear();
//		int month = today.getMonth() + 1;
//		int date = today.getDate();
		
		// Date <=> String 변환 클래스
		// SimpleDateFormat (import 필요)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = sdf.format(today);	// 날짜 형식에 맞게 String으로 반환
	}
	
	// 3. 필드값 전부 수동으로 받는 생성자
	public Board(int num, String title, String writer, String content, String writeDate) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
	}
	
	// 메소드
	
	// 1. 게시물 등록
//	boolean addArticle(Board[] boards, Board board) {
//		boolean exist = false;
//		for(int i = 0; i < boards.length; i++) {
//			if(boards[i] == null) {
//				boards[i] = board;
//				exist = true;
//				break;
//			}
//		}
//		return exist;
//	}
//	
	// 2. 목록 출력 메소드
	void showInfo() {
		System.out.printf(" %d\t %s\t %s\t\t %s\n", num, title, writer, writeDate);
	}
	
	// 3. 글 내용 출력 메소드
	String showDetailInfo() {
//		System.out.println("---------------------------------------------");
//		System.out.printf("번호: %d\t/ 제목: %s\n작성자: %s\n내용: %s\n일시: %s\n", 
//				num, title, writer, content, date);
		String result = "번호 : " + num + " / 제목 : " + title;
		result += "\n작성자 : " + writer;
		result += "\n내용 : " + content;
		result += "\n일시 : " + writeDate;
		return result;
	}
			
	// getter / setter 메소드
	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriteDate(String date) {
		this.writeDate = date;
	}
	
}


