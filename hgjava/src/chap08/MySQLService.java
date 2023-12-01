package chap08;

// 상속: extends 부모 클래스.
// 구현: implements 인터페이스.
public class MySQLService implements DatabaseService{

	@Override
	public void add() {
		System.out.println("MySQL 입력처리");
	}

	@Override
	public void modify() {
		System.out.println("MySQL 수정처리");
	}

	@Override
	public void remove() {
		System.out.println("MySQL 삭제처리");
	}

	
	
}
