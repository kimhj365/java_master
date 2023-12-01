package chap10;

public class ExceptionExe {

	public static void main(String[] args) {

		try {
			test();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		System.out.println("end of prog");
		
	}
	
	public static void test() throws ClassNotFoundException {	//
		// 일반예외 : 예외 처리 안하면 컴파일 안됨(RuntimeExcioption 하위클래스 아니라서)
			Class.forName("java.lang.String");
		
	}
}
