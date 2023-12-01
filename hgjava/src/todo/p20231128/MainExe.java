package todo.p20231128;

public class MainExe {

	public static void main(String[] args) {
		
		BoardApp app = BoardApp.getInstance();
//		BoardApp app2 = BoardApp.getInstance();
//		System.out.println(app == app2);	// true.
		// 인스턴스 여러개 생성하려해도 하나만 생성됨 => 싱글톤 패턴	
		app.start();
		
	}
	
}
