package chap07.abstracts;

public class MainExe {

	public static void main(String[] args) {
		
		// 추상 클래스는 인스턴스 생성 불가(생성자 있어도).
		Animal animal = null;
		animal = new Bird();	// 자동 형변환.
		
	}

}
