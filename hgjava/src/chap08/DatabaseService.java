package chap08;

// 추상 클래스처럼 추상 메소드만 정의 / 생성자 못만듦.
// ex) DB회사 별 예약어 => Oracle: insert(), update() / MySQL:  add(), modify().
public interface DatabaseService {
 
	// 필드.
	public static final String name = "";	// 상수만 사용 가능.
	public String CONSTANT = "";	// 상수이름 : 대문자 
	
	// 메소드. => 모두 추상 메소드
	// 입력, 수정, 삭제.
	public void add();
	public void modify();
	public void remove();
	
	
}
